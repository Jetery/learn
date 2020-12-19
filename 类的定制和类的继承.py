"""
作者:Jetery
日期:2020//12//11//
"""
class Student:
    def __init__(self, name, job=None, time=0.00, time_effective=0.00):
        self.name = name
        self.job = job
        self.time = time
        self.time_effective = time_effective

    def count_time(self, hour, rate):
        self.time += hour
        self.time_effective = hour * rate

# 请你完成子类的定制（包括初始化方法和count_time函数）
class Programmer(Student):
    def __init__(self,name,job='programmer',time=0.00,time_effective=0.00):
        Student.__init__(self,name,job,time,time_effective)
    def count_time(self,hour,rate=1.00):
        Student.count_time(self, hour, rate)

# 通过两个实例，完成子类和父类的对比（可自行验证）
student1 = Student('韩梅梅')
student2 = Programmer('李雷')
student1.count_time(10,0.8)
print(student1.time_effective)
student2.count_time(10)
print(student2.time_effective)
print(student1.job)
print(student2.job)
