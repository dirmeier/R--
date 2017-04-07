package net.digital_alexandria.r__.parser;

import net.digital_alexandria.r__.lexer.Token;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class BinaryOperationNode extends ASTNode
{
    private final ASTNode _lhs;
    private final ASTNode _rhs;
    private final Token<?> _token;

    public BinaryOperationNode(ASTNode lhs, Token<?> t, ASTNode rhs)
    {
        this._lhs = lhs;
        this._rhs = rhs;
        this._token = t;
    }
}
