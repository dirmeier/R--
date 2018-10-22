
#include "lexer.hpp"

const char lexer::END_CHAR = '$';

void lexer::init(const std::string& text) const
{
    text_ = text + END_CHAR;
    position_ = 0;
    current_char_ = text_[position_];
}

token lexer::next()  const
{
    while (_currChar != '$')
    {
        if (Character.isSpaceChar(_currChar))
        {
            skipWhitespace();
            continue;
        }
        if (Character.isDigit(_currChar))
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
        else if (_currChar == '(')
        {
            incrementPosition();
            return new Token(TokenCategory.LPARENS, '(');
        }
        else if (_currChar == ')')
        {
            incrementPosition();
            return new Token(TokenCategory.RPARENS, ')');
        }
        throw new ParsingException("Could not take next token.");
    }
    return new Token(TokenCategory.EOF, -1);
}

void lexer::skip_whitespace()  const
{
    while (_currChar != '$' && Character.isSpaceChar(_currChar))
        incrementPosition();
}

void lexer::increment_position()  const
{
    _pos++;
    if (this._pos > _text.length() - 1)
        _currChar = '$';
    else
        _currChar = this._text.charAt(this._pos);
}

unsigned int lexer::to_int()  const
{
    StringBuilder res = new StringBuilder();
    while (_currChar != '$' && Character.isDigit(_currChar))
    {
        res.append(_currChar);
        incrementPosition();
    }
    return Integer.parseInt(res.toString());
}