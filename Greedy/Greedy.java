package Greedy;

import java.util.*;

public class Greedy {

   // ✅ Activity Selection Problem (Without Sorting)
   public static void Activity_selection_problem(int start[], int end[]) {
      int maxActivity = 1;
      int lastEnd = end[0];
      ArrayList<Integer> list = new ArrayList<>();
      list.add(0); // First activity always selected

      for (int i = 1; i < end.length; i++) { // Start from second activity
         if (start[i] >= lastEnd) { // Check if it can be selected
            list.add(i);
            maxActivity++;
            lastEnd = end[i]; // Update last selected end time
         }
      }

      // Print selected activities
      System.out.print("Selected Activities: ");
      for (int i : list) {
         System.out.print("A" + i + " ");
      }
      System.out.println("\nTotal Activities Selected: " + maxActivity);
   }

   // ✅ Activity Selection Problem (With Sorting)
   public static void asp_bysorting(int start[], int end[]) {
      int maxActivity = 1;
      int activity[][] = new int[start.length][3];
      ArrayList<Integer> list = new ArrayList<>();

      // Create a 2D array {index, start, end}
      for (int i = 0; i < start.length; i++) {
         activity[i][0] = i; // Index
         activity[i][1] = start[i]; // Start time
         activity[i][2] = end[i]; // End time
      }

      // Sort activities by end time in ascending order
      Arrays.sort(activity, Comparator.comparingInt(o -> o[2]));

      list.add(activity[0][0]); // First activity is always selected
      int prev = activity[0][2];

      for (int i = 1; i < activity.length; i++) {
         if (activity[i][1] >= prev) {
            maxActivity++;
            prev = activity[i][2];
            list.add(activity[i][0]);
         }
      }

      // Print selected activities
      System.out.print("Selected Activities (Sorted): ");
      for (int i : list) {
         System.out.print("A" + i + " ");
      }
      System.out.println("\nTotal Activities Selected: " + maxActivity);
   }

   // ✅ Fractional Knapsack Problem
   public static void fractional_Knapsack(int weight[], int value[], int W) {
      int n = weight.length;
      double ratio[][] = new double[n][2]; // {index, value/weight}

      // Compute value-to-weight ratio
      for (int i = 0; i < n; i++) {
         ratio[i][0] = i; // Store index
         ratio[i][1] = (double) value[i] / weight[i]; // Store ratio
      }

      // Sort by ratio in descending order
      Arrays.sort(ratio, (a, b) -> Double.compare(b[1], a[1]));

      int totalValue = 0;
      int capacity = W;

      // Process items
      for (int i = 0; i < n; i++) {
         int idx = (int) ratio[i][0];

         if (capacity >= weight[idx]) { // Take full item
            capacity -= weight[idx];
            totalValue += value[idx];
         } else { // Take fraction of item
            totalValue += (ratio[i][1] * capacity);
            capacity = 0;
            break; // Knapsack full
         }
      }

      System.out.println("Maximum Knapsack Value: " + totalValue);
   }
   public static String getFrequencyString(String str){
      int freq[] =new int[26];
      for(char ch : str.toCharArray()){
         freq[ch - 'a']++;
      }
      StringBuilder sb = new StringBuilder();
      char ch='a';
      for(int i :freq){
         sb.append(ch);
         sb.append(freq[i]);
         ch++;
      }
      return sb.toString();
   }
   public static void maximum_length_of_pairs_sum(int arr1[],int arr2[]){
      int dp[][]=new int[arr1.length][2];
      for(int i =0;i<dp.length;i++){
         dp[i][1]=arr1[i];
         dp[i][2]=arr2[i];
      }
      Arrays.sort(dp,Comparator.comparingInt(o->o[1]));
      int max =1;
      int lastend = dp[0][1];
      for(int i =1;i<dp.length;i++){
         if(dp[i][0]>=lastend){
            lastend = dp[i][1];
            max++;
         }
      }
   }
   public static void indian_coins(int amount){
      Integer coins[]={1,2,5,10,20,50,100,500,2000};
      Arrays.sort(arr,Comparator.reverseOrder());
      ArrayList<Integer> list = new ArrayList<>();
      for(int i =0;i<coins.length;i++){
         if(amount>=coins[i]){
            while(amount>=coins[i]){
               amount-=coins[i];
               list.add(coins[i]);
            }
         }
      }
   }
   public static class Job{
      int id ;int deadline;int profit;
      public Job(int id ,int deadline,int profit ){
         this.id = id;
         this.deadline = deadline;
         this.profit = profit;
      }
   }
   public static void job_squencing_problem(int jobe[][]){
      ArrayList<Job> jobs = new ArrayList<>();
      for(int i =0;i<jobe.length;i++){
         jobs.add(new Job(i,jobe[i][0],jobe[i][1]));
      }
   }
   public static void main(String[] args) {
      // Test Case 1: Activity Selection (Without Sorting)
      int start[] = { 1, 3, 0, 5, 8, 5 };
      int end[] = { 2, 4, 6, 7, 9, 9 };
      System.out.println("Activity Selection (Without Sorting):");
      Activity_selection_problem(start, end);

      // Test Case 2: Activity Selection (With Sorting)
      System.out.println("\nActivity Selection (With Sorting):");
      asp_bysorting(start, end);

      // Test Case 3: Fractional Knapsack
      int values[] = { 60, 100, 120 };
      int weights[] = { 10, 20, 30 };
      int capacity = 50;
      System.out.println("\nFractional Knapsack:");
      fractional_Knapsack(weights, values, capacity);
   }
}
