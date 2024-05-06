class Solution {
    //Why 20003 ? The limit is 10 to the power 4-->10000 rows, 10000 columns.
    //Here the indexing I have chosen is 1-based , so that vis can checked without altering the defaults
    //Hence 1 to 10001 for denoting rows , 10002 to 20002 denoting number of columns 
    //20003 because the size will be taken as n-1 , hence 20003
    int[] par=new int[20003];
    int cnt=0;
    public int removeStones(int[][] stones) {
        for(int i=0;i<stones.length;i++){
            //Take the row & add 1 , Take the column & add 10002 
            union(stones[i][0]+1,stones[i][1]+10002);
        }
        //Minus the cnt from struggling no of stones
        return stones.length-cnt;
    }
    public void union(int x,int y){
        //Find the parent of the row and column value , check if they are not same.
        //If they aren't same , Keep them same and reduce the cnt -->Meaning the disjoint sets had been reduced
        int px=findPar(x);
        int py=findPar(y);
        if(px!=py){
            par[py]=px;
            cnt--;
        }
    }
    public int findPar(int val){
        //If unvisited , keep the same as parent , increment cnt
        if(par[val]==0){
            par[val]=val;
            cnt++;
        }
        //if parent is same as val , return val
        if(par[val]==val){
            return val;
        }
        // else find the parent of the node by recursion
        return par[val]=findPar(par[val]);
    }
}