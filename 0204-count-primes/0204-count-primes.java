class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
    boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;

    int count = 1;  
    for (int i = 3; i < n; i += 2) {
        if (isPrime[i]) {
            count++;
            if ((long) i * i < n) {
                for (int j = i * i; j < n; j += 2 * i) {
                    isPrime[j] = false;
                }
            }
        }
    }
        return count;
    }
}