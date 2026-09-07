import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        b = b % n; // normalize
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        String smallest = s;

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (visited.contains(curr)) continue;
            visited.add(curr);

            if (curr.compareTo(smallest) < 0) smallest = curr;

            // Operation 1: add 'a' to all odd indices
            char[] added = curr.toCharArray();
            for (int i = 1; i < n; i += 2) {
                int digit = (added[i] - '0' + a) % 10;
                added[i] = (char) ('0' + digit);
            }
            String addStr = new String(added);

            // Operation 2: rotate right by b
            String rotStr = (b == 0) ? curr : (curr.substring(n - b) + curr.substring(0, n - b));

            if (!visited.contains(addStr)) queue.offer(addStr);
            if (!visited.contains(rotStr)) queue.offer(rotStr);
        }

        return smallest;
    }
}
