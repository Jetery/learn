"""
作者:Jetery
日期:2020//12//06//
"""
import random

punches = ['石头','剪刀','布']
punches2 = ['1','2','3']
computer_choice = random.choice(punches)
user_choice = input('你的选择是：1.石头,2.剪刀,3.布')
while user_choice not in punches2:
    user_choice = input('输入有误，请重新出拳')

# 亮拳
print('————战斗过程————')
print('电脑的选择是：%s,你的选择是：%s'%(computer_choice,punches[int(user_choice)-1]))

#判断胜负
if computer_choice == punches[int(user_choice)-1]:
    print('平局')
elif (computer_choice == '石头' and user_choice == '3')or(computer_choice == '剪刀' and user_choice == '1')or(computer_choice == '布' and user_choice == '2'):
    print('你赢了')
else:
    print('你输了')
