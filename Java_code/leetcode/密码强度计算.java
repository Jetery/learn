import java.util.*;
public class Main{
    public static void main(String[] args){
        String A = "VERY_SECURE";
        String B = "SECURE";
        String C = "VERY_STRONG";
        String D = "STRONG";
        String E = "AVERAGE";
        String F = "WEAK";
        String G = "VERY_WEAK";
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            char[] chars = str.toCharArray();

            int level = 0;
            int len = str.length();
            if (len <= 4){
                level += 5;
            } else if (len < 8){
                level += 10;
            } else {
                level += 25;
            }
            int containsLetter = 0;
            int containsNum = 0;
            int containsSign = 0;

            int cntOfSmall = 0;
            int cntOfBig = 0;
            int cntOfNum = 0;
            int cntOfSign = 0;
            for (char c : chars){
                if (c >= 'a' && c <= 'z'){
                    cntOfSmall++;
                }
                if (c >= 'A' && c <= 'Z'){
                    cntOfBig++;
                }
                if (c >= '0' && c <= '9'){
                    cntOfNum++;
                }
                if ((c >= '!' && c <= '/') ||
                        (c >= ':' && c <= '@') ||
                        (c >= '[' && c <= '`') ||
                        (c >= '{' && c <= '~')){
                    cntOfSign++;
                }
            }
            if (cntOfBig > 0 && cntOfSmall > 0){
                containsLetter = 2;
                level += 20;
            } else if (cntOfBig > 0 || cntOfSmall > 0){
                containsLetter = 1;
                level += 10;
            }
            if (cntOfNum > 1){
                containsNum = 1;
                level += 20;
            } else if (cntOfNum > 0){
                containsNum = 1;
                level += 10;
            }
            if (cntOfSign > 1){
                containsSign = 1;
                level += 25;
            } else if (cntOfSign > 0){
                containsSign = 1;
                level += 10;
            }
            if (containsLetter == 2 && containsNum == 1 && containsSign == 1){
                level += 5;
            } else if (containsLetter == 1 && containsNum == 1 && containsSign == 1){
                level += 3;
            } else if (containsNum == 1 && containsSign == 1){
                level += 2;
            }
            System.out.println(level);
            if (level >= 90){
                System.out.println(A);
            } else if (level >= 80){
                System.out.println(B);
            } else if (level >= 70){
                System.out.println(C);
            } else if (level >= 60){
                System.out.println(D);
            } else if (level >= 50){
                System.out.println(E);
            } else if (level >= 25){
                System.out.println(F);
            } else {
                System.out.println(G);
            }
        }
    }
}