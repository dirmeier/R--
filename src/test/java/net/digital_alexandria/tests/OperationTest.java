package net.digital_alexandria.tests;

import net.digital_alexandria.r__.Operation;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Simon Dirmeier {@literal simon.dirmeier@gmx.de}
 */
public class OperationTest
{
    @Test
    @SuppressWarnings("unchecked")
    public void testIntegerAddition() throws
                                      NoSuchMethodException,
                                      InvocationTargetException,
                                      IllegalAccessException
    {
        Integer i1 = 1;
        Integer i2 = 2;
        assert new Operation().addition(i1, i2).equals("3");
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testIntegerSubstraction() throws NoSuchMethodException,
                                                 InvocationTargetException,
                                                 IllegalAccessException
    {
        Integer i1 = 1;
        Integer i2 = 2;
        assert new Operation().substraction(i1, i2).equals("-1");
    }
}

