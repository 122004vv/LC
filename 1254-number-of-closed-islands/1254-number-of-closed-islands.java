//Appproach : DFS AND FILL THE ZEROS Once the result++ is done 
class Solution {
    public int closedIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
                    fill(grid,i,j);
                }
            }
        }
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    res++;
                    fill(grid,i,j);
                }
            }
        }
        return res;
    }
    public void fill(int[][] grid,int x,int y){
        int[] dr=new int[]{-1,0,1,0};
        int[] dc=new int[]{0,1,0,-1};
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length) return;
        if(grid[x][y]==1){
            return ;
        }
        grid[x][y]=1;
        for(int i=0;i<4;i++){
            int nx=x+dr[i];
            int ny=y+dc[i];
            fill(grid,nx,ny);
        }
    }
}