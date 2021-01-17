"""
作者:Jetery
日期:2020//12//08//
"""
def get_average():
    sum_score = 0
    scores = {'语文':89, '数学':95, '英语':80}
    for subject in scores:
        score = scores[subject]
        sum_score += score
    ave_score = sum_score / len(scores)
    print('平均分是%d' % ave_score)
get_average()