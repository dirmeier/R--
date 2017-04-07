package net.digital_alexandria.r__.parser;

import net.digital_alexandria.r__.lexer.Token;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class NumberNode  <T extends Number> extends AbstractSyntaxSubtree
{
    private final Token<T> _token;

    public NumberNode(Token<T> token) 
    {
        this._token = token;
    }
}
