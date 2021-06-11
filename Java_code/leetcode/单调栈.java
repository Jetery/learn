import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.06.11
 */
class StockSpanner {

    private Stack<Integer> stack;
    private Stack<Integer> dump;

    public StockSpanner() {
        stack = new Stack<>();
        dump = new Stack<>();
    }

    public int next(int price) {
        int ret = 1;
        while(!stack.isEmpty() && stack.peek() <= price) {
            stack.pop();
            ret += dump.pop();
        }
        stack.push(price);
        dump.push(ret);
        return ret;
    }
}