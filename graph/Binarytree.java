package graph;

import java.util.*;

public class Binarytree {
    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class Binary {
        static int idx = -1;

        public static Node buildtree(Binarytree tree, int arr[]) {
            idx++;
            if (idx >= arr.length || arr[idx] == -1) {
                return null;
            }
            Node newnode = tree.new Node(arr[idx]);
            newnode.left = buildtree(tree, arr);
            newnode.right = buildtree(tree, arr);
            return newnode;
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelorder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int sum = 0;  // Fix: Using an integer for sum instead of Node

        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                sum += temp.data;  // Fix: Summing up data correctly
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            System.out.println("Sum of the tree is: " + sum);  // Fix: Printing sum correctly
        }
    }
    static int maxdia = 0;
    public static int diameter_of_the_tree(Node root){
        if(root ==null) return 0;
        int leftdia = diameter_of_the_tree(root.left);
        int rightdia = diameter_of_the_tree(root.right);

        int leftheight = height_of_the_tree(root.left);
        int rightheight = height_of_the_tree(root.right);
        int selfdia = leftheight+rightheight+1;
        return Math.max(selfdia,Math.max(leftdia,rightdia));
    }
    public static int height_of_the_tree(Node root) {
        if (root == null) return 0;  // Fix: Return -1 for an empty tree
        int left = height_of_the_tree(root.left);
        int right = height_of_the_tree(root.right);
        return Math.max(left, right) + 1;
    }
    public class Info{
        int dia;
        int ht;
        Info(int dia,int ht){
            this.dia = dia;
            this.ht = ht;
        }
    }
    public static Info diameter(Binarytree tree, Node root){
        if(root==null){
            return tree.new Info(0,0);
        }
        Info leftInfo = diameter(tree, root.left);
        Info rightInfo = diameter(tree, root.right);
        int leftd = leftInfo.dia;
        int rightd= rightInfo.dia;
        int lefth = leftInfo.ht;
        int righth = rightInfo.ht;
        int selfdia = leftInfo.ht+rightInfo.ht+1;
        int maxdia = Math.max(selfdia,Math.max(leftd,rightd));
        int height = Math.max(lefth,righth)+1;
        return tree.new Info(maxdia, height);
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, -1, -1, -1}; 



        Binarytree tree = new Binarytree();
        Node root = Binary.buildtree(tree, arr);
        
        System.out.println("Root node: " + root.data);
        
        System.out.println("Level Order Traversal:");
        levelorder(root);
        
        System.out.println("Height of the tree is: " + height_of_the_tree(root));
        System.out.println("Diameter of the tree is:"+diameter(tree, root).dia);
    }
}
