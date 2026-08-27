class Solution {
    public static boolean isPrime(int x) {
     if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
     public static int createPalindrome(int half) {
        String halfStr = Integer.toString(half);
        StringBuilder sb = new StringBuilder(halfStr);
        sb.reverse();
       sb.deleteCharAt(0);
        return Integer.parseInt(halfStr + sb.toString());
    }
    public int primePalindrome(int n) {
        if (n <= 2) return 2;
        if (n <= 3) return 3;
        if (n <= 5) return 5;
        if (n <= 7) return 7;
        if (n <= 11) return 11;
        for (int length = 1; length < 6; length++) { 
            int start = (int) Math.pow(10, length - 1);
            int end = (int) Math.pow(10, length);
            for (int half = start; half < end; half++) {
                int palin = createPalindrome(half);
                if (palin >= n && isPrime(palin)) {
                    return palin;
                }
            }
        }

        return -1;
        
    }
}