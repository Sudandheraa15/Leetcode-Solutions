import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int second = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < second) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = stack.pop(); // update the "2"
            }
            stack.push(nums[i]); // potential "3"
        }
        
        return false;
    }
}
