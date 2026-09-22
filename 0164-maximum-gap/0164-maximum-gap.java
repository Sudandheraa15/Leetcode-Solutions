class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        int dif=0;
        for(int i=1;i<nums.length;i++){
            dif=nums[i]-nums[i-1];
if(dif>max){
    max=dif;
}
        }
        return max;
    }
}