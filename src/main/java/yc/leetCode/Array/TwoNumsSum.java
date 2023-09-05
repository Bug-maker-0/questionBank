package yc.leetCode.Array;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2023-08-21
 */
public class TwoNumsSum {

    public int[] twoSum(int[] nums, int target) {
        if(nums.length <= 1) {
            return null;
        }


        int i = 0, j = nums.length -1;

        while (i < j) {
            if (nums[i] + nums[j] > target){
                j--;
            }else if(nums[i] + nums[j] > target){
                i++;
            }else {
                return new int[]{i,j};
            }
        }

        return null;

    }
}
