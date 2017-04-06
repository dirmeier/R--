package net.digital_alexandria.r__.lexer;

import net.digital_alexandria.r__.operators.Arithmetic;
import net.digital_alexandria.r__.exceptions.ParsingException;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Lexer
{

    private final static char END_CHAR = '$';

    private String _text;
    private int _pos;
    private Token _currToken;
    private char _currChar;

    private Lexer(){}

    public static Lexer instance()
    {
        return new Lexer();
    }

    public final String tokenize(final String text)
    {
        _text = text + END_CHAR;
        _pos = 0;
        _currToken = null;
        _currChar = _text.charAt(_pos);
        return tokenize();
    }

    private String tokenize()
    {
        _currToken = next();

        Token lhs = _currToken;
        eat(TokenCategory.INTEGER);

        Token op = _currToken;
        eat(op.category() == TokenCategory.PLUS ?
              TokenCategory.PLUS :
              TokenCategory.MINUS);

        Token rhs = _currToken;
        eat(TokenCategory.INTEGER);

        switch (op.category())
        {
            case PLUS:
                return Arithmetic.addition(lhs.value(), rhs.value());
            case MINUS:
                return Arithmetic.substraction(lhs.value(), rhs.value());
            default:
                throw new ParsingException("I dont know what to do.");
        }
    }

    private void eat(final TokenCategory category)
    {
        if (_currToken.category() == category)
            _currToken = next();
        else
            throw new ParsingException("Could not eat text.");
    }

    private Token next()
    {
        while (_currChar != '$')
        {
            if (Character.isSpaceChar(_currChar))
                skipWhitespace();
            else if (Character.isDigit(_currChar))
                return new Token(TokenCategory.INTEGER, toInt());
            else if (_currChar == '+')
            {
                incrementPosition();
                return new Token(TokenCategory.PLUS, '+');
            }
            else if (_currChar == '-')
            {
                incrementPosition();
                return new Token(TokenCategory.MINUS, '-');
            }
            throw new ParsingException("Could not take next token.");
        }
        return new Token(TokenCategory.EOF, -1);
    }

    private void incrementPosition()
    {
        _pos++;
        if (this._pos > _text.length() - 1)
            _currChar = '$';
        else
            _currChar = this._text.charAt(this._pos);
    }

    private Integer toInt()
    {
        StringBuilder res = new StringBuilder();
        while (_currChar != '$' && Character.isDigit(_currChar))
        {
            res.append(_currChar);
            incrementPosition();
        }
        return Integer.parseInt(res.toString());
    }

    private void skipWhitespace()
    {
        char c = _currChar;
        while (_currChar != '$' && c == ' ')
            incrementPosition();
    }
}
