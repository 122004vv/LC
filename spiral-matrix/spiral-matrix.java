class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rs=0,re=matrix.length-1,cs=0,ce=matrix[0].length-1;
        List<Integer> ans=new ArrayList<>();
        int d=0;
        while(rs<=re && cs<=ce){
            if(d==0){
                for(int i=cs;i<=ce;i++){
                    ans.add(matrix[rs][i]);
                }
                rs++;
            }
            else if(d==1){
                for(int i=rs;i<=re;i++){
                    ans.add(matrix[i][ce]);
                }
                ce--;
            }
            else if(d==2){
                for(int i=ce;i>=cs;i--){
                    ans.add(matrix[re][i]);
                }
                re--;
            }
            else if(d==3){
                for(int i=re;i>=rs;i--){
                    ans.add(matrix[i][cs]);
                }
                cs++;
            }
            d=(d+1)%4;
        }
        return ans;
    }
}