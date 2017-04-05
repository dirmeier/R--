package net.digital_alexandria.r__;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Interpreter
{

    private final Lexer _lexer;
    private final Parser _parser;

    public static final String DISCLAIMER = new StringBuilder()
      .append("\nWelcome to R-- v0.1 ('It's Alive').\n\n")
      .append("R-- is a slower, experimental, bad implementation of R in Java.\n")
      .append("I implemented R-- mainly for learning how an interpreter works" +
              ".\n")
      .append("Be aware of bugs and minimal functionality.\n")
      .append("If you are brave enough you can contribute.\n\n")
      .append("Ctrl+C or Ctrl+D to quit! Good luck.\n\n")
      .toString();


    public Interpreter()
    {
        this._lexer = new Lexer();
        this._parser = new Parser();
    }

    public final void run()
    {
        Scanner sc = new Scanner(System.in);
        boolean isFirst = true;
        while (true)
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
                if (line == null) return;
                try
                {
                    System.out.println(this._interpret(line));
                }
                catch (ParsingException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            catch (NoSuchElementException e)
            {
                return;
            }
        }
    }

    private final String _interpret(String text)
    {
        return this._lexer.tokenize(text);
    }
}
