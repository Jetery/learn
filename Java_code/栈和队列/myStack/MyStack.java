package myStack;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 * User: Jetery
 * Date: 2021.06.04
 */
public class MyStack<T> {
    private T[] elem;//数组
    private int top;//当前可以存放数据元素的下标-》栈顶指针

    public MyStack() {
        this.elem = (T[]) new Object[10];
    }

    /**
     * 入栈操作
     * @param item 入栈的元素
     */
    public void push(T item) {
        //1、判断当前栈是否是满的
        if(top == this.elem.length){
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }

        // 2、elem[top] = item top++;
        this.elem[this.top++] = item;
    }

    /**
     * 出栈
     * @return 出栈的元素
     */
    public T pop() {
        if (empty()){
            throw new UnsupportedOperationException("栈为空");
        } else {
            //这里是前置--，很容易写成后置
            //注意top的指向
            return this.elem[--this.top];
        }
    }

    /**
     * 得到栈顶元素，但是不删除
     * @return
     */
    public T peek() {
        if (empty()){
            throw new UnsupportedOperationException("栈为空");
        } else {
            //top是课添加位置，读取需要 - 1
            return this.elem[this.top - 1];
        }
    }

    public boolean empty(){
        return this.top == 0;
    }

}