class Solution {
    public int longestBeautifulSubstring(String word) {
        int maxLength = 0, vowelStage = 1, left = 0;

        for(int i=1; i<word.length(); i++)
        {
            if(word.charAt(i-1) > word.charAt(i))
            {
                vowelStage = 1;
                left = i;
            }

            else if(word.charAt(i-1) < word.charAt(i))
            {
                vowelStage++;
            }

            if(vowelStage == 5)
            {
                maxLength = Math.max(maxLength, i-left+1);
            }
        
        }
        return maxLength;
    }
}