package yc.jianZhiOffer;

import java.util.Stack;

public class JZ_21 {
    /*输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
    假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
    但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）*/
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0 || pushA.length != popA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0 , j = 0 ;
        while(i < pushA.length){
            //判断压栈的数和出栈的数是否相等，不相等着把数压入栈中 ，i++，对下一个数进行判断
            if(pushA[i] != popA[j]){
                stack.push(pushA[i++]);
            }else{
                //当判断出压入栈的数和出栈数相等时，分别+1 对下一个数进行判断
                ++i;
                ++j;
                //对压入栈判空 和 栈顶元素是否和 当前出栈数相等
                while(!stack.empty() && stack.peek() == popA[j]){
                    //栈顶的出栈
                    stack.pop();
                    ++j;
                }
            }
        }
        return stack.empty();
    }
}
