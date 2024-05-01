public class Solution {
    class Pair{
        int a;
        int b;
        Pair(int g,int h){
            a=g;
            b=h;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid.length<1 || grid[0].length<1){
            return 0;
        }
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(i,j,grid);
                    c++;
                }
            }
        }
        return c;
    }
    public void bfs(int v,int d,char[][] grid){
        int[] dr=new int[]{-1,0,1,0};
        int[] dc=new int[]{0,1,0,-1};
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(v,d));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int x=p.a;
            int y=p.b;
            for(int i=0;i<4;i++){
                int nr=x+dr[i];
                int nc=y+dc[i];
                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1'){
                    q.add(new Pair(nr,nc));
                    grid[nr][nc]='2';
                }
            }
        }
    }
}