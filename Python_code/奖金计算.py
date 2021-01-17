"""
作者:Jetery
日期:2020//11//30//
"""
def money(time):
    global money
    if time <= 0:
        print('请输入大于零的数字！')
    elif 0 < time < 6:
        money == 500
        return money
    elif 6 <= time <= 12:
        money = time * 120
        return money
    else:
        money = time * 180
        return money


def main(name, time):
    print(name + '来了' + str(time) + '个月,获得奖金' + str(money(time)) + '元')
main('大聪', 14)
