package others;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class heap {
    public static void insert_in_maxheap(int arr[], int value, int n) {
        n = n + 1;
        arr[n] = value;
        int parent = (n - 1) / 2;
        int i = n;
        while (i > 1) {
            if (arr[parent] < arr[i]) {
                int temp = arr[parent];
                arr[parent] = arr[n];
                arr[n] = temp;
                i = parent;
            } else {
                break;
            }
        }
    }

    static int isMaxHeap(int array[], int n) {

        int flag = 0;
        for (int i = 0; i <= n / 2 - 1; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && array[i] < array[left]) {
                return 0; // Not a max-heap
            }

            // Check if right child exists and violates max-heap property
            if (right < n && array[i] < array[right]) {
                return 0; // Not a max-heap
            }
 
        }
        return 1;
    }

    static void modifyMintoMax(int array[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
    }

    public static void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr, n, largest);
        }
    }
    static void activitySelection(int[] start, int[] finish) {
        // Write your code here
        List<int[]> li  = new ArrayList<>();
          for(int i=0;i<start.length;i++){
              li.add(new int[]{start[i],finish[i]});
          }
          //sort the list
          li.sort((a,b)->a[1]-b[1]);
          //e variable ,for loop if condition
          int e =-1;
              for(int[]arr:li){
                  if(arr[0]>=e){
                      e=arr[1];
                      System.out.print(arr[0]+" ");
                  }
              }
      }
    static int jobScheduling(int[] deadlines, int[] profits) {
    //find out the max deadlines 
      int maxdeadline = Integer.MIN_VALUE;
      for(int deadline:deadlines){
          maxdeadline = Math.max(maxdeadline,deadline);
      }
      
      //make the array visited
      int visited[] =new int[maxdeadline+1];
      Arrays.fill(visited,-1);
      
      //make a list of deadlines and profits array
      List<int[]> jobs = new ArrayList<>();
      for(int i =0;i<deadlines.length;i++){
          jobs.add(new int[]{deadlines[i],profits[i]});
      }
      //sorting the array and making the count and totalprofits variable
      jobs.sort((a,b) ->b[1]-a[1]);
      int count =0;int totalprofit= 0;
      for(int[] job:jobs){
          int deadline = job[0];
          int profit = job[1];
      
      
      //while condition and two if conditions
          while(deadline>=1 && visited[deadline]!=-1){
              deadline--;
          }
          if(deadline>=1){
              totalprofit += profit;
              count++;
              visited[deadline] =profit;
          }
          if(count==maxdeadline){
              break;
          }
    }
      return totalprofit;
  }
    public static void insert_in_minheap(int arr[], int value, int n) {
        n = n + 1;
        arr[n] = value;
        int i = n;
        int parent = (i - 1) / 2;
        while (i > 1) {
            if (arr[parent] > arr[i]) {
                int temp = arr[parent];
                arr[parent] = arr[n];
                arr[n] = temp;
                i = parent;
            } else {
                break;
            }
        }
    }

    public static void delete_in_maxheap(int arr[]) {
        int n = arr.length;
        arr[1] = arr[n];
        n = n - 1;
        int i = 1;
        while (i < n) {
            int left = 2 * i;
            int right = 2 * i + 1;
            int larger = arr[left] > arr[right] ? left : right;
            if (arr[i] < arr[larger]) {
                int temp = arr[i];
                arr[i] = arr[larger];
                arr[larger] = temp;
                i = larger;
            } else {
                break;
            }
        }
    }
    static void printLevelWise(Node root) {
  if(root==null)return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        int n  =q.size();
        for(int i =0;i<n;i++){
            Node curr = q.poll();
            System.out.print(curr.data);
            if(i!=n-1){
                System.out.print(" ");
            }
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
            
        }
        System.out.println();
    }
  

}
static int countLeafs(Node root) {
    // Base case: If the tree is empty, return 0
    if (root == null) return 0;

    // If the node is a leaf node (both children are null)
    if (root.left == null && root.right == null) {
        return 1;
    }

    // Recursively count leaf nodes in left and right subtrees
    return countLeafs(root.left) + countLeafs(root.right);
}
static double fractionalKnapsack(int val[], int weight[], int n, int capacity)
  {
      List<double[]> li = new ArrayList<>();
      for(int i =0;i<val.length;i++){
          li.add(new double[]{val[i],weight[i]});
      }
      //sorting
      li.sort((a,b)->{
          double r1 = a[0]/a[1];
          double r2 = b[0]/b[1];
          return Double.compare(r2,r1);
      });
      //for loop,varaible ans and if condition and else condition
      double ans= 0.0;
      for(double []arr:li){
          if((int) arr[1]<capacity){
              capacity-=arr[1];
              ans+=arr[0];
          }
          else{
              ans+=(arr[0]/arr[1])*capacity;
              break;
          }
          
      }
      return ans;
  }
static int countNonLeafs(Node root) {
    // Base case: If the tree is empty, return 0
    if (root == null) return 0;

    // If the node is a non-leaf node (at least one child is not null)
    if (root.left != null || root.right != null) {
        return 1 + countNonLeafs(root.left) + countNonLeafs(root.right);
    }

    // If it's a leaf node, do not count
    return 0;
}
}
  static int intervalScheduling(int[] start, int[] end) {
    //make a list and add the element from start and end array 
      List<int[]> intervals = new ArrayList<>();
      for(int i =0;i<start.length;i++){
          intervals.add(new int[]{start[i],end[i]});
      }
      
      //sort the intervals list
      
      intervals.sort((a,b) -> Integer.compare(a[1],b[1]));
      
      //int count and int lastendtime
      int count =1;
      int lastendtime = intervals.get(0)[1];
      
      //comapring the laastendtime
      for(int i =0;i<intervals.size();i++){
          if(intervals.get(i)[0]>=lastendtime){
              lastendtime = intervals.get(i)[1];
              count++;
          }
      }
      return count;
    
  }
static void printOdd(Node root) {
    if(root==null) return;
     Queue<Node> q=new LinkedList<>();
     q.add(root);
       boolean flag=true;
       while(!q.isEmpty()){
           int size=q.size();
           for(int i=0;i<size;i++){
               Node current=q.poll();
               if(flag){
                   System.out.print(current.data+" ");
               }
               if(current.left!=null){
                   q.add(current.left);
               }
                if(current.right!=null){
                   q.add(current.right);
               }
           }
           flag=!flag;
       }
   }
 
}
