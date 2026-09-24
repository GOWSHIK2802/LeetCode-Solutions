class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left=0;
        int sum=0;
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int r=0;r<nums.length;r++){
            int a=nums[r];
            map.put(a,map.getOrDefault(a,0)+1);
            sum+=a;
            while(map.get(a)>1){
                int x=nums[left];
                map.put(x,map.get(x)-1);
                sum-=x;
                left++;
            }
            max=Math.max(sum,max);
        }
        return max;
    }
}