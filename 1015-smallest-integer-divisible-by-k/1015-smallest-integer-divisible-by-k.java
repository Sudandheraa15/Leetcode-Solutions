class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1; 
        int num = 1 % k;
        int length = 1;

        while (num != 0) {
            num = (num * 10 + 1) % k;
            length++;
        } 
        return length;
    }
}
