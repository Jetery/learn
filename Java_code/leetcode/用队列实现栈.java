//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。 
//
// 实现 MyStack 类： 
//
// 
// void push(int x) 将元素 x 压入栈顶。 
// int pop() 移除并返回栈顶元素。 
// int top() 返回栈顶元素。 
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 注意： 
//
// 
// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。 
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 2, 2, false]
//
//解释：
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // 返回 2
//myStack.pop(); // 返回 2
//myStack.empty(); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用100 次 push、pop、top 和 empty 
// 每次调用 pop 和 top 都保证栈不为空 
// 
//
// 
//
// 进阶：你能否实现每种操作的均摊时间复杂度为 O(1) 的栈？换句话说，执行 n 个操作的总时间复杂度 O(n) ，尽管其中某个操作可能需要比其他操作更长的
//时间。你可以使用两个以上的队列。 
// Related Topics 栈 设计 
// 👍 332 👎 0


package leetcode.editor.cn;
//Java：用队列实现栈
public class P225ImplementStackUsingQueues{
    public static void main(String[] args) {
        Solution solution = new P225ImplementStackUsingQueues().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyStack {

        private Queue<Integer> q1;
        private Queue<Integer> q2;

        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (!q1.isEmpty()){
                q1.offer(x);
            } else if(!q2.isEmpty()){
                q2.offer(x);
            } else {
                q1.offer(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (empty()) return -1;
            if (!q1.isEmpty()) {
                int size = q1.size();
                for(int i = 0; i < size - 1; i++){
                    q2.offer(q1.poll());
                }
                return q1.poll();
            } else {
                int size = q2.size();
                for(int i = 0; i < size - 1; i++) {
                    q1.offer(q2.poll());
                }
                return q2.poll();
            }
        }

        /** Get the top element. */
        public int top() {
            if (empty()) return -1;
            int x = -1;
            if (!q1.isEmpty()) {
                int size = q1.size();
                for(int i = 0; i < size; i++){
                    x = q1.poll();
                    q2.offer(x);
                }
                return x;
            } else {
                int size = q2.size();
                for(int i = 0; i < size; i++){
                    x = q2.poll();
                    q1.offer(x);
                }
                return x;
            }
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
