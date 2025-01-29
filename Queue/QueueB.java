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
    public static void main(String[] args){
        String  s = "aabbcssd";
        non_repreating(s);
    }
}
