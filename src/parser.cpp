


#include "parser.hpp"
#include "binary.hpp"
#include "unary.hpp"
#include "number_node.hpp"

void parser::init(const std::string& text) const
{
    lexer_.init(text);
    token_ = lexer_.next();
}

ast* parser::parse() const
{
    return expression();
}

ast* parser::expression() const
{
    ast* curr = term();

    while (token_.category() == token_category::PLUS ||
           token_.category() == token_category::MINUS)
    {
        token t = token_;
        switch (t.category())
        {
            case token_category::PLUS:
                eat(token_category::PLUS);
                break;
            case token_category::MINUS:
                eat(token_category::MINUS);
                break;
            default:
                throw parsing_exception("I dont know what to do.");
        }

        curr = new binary(curr, term(), t);
    }

    return curr;
}

ast* parser::term() const
{
    ast* curr= factor();

    while (token_.category() == token_category::MULT ||
           token_.category() == token_category::DIV)
    {
        token t = token_;
        switch (t.category())
        {
            case token_category::MULT:
                eat(token_category::MULT);
                break;
            case token_category::DIV:
                eat(token_category::DIV);
                break;
            default:
                throw parsing_exception("Error when term-ing.");
        }
        curr = new binary(curr, factor(), t);
    }

    return curr;
}

ast* parser::factor() const
{
    token f = token_;
    ast* node;
    switch (f.category())
    {
        case token_category::PLUS:
            eat(token_category::PLUS);
            return new unary(factor(), f);
        case token_category::MINUS:
            eat(token_category::MINUS);
            return new unary(factor(), f);
        case token_category::INTEGER:
            eat(token_category::INTEGER);
            return new number_node(f);
        case token_category::LPARENS:
            eat(token_category::LPARENS);
            node = expression();
            eat(token_category::RPARENS);
            return node;
        default:
            throw parsing_exception("Error when factorizing.");

    }
}

void parser::eat(const token_category& category) const
{
    if (token_.category() == category)
        token_ = lexer_.next();
    else
        throw parsing_exception("Could not eat text.");
}
