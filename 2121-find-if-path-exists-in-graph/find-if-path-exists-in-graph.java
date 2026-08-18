class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;
        List<List<Integer>> list = new  ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] side : edges){
            list.get(side[0]).add(side[1]);
            list.get(side[1]).add(side[0]);
        }

        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            vis[i]=0;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source]=1;
        while(!q.isEmpty()){
            int node = q.poll();
            vis[node]=1;
            for(int i: list.get(node)){
                 if(i==destination){
                        return true;
                    }
                if(vis[i]==0){
                    vis[i]=1;
                    q.add(i);
                   
                }
            }
        }
        return false;
        
    }
}