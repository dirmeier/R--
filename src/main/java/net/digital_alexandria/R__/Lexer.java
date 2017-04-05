package net.digital_alexandria.R__;

/**
 * @author Simon Dirmeier {@literal mail@simon-dirmeier.net}
 */
public final class Lexer
{
    private final static char END_CHAR = '$';
    private final static Operation _OP = new Operation();

    private String _text;
    private int _pos;
    private Token _currToken;
    private char _currChar;

    public String tokenize(String text)
    {
        _text = text + END_CHAR;
        _pos = 0;
        _currToken = null;
        _currChar = _text.charAt(_pos);
        return _tokenize();
    }

    private String _tokenize()
    {
        _currToken = _next();

        Token lhs = _currToken;
        _eat(TokenCategory.INTEGER);

        Token op = _currToken;
        _eat(op.category() == TokenCategory.PLUS ?
                 TokenCategory.PLUS :
                 TokenCategory.MINUS);

        Token rhs = _currToken;
        _eat(TokenCategory.INTEGER);

        switch (op.category())
        {
            case PLUS:
                return _OP.addition(lhs.value(), rhs.value());
            case MINUS:
                return _OP.substraction(lhs.value(), rhs.value());
            default:
                throw new ParsingException("I dont know what to do.");
        }
    }

    private void _eat(TokenCategory category)
    {
        if (_currToken.category() == category)
            _currToken = _next();
        else
            throw new ParsingException("Could not eat text.");
    }

    private Token _next()
    {
        while (_currChar != '$')
        {
            if (Character.isSpaceChar(_currChar))
                _skipWhitespace();
            else if (Character.isDigit(_currChar))
                return new Token(TokenCategory.INTEGER, _toInt());
            else if (_currChar == '+')
            {
                _incrementPosition();
                return new Token(TokenCategory.PLUS, '+');
            }
            else if (_currChar == '-')
            {
                _incrementPosition();
                return new Token(TokenCategory.MINUS, '-');
            }
            throw new ParsingException("Could not take next token.");
        }
        return new Token(TokenCategory.EOF, -1);
    }

    private void _incrementPosition()
    {
        _pos++;
        if (this._pos > _text.length() - 1)
            _currChar = '$';
        else
            _currChar = this._text.charAt(this._pos);
    }

    private Integer _toInt()
    {
        StringBuilder res = new StringBuilder();
        while (_currChar != '$' && Character.isDigit(_currChar))
        {
            res.append(_currChar);
            _incrementPosition();
        }
        return Integer.parseInt(res.toString());
    }

    private void _skipWhitespace()
    {
        char c = _currChar;
        while (_currChar != '$' && c == ' ')
            _incrementPosition();
    }
}
