/*

链接：https://www.nowcoder.com/questionTerminal/03ba8aeeef73400ca7a37a5f3370fe68
来源：牛客网

定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
现在给定你 n 个单词，另外再给你一个单词 str ，让你寻找 str 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
注意：字典中可能有重复单词。本题含有多组输入数据。

数据范围：1 ≤ n ≤ 1000 ，输入的字符串长度满足 1 ≤ len(str) ≤ 10   1 ≤ k < n 

输入描述:
先输入单词的个数n，再输入n个单词。
再输入一个单词，为待查找的单词x
最后输入数字k


输出描述:
	输出查找到x的兄弟单词的个数m
	然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。

示例1
	输入
		3 abc bca cab abc 1
	输出
		2
		bca

示例2
	输入
		6 cab ad abcd cba abc bca abc 1
	输出
		3
		bca

说明
	abc的兄弟单词有cab cba bca，所以输出3
	经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca   

*/


import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++)
                strs[i] = sc.next();
            String str = sc.next();
            HashMap<Character, Integer> strMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                strMap.put(c, strMap.getOrDefault(c, 0) + 1);
            }

            List<String> list = new ArrayList<>();
            for (String s : strs){
                if (!s.equals(str) && s.length() == str.length()){
                    HashMap<Character, Integer> tempMap = new HashMap<>();
                    boolean flag = true;
                    for (int i = 0; i < s.length(); i++){
                        char c = s.charAt(i);
                        if (strMap.containsKey(c)){
                            tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    for (char c : strMap.keySet()){
                        if (!Objects.equals(strMap.get(c), tempMap.get(c))){
                            flag = false;
                            break;
                        }
                    }
                    if (flag) list.add(s);

                }
            }

            int k = sc.nextInt();
            System.out.println(list.size());
            if (list.size() >= k){
                Collections.sort(list);
                System.out.println(list.get(k - 1));
            }
        }
    }
}
