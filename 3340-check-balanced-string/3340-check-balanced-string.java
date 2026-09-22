class Solution {
    public boolean isBalanced(String num) {
        int odd=0;
        int even=0;
        for(int i=0;i<num.length();i++){
            int n=num.charAt(i)-'0';
            if(i%2==0){
                even+=n;
            }
            else{
                odd+=n;
            }
        }
        if(odd==even){
            return true;
        }
        
        return false;
    }
}