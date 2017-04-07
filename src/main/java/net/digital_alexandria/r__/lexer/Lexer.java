package net.digital_alexandria.r__.lexer;

import net.digital_alexandria.r__.exceptions.ParsingException;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Lexer
{

    private final static char END_CHAR = '$';

    private String _text;
    private int _pos;
    private char _currChar;

    private Lexer() {}

    public static Lexer instance()
    {
        return new Lexer();
    }

    public void init(String text)
    {
        _text = text + END_CHAR;
        _pos = 0;
        _currChar = _text.charAt(_pos);
    }

    @SuppressWarnings("unchecked")
    public Token next()
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
            else if (_currChar == '*')
            {
                incrementPosition();
                return new Token(TokenCategory.MULT, '*');
            }
            else if (_currChar == '/')
            {
                incrementPosition();
                return new Token(TokenCategory.DIV, '/');
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
        while (_currChar != '$' && _currChar == ' ')
            incrementPosition();
    }


}
