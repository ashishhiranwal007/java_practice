import java.util.*;
public class Tree {
    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data=data;
            this.right =null;
            this.left=null;
        }

    }
    static class Binarytree {
        static int index =-1;
        public static Node builtree(int nodes[]){
            index++;
            if(nodes[index]==-1){
                
                return null;
            }
            Node newnNode = new Node(nodes[index]);
            newnNode.left = builtree(nodes);
            newnNode.right = builtree(nodes);
            return newnNode;
        }  
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.err.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }      
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.err.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.err.print(root.data+" ");
        }
        public static void levelorder(Node root){
            if(root==null){
                System.out.println();
                return;
            }
            Queue<Node> q =new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node  curr = q.remove();
                if(curr==null){
                    System.err.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }
                else{
                    System.err.print(curr.data+" ");
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right); 
                    }
                }
                
            }
        }
        public static int heightoftree(Node root){
            if(root==null){
                return 0;
            }
            int lh = heightoftree(root.left);
            int rh = heightoftree(root.right);
            return Math.max(lh, rh)+1;
        }
        public static int countoftree(Node root){
            if(root==null){
                return 0;
            }
            int lh = heightoftree(root.left);
            int rh = heightoftree(root.right);
            return lh+rh+1;
        }
    }

    public static void main(String[] args) {
        Binarytree b = new Binarytree();
        int nodes[]  = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = b.builtree(nodes);
        System.err.println(root.data);
    }
}
