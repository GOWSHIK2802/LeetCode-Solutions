class Solution {
    public int missingInteger(int[] nums) {
         int sum = nums[0];
         for(int i =1; i<nums.length; i++){
            if(nums[i] == nums[i-1]+1){
                sum += nums[i];
            }else{
                break;
            }
         }
         int candi = sum;
         while(true){
            boolean found = false;
            for(int j=0; j<nums.length; j++){
                if(nums[j] == candi){
                    found = true;
                     break;
                }
            }
            if(found == true){
                candi++;
            } else{
                break;
            }
         }
         return candi;

        
    }
}