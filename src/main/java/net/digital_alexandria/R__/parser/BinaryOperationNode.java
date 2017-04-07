package net.digital_alexandria.r__.parser;

import net.digital_alexandria.r__.lexer.Token;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class BinaryOperationNode extends AbstractSyntaxSubtree
{
    private final AbstractSyntaxSubtree _lhs;
    private final AbstractSyntaxSubtree _rhs;
    private final Token<?> _token;

    public BinaryOperationNode(AbstractSyntaxSubtree lhs, Token<?> t, AbstractSyntaxSubtree rhs)
    {
        this._lhs = lhs;
        this._rhs = rhs;
        this._token = t;
    }
}
