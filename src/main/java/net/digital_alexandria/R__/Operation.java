package net.digital_alexandria.r__;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public class Operation
{

    public String addition(Object lhs, Object rhs)
    {
        if (lhs instanceof Integer && rhs instanceof Integer)
            return addition((Integer) lhs, (Integer) rhs);
        throw new ParsingException("Objects of different class");
    }

    public String addition(Integer lhs, Integer rhs)
    {
        return String.valueOf(lhs + rhs);
    }

    public String substraction(Object lhs, Object rhs)
    {
        if (lhs instanceof Integer && rhs instanceof Integer)
            return substraction((Integer) lhs, (Integer) rhs);
        throw new ParsingException("Objects of different class");
    }

    public String substraction(Integer lhs, Integer rhs)
    {
        return String.valueOf(lhs - rhs);
    }
}
