cmake_minimum_required(VERSION 3.20)
project(learn)

set(CMAKE_CXX_STANDARD 11)

#添加bits/stdc++的路径
include_directories(BEFORE dependencies/include)

# 添加子目录
add_subdirectory(acwing)


# fmt支持
add_subdirectory(dependencies/fmt EXCLUDE_FROM_ALL)


