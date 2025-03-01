package graph;

import java.util.* ;

public class Binarytree {
    public class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }        
    }
    public static class Binary{
        static int idx =-1;
        public static Node buildtree(Binarytree tree, int arr[]){
            idx++;
            if(arr[idx]==-1){
                return null;
            }
            Node newnode = tree.new Node(arr[idx]);
            newnode.left = buildtree(tree, arr);
            newnode.right = buildtree(tree, arr);
            return newnode;
        }
    }   
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelorder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp==null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }

            }
            else{
                System.out.print(temp+" ");
                if(temp.left!=null){
                    q.add(root.left);
                }
                if(temp.right!=null){
                    q.add(root.right);
                }

            }
        }
    }
    public static void main(String[]args){
        int arr[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binarytree tree = new Binarytree();
        Node root = Binary.buildtree(tree, arr);
        System.out.println(root.data);
    }
}
