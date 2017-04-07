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

    public AbstractSyntaxTree parse()
    {
        return expression();
    }

    @SuppressWarnings("unchecked")
    private AbstractSyntaxTree expression()
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

        return new AbstractSyntaxTree(root);
    }

    @SuppressWarnings("unchecked")
    private Integer term()
    {
        Integer res = factor();
        while (_currToken.category() == TokenCategory.MULT ||
               _currToken.category() == TokenCategory.DIV)
        {
            Token<?> t = _currToken;
            switch (t.category())
            {
                case MULT:
                    eat(TokenCategory.MULT);
                    res = Arithmetic.multiplication(res, factor());
                    break;
                case DIV:
                    eat(TokenCategory.DIV);
                    res = Arithmetic.division(res, factor());
                    break;
                default:
                    throw new ParsingException("Error when term-ing.");
            }
        }

        return res;
    }

    @SuppressWarnings("unchecked")
    private Integer factor()
    {
        Token<?> f = _currToken;
        switch (f.category())
        {
            case INTEGER:
                eat(TokenCategory.INTEGER);
                return (Integer) f.value();
            case LPARENS:
                eat(TokenCategory.LPARENS);
                Integer res = expression();
                eat(TokenCategory.RPARENS);
                return res;
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
