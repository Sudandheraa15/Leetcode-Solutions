class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitmask = new int[n];
        int[] len = new int[n];

        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            bitmask[i] = mask;
            len[i] = words[i].length();
        }

        int maxProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bitmask[i] & bitmask[j]) == 0) {
                    maxProduct = Math.max(maxProduct, len[i] * len[j]);
                }
            }
        }

        return maxProduct;
    }
}
