import java.util.*;
// import bank;
// class Student{
//     String name;
//     int age;
//     public void printinfo(){
//         System.out.println(this.name);
//         System.out.println(this.age);
//     }
// }
// public class oops{
//     public static void any(){
//         Scanner s = new Scanner(System.in);
//         String name = s.nextLine();
//         int age = s.nextInt();
//         int money = s.nextInt();
//         System.out.println(name);
//         System.out.println(age);
//         System.out.println(money);
//     }
//     public static void main(String[] args) {
//         Scanner s = new Scanner(System.in);
//         Student st = new Student();
//         st.name="ashihs";
//         st.age=12;
//         // st.printinfo();
//         int num  = s.nextInt();
//         for(int i =0;i<num;i++){
//             any();
//         }
//     }
// }

// class Pen {
//     int tipsize;String color;
//     pen(int tipsize,String color){
//         this.tipsize = tipsize;
//         this.color=color;
//         System.out.println("this pen constructor ");
//     }
    
//     void print(){
//         System.out.println("this will be the use of super keyword");
//     }
//     // int SettipSize(int tipsize){
//     //     this.tipsize = tipsize;
//     //     return tipsize;
//     // }
//     // String SetColor(String color){
//     //     this.color = color;
//     //     return color;
//     // }
// }
// class company_pen extends pen{
//     super(tipsize,color,print);
//     company_pen.print();
//     String company_name ;
//     company_pen(company_name){
//         this.company_name = company_name;
//     }
// }

// class natraj extends company_pen{
//     super(tipsize,color,print,company_name);
//     System.out.println(tipsize" "+ color" "+print" "+company_name);
// }


abstract class Animal{
    // void eat();abstract void walk();
}
// class horse extends Animal{
//     void eat(){
//         int n=9;
//     }
// }