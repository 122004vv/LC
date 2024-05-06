class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] adj=new List[n];
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            int u=e[0],v=e[1],wt=e[2];
            adj[u].add(new int[]{v,wt});
            adj[v].add(new int[]{u,wt});
            //Bidirectional graph , so add the wt to both vertices .
        }
        int INF=(int)1e9+7;
        for(int i=0;i<n;i++){
            dist[i][i]=0;
            Arrays.fill(dist[i],INF);
        }
        for(int i=0;i<n;i++){
            //Find shortest path for every node to every other node and update it in dist[i]
            dj(dist[i],i,adj);
        }
        int minC=-1,mincurrCity=n;
        for(int i=0;i<n;i++){
            int currCityval=0;
            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }
                //If distane from one Node to another is within threshold , inc currCityval
                if(dist[i][j]<=distanceThreshold){
                    currCityval++;
                }
            }
            //if the curr city's no of values is < minCurrcity which is initially n , replace the value
            if(currCityval<=mincurrCity){
                mincurrCity=currCityval;
                minC=i;
            }
        }
        //return the city with minimum number of cities that are attainable within threshold .
        return minC;
    }
    public void dj(int[] dist,int src,List<int[]>[] adj){
        //pq to order them by distance's asc order.
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] node=pq.remove();
            int u=node[0],wtu=node[1];
            if(wtu>dist[u]){ //if wt of this route is greater than the existing one , then continue -->No need to add the new dest and it's weight to pq. 
                continue;
            }
            for(int[] nd:adj[u]){
                //If it is smaller than the existing one , take that value's adj ones
                int v=nd[0],wtv=nd[1];
                //Check if the wt using this value is less than already existing distance,change it
                if(wtu+wtv<dist[v]){
                    dist[v]=wtu+wtv;
                    //Add this to pq.
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
    }
}