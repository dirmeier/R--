package net.digital_alexandria.r__.interpreter;

import net.digital_alexandria.r__.exceptions.ParsingException;
import net.digital_alexandria.r__.lexer.Lexer;
import net.digital_alexandria.r__.lexer.Token;
import net.digital_alexandria.r__.lexer.TokenCategory;
import net.digital_alexandria.r__.operators.Arithmetic;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Interpreter
{
    private volatile static Interpreter _interpreter;

    private final Lexer _lexer;
    private Token _currToken;

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
        return expression(text);
    }

    private String expression(final String text)
    {
        _lexer.init(text);
        _currToken = _lexer.next();
        return String.valueOf(expression());
    }

    private Integer expression()
    {
        Integer res = term();

        while (_currToken.category() == TokenCategory.PLUS ||
               _currToken.category() == TokenCategory.MINUS)
        {
            Token<?> t = _currToken;
            switch (t.category())
            {
                case PLUS:
                    eat(TokenCategory.PLUS);
                    res = Arithmetic.addition(res, term());
                    break;
                case MINUS:
                    eat(TokenCategory.MINUS);
                    res = Arithmetic.substraction(res, term());
                    break;
                default:
                    throw new ParsingException("I dont know what to do.");
            }
        }

        return res;
    }

    private void eat(final TokenCategory category)
    {
        if (_currToken.category() == category)
            _currToken = _lexer.next();
        else
            throw new ParsingException("Could not eat text.");
    }

    @SuppressWarnings("unchecked")
    private Integer factor()
    {
        Token<?> f = _currToken;
        switch (f.category())
        {
            case INTEGER:
                eat(TokenCategory.INTEGER);
                return (Integer) f.value();
            case LPARENS:
                eat(TokenCategory.LPARENS);
                Integer res = expression();
                eat(TokenCategory.RPARENS);
                return res;
            default:
                throw new ParsingException("Error when factorizing.");

        }
    }

    @SuppressWarnings("unchecked")
    private Integer term()
    {
        Integer res = factor();
        while (_currToken.category() == TokenCategory.MULT ||
               _currToken.category() == TokenCategory.DIV)
        {
            Token<?> t = _currToken;
            switch (t.category())
            {
                case MULT:
                    eat(TokenCategory.MULT);
                    res = Arithmetic.multiplication(res, factor());
                    break;
                case DIV:
                    eat(TokenCategory.DIV);
                    res = Arithmetic.division(res, factor());
                    break;
                default:
                    throw new ParsingException("Error when term-ing.");
            }
        }

        return res;
    }
}
