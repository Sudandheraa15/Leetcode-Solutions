class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        long totalShift = 0; // use long to prevent overflow
        char[] chars = s.toCharArray();
        
        for (int i = n - 1; i >= 0; i--) {
            totalShift += shifts[i];
            // shift character by totalShift modulo 26
            chars[i] = (char)((chars[i] - 'a' + totalShift) % 26 + 'a');
        }
        
        return new String(chars);
    }
}
