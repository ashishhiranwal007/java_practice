package others;
public class Backtracking {
    public static void changearr(int arr[],int i ,int value){
         if(i==arr.length){
            return ;
         }
         arr[i] = value;
         changearr(arr, i+1, value+1);
         arr[i] = arr[i]-2;
    }
    public static void findsubset(String str,String ans,int i){
        if(i==str.length()){
            System.err.print(ans);
            return;
        }
        findsubset(str, ans+str.charAt(i), i+1);
        findsubset(str, ans, i+1);
    }
    public static void findpermutation(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char curr= str.charAt(i);
            String newString = str.substring(0, i)+str.substring(i+1);
            findpermutation(newString, ans+curr);
        }
    }
    public static void findqueens(char arr[][],int row){
        if(row==arr.length){
            printBoard(arr);
            return;
        }
        for(int i =0;i<arr.length;i++){
            if(issafe(arr, row, i)){
                arr[row][i] = 'Q';
                findqueens(arr, row+1);
                arr[row][i] = 'x';
            }
        }
    }
    public static void printBoard(char arr[][]){
        System.out.println("----nqueens----");
        for(int i = 0;i<arr.length;i++){
            for(int j =0;j<arr.length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void print(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static boolean issafe(char arr[][],int row,int col){
        for(int i =row-1,j=col;i>=0;i--){
            if(arr[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(arr[i][j]=='Q'){
                return false;
            }
        }
        for(int i =row-1,j=col+1;i>=0 && j<arr.length;i--,j++){
            if(arr[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static int grid_problem(int i,int j,int n,int m){
        if(i==n-1 && j==m-1){
            return 1;
        }
        else if(i==n || j==m){
            return 0;
        }
        int w1 = grid_problem(i+1, j, n, m);
        int w2 = grid_problem(i, j+1, n, m);
        return w1+w2;
    }
    public static boolean is_safe(int sudoku[][],int row,int col,int digit){
        for(int i =0;i<9;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        for(int j=0;j<9;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }
        int rc = (row/3)*3;
        int cc  = (col/3)*3;
        for(int i = rc;i<rc+3;i++){
            for(int j =cc;j<cc+3;j++){
                if(sudoku[i][j] ==digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudoku_problem(int sudoku[][],int row,int col){
        if(row == 9 && col == 0 ){
            return true;
        }
        if(row==9){
            return false;
        }
        int newrow = row;
        int newcol=col+1;
         if(col+1==9){
            newrow = row+1;
            newcol  =0;
         }
         if(sudoku[row][col]!=0){
            return sudoku_problem(sudoku, newrow, newcol);
         }
         for(int digit=1;digit<=9;digit++){
            if(is_safe(sudoku, row,col, digit)){
                sudoku[row][col]  =digit;
                if(sudoku_problem(sudoku, newrow, newcol)){
                    return true;
                }
                sudoku[row][col] =0;
            }
         }
         return false;
    }
    public static void printsudoku(int sudoku[][]){
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.err.println();
        }
    }

    public static void main(String[] args) {
        int sudoku[][]= {{3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 8, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        if(sudoku_problem(sudoku, 0, 0)){
            System.err.println("this is a sudoku ");
            printsudoku(sudoku);
        }
        else{
            System.err.println("this is not a sudoku");
        }
        // System.out.println(grid_problem(0, 0, 2 ,2));
        // int n =4;
        // char board[][] =new char[n][n];
        // for(int i =0  ;i<n;i++){
        //     for(int j =0;j<n;j++){
        //         board[i][j]='x';
        //     }
        // }
        // findqueens(board,0);
        // int arr[] = new int[5];
        // findsubset("abc", "", 0);
        // changearr(arr,0,1);
        // print(arr);
    }
}
