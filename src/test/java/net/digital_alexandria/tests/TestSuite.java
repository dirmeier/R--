
package net.digital_alexandria.tests;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Simon Dirmeier {@literal simon.dirmeier@gmx.de}
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  ArithmeticTest.class
})
public class TestSuite
{
    @BeforeClass
    public static void setup()
    {}
}
