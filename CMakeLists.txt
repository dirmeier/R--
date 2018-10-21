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

set(SOURCE_FILES
        src/ast.cpp
        src/binary.cpp
        src/interpreter.cpp
        src/lexer.cpp
        src/number_node.cpp
        src/parser.cpp
        src/token.cpp
        src/token_category.hpp
        src/unary.cpp
        src/main.cpp)

add_executable(R-- ${SOURCE_FILES})
target_compile_options(R-- PUBLIC -Wall)
install(TARGETS R-- DESTINATION ${CMAKE_INSTALL_BINDIR})

feature_summary(WHAT ALL)

MESSAGE(STATUS "Using CMAKE_CXX_COMPILER: " ${CMAKE_CXX_COMPILER})
MESSAGE(STATUS "Using CMAKE_CXX_FLAGS: " ${CMAKE_CXX_FLAGS})
MESSAGE(STATUS "Using CMAKE_CXX_FLAGS_RELWITHDEBINFO: " ${CMAKE_CXX_FLAGS_RELWITHDEBINFO})