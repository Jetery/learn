/*

NowCoder在淘宝上开了一家网店。他发现在月份为素数的时候，当月每天能赚1元；否则每天能赚2元

现在给你一段时间区间，请你帮他计算总收益有多少

输入描述:

    输入包含多组数据。

    每组数据包含两个日期from和to (2000-01-01 ≤ from ≤ to ≤ 2999-12-31)。

    日期用三个正整数表示，用空格隔开：year month day。



输出描述:

    对应每一组数据，输出在给定的日期范围（包含开始和结束日期）内能赚多少钱。

*/

import java.util.*;
public class Main{
    private static boolean isLeapYear(int year){
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
            return true;
        }
        return false;
    }
    private static boolean isPrime(int num){
        if (num == 1){
            return false;
        }
        if (num == 2){
            return true;
        }
        for (int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] leap = new int[] {0, 31, 29, 31, 30,
                               31, 30, 31, 31,
                               30, 31, 30, 31};
        int[] days = new int[] {0, 31, 28, 31, 30,
                               31, 30, 31, 31,
                               30, 31, 30, 31};
        while (sc.hasNext()){
            int beginYear = sc.nextInt();
            int beginMonth = sc.nextInt();
            int beginDay = sc.nextInt();
            int endYear = sc.nextInt();
            int endMonth = sc.nextInt();
            int endDay = sc.nextInt();
            int leapYearBenefit = 0;
            for (int i = 1; i <= 12; i++){
                if (isPrime(i)){
                    leapYearBenefit += leap[i];
                } else {
                    leapYearBenefit += leap[i] * 2;
                }
            }
            int daysBenefit = 0;
            for (int i = 1; i <= 12; i++){
                if (isPrime(i)){
                    daysBenefit += days[i];
                } else {
                    daysBenefit += days[i] * 2;
                }
            }
            int ans = 0;
            //处理中间
            if (endYear - 1 > beginYear){
                for (int i = beginYear + 1; i < endYear; i++){
                    if (isLeapYear(i)){
                        ans += leapYearBenefit;
                    } else {
                        ans += daysBenefit;
                    }
                }
            }
            //处理头尾
            //同年同月
            if (beginYear == endYear && beginMonth == endMonth){
                if (isPrime(beginMonth)){
                    ans += endDay - beginDay + 1;
                } else {
                    ans += (endDay - beginDay + 1) * 2;
                }
            //仅同年
            } else if (beginYear == endYear){
                if (isLeapYear(beginYear)){
                    //起始月
                    if (isPrime(beginMonth)){
                        ans += leap[beginMonth] - beginDay;
                    } else {
                        ans += (leap[beginMonth] - beginDay) * 2;
                    }
                    //中间月
                    for (int i = beginMonth + 1; i < endMonth; i++){
                        if (isPrime(i)){
                            ans += leap[i];
                        } else {
                            ans += leap[i] * 2;
                        }
                    }
                    //尾月
                    if (isPrime(endMonth)){
                        ans += endDay;
                    } else {
                        ans += endDay * 2;
                    }
                } else {
                    //起始月
                    if (isPrime(beginMonth)){
                        ans += days[beginMonth] - beginDay;
                    } else {
                        ans += (days[beginMonth] - beginDay) * 2;
                    }
                    //中间月
                    for (int i = beginMonth + 1; i <= endMonth; i++){
                        if (isPrime(i)){
                            ans += days[i];
                        } else {
                            ans += days[i] * 2;
                        }
                    }
                    //尾月
                    if (isPrime(endMonth)){
                        ans += endDay;
                    } else {
                        ans += endDay * 2;
                    }
                }
            //不同年
            } else {
                
                //第一年
                if (isLeapYear(beginYear)){
                    //第一月
                    if (isPrime(beginMonth)){
                        ans += leap[beginMonth] - beginDay + 1;
                    } else {
                        ans += (leap[beginMonth] - beginDay + 1) * 2;
                    }
                    //后续月
                    for (int i = beginMonth + 1; i <= 12; i++){
                        if (isPrime(i)){
                            ans += leap[i];
                        } else {
                            ans += leap[i] * 2;
                        }
                    }
                } else {
                    //第一月
                    if (isPrime(beginMonth)){
                        ans += days[beginMonth] - beginDay + 1;
                    } else {
                        ans += (days[beginMonth] - beginDay + 1) * 2;
                    }
                    //后续月
                    for (int i = beginMonth + 1; i <= 12; i++){
                        if (isPrime(i)){
                            ans += days[i];
                        } else {
                            ans += days[i] * 2;
                        }
                    }
                }
                
                if (isLeapYear(endYear)){
                    //最后月
                    if (isPrime(endMonth)){
                        ans += endDay;
                    } else {
                        ans += endDay * 2;
                    }
                    //前序月
                    for (int i = 1; i < endMonth; i++){
                        if (isPrime(i)){
                            ans += leap[i];
                        } else {
                            ans += leap[i] * 2;
                        }
                    }
                } else {
                    //最后月
                    if (isPrime(endMonth)){
                        ans += endDay;
                    } else {
                        ans += endDay * 2;
                    }
                    //前序月
                    for (int i = 1; i < endMonth; i++){
                        if (isPrime(i)){
                            ans += days[i];
                        } else {
                            ans += days[i] * 2;
                        }
                    }
                }
                
                
            }
            System.out.println(ans);
        }
    }
}