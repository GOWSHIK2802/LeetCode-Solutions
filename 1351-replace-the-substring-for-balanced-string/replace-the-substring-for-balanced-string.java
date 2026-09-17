class Solution {
    public int balancedString(String s) {
        
        int [] arr = new int[4];
        String ss = "EQRW";
        for(int i=0;i<s.length();++i){
            arr[ss.indexOf(s.charAt(i))]++;
        }
        int m = s.length()/4;
        if(arr[0]==m&&arr[1]==m&&arr[2]==m&&arr[3]==m) return 0;
        int ans = s.length();
        for(int i=0,j=0;i<s.length();++i){
            arr[ss.indexOf(s.charAt(i))]--;
            while(j<=i && arr[0] <= m && arr[1] <= m && arr[2] <= m && arr[3] <= m){
                ans = Math.min(ans,i-j+1);
                arr[ss.indexOf(s.charAt(j++))]++;
            }
        }
        return ans;
    }
}