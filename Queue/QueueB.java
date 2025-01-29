package Queue;
import java.util.*;
public class QueueB {
     public static void non_repreating(String s){
        int freq[] =new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print("-1"+" ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
        }
        System.err.println();

    }
    public static void interleave(Queue<Integer> q){
        Queue<Integer>q2 = new LinkedList<>();
        int n =q.size();
        for(int i =0;i<n/2;i++){
            q2.add(q.remove());
        }
        while(!q2.isEmpty()){
            q.add(q2.remove());
            q.add(q.remove());
        }
    }
    public static void queue_reversal(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()){
            st.push(q.poll());
        }
        while(!st.isEmpty()){
            q.add(st.pop());
        }
    }
    public static void main(String[] args){
        String  s = "aabbcssd";
        non_repreating(s);
    }
}
