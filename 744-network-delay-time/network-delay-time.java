class Solution {

    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {

            int u = time[0];
            int v = time[1];
            int wt = time[2];

            adj.get(u).add(new Pair(v, wt));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a.distance, b.distance));

        dist[k] = 0;
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int distance = current.distance;

            if (distance > dist[node]) {
                continue;
            }

            for (Pair next : adj.get(node)) {

                int nextNode = next.node;
                int weight = next.distance;

                int newDistance = distance + weight;

                if (newDistance < dist[nextNode]) {
                    dist[nextNode] = newDistance;
                    pq.offer(new Pair(nextNode, newDistance));
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}