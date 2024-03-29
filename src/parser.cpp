#include "parser.hpp"
#include "binary.hpp"
#include "unary.hpp"
#include "number_node.hpp"

void parser::init(const std::string& text) const
{
    lexer_.init(text);
    token_ = lexer_.next();
}

std::unique_ptr<ast> parser::parse() const
{
    return expression();
}

std::unique_ptr<ast> parser::expression() const
{
    std::unique_ptr<ast> curr(term());

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

        curr = std::unique_ptr<binary>(new binary(std::move(curr), term(), t));
    }

    return curr;
}

std::unique_ptr<ast> parser::term() const
{
    std::unique_ptr<ast> curr(factor());

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
        curr =
          std::unique_ptr<binary>(new binary(std::move(curr), factor(), t));
    }

    return curr;
}

std::unique_ptr<ast> parser::factor() const
{
    token f = token_;
    std::unique_ptr<ast> node;
    switch (f.category())
    {
        case token_category::PLUS:
            eat(token_category::PLUS);
            return std::unique_ptr<unary>(new unary(factor(), f));
        case token_category::MINUS:
            eat(token_category::MINUS);
            return std::unique_ptr<unary>(new unary(factor(), f));
        case token_category::INTEGER:
            eat(token_category::INTEGER);
            return std::unique_ptr<number_node>(new number_node(f));
        case token_category::LPARENS:
            eat(token_category::LPARENS);
            node = std::unique_ptr<ast>(expression());
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
