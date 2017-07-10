package fatlamb.leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 58 on 2017/7/7.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].

 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i= 0 ; i < nums.length ; i++){
            for (int j = i+1 ; j < nums.length ; j++){
                try{
                    if (nums[i] + nums[j] == target){
                        result[0] = i ;
                        result[1] = j ;
                        return result ;
                    }
                }catch (Exception e){}
            }
        }
        return result ;
    }

    public int[] twoSumHashmap(int[] nums , int target){
        Map<Integer , Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < nums.length ; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]) , i};
            }
            map.put(nums[i] , i) ;
        }
        return  null ;
    }
}
