package net.digital_alexandria.r__.parser;

import net.digital_alexandria.r__.exceptions.ParsingException;
import net.digital_alexandria.r__.lexer.Lexer;
import net.digital_alexandria.r__.lexer.Token;
import net.digital_alexandria.r__.lexer.TokenCategory;
import net.digital_alexandria.r__.operators.Arithmetic;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public class Parser
{
    private final Lexer _lexer;
    private Token _currToken;

    private Parser(Lexer lexer)
    {
        this._lexer = lexer;
    }

    public static Parser instance(Lexer lexer)
    {
        return new Parser(lexer);
    }

    public void init(String text)
    {
        _lexer.init(text);
        _currToken = _lexer.next();
    }

    public ASTNode parse()
    {
        return expression();
    }

    @SuppressWarnings("unchecked")
    private ASTNode expression()
    {
        ASTNode root = term();

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
            root = new BinaryOperationNode(root, t, term());
        }

        return root;
    }

    @SuppressWarnings("unchecked")
    private ASTNode term()
    {
        ASTNode res = factor();
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
            res = new BinaryOperationNode(res, t, factor());
        }

        return res;
    }

    @SuppressWarnings("unchecked")
    private ASTNode factor()
    {
        Token<?> f = _currToken;
        ASTNode node;
        switch (f.category())
        {
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
