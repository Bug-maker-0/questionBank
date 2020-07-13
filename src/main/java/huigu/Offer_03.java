package huigu;

import java.util.HashMap;

public class Offer_03 {
    public int findRepeatNumber(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; ++i){
            if (map.containsKey(nums[i])) {
                int sum = (int) map.get(nums[i]);
                map.put(nums[i],sum+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int key = -1;
        for (int getKey:map.keySet()) {
            if(map.get(getKey)>=2){
                key = getKey;
            }
        }

        System.out.println(map.entrySet());
        return key;
    }

    public int findRepeatNumber1(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={2,3,1,0,2,5,3};
        Offer_03 offer_03 = new Offer_03();
        int number = offer_03.findRepeatNumber(nums);
        System.out.println(number);
    }
}
