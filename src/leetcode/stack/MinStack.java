package leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 155. 最小栈
 * <a href='https://leetcode-cn.com/problems/min-stack/'>155. 最小栈（2019/8/26）</a>
 */
class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println((minStack.getMin()));
    }

    /**
     * initialize your data structure here.
     */
    private int min;
    private final static List<Integer> mList = new ArrayList<Integer>();

    public MinStack() {

    }

    public void push(int val) {
        if (mList.size() == 0) {
            min = val;
        } else {
            min = Math.min(val, min);
        }
        mList.add(val);
    }

    public void pop() {
        int size = mList.size();

        if (size > 1 && mList.get(size - 1) == min) {
            mList.remove(size - 1);
            min = mList.get(0);
            for (int i = 1; i < size - 1; i++) {
//                if (mList.get(i) < min) {
//                    min = mList.get(i);
//                }
                min = Math.min(mList.get(i), min);
            }
        } else {
            mList.remove(size - 1);
        }

    }

    public int top() {
        return mList.get(mList.size() - 1);
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */