"""
作者:Jetery
日期:2021//03//23//
"""
import re

string = "  .  it is  blank space test *  I    love  python"
str_new1 = re.sub(r"\s+", " ", string) # 多个连续空格合并成一个空格
print(str_new1)
str_new3 = ' '.join(string.split())
print(str_new3)

