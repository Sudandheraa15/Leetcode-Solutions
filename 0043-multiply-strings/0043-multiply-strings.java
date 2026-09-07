class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] product = new int[m + n]; // max possible digits

        // Multiply each digit
        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                product[i + j + 1] += a * b;
            }
        }

        // Handle carry
        for (int i = m + n - 1; i > 0; i--) {
            product[i - 1] += product[i] / 10;
            product[i] %= 10;
        }

        // Convert to string
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // Skip leading zeros
        while (i < product.length && product[i] == 0) i++;
        for (; i < product.length; i++) sb.append(product[i]);

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
