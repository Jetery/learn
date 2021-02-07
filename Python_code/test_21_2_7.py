"""
作者:Jetery
日期:2022//02//07//
"""
import requests
# 引用requests模块
from bs4 import BeautifulSoup
# 为躲避反爬机制，伪装成浏览器的请求头
headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36'}
for x in range(10):
    url = 'https://movie.douban.com/top250?start=' + str(x*25) + '&filter='
    res = requests.get(url, headers=headers)
    bs = BeautifulSoup(res.text, 'html.parser')
    tag_num = bs.find_all('div', class_="item")
    # 查找包含序号，电影名，链接的<div>标签
    tag_comment = bs.find_all('div', class_='star')
    # 查找包含评分的<div>标签
    tag_word = bs.find_all('span', class_='inq')
    # 查找推荐语
    list_all = []
    for x in range(len(tag_num)):
        if tag_num[x].text[2:5] == '' or tag_num[x].text[2:5] =='' or x >= len(tag_word):
        # 此处引号内，填写没有推荐语的电影序号
            list_movie = [tag_num[x].text[2:5], tag_num[x].find('img')['alt'], tag_comment[x].text[2:5], tag_num[x].find('a')['href'] ]
        else:
            list_movie = [tag_num[x].text[2:5], tag_num[x].find('img')['alt'], tag_comment[x].text[2:5], tag_word[x].text, tag_num[x].find('a')['href']]
        list_all.append(list_movie)
    print(list_all)