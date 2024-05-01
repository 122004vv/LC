/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int lsize=q.size();
            double averageval=0;
            List<Integer> currlvl=new ArrayList<>(lsize);
            for(int i=0;i<lsize;i++){
                TreeNode r=q.poll();
                averageval+=(double) r.val;
                if(r.left!=null){
                    q.offer(r.left);
                }
                if(r.right!=null){
                    q.offer(r.right);
                }
            }
            ans.add(averageval/lsize);
        }
        return ans;
    }
}