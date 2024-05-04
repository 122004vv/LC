class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Base case
        if(root==null) return root;
        //Case 1: Either p is a root of q || q is a root of p
        if(root==p || root==q) return root;
        //Case 3: traverse left & right most nodes
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        if(right==null) return left;
        else return root;
    }
}