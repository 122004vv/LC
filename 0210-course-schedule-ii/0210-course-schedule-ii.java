class Solution {
    public int[] findOrder(int n, int[][] arr) {
        //if(n<0) return false;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] ind=new int[n];
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][0]).add(arr[i][1]);
        }
        //indegree calc
        for(int i=0;i<n;i++){
            for(int k:adj.get(i)){
                ind[k]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ind[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int m=q.poll();
            al.add(0,m);
            for(int j:adj.get(m)){
                ind[j]--;
                if(ind[j]==0){
                    q.add(j);
                }
            }
        }
        if(al.size()==n){
            int[] arr1=al.stream().mapToInt(Integer::intValue).toArray();
            return arr1;
        }
        return new int[]{};
    }
}