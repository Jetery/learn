/**

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在 队列尾部插入 整数和在 队列头部删除 整数的功能。
(若队列中没有元素，deleteHead 操作返回 -1 )



示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

*/

//  一个栈负责入元素, 删操作时, 将入栈元素全部弹至outPool栈中, outPool栈顶就是要删除的头部元素
//  需要注意的是, outPool 为空查看 inPool, 才能再次将inPool全部纳入

class CQueue {

    Stack<Integer> inPool;
    Stack<Integer> outPool;

    public CQueue() {
        inPool = new Stack<>();
        outPool = new Stack<>();
    }
    
    public void appendTail(int value) {
        inPool.push(value);
    }
    
    public int deleteHead() {
        if (inPool.isEmpty() && outPool.isEmpty()) return -1;
        if (!outPool.isEmpty()) {
            return outPool.pop();
        } else 
            while (!inPool.isEmpty()) 
                outPool.push(inPool.pop());
        return outPool.pop();
    }
}
