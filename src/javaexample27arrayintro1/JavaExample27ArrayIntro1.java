
package javaexample27arrayintro1;

import java.util.Scanner;


public class JavaExample27ArrayIntro1 {

    
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        int v1Length=0;
        
        System.out.print("Enter the length of your array: ");
        v1Length=GetInteger(in);
        in.nextLine();
        
        int[] v1=new int[v1Length];
        System.out.println("Initialize your array.");
        InitializeIntegerArray(v1, in);
        PrintIntArray(v1);
        System.out.println();
        
        int[] v2=v1;
        v2[1]=1000;
        PrintIntArray(v1);
        System.out.print("Copy-refrence: ");
        PrintIntArray(v2);
        System.out.println();
        
        int[] v3 =CopyIntArray(v1);
        v3[1]=0;
        PrintIntArray(v1);
        System.out.print("Copy-refrence: ");
        PrintIntArray(v2);
        System.out.print("Copy-object..: ");
        PrintIntArray(v3);
        System.out.println();
        
        
        in.nextLine();
        
    }// end main()
    
    private static int[] CopyIntArray(int[] arr)
    {
        int[] res=new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i]=arr[i];
        }
        return res;
    }
    
    //uses for-each loop
    private static void PrintIntArray(int[] a)
    {
        System.out.print("Your array is: ");
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    private static void InitializeIntegerArray(int[] arr, Scanner input)
    {
        try{
        for (int i = 0; i < arr.length; i++) {
            arr[i]=input.nextInt();
            //input.nextLine(); // to accept one item per line only!
        }
        }catch(Exception e)
        {
            input.nextLine();
            System.out.println(e.toString());
            System.out.println("Re-initialize your array.");
            InitializeIntegerArray(arr, input);
        }
    }
    
    public static int GetInteger(Scanner input)
    {
        int res=0;
        try{
            res=input.nextInt();
            if(res<=0)
                throw new IllegalArgumentException("zero or negative number!");
            return res;
        }catch(Exception e)
        {
            input.nextLine();
            System.out.println(e.toString());
            return GetInteger(input);
        }
    }// end GetInteger()
    
}
