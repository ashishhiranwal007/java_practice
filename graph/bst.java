package graph;
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        this.left = null;
        this.right=null;
    }
}
public class bst {
    public static Node insert_in_bst(Node root,int value){
        if(root==null){
            root = new Node(value);
            return root;
        }
        if(value<root.data){
            root.left = insert_in_bst(root.left,value);
        }
        else if(value>root.data){
            root.right = insert_in_bst(root.right,value);
        }
        return root;
    }
    public static boolean search_in_bst(Node root,int value){
        if(root==null){
            return false;
        }
        if(value==root.data){
            return true;
        }
        if(value<root.data){
             return search_in_bst(root.left,value);
        }
        else{
             return search_in_bst(root.right,value);
        }
        
    }
}
