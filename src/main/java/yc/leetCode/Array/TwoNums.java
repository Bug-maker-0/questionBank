package yc.leetCode.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangcheng <yangcheng03@kuaishou.com>
 * Created on 2023-07-14
 */
public class TwoNums {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mapNums.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (mapNums.containsKey(tmp)){
                int num = mapNums.get(tmp);
                if (num == i){
                    continue;
                }
                return new int[]{nums[i],nums[num]};
            }

        }
        return null;
    }


    /**
     * 双指针
     *
     * 分别从数组两头想中间走，由于数组是有序数组，i，j
     * 当 两数之和 > target j--；
     *    两数之和 < target i++;
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumV2(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int tmp = nums[i] + nums[j];
            if (tmp > target) {
                j--;
            } else if (tmp < target) {
                i++;
            } else if(tmp == target) {
                return new int[]{nums[i],nums[j]};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {14,15,16,22,53,60};
        int target = 76;
        int[] qwe = twoSumV2(nums,target);
        System.out.println("qwe: " + twoSum(nums,target));
    }
}
