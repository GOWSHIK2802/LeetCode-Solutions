class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
        {
            return image;
        }
        int old = image[sr][sc];

        return dfs(image,sr,sc,color,old);
    }
    private int[][] dfs(int[][] image, int r, int c, int color,int old)
    {
        if(r<0 || r>=image.length || c<0 || c>=image[0].length || image[r][c]!=old)
        {
            return image;
        }

        image[r][c] = color;

        dfs(image,r-1,c,color,old);
        dfs(image,r+1,c,color,old);
        dfs(image,r,c-1,color,old);
        dfs(image,r,c+1,color,old);

        return image;
    }
}