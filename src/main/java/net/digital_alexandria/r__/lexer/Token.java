package net.digital_alexandria.r__.lexer;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Token
{
    private final TokenCategory _tok;
    private final Object _val;

    Token(TokenCategory category, Object value)
    {
        _tok = category;
        _val = value;
    }

    public final TokenCategory category()
    {
        return _tok;
    }

    public final Object value()
    {
        return _val;
    }
}
