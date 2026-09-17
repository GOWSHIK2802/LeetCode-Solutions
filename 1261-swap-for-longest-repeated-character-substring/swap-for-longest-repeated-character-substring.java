class Solution {
    public int maxRepOpt1(String text) {
        int[] prefix = new int[text.length()];
        int[] suffix = new int[text.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:text.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        prefix[0] = 1;
        int res = 1;
        suffix[text.length()-1] = 1;
        for(int i=1;i<text.length();i++){
            if(text.charAt(i)==text.charAt(i-1)){
                prefix[i] = prefix[i-1]+1;
            }else{
                prefix[i] = 1;
            }
        }
        for(int i=text.length()-2;i>=0;i--){
            if(text.charAt(i)==text.charAt(i+1)){
                suffix[i] = suffix[i+1]+1;
            }else{
                suffix[i] = 1;
            }
        }
        for(int i=1;i<text.length()-1;i++){
            int rem = 0;
            int cnt = 0;
            if(text.charAt(i-1)==text.charAt(i+1)){
                if(text.charAt(i)==text.charAt(i-1)){
                    cnt = prefix[i-1]+suffix[i+1]+1;
                    rem = map.get(text.charAt(i))-cnt;
                    res = Math.max(res,prefix[i-1]+suffix[i+1]+1);
                    continue;
                }else{
                    cnt = prefix[i-1]+suffix[i+1];
                    rem = map.get(text.charAt(i-1))-cnt;
                }
                if(rem>0){
                    res = Math.max(res,prefix[i-1]+suffix[i+1]+1);
                }else{
                    res = Math.max(res,prefix[i-1]+suffix[i+1]);
                }
            }else{
                if(text.charAt(i)==text.charAt(i+1)){
                    cnt = suffix[i+1]+1;
                    rem = map.get(text.charAt(i))-cnt;
                    if(rem>0){
                        res = Math.max(res,suffix[i+1]+2);
                    }else{
                        res = Math.max(res,suffix[i+1]+1);
                    }
                }else if(text.charAt(i)==text.charAt(i-1)){
                    cnt = prefix[i-1]+1;
                    rem = map.get(text.charAt(i))-cnt;
                    if(rem>0){
                        res = Math.max(res,prefix[i-1]+2);
                    }else{
                        res = Math.max(res,prefix[i+1]+1);
                    }
                }else{
                    rem = -1;
                }
                
            }
        }
        return res;
    }
}