#ifndef R_NODE_HPP
#define R_NODE_HPP

template<typename T>
class node
{
   public:
    node(T value) : value_(value)
    {
    }

    T get()
    {
        return value_;
    }

   private:
    T value_;
};

#endif  // R_NODE_HPP
