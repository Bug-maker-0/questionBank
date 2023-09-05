package yc.leetCode.Array;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2023-08-24
 */
public class ZhengShuFanZhuan {

    public static int reverse(int x) {
        char[] ch = String.valueOf(x).toCharArray();
        char[] hc = new char[]{};

        if (x < 0 ) {
            hc[0] = ch[0];
            for (int i = 1, length = ch.length - 1; length > 0 ; i++) {
                hc[i] = ch[length];
                length--;
            }
        } else {
            for (int i = 0, length = ch.length - 1; i < ch.length ; i++) {
                hc[i] = ch[length];
                length--;
            }
        }

        return Integer.valueOf(String.valueOf(hc));
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
}
