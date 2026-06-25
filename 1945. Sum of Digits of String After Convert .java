class Solution {
    public int getLucky(String s, int k) {
        int currsum=0;
        for(int i=0;i<s.length();i++){
            int n=s.charAt(i)-'a'+1;
        
        while(n>0){
            int digit=n%10;
            currsum+=digit;
            n/=10;
        }
        } 
        for(int i=1;i<k;i++){
           int sum=0;
           while(currsum>0){
            int digit=currsum%10;
            sum+=digit;
            currsum/=10;
           }
           currsum=sum;
        }
        return currsum;
    }
}
