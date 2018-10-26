cmake_minimum_required(VERSION 3.8)
project(r__ LANGUAGES CXX C)

if (NOT CMAKE_BUILD_TYPE)
    set(CMAKE_BUILD_TYPE "RelWithDebInfo")
endif ()

set(CMAKE_VERBOSE_MAKEFILE on)
set(CMAKE_CXX_FLAGS_RELWITHDEBINFO "-O3 -g")
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)
set(CMAKE_VERBOSE_MAKEFILE OFF)

include(GNUInstallDirs)
include(FeatureSummary)
include(CTest)

find_package(Boost)

set(SOURCE_FILES
        src/arithmetic.cpp
        src/arithmetic.hpp
        src/ast.hpp
        src/binary.hpp
        src/interpreter.cpp
        src/interpreter.hpp
        src/lexer.cpp
        src/lexer.hpp
        src/node.hpp
        src/number_node.hpp
        src/parser.cpp
        src/parser.hpp
        src/parsing_exception.hpp
        src/token.hpp
        src/token_category.hpp
        src/unary.hpp
        src/main.cpp)

add_executable(R-- ${SOURCE_FILES})

target_include_directories(R-- PUBLIC ${Boost_INCLUDE_DIRS})
target_link_libraries(R-- PUBLIC ${Boost_LIBRARIES})
target_compile_options(R-- PUBLIC -Wall)

install(TARGETS R-- DESTINATION ${CMAKE_INSTALL_BINDIR})

feature_summary(WHAT ALL)

MESSAGE(STATUS "Using CMAKE_CXX_COMPILER: " ${CMAKE_CXX_COMPILER})
MESSAGE(STATUS "Using CMAKE_CXX_FLAGS: " ${CMAKE_CXX_FLAGS})
MESSAGE(STATUS "Using CMAKE_CXX_FLAGS_RELWITHDEBINFO: " ${CMAKE_CXX_FLAGS_RELWITHDEBINFO})