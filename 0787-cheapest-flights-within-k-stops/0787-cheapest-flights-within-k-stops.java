class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }
        for(int[] flight:flights){
            adj.get(flight[0]).add(new int[] { flight[1],flight[2] });
        }
        Queue<int[]> q=new LinkedList();
        q.offer(new int[]{src,0});
        int[] mc=new int[n];
        Arrays.fill(mc,Integer.MAX_VALUE);
        int s=0;
        while(s<=k && !q.isEmpty()){
            int size=q.size();
            while(size-- >0){
                int[] c=q.poll();
                for(int[] na:adj.get(c[0])){
                    int p=na[1],nn=na[0];
                    if(p+c[1]>=mc[nn]){
                        continue;
                    }
                    mc[nn]=p+c[1];
                    q.offer(new int[]{nn,mc[nn]});
                }
            }
            s++;
        }
        return mc[dst]==Integer.MAX_VALUE?-1:mc[dst];
    }
}