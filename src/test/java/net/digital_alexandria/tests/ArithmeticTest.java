package net.digital_alexandria.tests;

import net.digital_alexandria.r__.operators.Arithmetic;
import org.junit.Test;

/**
 * @author Simon Dirmeier {@literal simon.dirmeier@gmx.de}
 */
public class ArithmeticTest
{
    @Test
    public void testIntegerAddition()
    {
        Integer i1 = 1;
        Integer i2 = 2;
        assert Arithmetic.addition(i1, i2).equals("3");
    }

    @Test
    public void testIntegerSubstraction()
    {
        Integer i1 = 1;
        Integer i2 = 2;
        assert Arithmetic.substraction(i1, i2).equals("-1");
    }
}

