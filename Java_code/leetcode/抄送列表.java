/*

NowCoder每天要处理许多邮件，但他并不是在收件人列表中，有时候只是被抄送

他认为这些抄送的邮件重要性比自己在收件人列表里的邮件低，因此他要过滤掉这些次要的邮件，优先处理重要的邮件

现在给你一串抄送列表，请你判断目标用户是否在抄送列表中

输入描述:
    输入有多组数据，每组数据有两行

    第一行抄送列表，姓名之间用一个逗号隔开。如果姓名中包含空格或逗号，则姓名包含在双引号里。总长度不超过512个字符

    第二行只包含一个姓名，是待查找的用户的名字（姓名要完全匹配）。长度不超过16个字符


输出描述:

    如果第二行的名字出现在收件人列表中，则输出“Ignore”，表示这封邮件不重要；

    否则，输出“Important!”，表示这封邮件需要被优先处理。


示例1

    输入
        Joe,Kewell,Leon
        Joe
        "Letendre, Bruce",Joe,"Quan, William"
        William

    输出
        Ignore
        Important!


*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String first = sc.nextLine();
            String second = sc.nextLine();
            TreeSet<String> set = new TreeSet<>();
            StringBuilder s = new StringBuilder();
            char[] names = first.toCharArray();
            for (int i = 0; i < names.length; i++){
                char c = names[i];
                int j = i + 1;
                if (c == '"'){
                    for ( ; j < names.length && names[j] != '"'; j++){
                        s.append(names[j]);
                    }
                } else {
                    if (j < names.length){
                        c = names[j];
                    }
                    if (c == '"'){
                        continue;
                    } else {
                        j--;
                    }
                    for ( ; j < names.length && names[j] != ','; j++){
                        s.append(names[j]);
                    }
                }
                i = j;
                set.add(s.toString());
                s = new StringBuilder();
            }
            if (set.contains(second)){
                System.out.println("Ignore");
            } else {
                System.out.println("Important!");
            }
        }

    }
}