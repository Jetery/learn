import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] strs = str.split("\\s+");
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            boolean flag = true;
            for (String s : strs){
                if (s.charAt(0) == '"' && s.charAt(s.length()-1) == '"'){
                    sb.append(s, 1,s.length()-1);
                    list.add(String.valueOf(sb));
                    ////
                    sb = new StringBuilder();
                    continue;
                }
                if (s.charAt(0) != '"' && s.charAt(s.length()-1) != '"'){
                    sb.append(s);
                    if(!flag) sb.append(" ");
                } else if (s.charAt(0) == '"'){
                    sb = new StringBuilder();
                    sb.append(s.substring(1)).append(" ");
                    flag = false;
                } else {
                    sb.append(s, 0, s.length()-1);
                    flag = true;
                }

                if (flag){
                    list.add(String.valueOf(sb));
                    sb = new StringBuilder();
                }
            }
            System.out.println(list.size());
            for(String s : list){
                System.out.println(s);
            }

        }
    }
}