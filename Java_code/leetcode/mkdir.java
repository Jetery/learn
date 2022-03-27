/*

链接：https://www.nowcoder.com/questionTerminal/433c0c6a1e604a4795291d9cd7a60c7a
来源：牛客网

工作中，每当要部署一台新机器的时候，就意味着有一堆目录需要创建。
例如要创建目录“/usr/local/bin”，就需要此次创建“/usr”、“/usr/local”以及“/usr/local/bin”。
好在，Linux下mkdir提供了强大的“-p”选项，只要一条命令“mkdir -p /usr/local/bin”就能自动创建需要的上级目录。
现在给你一些需要创建的文件夹目录，请你帮忙生成相应的“mkdir -p”命令。

输入描述:
	输入包含多组数据。

	每组数据第一行为一个正整数n(1≤n≤1024)。

	紧接着n行，每行包含一个待创建的目录名，目录名仅由数字和字母组成，长度不超过200个字符。


输出描述:
	对应每一组数据，输出相应的、按照字典顺序排序的“mkdir -p”命令。

	每组数据之后输出一个空行作为分隔。


示例1
	
	输入
		3
		/a
		/a/b
		/a/b/c
		3
		/usr/local/bin
		/usr/bin
		/usr/local/share/bin
	
	输出
		mkdir -p /a/b/c

		mkdir -p /usr/bin
		mkdir -p /usr/local/bin
		mkdir -p /usr/local/share/bin

*/
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            String[] strs = new String[n];
            for (int i = 0; i < n; i++){
                strs[i] = sc.nextLine();
            }
            Arrays.sort(strs);
            List<String> list = new ArrayList<>();
            for (int i = 1; i < n; i++){
            	// + "/" 是细节!!!
                if (!strs[i].startsWith(strs[i - 1] + "/")){
                    list.add(strs[i - 1]);
                }
            }
            list.add(strs[n - 1]);
            String begin = "mkdir -p ";
            for (String s : list){
                System.out.println(begin + s);
            }
            System.out.println();
        }
    }
}