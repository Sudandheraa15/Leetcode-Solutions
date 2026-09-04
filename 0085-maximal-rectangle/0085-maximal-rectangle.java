class Solution {
    public int maximalRectangle(char[][] matrix) {
       if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            // Build histogram
            for (int j = 0; j < n; j++) {
                height[j] = (matrix[i][j] == '1') ? height[j] + 1 : 0;
            }
            // Calculate largest rectangle in histogram
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int[] h = Arrays.copyOf(heights, n + 1); // append 0 height to flush stack

        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
  