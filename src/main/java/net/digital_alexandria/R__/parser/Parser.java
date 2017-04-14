package net.digital_alexandria.r__.parser;

import net.digital_alexandria.r__.exceptions.ParsingException;
import net.digital_alexandria.r__.lexer.Lexer;
import net.digital_alexandria.r__.lexer.Token;
import net.digital_alexandria.r__.lexer.TokenCategory;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Parser
{
    private final Lexer _lexer;
    private Token _currToken;

    private Parser(final Lexer lexer)
    {
        this._lexer = lexer;
    }

    public static Parser instance(final Lexer lexer)
    {
        return new Parser(lexer);
    }

    public void init(final String text)
    {
        _lexer.init(text);
        _currToken = _lexer.next();
    }

    public AbstractSyntaxSubtree parse()
    {
        return expression();
    }

    @SuppressWarnings("unchecked")
    private AbstractSyntaxSubtree expression()
    {
        AbstractSyntaxSubtree root = term();

        while (_currToken.category() == TokenCategory.PLUS ||
               _currToken.category() == TokenCategory.MINUS)
        {
            Token<?> t = _currToken;
            switch (t.category())
            {
                case PLUS:
                    eat(TokenCategory.PLUS);
                    break;
                case MINUS:
                    eat(TokenCategory.MINUS);
                    break;
                default:
                    throw new ParsingException("I dont know what to do.");
            }
            root = new Binary(root, t, term());
        }

        return root;
    }

    @SuppressWarnings("unchecked")
    private AbstractSyntaxSubtree term()
    {
        AbstractSyntaxSubtree res = factor();
        while (_currToken.category() == TokenCategory.MULT ||
               _currToken.category() == TokenCategory.DIV)
        {
            Token<?> t = _currToken;
            switch (t.category())
            {
                case MULT:
                    eat(TokenCategory.MULT);
                    break;
                case DIV:
                    eat(TokenCategory.DIV);
                    break;
                default:
                    throw new ParsingException("Error when term-ing.");
            }
            res = new Binary(res, t, factor());
        }

        return res;
    }

    @SuppressWarnings("unchecked")
    private AbstractSyntaxSubtree factor()
    {
        Token<?> f = _currToken;
        AbstractSyntaxSubtree node;
        switch (f.category())
        {
            case PLUS:
                eat(TokenCategory.PLUS);
                return new Unary(f, factor());
            case MINUS:
                eat(TokenCategory.MINUS);
                return new Unary(f, factor());
            case INTEGER:
                eat(TokenCategory.INTEGER);
                return new NumberNode(f);
            case LPARENS:
                eat(TokenCategory.LPARENS);
                node = expression();
                eat(TokenCategory.RPARENS);
                return node;
            default:
                throw new ParsingException("Error when factorizing.");

        }
    }

    private void eat(final TokenCategory category)
    {
        if (_currToken.category() == category)
            _currToken = _lexer.next();
        else
            throw new ParsingException("Could not eat text.");
    }
}
