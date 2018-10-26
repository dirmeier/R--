
#include <cctype>

#include "lexer.hpp"
#include "parsing_exception.hpp"
#include "token_category.hpp"

const char lexer::END_CHAR = '$';

void lexer::init(const std::string& text) const
{
    text_ = text + END_CHAR;
    position_ = 0;
    current_char_ = text_[position_];
}

token lexer::next() const
{
    while (current_char_ != '$')
    {
        if (current_char_ == ' ')
        {
            skip_whitespace();
            continue;
        }
        if (isdigit(current_char_))
            return token(token_category::INTEGER, to_int());
        else if (current_char_ == '+')
        {
            increment_position();
            return token(token_category::PLUS, '+');
        }
        else if (current_char_ == '-')
        {
            increment_position();
            return token(token_category::MINUS, '-');
        }
        else if (current_char_ == '*')
        {
            increment_position();
            return token(token_category::MULT, '*');
        }
        else if (current_char_ == '/')
        {
            increment_position();
            return token(token_category::DIV, '/');
        }
        else if (current_char_ == '(')
        {
            increment_position();
            return token(token_category::LPARENS, '(');
        }
        else if (current_char_ == ')')
        {
            increment_position();
            return token(token_category::RPARENS, ')');
        }
        throw parsing_exception("Could not take next token.");
    }
    return token(token_category::END, -1);
}

void lexer::skip_whitespace()  const
{
    while (current_char_ != '$' && current_char_ == ' ')
        increment_position();
}

void lexer::increment_position()  const
{
    position_++;
    if (position_ > text_.size() - 1)
        current_char_ = '$';
    else
        current_char_ = text_[position_];
}

int lexer::to_int()  const
{
    std::string res("");
    while (current_char_ != '$' && isdigit(current_char_))
    {
        res += current_char_;
        increment_position();
    }
    return std::stoi(res);
}