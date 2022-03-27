/*

MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。

为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌

现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：

1. 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。

光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。

其他情况下用户按Up键，光标挪到上一首歌曲；用户按Down键，光标挪到下一首歌曲。

2. 歌曲总数大于4的时候（以一共有10首歌为例）：


特殊翻页：屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，屏幕要显示最后一页（即显示第7-10首歌），

同时光标放到最后一首歌上。同样的，屏幕显示最后一页时，光标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上。

一般翻页：屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时，用户按Up键后，屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。

光标当前屏幕的最后一首歌时的Down键处理也类似。

其他情况，不用翻页，只是挪动光标就行。

数据范围：本题含有多组输入数据，数据组数，命令长度，歌曲数量

进阶：时间复杂度：O(n)，空间复杂度： O(n)

*/

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = Integer.parseInt(sc.nextLine());
            String order = sc.nextLine();
            char[] orders = order.toCharArray();
            int now = 1;
            int head = now;
            int last = now + 3;
            for (int i = 0; i < orders.length; i++){
                char ord = orders[i];
                if (ord == 'U') {
                    if (now == 1){
                        now = n;
                        head = now - 3;
                        last = n;
                    } else {
                        now--;
                        if (now + 1 == head){
                            last--;
                            head--;
                        }
                    }
                } else {
                    if (now == n){
                        now = 1;
                        head = 1;
                        last = now + 3;
                    } else {
                        now++;
                        if (now - 1 == last){
                            head++;
                            last++;
                        }
                    }
                }
            }
            if (n <= 4){
                for (int i = 1; i <= n; i++){
                    if (i == n){
                        System.out.println(i);
                        break;
                    }
                    System.out.print(i + " ");
                }
                System.out.println(now);
                continue;
            }
            for (int i = head; i <= last; i++){
                if (i == last){
                    System.out.println(i);
                    break;
                }
                System.out.print(i + " ");
            }
            System.out.println(now);
        }
    }
}