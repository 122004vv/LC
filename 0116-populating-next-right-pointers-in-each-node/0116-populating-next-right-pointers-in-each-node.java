/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            List<Node> cl=new ArrayList<Node>(s);
            for(int i=0;i<s;i++){
                Node currNode=q.poll();
                cl.add(currNode);
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
            while(cl.size()>1){
                Node ln=cl.remove(0);
                Node rn=cl.get(0);
                ln.next=rn;
            }
        }
        return root;
    }
}