package yc.leetCode.Stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2023-01-23
 */
public class LeetCode_20 {



    public boolean isValid(String s) {
        if (s.length() % 2 != 0 ){
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character> (){
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');

            }
        };
        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                if (stack.isEmpty() || stack.peek() != map.get("ch")){
                    return false;
                }
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }
}
