"""
作者:Jetery
日期:2020//12//01//
"""
import random
import time

def main(a, b, c):
    luckylist = [a, b, c]
    a = random.choice(luckylist)
    print('开奖倒计时', 3)
    time.sleep(1)
    print('开奖倒计时', 2)
    time.sleep(1)
    print('开奖倒计时', 1)
    time.sleep(1)
    image = '''
     /\_)o<
    |      \\
    | O . O|
     \_____/
    '''
    print(image)
    print('恭喜' + a + '中奖！')

main('海绵宝宝', '派大星', '章鱼哥')
