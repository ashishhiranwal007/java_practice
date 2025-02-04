package Greedy;

import java.util.*;
public class Greedy {
     public static void Activity_selection_problem(int start[],int end []){
        int maxacitivity = 0;
        int lastend = end[0];
        ArrayList <Integer> list = new ArrayList<>();
        list.add(0);
        maxacitivity=1;
        for(int i =0;i<end.length;i++){
         if(start[i]>=end[i]){
            list.add(i);maxacitivity++;lastend = end[i];
         }
        }
        for(int i  =0;i<list.size();i++){
         System.out.print("A"+list.get(i)+" ");
        }
        System.err.println();
     }
}
