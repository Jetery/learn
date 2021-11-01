import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            //  make sure to let b is longest
            if (a.length() > b.length()){
                String temp = a;
                a = b;
                b = temp;
            }
            String ans = "";
            for (int i = 0; i < a.length(); i++){
                for (int j = i + 1; j <= a.length(); j++){
                    String sub = a.substring(i, j);
                    System.out.println(sub);
                    if (b.contains(sub)){
                        if (sub.length() > ans.length()){
                            ans = sub;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}