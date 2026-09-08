class Solution {
    public int majorityElement(int[] nums) {
        int c=1;
        int ele=nums[0];
        for(int j=1;j<nums.length;j++){
            if(ele==nums[j]){
                c++;
            }
            else if(c==0){
                ele=nums[j];
                c=1;
            }
            else{
                c--;
            }
        }
        return ele;
    }
}