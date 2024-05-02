class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int f=0,m=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    f++;
                }
            }
        }
        while(!q.isEmpty() && f>0){
            int s=q.size();
            int[] dr=new int[]{-1,0,1,0};
            int[] dc=new int[]{0,-1,0,1};
            for(int i=0;i<s;i++){
                int[] coord=q.poll();
                for(int j=0;j<4;j++){
                    int nx=coord[0]+dr[j];
                    int ny=coord[1]+dc[j];
                    if(nx>=0  && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        f--;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            m++;
        }
        return (f==0)?m:-1;
    }
}