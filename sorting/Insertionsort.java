package com.company.sorting;

import java.util.Arrays;

public class Insertionsort {
    public static void Insertsort(int x[], int n) {
        for (int i = 1; i < n; i++) {
                int elem=x[i];
                int j;
            for( j=i;j>0 && x[j-1]>elem;j--){
                x[j]=x[j-1];
            }
            x[j]=elem;
        }
    }

    public static void main(String[] args) {
        int x[]={15,8,50,36,1,9,10,2};

        Insertsort(x,x.length);
        System.out.println(Arrays.toString(x));
    }
}
