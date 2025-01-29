import java.util.*;

class Student {
    String name;
    int age;

    public static void printinfo() {
        System.out.println("this.name");
        System.out.println("this.age");
    }
}

class index {
    public static int addition(int a, int b) {
        return a + b;
    }

    // public static void main(int n){
    // for(int i=2;i<n;i++){
    // for(int j=2;j<n;j++){
    // + if(i%j==0){
    // System.out.println(i+" is not a prime number");
    // break;
    // }
    // }
    // }
    // }
    public static void btod(int number) {
        int count = 0;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum = sum + (digit * (int) (Math.pow(2, count)));
            count++;
            number = number / 10;
        }
        System.out.println(sum);
    }

    public static void dtob(int number) {
        String ans = "";
        while (number > 0) {
            int digit = number % 2;
            ans = digit + ans;
            number = number / 2;
        }
        System.out.println(ans);
    }

    public static void hollowreactagle(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number; j++) {
                if (j == 1 || i == 1 || j == number || i == number) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void invertedpyramid(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void invertednumber(int num) {
        for (int i = 0; i < num; i++) {
            int k = 1;
            for (int j = num; j > i; j--) {
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }
    }

    public static void flyodtriangle(int num) {
        int k = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }
    }

    public static void triangle(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * (num - i); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < num; i++) {
            for (int j = num - i; j > 0; j--) {
                System.out.print("*");
            }
            for (int j = 2 * (i); j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = num - i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void rhombus(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < num; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollowrhombus(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < num; j++) {
                if (i == 0 || i == num - 1 || j == 0 || j == num - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int num) {
        for (int i = 1; i < num; i++) {
            for (int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = num; i > 0; i--) {
            for (int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void numberpyramid(int num) {
        int number = 1;
        for (int i = 1; i < num; i++) {
            for (int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(number);
            }
            for (int j = 0; j < i - 1; j++) {
                System.out.print(number);
            }
            number++;
            System.out.println();
        }
    }

    public static void palindromic(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < num - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(i - j);
            }
            for (int j = 1; j < i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    public static void fibonaccicheck(int num) {
        int a = 0, b = 1;
        int sum = a;
        for (int i = 0; i < num; i++) {
            int temp = a;
            // System.out.println(a+" ");
            sum += a;
            a = b;
            b = temp + a;
            System.out.println(sum);
        }
    }

    public static void matrixcreation(int num) {
        Scanner s = new Scanner(System.in);
        int matrix[][] = new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix[i][j] = s.nextInt();
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // public static void main(int num){
    // // int place = s.nextInt();
    // int arr[]=new int [num];
    // for(int i = 0;i<num;i++){
    // // arr[i]=s.nextInt();
    // }
    // Arrays.sort(arr);
    // for(int i = 0;i<num;i++){
    // if(i==place){
    // System.out.println(arr[i]);
    // }
    // }
    // }
    public static void reversestring(String str) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(str.length() - i - 1));
        }
        System.out.print(temp);
    }

    public static void palindromestring(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean flag = true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                flag = false;
            }
            start++;
            end--;
        }
        if (flag) {
            System.out.println("Palindrome");

        } else {
            System.out.println("Not a palindrome");
        }
    }

    public static float shortestpath(String s, int i, int x, int y) {

        if (i == s.length()) {
            return (float) Math.sqrt((x * x) + (y * y));
        }
        char dir = s.charAt(i);
        if (dir == 'S') {
            x++;
        } else if (dir == 'N') {
            x--;
        } else if (dir == 'E') {
            y++;
        } else {
            y--;
        }
        return shortestpath(s, i + 1, x, y);

    }

    public static void binarysort(int arr[]) {// simple sorting comparing each element to the other element
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                }
            }
        }
    }
    public static void selectionsort(int arr[]){ // selecting one element and finding its correct position
        for(int i =0;i<arr.length-1;i++){
            int minpos =i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minpos]>arr[j]){
                    minpos= j;
                }
            }
            int temp = arr[minpos];
            arr[minpos] = arr[i];
            arr[i] = temp;
        }
    }
    public static void insertionsort(int arr[]){// pushing the element in the correct order
        for(int i =1;i<arr.length;i++){ // i==1 because one will be the sorted array and the other will be unsorted 
            int curr =arr[i];
            int prev = i-1;
            //finding the corrwct position to be inserted
            while(prev>=0 && arr[prev]>curr){
                arr[prev+1] =arr[prev];
                prev--;
            } 
            //inserting the value
            arr[prev+1] =curr;
        }
    }
    public static void countsort(int arr[]){
        int max   = arr[0];
        for(int i =0;i<arr.length;i++){
            if(max<arr[i]){
                max= arr[i];
            }
        }
        int arr2[] = new int[max+1];
        for(int i =0;i<arr.length;i++){
            arr2[arr[i]]++;
        }
        int j =0;
        for(int i =0;i<arr2.length;i++){
            while(arr2[i]>0){
                arr[j] = i;
                j++;
                arr2[i]--;
            }
        }
    }
    public static void spiralmatrix(int arr[][]){
        int startrow =0;int endrow= arr.length -1 ;
        int startcol =0;int endcol = arr[0].length -1;
        while(startrow <= endrow && startcol <= endcol){
            for(int i=startcol;i<=endcol;i++){
                System.out.print(arr[startrow][i]+" ");
            }
            for(int i=startrow+1;i<=endrow;i++){
                System.out.print(arr[i][endcol]+" ");
            }
            for(int i=endcol-1;i>=startcol;i--){
                System.out.print(arr[endrow][i]+" ");
            }
            for(int i=endrow-1;i>=startrow+1;i--){
                System.out.print(arr[i][startcol]+" ");
            }
            startrow++;
            endcol--;
            endrow--;
            startcol++;
        }
    }
    public static void printarr(int arr[]){
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" "); 
        }
    }
    
    public static void main(String args[]) {
        // int arr[] =new int[5];
        // Student s1 = new Student();
        // s1.name = "Rahul";
        // s1.rollno = 1;
        // s1.printinfo();
        Scanner s = new Scanner(System.in);
        // for(int i =0;i<5;i++){
        //     int element  = s.nextInt();
        //     arr[i] = element;
        // }
        int arr[][] ={{1,2,3},{4,5,6},{7,8,9}};
        spiralmatrix(arr);
        // countsort(arr);
        // selectionsort(arr);
        // printarr(arr);
        // binarysort(arr);
        // printarr(arr);
        // String str = s.next();
        // int num =s.nextInt();
        // System.out.print(shortestpath(str,0,0,0));
        // palindromestring(str);
        // reversestring(str);
        // fibonaccicheck(num);
        // matrixcreation(num);
        // palindromic(num);
        // numberpyramid(num);
        // diamond(num);
        // hollowrhombus(num);
        // rhombus(num);
        // butterfly(num);
        // triangle(num);
        // flyodtriangle(num);
        // invertednumber(num);
        // invertedpyramid(num);
        // hollowreactagle(num);
        // dtob(num);
        // btod(num);
        // String input = sc.nextLine();
        // System.out.print(input);
        // int a = sc.nextInt();
        // // int b = sc.nextInt();
        // float product = 3.14f*(a*a);
        // System.out.println(product);
        // float a = 45.5f;
        // int marks = (int) a;
        // System.out.println(marks);
        // char ch = 'a'-'A';
        // System.out.print(ch);
        // int a =45;
        // float b= 32.32f;
        // double c = 2323.23;
        // long d = 2332;
        // double f = a-b+c+d;
        // System.out.println(f);
        // int a =20;
        // int b= 5;
        // System.out.print("divisior equal to " + (a/b));
        // System.out.println((3)&&(2));
        // ((5%2)==0)? System.out.println("even"):System.out.println("odd");
        // int marks =2;
        // // String type = ((marks>=33)?"pass":"fail");
        // // System.out.println(type);
        // switch(marks){
        // case 1:
        // System.out.print("mango");break;
        // case 2:
        // System.out.print("mango2");break;
        // case 3:
        // System.out.print("mango3");break;
        // case 4:
        // System.out.print("mango4");break;
        // default:
        // System.out.print("mango default");
        // }
        // }

        // int a= 5,b=5;

        // char ch= s.next().charAt(0);
        // switch(ch){
        // case '+':
        // System.out.print(a+b);
        // break;
        // case '-':
        // System.out.print(a-b);
        // break;
        // default:
        // System.out.print("invalid operator");
        // }
        // }
        // int number =1305;
        // int reversenumber =0;
        // while(number>0){
        // int digit = number%10;
        // reversenumber = reversenumber*10+digit;
        // number =number/10;
        // System.out.println(digit);
        // }
        // System.out.print(reversenumber);
        // }
        // int number = 2;
        // while(true){
        // number= s.nextInt();
        // if(number%10!=0){
        // System.out.println(number);
        // }
        // else{
        // continue;
        // }
        // }
        // int n = s.nextInt();
        // for(int i =0;i<n;i++){
        // for(int j=n%2;j>i;j--){
        // System.out.print(' ');
        // }
        // for(int j=0;j<i;j++){
        // System.out.print('*');
        // }
        // System.out.println();
        // }
        // char number ='A';
        // for(int i =1;i<5;i++){

        // for(int j=0;j<i;j++){
        // System.out.print(number);
        // number++;
        // }
        // System.out.println();
        // }
        // int a = s.nextInt();
        // int b = s.nextInt();
        // System.out.print(addition(a,b));
    }
}