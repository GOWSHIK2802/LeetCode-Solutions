class Solution {
        public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        int n=arr.length;

        for(int i=arr.length-1;i>0;i--)
        {
            int index=-1;

            for(int j=0;j<=i;j++)
            {
                if(arr[j]==n)
                {
                    index=j;
                    break;
                }


            }

            if(index==i)
            {
                 n--;
                 continue;

            }

            reverse(arr,0,index);
            reverse(arr,0,i);

            ans.add(index+1);
            ans.add(i+1);

            n--;
        }
        return ans;


        
    }

    public void reverse(int []  nums,int l,int r)
    {
        while(l<r)
        {
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}