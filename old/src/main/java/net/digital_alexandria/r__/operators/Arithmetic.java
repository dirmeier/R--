package net.digital_alexandria.r__.operators;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Arithmetic
{

    private Arithmetic() {}


    public static Integer addition(final Integer lhs, final Integer rhs)
    {
        return lhs + rhs;
    }

    public static Integer substraction(final Integer lhs, final Integer rhs)
    {
        return lhs - rhs;
    }

    public static Integer multiplication(final Integer lhs, final Integer rhs)
    {
        return lhs * rhs;
    }

    public static Integer division(final Integer lhs, final Integer rhs)
    {
        return lhs / rhs;
    }

}
