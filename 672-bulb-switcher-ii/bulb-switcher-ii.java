class Solution {
    public int flipLights(int n, int k) {
        StringBuilder sb= new StringBuilder();
        for( int i=0;i<Math.min(6,n);i++)
        sb.append("1");

        Set<String> set= new HashSet<>();
        set.add(sb.toString());

        for ( int j=0;j<k;j++)
        {
          Set<String> temp= new HashSet<>();
          for(String s: set)
          { 
            sb= new StringBuilder(s);
            for ( int i=0;i<Math.min(6,n);i++)
            {
              if( sb.charAt(i)=='0')
              sb.setCharAt(i,'1');
              else
              sb.setCharAt(i,'0');
            }
            temp.add(sb.toString());

            sb= new StringBuilder(s);
            for ( int i=0;i<Math.min(6,n);i+=2)
            {
              if( sb.charAt(i)=='0')
              sb.setCharAt(i,'1');
              else
              sb.setCharAt(i,'0');
            }
            temp.add(sb.toString());

            sb= new StringBuilder(s);
            for ( int i=1;i<Math.min(6,n);i+=2)
            {
              if( sb.charAt(i)=='0')
              sb.setCharAt(i,'1');
              else
              sb.setCharAt(i,'0');
            }
            temp.add(sb.toString());

            sb= new StringBuilder(s);
            for ( int i=0;i<Math.min(6,n);i+=3)
            {
              if( sb.charAt(i)=='0')
              sb.setCharAt(i,'1');
              else
              sb.setCharAt(i,'0');
            }
            temp.add(sb.toString());

            set= new HashSet<>(temp);
          }
        }
        return set.size();
    }
}