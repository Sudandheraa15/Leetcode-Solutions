class Solution {
    public int fib(int n) {
        int f=0;
        int s=1;
        if(n==0) return 0;
        if(n==1) return 1;
        for(int i=2;i<=n;i++){
            int nt=f+s;
            f=s;
            s=nt;
        }
        return s;
    }
}