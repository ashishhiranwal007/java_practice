import java.util.*;

class Recursion{
    void decresingcount(int n){
        System.out.print("fgdf");
    }
    public static void increasingcount(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
    increasingcount(n-1);
        System.out.print(n+" ");
    }
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int sum_of_n_number(int n){
        if(n==1){
            return 1;
        }
        return n+sum_of_n_number(n-1);
    }
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static boolean sorted_array(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return sorted_array(arr,i+1);
        
    }
    public static int first_ocuurence(int arr[],int i,int key){
        if(arr[i]==key){
            return i;
        }
        return first_ocuurence(arr,i+1,key);
        // return 0;
    }
    public static int x_power_n(int n,int x){
        if(n==1){
            return x;
        }
        return x*x_power_n(n-1,x);
    }
    public static void duplicates(String s,int index,StringBuilder newstr,boolean map[]){
        if(index == str.length()){
            System.out.print(newstr);
            return;
        }
        char currchar = str.charAt(index)
        if(map[currchar]==true){
            duplicates(str,index+1,newstr,map);
        }
        else{
            map[currchar-'a']==true;
            duplicates(str.index+1,newstr.append(currchar),map);
        }
    }
    public static void mergesort(int arr[],int si,int ei){
        if(si>=ei){return;}
        int mi= si+(ei-si)/2;
        mergesort(arr,si,mi);
        mergesort(arr,mi+1,ei);
        merge(arr,si,mi,ei);
    }
    public static void merge(int arr[],int si,int mi,int ei){
        int temp[] = new int[ei-si+1];
        int i =si;int j=mid+1;int k=0;
        while(i<=mi && j<=ei){if(arr[i]<arr[j]){
            temp[k] =arr[i];i++;
        }
        else{
            temp[k]=arr[j];j++;
        }
        k++;}
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]= arr[j++];
        }
        for(k=0,i=si;k<temp.length;k++;i++){
            arr[i] =temp[k];
        }

    }
    public static void quicksort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        int pivotindex = partition(arr,si,ei);
        quicksort(arr,si,pivotindex-1);
        quicksort(arr,pivotindex+1,ei);
    }
    public static int partition(int arr[],int si,int ei){
        int i= si-1;
        int pivot = arr[ei];
        for(int j=sij<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j]= arr[i];
                arr[i]= temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] =arr[i];
        arr[i]=temp;
        return i;
    }
    public static void main(String args[]){
        //Recursion myobject = new Recursion();
        // myobject.decresingcount(10);
        // increasingcount(10);
        // System.out.print(factorial(5));
        // System.out.print(sum_of_n_number(5));
        // System.out.print(fibonacci(5));
        int arr[] ={2,51,1,5,6,2};
        // System.out.print(first_ocuurence(arr,0,2));
        System.out.print(x_power_n(3,2));
    }
}