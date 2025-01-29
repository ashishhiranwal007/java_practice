package others;
import java.util.*;
public class Dp {
    public static void main(String[] args) {
        int arr[] = { 7, 5, 1 };
        int n = 18;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(minCoins(n, arr, dp));
        System.err.println(fibnacciSeries(dp, 5));
    }
    public static int knapsackProblem(int weight[] ,int profits[],int total_weight) {
        int maxprofit = -2323;
        int newarr[][] = new int[profits.length+1][total_weight+1];
        for(int i=0;i<=profits.length;i++){
            for(int j=0;j<=total_weight;j++){
                if(i==0 || j==0){
                    newarr[i][j] = 0;
                }
                else if(weight[i-1]<=j){
                    newarr[i][j] = Math.max(profits[i-1] + newarr[i-1][j-weight[i-1]], newarr[i-1][j]);
                }
                else{
                    newarr[i][j] = newarr[i-1][j];
                }
            }
        }
        return maxprofit;
    }
    public static int lcs(String a,String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        return lcsutil(m,n,a,b,dp);
    }
    public static int lcsutil(int m,int n ,String a,String b,int[][] dp){
        if(m==0 || n==0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(a.charAt(m) == b.charAt(n)){
            return dp[m][n] = 1+lcsutil(m-1, n-1, a, b, dp);
        }
        else{
            return dp[m][n] = Math.max(lcsutil(m-1, n, a, b, dp), lcsutil(m, n-1, a, b, dp));
        }
    }
    public static int lcsu_tabular(String a,String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];
        return lcsu_tabularutil(m,n,a,b,dp);
    }
    public static int lcsu_tabularutil(int m,int n, String a, String b, int[][] dp){
        for(int i =1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static int fibnacciSeries(int dp[] , int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n] = fibnacciSeries(dp, n-1) + fibnacciSeries(dp, n-2);
    }
    public static int minCoins(int n, int arr[], int dp[]) {
        if (n == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (n - arr[i] >= 0) {
                int subans = 0;
                if (dp[n - arr[i]] != -1) {
                    subans = dp[n - arr[i]];
                } else {
                    subans = minCoins(n - arr[i], arr, dp);
                }
                if (subans != Integer.MAX_VALUE && subans + 1 < min) {
                    min = subans + 1;
                }
            }
        }
        return min;
    }

}
