package yc.leetCode.Array;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2022-03-09
 */


/**
 * 盛最多的水
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 */
public class LeetCode_11 {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int sum = 0;

        //通过双指针方式解决问题，移动较小一侧，计算最大面积
        while (left < right) {

            //取最小一侧，乘以数组长度
            int area = Math.min(height[left], height[right]) * (right - left);
            //取最大面积
            sum = Math.max(sum, area);
            //判断左右指针大小，左小则left+1，右小则right-1

            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        LeetCode_11 leetCode_11 = new LeetCode_11();

        int area = leetCode_11.maxArea(height);

        System.out.println(area);
    }
}
