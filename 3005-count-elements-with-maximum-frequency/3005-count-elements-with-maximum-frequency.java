class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int max=0;
        for(int m:map.values()){
            if(m>max){
                max=m;
            }
        }
        int ans=0;
        for(int a:map.values()){
            if(a==max){
                ans+=a;
            }
        }
        return ans;
    }
}