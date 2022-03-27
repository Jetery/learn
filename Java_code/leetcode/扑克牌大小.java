/*

 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A、2各4张，小王1张，大王1张。牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：
3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，如：4 4 4 4-joker JOKER。
请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
基本规则：
（1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
（2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）；
（3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；

（4）输入的两手牌不会出现相等的情况。 

*/

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // 处理手牌大小
        HashMap<String, Integer> map = new HashMap<>();
        map.put("3",1);
        map.put("4",2);
        map.put("5",3);
        map.put("6",4);
        map.put("7",8);
        map.put("8",9);
        map.put("9",10);
        map.put("10",11);
        map.put("J",12);
        map.put("Q",13);
        map.put("K",14);
        map.put("A",15);
        map.put("2",16);
        map.put("jocker",17);
        map.put("JOCKER",18);
        while (sc.hasNext()){
            String twoCards = sc.nextLine();
            String[] cards = twoCards.split("-");
            String[] left = cards[0].split(" ");
            String[] right = cards[1].split(" ");
            // 处理王炸
            if (left.length == 2 && left[0].toUpperCase().equals("JOKER") && left[0].toUpperCase().equals(left[1])){
                String ans = String.format("%s %s", left[0], left[1]);
                System.out.println(ans);
                return;
            } else if (right.length == 2 && right[0].toUpperCase().equals("JOKER")&& right[0].toUpperCase().equals(right[1])){
                String ans = String.format("%s %s", right[0], right[1]);
                System.out.println(ans);
                return;
            }
            // 处理炸弹
            if (left.length == 4 || right.length == 4){
                //left has
                if (left.length == 4){
                    //when right has
                    if (right.length == 4){
                        if (map.get(left[0]) > map.get(right[0])){
                            for (int i = 0; i < 3; i++){
                                System.out.print(left[i] + " ");
                            }
                            System.out.print(left[3] + "\n");
                            return;
                        } else {
                            for (int i = 0; i < 3; i++){
                                System.out.print(right[i]);
                            }
                            System.out.print(right[3] + "\n");
                            return;
                        }
                    } else {
                        for (int i = 0; i < 3; i++){
                            System.out.print(left[i] + " ");
                        }
                        System.out.print(left[3] + "\n");
                        return;
                    }
                } else {
                    for (int i = 0; i < 3; i++){
                        System.out.print(right[i] + " ");
                    }
                    System.out.print(right[3] + "\n");
                    return;
                }
              // 处理长度相同
            } else if (left.length == right.length){
                if(map.get(left[0]) > map.get(right[0])){
                    for (int i = 0; i < left.length - 1; i++){
                        System.out.print(left[i] + " ");
                    }
                    System.out.print(left[left.length-1] + "\n");
                    return;
                } else {
                    for (int i = 0; i < right.length - 1; i++){
                        System.out.print(right[i] + " ");
                    }
                    System.out.print(right[right.length - 1] + "\n");
                    return;
                }
                // 处理三个
            } else {
                System.out.println("ERROR");
                return;
            }
        }
    }
}