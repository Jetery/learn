"""
作者:Jetery
日期:2020//12//15//
"""
class Book:
    def __init__(self, name, author, comment, state=0):
        self.name = name
        self.author = author
        self.comment = comment
        self.state = state

# 创建一个Book类的子类 FictionBook
class FictionBook(Book):
    def __init__(self, name, author, comment, state = 0,type = '虚构类'):
        Book.__init__(self, name, author, comment, state = 0)
        self.type = type
    # 继承并定制父类的初始化方法，增加默认参数 type = '虚构类'，让程序能够顺利执行。

    def __str__(self):
        status = '未借出'
        if self.state == 1:
            status = '已借出'
        return '类型：%s 名称：《%s》 作者：%s 推荐语：%s\n状态：%s ' % (self.type, self.name, self.author, self.comment, status)


book = FictionBook('囚鸟', '冯内古特', '我们都是受困于时代的囚鸟')
print(book)
