class Solution {
public:
    string addBinary(string a, string b) {
        
        string str = "";

        int i = a.size() - 1;
        int j = b.size() - 1;

        int carry = 0;

        while(i >= 0 || j >= 0 || carry) {
            
            int sum = carry;

            if(i >= 0) {
                sum += a[i] - '0';
                i--;
            }

            if(j >= 0) {
                sum += b[j] - '0';
                j--;
            }

            str += (sum % 2) + '0';

            carry = sum / 2;
        }

        reverse(str.begin(), str.end());

        return str;
    }
};