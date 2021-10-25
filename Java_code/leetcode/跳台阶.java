import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            LinkedList<Integer> queue = new LinkedList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(n,0);
            queue.offer(n);
            while (!queue.isEmpty()){
                int num = queue.poll();
                if (num == m){
                    System.out.println(map.get(num));
                    return;
                }
                if (num > m){
                    continue;
                }
                HashSet<Integer> set = new HashSet<>();
                help(num, set);
                for (int key : set){
                    if (!map.containsKey(num + key)){
                        map.put(num + key, map.get(num) + 1);
                        queue.offer(num + key);
                    }
                }
            }
            System.out.println(-1);
        }
    }

    private static void help(int n, HashSet<Integer> set){
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                set.add(i);
                set.add(n / i);
            }
        }
    }
}