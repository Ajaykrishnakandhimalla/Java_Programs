import java.util.*;

public class BinarySearchTree {
     class TreeNode{
         int value;
         TreeNode left;
         TreeNode right;
         
         TreeNode(int value) {
            this.value = value;
            right = null;
            left = null;
        }
     }
    
    public TreeNode insertNode(int nodeValue,TreeNode node){
        if(node == null){
            return new TreeNode(nodeValue);
        }
        if(nodeValue<node.value){
            node.left=insertNode(nodeValue,node.left);
        } 
        else if(nodeValue>node.value){
            node.right= insertNode(nodeValue,node.right);
        } 
        else return node;
        
        return node;
    } 
    
    public void traverseInOrderUsingDFS(TreeNode node){
        if(node==null) return ;
        traverseInOrderUsingDFS(node.left);
        System.out.print(node.value+" ");
        traverseInOrderUsingDFS(node.right);
    }
    
    public void traversePreOrderUsingDFS(TreeNode node){
        if(node==null) return ;
        System.out.print(node.value+" ");
        traversePreOrderUsingDFS(node.left);
        traversePreOrderUsingDFS(node.right);
    }
    public void traversePostOrderUsingDFS(TreeNode node){
        if(node==null) return ;
        traversePostOrderUsingDFS(node.left);
        traversePostOrderUsingDFS(node.right);
        System.out.print(node.value+" ");
    }
    
    public void BFS(TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                TreeNode node= q.poll();
                System.out.print(node.value+" ");
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }          
        }
    }
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] arr = new int[]{6,4,8,3,5,7,9};
        TreeNode root=null;
        for(int i=0;i<arr.length;i++){
            root = bst.insertNode(arr[i],root);
        }
        System.out.print("PreOrder using DFS: " );
        bst.traversePreOrderUsingDFS(root);
        System.out.println();
        System.out.print("InOrder using DFS: ");
        bst.traverseInOrderUsingDFS(root);
        System.out.println();
        System.out.print("PostOrder using DFS: ");
        bst.traversePostOrderUsingDFS(root);
        System.out.println();
        System.out.print("BFS/Level order traversal using BFS: ");
        bst.BFS(root);
        System.out.println();
    }
}
