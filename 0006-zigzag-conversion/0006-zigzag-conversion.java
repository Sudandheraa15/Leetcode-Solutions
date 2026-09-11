class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;

        String[] rows = new String[numRows];

        for (int i = 0; i < numRows; i++)
            rows[i] = "";

        int row = 0, dir = 1;

        for (char ch : s.toCharArray()) {
            rows[row] += ch;

            if (row == 0)
                dir = 1;
            else if (row == numRows - 1)
                dir = -1;

            row += dir;
        }

        String result = "";
        for (String str : rows)
            result += str;

        return result;
    }
}