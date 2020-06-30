
package yc.jianZhiOffer;

import java.util.Stack;

public class JZ_20 {
    /*定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
    注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。*/
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public void push(int node) {
        stack1.push(node);
        if(stack2.empty()){
            stack2.push(node);
        }else{
            if(node <= stack2.peek()){
                stack2.push(node);
            }else{
                stack2.push(stack2.peek());
            }
        }

    }
    //出栈，当stack1栈顶的数出栈时，stack2栈顶的数也要出栈，从而保证stack1最小的出栈，从而使stack2中最小的值改变
    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();

    }

    public int min() {
        return stack2.peek();
    }
}
