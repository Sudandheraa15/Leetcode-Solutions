import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        // Sort by the second element of each pair
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        
        int currentEnd = Integer.MIN_VALUE;
        int count = 0;
        
        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) {
                count++;
                currentEnd = pair[1];
            }
        }
        
        return count;
    }
}
