import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(nums, 0, 0, target, memo);
    }
    
    private int dfs(int[] nums, int index, int sum, int target, Map<String, Integer> memo) {
        String key = index + "," + sum;
        if (memo.containsKey(key)) return memo.get(key);
        
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        
        int count = dfs(nums, index + 1, sum + nums[index], target, memo) +
                    dfs(nums, index + 1, sum - nums[index], target, memo);
        
        memo.put(key, count);
        return count;
    }
}
