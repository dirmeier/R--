package net.digital_alexandria.tests;

import net.digital_alexandria.r__.operators.Arithmetic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Simon Dirmeier {@literal simon.dirmeier@gmx.de}
 */
public class ArithmeticTest
{
    @Test
    public void testIntegerAddition()
    {
        assert (Arithmetic.addition(1, 2) == 3);
    }

    @Test
    public void testIntegerSubstraction()
    {
        assert(Arithmetic.substraction(1, 2) == -1);
    }
}

