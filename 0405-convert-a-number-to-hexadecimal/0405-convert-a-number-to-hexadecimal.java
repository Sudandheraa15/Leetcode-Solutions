class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        // For hexadecimal digits
        char[] hexChars = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        // Use unsigned 32-bit representation
        while (num != 0 && sb.length() < 8) {
            int hexDigit = num & 15;   // get last 4 bits
            sb.append(hexChars[hexDigit]);
            num >>>= 4;                // unsigned right shift
        }

        return sb.reverse().toString();
    }
}

    