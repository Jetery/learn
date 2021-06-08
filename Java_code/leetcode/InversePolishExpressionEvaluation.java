import java.util.Stack;

/**
* Created with IntelliJ IDEA
* Description:
* User: Jetery
* Date: 2021.06.05
*/public class InversePolishExpressionEvaluation {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < tokens.length; i++){
                if(tokens[i].equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                } else if (tokens[i].equals("-")) {
                    int num = stack.pop();
                    stack.push(stack.pop() - num);
                } else if (tokens[i].equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else if (tokens[i].equals("/")) {
                    int num = stack.pop();
                    stack.push(stack.pop() / num);
                } else {
                    stack.push(Integer.valueOf(tokens[i]));
                }
            }
            return stack.pop();
        }
    }
}
