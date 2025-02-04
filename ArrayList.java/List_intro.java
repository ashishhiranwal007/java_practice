import java.util.ArrayList;

public class List_intro {
    public static void swap_twonumber(ArrayList<Integer> list,int i ,int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    public static int Container_Store_water(ArrayList<Integer> list){
        int area =0;
        for(int i =0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int len = Math.min(list.get(i), list.get(j));
                int breadth= j-i;
                area = Math.max(area,len*breadth);
            }
        }
        return area;
    }
    public static void store_water(ArrayList<Integer> list){
        int left= 0;
        int right = list.size()-1;
        int max =0;
        while(left<right){
            int length = Math.min(list.get(left),list.get(right));
            int breadth = right - left;;
            int curr = length*breadth;
            max = Math.min(max, curr);
            if(list.get(left)<list.get(right)){
                left++;
            }
            else{
                right--;
            }
        }
    }
    public static void pair_sum(ArrayList<Integer> list){
        int sum=45;
        int leftindex =0;
        int rightindex = list.size()-1;
        while(leftindex<rightindex){
            if(list.get(rightindex)+list.get(leftindex)==sum){
                System.out.println(list.get(rightindex) +" "+ list.get(leftindex));
                leftindex++;
                rightindex--;
            }
            else if(list.get(rightindex)+list.get(leftindex)>sum){
                rightindex--;
                    }
            else{
                leftindex++;
            }
        }
        //for sorted and rotated arraylist we will be using left = left+1%n right = right+n-1%n 
    }
    public static void main(String[] args){
        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(10);
        newList.add(20);
        newList.add(30);
        newList.add(0,15);//take n time complexity and add the elemnt by shifitng other by one 
        //.remove .get .contains .size
        System.out.println(newList);
    }
}
