class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        
        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        
        int i = 0, j = 0, d = 1; // direction: 1 = up-right, -1 = down-left
        for (int k = 0; k < m * n; k++) {
            result[k] = mat[i][j];
            
            if (d == 1) { // moving up-right
                if (j == n - 1) { // hit right boundary
                    i++;
                    d = -1;
                } else if (i == 0) { // hit top boundary
                    j++;
                    d = -1;
                } else {
                    i--;
                    j++;
                }
            } else { // moving down-left
                if (i == m - 1) { // hit bottom boundary
                    j++;
                    d = 1;
                } else if (j == 0) { // hit left boundary
                    i++;
                    d = 1;
                } else {
                    i++;
                    j--;
                }
            }
        }
        
        return result;
    }
}

