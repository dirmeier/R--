package net.digital_alexandria.r__.interpreter;

import net.digital_alexandria.r__.exceptions.ParsingException;
import net.digital_alexandria.r__.lexer.Lexer;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Interpreter
{
    private volatile static Interpreter _interpreter;

    private final Lexer _lexer;

    private static final String DISCLAIMER = new StringBuilder()
      .append("\nWelcome to R-- v0.1 ('It's Alive').\n\n")
      .append("R-- is a slower, experimental implementation of R in Java.\n")
      .append("Be aware of bugs and minimal functionality.\n")
      .append("If you are brave enough you can contribute.\n\n")
      .append("Ctrl+C or Ctrl+D to quit! Good luck.\n\n")
      .toString();


    private Interpreter()
    {
        this._lexer = Lexer.instance();
    }

    public static Interpreter instance()
    {
        synchronized (Interpreter.class)
        {
            if (_interpreter == null)
            {
                _interpreter = new Interpreter();
            }
        }
        return _interpreter;
    }

    public final void run()
    {
        Scanner sc = new Scanner(System.in);
        boolean isFirst = true;
        boolean exec = true;
        while (exec)
        {
            if (isFirst)
            {
                System.out.println(DISCLAIMER);
                isFirst = false;
            }
            System.out.print("R-- > ");
            try
            {
                String line = sc.nextLine();
                if (line == null) exec = false;
                else
                {
                    try
                    {
                        System.out.println(this.interpret(line));
                    }
                    catch (ParsingException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
            catch (NoSuchElementException e)
            {
                exec = false;
            }
        }
    }

    private String interpret(final String text)
    {
        return this._lexer.tokenize(text);
    }
}
