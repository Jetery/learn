"""
作者:Jetery
日期:2020//11//27//
"""
n = 24
x = 3
for i in range(3):
    y = input('猜猜数字是几？你现在有'+str(x)+'次机会')
    x = x-1
    if int(y) < n:
        print('太小了')
        continue
    elif int(y) > n:
        print('太大了')
        continue
    else:
        print('TRUE')
        break
else:
    print('失败了')