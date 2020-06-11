package com.company.sorting;

import java.util.Arrays;

public class Merge {
    static void mergeSort(int input[], int start, int end) {
        if (end - start < 2)
            return;
        else {
            int mid = (start + end) / 2;

            mergeSort(input,start,mid);
            mergeSort(input,mid, end);
            merge(input, start, mid,end);
        }
    }
    static void merge(int x[], int start, int mid, int end){
        if(x[mid-1]<x[mid])
            return;

        int temp[]=new int[end-start];
        int i=start;
        int j=mid;
        int id=0;
        while(i<mid && j<end){
            temp[id++]= x[i]>x[j]?x[j++]:x[i++];

        }
        System.arraycopy(x,i,x,start+id, mid-i);
        System.arraycopy(temp,0,x,start,id);
    }

    public static void main(String[] args) {
        int x[]={15,8,50,36,1,9,10,2};

        mergeSort(x,0,x.length);
        System.out.println(Arrays.toString(x));
    }
}
