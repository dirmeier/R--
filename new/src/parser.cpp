
#include "parser.hpp"

void parser::init(const std::string& text) const
{
    lexer_.init(text);
    token_ = lexer_.next();
}

ast parser::parse() const
{
    return expression();
}

ast parser::expression() const
{
//    ast root = term();

    return ast();
}

ast parser::factor() const
{
    return ast();
}

ast parser::term() const
{
    return ast();
}

void parser::eat(const token_category& category) const
{

}
