"""
作者:Jetery
日期:2020//11//27//
"""
movies = {
'妖猫传':['黄轩','染谷将太'],
'无问西东':['章子怡','王力宏','祖峰'],
'超时空同居':['雷佳音','佟丽娅'],
}

actor = input('你想查询哪个演员？')
for  movie in movies:  # 用 for 遍历字典
    actors = movies[movie]  # 读取各个字典的主演表
    if actor in actors:
        print(actor + '出演了电影' + movie)