<<<<<<< HEAD
"""
作者:Jetery
日期:2021//03//31//
"""
# 导入os模块
import os
# 设置文件夹路径为'工作文件夹'，获取文件夹下的所有文件名
path = './工作文件夹/'
file_list = os.listdir(path)
# 设置需要查找的关键词
key_word = input("关键字为：")

# 打开结果文件'./result.txt'
last_file = open('./result.txt','a',encoding = 'utf-8')
# 循环处理每一个文件
for file_name in file_list:
    if 'txt' in file_name:
        target_name = path + file_name
        # 打开文件，读取文件内容，然后关闭文件
        file = open(target_name,'r',encoding = 'utf-8')
        content = file.read()
        file.close()
        # 判断关键词是否在文件内容中
        if key_word in content:
            # 匹配到关键词时先打印提示
            print("妙啊，文件**{}**包含了关键词：{}".format(target_name, key_word))
            # 将包含关键词的文档的文件路径，写入结果文件。使用换行符'\n'实现逐行写入的效果。
            last_file.write(target_name+'\n')

# 关闭结果文件
=======
"""
作者:Jetery
日期:2021//03//31//
"""
# 导入os模块
import os
# 设置文件夹路径为'工作文件夹'，获取文件夹下的所有文件名
path = './工作文件夹/'
file_list = os.listdir(path)
# 设置需要查找的关键词
key_word = input("关键字为：")

# 打开结果文件'./result.txt'
last_file = open('./result.txt','a',encoding = 'utf-8')
# 循环处理每一个文件
for file_name in file_list:
    if 'txt' in file_name:
        target_name = path + file_name
        # 打开文件，读取文件内容，然后关闭文件
        file = open(target_name,'r',encoding = 'utf-8')
        content = file.read()
        file.close()
        # 判断关键词是否在文件内容中
        if key_word in content:
            # 匹配到关键词时先打印提示
            print("妙啊，文件**{}**包含了关键词：{}".format(target_name, key_word))
            # 将包含关键词的文档的文件路径，写入结果文件。使用换行符'\n'实现逐行写入的效果。
            last_file.write(target_name+'\n')

# 关闭结果文件
>>>>>>> 164e6676e9948185caa5bb9073f9092dfca9b3f3
last_file.close()