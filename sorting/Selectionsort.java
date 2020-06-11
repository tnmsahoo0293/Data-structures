package com.company.sorting;
import java.util.Arrays;
public class Selectionsort { // unstable algorithm
   public static void select(int x[], int length){
        for(int uid=length-1;uid>=0;uid--){
            int largest= 0;
            for(int i=1;i<=uid;i++){
                if(x[i]>x[largest])
                    largest=i;
            }
            swap(x,uid,largest);
           // System.out.println(Arrays.toString(x));
        }
        System.out.println(Arrays.toString(x));
    }

   static void swap(int x[], int i, int y){
        int temp=x[i];
        x[i]=x[y];
        x[y]=temp;
    }
    public static void main(String[] args) {
        int arr[]={20,35,-15,7,55,1,-22};
        select(arr,arr.length);
    }
}
