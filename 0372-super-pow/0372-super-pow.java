class Solution {
   
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return helper(a % MOD, b, b.length - 1);
    }

    private int helper(int a, int[] b, int index) {
        if (index < 0) return 1;
        int last = b[index];
        int part1 = modPow(a, last);
        int part2 = modPow(helper(a, b, index - 1), 10);
        return (part1 * part2) % MOD;
    }

    private int modPow(int a, int k) {
        int res = 1;
        a %= MOD;
        while (k > 0) {
            if ((k & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            k >>= 1;
        }
        return res;
    }
}

