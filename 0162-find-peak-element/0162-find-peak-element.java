class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int max=nums[0];
        int c=0;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
               c=i;
            }

        }
        return c;
    }
}