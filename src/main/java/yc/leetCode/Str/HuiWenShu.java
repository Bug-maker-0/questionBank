package yc.leetCode.Str;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2023-08-21
 */
public class HuiWenShu {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int cur = 0, num = x;
        while (num > 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1232));
    }
}
