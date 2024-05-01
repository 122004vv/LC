class Solution {
class Pair{
    int a;
    int b;
    public Pair(int g, int h){
        a=g;
        b=h;
    }
}
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length<1 || grid[0].length<1){
            return 0;
        }
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int val=bfs(i,j,grid);
                    //System.out.println("val is "+val);
                    ans=Math.max(ans,val);
                }
            }
        }
        return ans;
    }
    public int bfs(int k,int l,int[][] grid){
        int[] dr=new int[]{-1,0,1,0};
        int[] dc=new int[]{0,-1,0,1};
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(k,l));
        grid[k][l]=2;
        int area=0;
        while(!q.isEmpty()){
            Pair p=q.poll();
            //System.out.println(p.a+" "+p.b);
            area++;
            int xval=p.a;
            int yval=p.b;
            for(int i=0;i<4;i++){
                int nr=xval+dr[i];
                int nc=yval+dc[i];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]==1){
                    // area++;
                    q.add(new Pair(nr,nc));
                    grid[nr][nc]=2;
                }
            }
        }
        return area;
    }
}