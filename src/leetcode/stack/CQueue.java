package leetcode.stack;

import java.util.Stack;

//剑指 Offer 09. 用两个栈实现队列
public class CQueue {
    //初始化两个栈
    Stack<Integer> stack1, stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    //入队，我们往第一个栈压入值
    public void appendTail(int value) {
        stack1.push(value);
    }

    //出队
    public int deleteHead() {
        //如果执行过一次 那么新的元素还在栈中 属于后面的元素 不需要倾倒进入
        if (stack2.isEmpty()) {
            //如果此时A栈没有值，则直接-1 根据题意输出
            if (stack1.isEmpty()) {
                return -1;
            }
            //当B栈元素没有了 或者B栈为空的情况
            //将A栈的值，压入B栈中
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        //此时满足队列的排序
        return stack2.pop();
    }
}