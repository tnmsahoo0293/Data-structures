package com.company.sorting;


import java.util.Arrays;

public class bubble { // O(n*n); in-place algorithm; space complexity: O(1)

    static void bubblesort(int x[], int n){
        for(int i=0;i<n;i++){

            for(int j=0;j<n-1-i;j++){ // end of every iteration we get the (i+1)th largest algorithm
                if(x[j]>x[j+1])
                {
                    int temp=x[j];
                x[j]=x[j+1];
                x[j+1]=temp;
            }
        }

    }


    }
    public static void main(String[] args) {
        int x[]={15,8,50,36,1,9,10,2};
        System.out.println(Arrays.toString(x));
       bubblesort(x,x.length);

        System.out.print(Arrays.toString(x));
    }
}
