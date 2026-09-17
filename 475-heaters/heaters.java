class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int left = 0;
        int right = (int)1e9+7;

        int optimalRadius = right;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(isPossible(houses, heaters, mid)) {
                optimalRadius = mid;
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }

        return optimalRadius;
    }

    private boolean isPossible(int[] houses, int[] heaters, int radius) {
        int j = 0;
        for(int house: houses) {
            while(j < heaters.length && heaters[j] + radius < house) {
                j++; // move to heater that can potentially cover this particular house.
            }

            if(j == heaters.length) {
                return false;   // no heater can cover this house.
            }
            if(heaters[j] - radius > house) {
                return false;  // current heater is too far to the right.
            }
        }

        return true; // else done!
    }
}