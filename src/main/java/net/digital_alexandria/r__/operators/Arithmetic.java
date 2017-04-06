package net.digital_alexandria.r__.operators;

import net.digital_alexandria.r__.exceptions.ParsingException;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Arithmetic
{

    private Arithmetic() {}

    public static String addition(final Object lhs, final Object rhs)
    {
        if (lhs instanceof Integer && rhs instanceof Integer)
            return addition((Integer) lhs, (Integer) rhs);
        throw new ParsingException("Objects of different class");
    }

    public static String addition(final Integer lhs, final Integer rhs)
    {
        return String.valueOf(lhs + rhs);
    }

    public static String substraction(final Object lhs, final Object rhs)
    {
        if (lhs instanceof Integer && rhs instanceof Integer)
            return substraction((Integer) lhs, (Integer) rhs);
        throw new ParsingException("Objects of different class");
    }

    public static String substraction(final Integer lhs, final Integer rhs)
    {
        return String.valueOf(lhs - rhs);
    }
}
