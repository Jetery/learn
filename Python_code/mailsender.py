"""
作者:Jetery
日期:2020//12//30//
"""
import smtplib
from email.mime.text import MIMEText
from email.header import Header
import csv

# 发信方的信息：发信邮箱，QQ邮箱授权码
from_addr = '981695266@qq.com'
password = input('请输入授权码:')

# 发信服务器
smtp_server = 'smtp.qq.com'

# 收信方邮箱
data = [['1','981695266@qq.com'],['2','434706440@qq.com']]

with open('to_adders.csv','w',newline='') as f:
    writer = csv.writer(f)
    for row in data:
        writer.writerow(row)

# 编辑文档
text = """希望学习Python对你不是一件困难的事情！

人生苦短，我用Python
"""

# 读取csv
with open('to_adders.csv','r') as f:
    reader = csv.reader(f)
    for row in reader:
        to_adders = row[1]
        # 发送邮件
        msg = MIMEText(text, 'plain', 'utf-8')
        # 邮件头信息
        msg['From'] = Header(from_addr)
        msg['To'] = Header(','.join(to_adders))
        msg['Subject'] = Header('python test')
        # 开启发信服务，这里使用的是加密传输
        server = smtplib.SMTP_SSL(smtp_server)
        server.connect(smtp_server, 465)
        # 登录发信邮箱
        server.login(from_addr, password)
        server.sendmail(from_addr, to_adders, msg.as_string())

# 关闭服务器
server.quit()
