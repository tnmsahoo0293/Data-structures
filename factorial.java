package com.company;
import java.util.*;


public class factorial {
    static int fact(int x) {
        if (x<1) {
            return 1;
        }
        else
            {
            return (x*fact(x-1));
            }
    }

    static int factor(int x){
        int sum=1;
        for(int i=1;i<=x;i++){
            sum*=i;
        }
        return sum;
    }
    public static void main(String[] args) {
        int x;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number to find the factorial");
        x= sc.nextInt();
        int ans;

        ans= fact(x);
        System.out.println(ans);
        ans= factor(x);
        System.out.println(ans);
    }
}
