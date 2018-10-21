package net.digital_alexandria.r__.lexer;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Token<T>
{
    private final TokenCategory _tok;
    private final T _val;

    Token(final TokenCategory category, final T value)
    {
        _tok = category;
        _val = value;
    }

    public final TokenCategory category()
    {
        return _tok;
    }

    public final T value()
    {
        return _val;
    }
}
