

#include <memory>
//#include "binary.hpp"
#include "parser.hpp"
#include "unary.hpp"

void parser::init(const std::string& text) const
{
//    lexer_.init(text);
//    token_ = lexer_.next();
}

ast parser::parse() const
{
    return expression();
}

ast parser::expression() const
{
//    ast root = term();
//    std::unique_ptr<ast> curr;
//
//
//    while (token_.category() == token_category::PLUS ||
//        token_.category() == token_category::MINUS)
//    {
//        token t = token_;
//        switch (t.category())
//        {
//            case token_category::PLUS:
//                eat(token_category::PLUS);
//                break;
//            case token_category::MINUS:
//                eat(token_category::MINUS);
//                break;
//            default:
//                throw parsing_exception("I dont know what to do.");
//        }
//        curr = std::unique_ptr<binary>(new binary(root, t, term()));
//    }
//
//    return root;
    return factor();
}

ast parser::term() const
{
//    ast res = factor();
//    while (token_.category() == token_category::MULT ||
//           token_.category() == token_category::DIV)
//    {
//        token t = token_;
//        switch (t.category())
//        {
//            case token_category::MULT:
//                eat(token_category::MULT);
//                break;
//            case token_category::DIV:
//                eat(token_category::DIV);
//                break;
//            default:
//                throw parsing_exception("Error when term-ing.");
//        }
//        res = binary(res, t, factor());
//    }
//
//    return res;
    return ast();
}

ast parser::factor() const
{
//    token f = token_;
//    ast node;
//    switch (f.category())
//    {
//        case token_category::PLUS:
//            eat(token_category::PLUS);
//            return unary(f, factor());
//        case token_category::MINUS:
//            eat(token_category::MINUS);
//            return unary(f, factor());
//        case token_category::INTEGER:
//            eat(token_category::INTEGER);
//            return number_node(f);
////        case token_category::LPARENS:
////            eat(TokenCategory.LPARENS);
////            node = expression();
////            eat(TokenCategory.RPARENS);
////            return node;
//        default:
//            throw  parsing_exception("Error when factorizing.");
//
//    }
    return ast();
}

void parser::eat(const token_category& category) const
{
    if (token_.category() == category)
        token_ = lexer_.next();
    else
        throw parsing_exception("Could not eat text.");
}
