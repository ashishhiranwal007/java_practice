package graph;

import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class Tree {
    static class Info{
        Node node;
        int hd;
        Info(Node node ,int hd){
            this.hd= hd;
            this.node = node;
        }
    }
    public static void topview(Node root ){
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        int min =0;int max =0;
        q.add(new Info(root,0));
        q.add(null);
        while(!q.isEmpty()){
            Info temp = q.remove();
            if(temp==null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
           else{
            if(!map.containsKey(temp.hd)){
                map.put(temp.hd,temp.node);
            }
            if(temp.node.left!=null){
                q.add(new Info(temp.node.left, temp.hd-1));
                min = Math.min(min, temp.hd-1);
            }
            if(temp.node.right!=null){
                q.add(new Info(temp.node.right, temp.hd+1));
                max = Math.max(max, temp.hd+1);
            }
           }
            for(int i=min;i<=max;i++){
                System.out.print(map.get(i).data);
            }
            System.out.println();
        }
    }
    public static boolean isidentical(Node root,Node subroot){
        if(root == null && subroot==null){
            return true;
        }
        if(root == null || subroot == null || root.data!= subroot.data){
            return false;
        }
        if(!isidentical(root.left,subroot.left)){
            return false;
        }
        if(!isidentical(root.right,subroot.right)){
            return false;
        }
        return true;


    }
    public static boolean issubtree(Node root,Node subroot){
        if(root==null ){
            return false;
        }
        if (root.data==subroot.data) {
            if(isidentical(root,subroot)){
                return true;
            }
        }
        return issubtree(root.left, subroot.left) || issubtree(root.right, subroot.right);


    }
    public static int height(Node root){
        if(root ==null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }
    public static int diameter(Node root){
        if(root==null){
            return 0;
        }
        int leftdia = diameter(root.left);
        int lh = height(root.left);
        int rightdia = diameter(root.right);
        int rh = height(root.right);
        int self = lh+rh+1;
        return Math.max(self, Math.max(leftdia,rightdia));
    }
}
