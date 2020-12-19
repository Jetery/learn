"""
作者:Jetery
日期:2020//12//09//
"""
class Robot:
    def __init__(self, robot, you, wish):
        self.robot = robot
        self.you = you
        self.wish = wish

    def greeting(self):
        print('你好，%s。我是%s。遇见你，真好。' % (self.you, self.robot))

    def say_wish(self):
        print('%s的愿望是：' % (self.you))
        for i in range(3):
            print('%s' % (self.wish))


Z = Robot('瓦力', 'ZTR', '学会 Python 基础！')
Z.greeting()
Z.say_wish()
