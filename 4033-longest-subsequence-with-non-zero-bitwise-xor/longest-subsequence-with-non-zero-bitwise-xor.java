class Solution {
    public int longestSubsequence(int[] nums) {
        int res = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            res ^= num;

            if (num != 0) {
                hasNonZero = true;
            }
        }

        if (res != 0) {
            return nums.length;
        }

        if (hasNonZero) {
            return nums.length - 1;
        }

        return 0;
    }
}