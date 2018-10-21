package net.digital_alexandria.r__.parser;

import net.digital_alexandria.r__.exceptions.ParsingException;
import net.digital_alexandria.r__.lexer.Token;
import net.digital_alexandria.r__.operators.Arithmetic;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public class Unary extends AbstractSyntaxSubtree
{

    private final AbstractSyntaxSubtree _expr;
    private final Token<?> _token;

    public Unary(final Token<?> t, AbstractSyntaxSubtree expr)
    {
        this._token = t;
        this._expr = expr;
    }

    @Override
    public Object traverse()
    {
        switch (_token.category())
        {
            case PLUS:
                return (Integer) _expr.traverse();
            case MINUS:
                return -(Integer) _expr.traverse();
            default:
                throw new ParsingException("Could not traverse AST.");
        }
    }
}
