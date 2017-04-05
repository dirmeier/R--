package net.digital_alexandria.R__;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public class Token
{
    private final TokenCategory _tok;
    private final Object _val;

    public Token(TokenCategory category, Object value)
    {
        _tok = category;
        _val = value;
    }

    public TokenCategory category()
    {
        return _tok;
    }

    public Object value()
    {
        return _val;
    }
}
