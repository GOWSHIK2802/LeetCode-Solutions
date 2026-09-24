class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) 
    {
        int n = arr.length;

        int left = 0;
        int sum = 0;
        int windowCount = 0;

        for(int right = 0; right < n; right++)
        {
            sum = sum + arr[right];

            int windowSize = right - left + 1;

            if(windowSize == k)
            {
                if(sum >= k * threshold)
                {
                    windowCount++;
                }
                
                sum = sum - arr[left];
                left++;
            }
        }
  
        return windowCount;
    }
}
