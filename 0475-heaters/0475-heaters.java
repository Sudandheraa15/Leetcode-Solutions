import java.util.*;

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;

        for (int house : houses) {
            int pos = Arrays.binarySearch(heaters, house);
            if (pos < 0) {
                pos = -pos - 1; // insertion point
            }
            
            int dist1 = pos - 1 >= 0 ? house - heaters[pos - 1] : Integer.MAX_VALUE;
            int dist2 = pos < heaters.length ? heaters[pos] - house : Integer.MAX_VALUE;
            radius = Math.max(radius, Math.min(dist1, dist2));
        }
        
        return radius;
    }
}
