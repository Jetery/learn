"""
作者:Jetery
日期:2021//02//03//
"""
import requests, bs4
# openpyxl
'''
# 创建工作薄
wb=openpyxl.Workbook()  
# 获取工作薄的活动表
sheet=wb.active 
# 工作表重命名
sheet.title='movies' 

sheet['A1'] ='序号'       # 加表头，给A1单元格赋值
sheet['B1'] ='电影名'     # 加表头，给B1单元格赋值
sheet['C1'] ='评分'      # 加表头，给C1单元格赋值
sheet['D1'] ='推荐语'    # 加表头，给D1单元格赋值
sheet['E1'] ='链接'     # 加表头，给E1单元格赋值
'''
headers={
    'user-agent':'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36'
}
for x in range(10):
    url = 'https://movie.douban.com/top250?start=' + str(x*25) + '&filter='
    res = requests.get(url, headers=headers)
    bs = bs4.BeautifulSoup(res.text, 'html.parser')
    bs = bs.find('ol', class_="grid_view")
    for titles in bs.find_all('li'):
        num = titles.find('em',class_="").text
        title = titles.find('span', class_="title").text
        comment = titles.find('span',class_="rating_num").text
        url_movie = titles.find('a')['href']

        if titles.find('span',class_="inq") != None:
            tes = titles.find('span',class_="inq").text
            #sheet.append([num, title, comment, tes, url_movie])
            # 把num, title, comment, tes和url_movie写成列表，用append函数多行写入Excel
            print(num + '.' + title + '——' + comment + '\n' + '推荐语：' + tes +'\n' + url_movie)
        else:
            #sheet.append([num, title, comment, None,url_movie])
            print(num + '.' + title + '——' + comment + '\n' +'\n' + url_movie)

# 最后保存并命名这个Excel文件
#wb.save(r'movieTop250.xlsx')