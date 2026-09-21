class Solution {
    final int MOD = 1_000_000_007;
    private int solve(int index, int k, int[] arr, int target, int[][][] dp){
        if(k == 0){
            if(target == 0) return 1;
            return 0;
        }
        if(index >= arr.length) return 0;

        if(dp[index][k][target] != -1) return dp[index][k][target];

        int skip = solve(index+1,k,arr,target,dp)%MOD;
        int take = 0;
        if(target - arr[index] >= 0){
            take = (take + solve(index+1,k-1,arr,target-arr[index],dp))%MOD;
        }

        return dp[index][k][target] = (take + skip)%MOD;
    }
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length;

        int[][][] dp = new int[n+1][4][target+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<4;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0,3,arr,target,dp);
    }
}