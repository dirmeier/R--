package net.digital_alexandria.r__.parser;

import net.digital_alexandria.r__.lexer.Token;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class NumberNode extends AbstractSyntaxSubtree
{
    private final Token<?> _token;

    public NumberNode(final Token<?> token)
    {
        this._token = token;
    }

    @Override
    public Object traverse()
    {
        return _token.value();
    }
}
