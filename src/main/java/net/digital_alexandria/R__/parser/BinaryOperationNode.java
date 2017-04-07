package net.digital_alexandria.r__.parser;

import net.digital_alexandria.r__.exceptions.ParsingException;
import net.digital_alexandria.r__.lexer.Token;
import net.digital_alexandria.r__.operators.Arithmetic;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class BinaryOperationNode extends AbstractSyntaxSubtree
{
    private final AbstractSyntaxSubtree _lhs;
    private final AbstractSyntaxSubtree _rhs;
    private final Token<?> _token;

    public BinaryOperationNode(final AbstractSyntaxSubtree lhs,
                               final Token<?> t,
                               final AbstractSyntaxSubtree rhs)
    {
        this._lhs = lhs;
        this._rhs = rhs;
        this._token = t;
    }

    @Override
    public Object traverse()
    {
        switch (_token.category())
        {
            case PLUS:
                return Arithmetic.addition(
                  (Integer) _lhs.traverse(), (Integer) _rhs.traverse());
            case MINUS:
                return Arithmetic.substraction(
                  (Integer) _lhs.traverse(), (Integer) _rhs.traverse());
            case MULT:
                return Arithmetic.multiplication(
                  (Integer) _lhs.traverse(), (Integer) _rhs.traverse());
            case DIV:
                return Arithmetic.division(
                  (Integer) _lhs.traverse(), (Integer) _rhs.traverse());
            default:
                throw new ParsingException("Could not traverse AST.");
        }
    }
}
