import java.util.*;
class Priorityqueue{
    static class Student implements Comparable<Student>{
        int rank;
        String name;
        
        public Student(String name,int rank){
            this.rank= rank;
            this.name= name;
        }
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }
    static class Heap{
        ArrayList<Integer> arr= new ArrayList<>();
        public void insert(int data){
            arr.add(data);
            int x = arr.size()-1;
            int par = (x-1)/2;
            while(arr.get(x)<arr.get(par)){
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
            }
            x=par;
            par=(x-1)/2;
        }
        public int peek(){
            return arr.get(0);
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
        private void heapify(int index){
            int left = 2*index+1;
            int right = 2*index+2;
            int minindex  = index;
            if(left<arr.size() && arr.get(left)<arr.get(minindex)){
                minindex =left;
            }
            if(right<arr.size() && arr.get(right)<arr.get(minindex)){
                minindex=right;
            }
            if(minindex!=index){
                int temp = arr.get(index);
                arr.set(index, arr.get(minindex));
                arr.set(minindex, temp);
                heapify(minindex);
            }
        }
        public int remove(){
            int data =arr.get(0);
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1,temp);
            arr.remove(arr.size()-1);
            heapify(0);
            return data;
        }
    }
    public static void main(String args[]){
        // PriorityQueue<Student> pq = new PriorityQueue<>();
        // pq.add(new Student("a",34));
        // pq.add(new Student("b",32));
        // pq.add(new Student("c",1));
        // pq.add(new Student("d",2));
        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek().name +" "+ pq.peek().rank);

        //     pq.remove();
        // }
        Heap hp = new Heap();
        hp.insert(32);
        hp.insert(34);
        hp.insert(1);
        while (!hp.isEmpty()) {
            System.out.println(hp.peek());
            hp.remove();
        }
    }
}