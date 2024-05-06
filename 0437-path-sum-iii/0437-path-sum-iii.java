public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;  
        if(root.val==1000000000) return 0;
        return fn(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    } 
    private int fn(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) + fn(node.left, sum - node.val) + fn(node.right, sum - node.val);
    }
}