package stack;

import java.util.*;

public class stackB {
    static public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // static ArrayList<Integer> list = new ArrayList<>();
    // public static boolean isEmpty(){
    // return list.size() == 0;
    // }
    // public static void push(int data){
    // list.add(data);
    // }
    // public static int pop(){
    // if(isEmpty()){
    // System.out.println("Stack is empty");
    // return -1;
    // }
    // int top = list.get(list.size() - 1);
    // list.remove(list.size()-1);
    // return top;
    // }
    // public static int peek(){
    // if(isEmpty()){
    // System.out.println("Stack is empty");
    // return -1;
    // }
    // return list.get(list.size() - 1);
    // }

    // public static class stack{
    // static Node head =null;
    // public static boolean isEmpty(){
    // return head==null;
    // }
    // public static void push(int data){
    // Node newNode =new Node(data);
    // if(isEmpty()){
    // head = newNode;
    // return;
    // }

    // newNode.next = head;
    // head = newNode;
    // }
    // public static int pop(){

    // if(isEmpty()){
    // return -1;
    // }
    // int top = head.data;
    // head = head.next;
    // return top;

    // }
    // }
    public static void pushAtBottom(Stack<Integer> s, int x) {
        if (s.isEmpty()) {
            s.push(x);
            return;
        }
        int temp = s.pop();

        pushAtBottom(s, x);
        s.push(temp);
    }

    public static String reverse(String st) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < s.size(); i++) {
            s.push(st.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.size(); i++) {
            char ch = s.pop();
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void stockspan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        span[0] = 1;
        for (int i = 1; i < stocks.length; i++) {
            int curr = stocks[i];
            while (!s.isEmpty() && curr > stocks[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    public static boolean validparenthies(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (ch == ')') {
                    if (st.isEmpty() || st.pop() != '(') {
                        System.out.println("Invalid parentheses");
                        return false;
                    }

                } else if (ch == '}') {
                    if (st.isEmpty() || st.pop() != '{') {
                        System.out.println("Invalid parentheses");
                        return false;
                    }

                } else if (ch == ']') {
                    if (st.isEmpty() || st.pop() != '[') {
                        System.out.println("Invalid parentheses");
                        return false;
                    }

                }
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }
    public static boolean duplicate_parentheses(String str){
        Stack<Character> st = new Stack<>();
        for(int i =0;i<str.length();i++){
            char ch  = str.charAt(i);
            if(ch!=')'){
                st.push(ch);
            }else{
                int count =0;
                while(!st.isEmpty() && st.peek()!='('){
                    st.pop();
                    count++;
                }
                if(st.isEmpty()){
                    return false;
                }
                else{
                    st.pop();
                }
                if(count<1){
                    return true;
                }
            }
        }
        return false;
    }
    public static int max_histogram_area(int arr[]){
        Stack<Integer> st = new Stack<>();
        int max_area =0;
        for(int i =0;i<arr.length;i++){
            int ans =0;
            4
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Scanner sc = new Scanner(System.in);
        s.push(10);
        s.push(20);
        s.push(30);
        int data = sc.nextInt();
        // pushAtBottom(s, data);
        System.err.println("nothing");
        System.out.println(duplicate_parentheses("(((a+b)+(c+d)))"));
    }
}
