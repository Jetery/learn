import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.06.05
 */
public class StackPopUpSequence {
    public class Solution {
        public boolean IsPopOrder(int [] pushA,int [] popA) {
            if (pushA.length == 0 || popA.length == 0){
                return false;
            }
            Stack<Integer> sta = new Stack<>();
            int j = 0;
            for(int i = 0; i < pushA.length; i++){
                sta.push(pushA[i]);
                while(!sta.isEmpty() && sta.peek() == popA[j]){
                    sta.pop();
                    j++;
                }
            }
            return sta.isEmpty();
        }
    }
}
