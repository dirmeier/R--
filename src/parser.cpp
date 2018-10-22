
#include "parser.hpp"
#include "binary.hpp"

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
    ast root = term();
    ast curr;

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
        curr = static_cast<binary>(root, t, term());
    }

    return root;
}

ast parser::term() const
{
    AbstractSyntaxSubtree res = factor();
    while (_currToken.category() == TokenCategory.MULT ||
           _currToken.category() == TokenCategory.DIV)
    {
        Token<?> t = _currToken;
        switch (t.category())
        {
            case MULT:
                eat(TokenCategory.MULT);
                break;
            case DIV:
                eat(TokenCategory.DIV);
                break;
            default:
                throw new ParsingException("Error when term-ing.");
        }
        res = new Binary(res, t, factor());
    }

    return res;
}

ast parser::factor() const
{
    Token<?> f = _currToken;
    AbstractSyntaxSubtree node;
    switch (f.category())
    {
        case PLUS:
            eat(TokenCategory.PLUS);
            return new Unary(f, factor());
        case MINUS:
            eat(TokenCategory.MINUS);
            return new Unary(f, factor());
        case INTEGER:
            eat(TokenCategory.INTEGER);
            return new NumberNode(f);
        case LPARENS:
            eat(TokenCategory.LPARENS);
            node = expression();
            eat(TokenCategory.RPARENS);
            return node;
        default:
            throw new ParsingException("Error when factorizing.");

    }
}

void parser::eat(const token_category& category) const
{
    if (_currToken.category() == category)
        _currToken = _lexer.next();
    else
        throw new ParsingException("Could not eat text.");
}
