package yc.leetCode.Array;

import java.util.Scanner;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2023-07-18
 */

/**
 * 翻转单词顺序
 * 1、双指针
 *   a、判断" "，不存在，向左移动，i--，
 *   b、不等于 " "
 *使用string类的trim(),subString()方法，以及stringBuffer的append方法
 *
 */
public class InvertString {

    public static String invert(String str){
        str.trim();
        int i = str.length() - 1,j = i;

        StringBuffer strB = new StringBuffer();
        while (i >= 0) {
            while(i >= 0 && str.charAt(i) != ' '){
                i--;
            }
            strB.append(str.substring(i + 1,j + 1) + " ");
            while(i >= 0 && str.charAt(i) == ' '){
                i--;
            }
            j = i;

        }
        return strB.toString().trim();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String te = invert(str);
        System.out.println(te);
    }
}
