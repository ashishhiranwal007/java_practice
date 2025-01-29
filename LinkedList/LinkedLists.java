package LinkedList;
import java.util.LinkedList;
public class LinkedLists {
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public void add(int data){
        Node newnode = new Node(data);
        if(head==null){
            tail = head = newnode;
            return;
        }
        newnode.next=head;
        head = newnode;
    }
    public static void reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node nextN ;
        while(curr!=null){
            nextN = curr.next;
            curr.next = prev;
            prev = curr;
            curr=nextN;
        }
    }
    public static Node mid(){
        Node slow= head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static boolean detectcycle(){
        Node slow =head;
        Node fast = head;
        while(fast!=null){
            slow =slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static boolean palindrome(){
        if(head==null || head.next==null){
            return true;
        }
        Node mid = mid();
        Node curr = mid;
        Node prev = null;
        while(curr!=null){
            Node next = mid.next;
            mid.next =null;
            prev = curr;
            curr= next;    
        }
        Node right  = prev ;
        Node left=head;
        while(right!=null){
            if(left!=right){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public static void main(String[] args){
       int arr[]={100,200,300,400,500};

        int k =3;
        System.out.print(ksumofarray(arr, k));
        
    }
    public static int ksumofarray(int arr[],int k){
       int ans =0;
       int sum =0;
       for(int i =0;i<arr.length;i++){
        sum+=arr[i];
        if(i>k-1){
            sum-=arr[i-k];
        }
        ans = Math.max(sum,ans);
       }
       return ans;
    }

}
