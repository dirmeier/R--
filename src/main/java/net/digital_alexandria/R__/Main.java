package net.digital_alexandria.r__;

import net.digital_alexandria.r__.interpreter.Interpreter;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Main
{
    private Main(){}

    public static void main(final String[] args)
    {
        Interpreter.instance().run();
    }
}
