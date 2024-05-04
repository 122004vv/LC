class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode t, int k) {
        //Map to store the Parent of every Node , key is the child , value is the parent
        HashMap<TreeNode,TreeNode> mp=new HashMap<>();
        //Function to place the parent and children in map
        findParent(mp,root);
        List<Integer> res=new ArrayList<>();
        //HashSet to use as a visited array ->If it has the node, then it has been visited 
        HashSet<TreeNode> hs=new HashSet<>();
        //DFS traversal
        dfs(t,k,res,mp,hs);
        return res;
    }
    public void findParent(HashMap<TreeNode,TreeNode> mp,TreeNode root){
        //DFS function traversal to add them in Map , with child and root as entry
        if(root==null) return ;
        if(root.left!=null){
            mp.put(root.left,root);
        }
        if(root.right!=null){
            mp.put(root.right,root);
        }
        findParent(mp,root.left);
        findParent(mp,root.right);
    }
    public void dfs(TreeNode root,int k,List<Integer> res,HashMap<TreeNode,TreeNode> mp,HashSet<TreeNode> hs){
        if(root==null){
            return ;
        }
        //Add the root as visited
        hs.add(root);
        //System.out.println(root.val);
        if(k==0){
            res.add(root.val);
            return ;
        }
        //Recursively call left node
        if(!hs.contains(root.left)){
            dfs(root.left,k-1,res,mp,hs);
        }
        //Recursively call right node
        if(!hs.contains(root.right)){
            dfs(root.right,k-1,res,mp,hs);
        }
        //Recursively call parent node using map value
        if(!hs.contains(mp.get(root))){
            dfs(mp.get(root),k-1,res,mp,hs);
        }
    }
}