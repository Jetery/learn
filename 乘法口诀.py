"""
作者:Jetery
日期:2020//11//29//
"""
list = []
for i2 in range(1,10):
    for i1 in range(1,i2+1):
        list.append("{0} X {1} = {2}".format(i1,i2,i1*i2))
    print(list[-i2:])