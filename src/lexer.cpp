
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
    return token();
}

void lexer::skip_whitespace()  const
{

}

void lexer::increment_position()  const
{

}

unsigned int lexer::to_int()  const
{
 return 1;
}