import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];
        
        // Store start and original index
        int[][] startWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            startWithIndex[i][0] = intervals[i][0]; // start
            startWithIndex[i][1] = i;               // original index
        }
        
        // Sort by start
        Arrays.sort(startWithIndex, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int idx = binarySearch(startWithIndex, end);
            result[i] = idx;
        }
        
        return result;
    }
    
    private int binarySearch(int[][] startWithIndex, int target) {
        int left = 0, right = startWithIndex.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (startWithIndex[mid][0] >= target) {
                res = startWithIndex[mid][1];
                right = mid - 1; // try to find smaller start
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
