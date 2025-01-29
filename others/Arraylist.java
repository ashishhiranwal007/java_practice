package others;
import java.util.*;
public class Arraylist {
    public static int storeWater(ArrayList<Integer> list){
        int maxWater = 0;
        for(int i =0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int height =Math.min(list.get(i),list.get(j));
                int width = j-i;
                maxWater = Math.max(maxWater,height*width);
            }
        }
        return maxWater ;
    }
    //2 pointer approach for storing water
    public static int storeWater2(ArrayList<Integer> list){
        int maxWater = 0;
        int left =0;
        int right = list.size()-1;
        while(left<right){
            int height = Math.min(list.get(left),list.get(right));
            int breadth = right - left;
            maxWater = Math.max(maxWater,height*breadth);
            if(list.get(left)<list.get(right)){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3,0,2,0,4));
        System.out.println(storeWater(list)); 
    }
}
