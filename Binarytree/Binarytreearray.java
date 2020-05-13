package com.company.Binarytree;

import java.util.LinkedList;
import java.util.Queue;

class Binary{
        int arr[];
        int root=0;
        int size;
        int top=-1;

        Binary(int size){
            this.arr= new int[size];
            top=0;
        }
        void insert ( int val){
            if (top==(arr.length-1))
                System.out.println("tree is full");
            else{
                arr[++top]=val;
                if(top==1)
                    root=top;
                System.out.println("Element inserted into the array");
            }
        }
        void search (int val){
            for(int i=1;i<=top;i++){
                    if(arr[i]==val) {
                        System.out.println("Element found in the tree!!");
                        return;
                    }
            }
            System.out.println("Element not found in the array");
        }

        void inorder(int idx){
            if(root==-1)
                System.out.println("Tree is empty");

            else if(idx>top) {
                return;
            }
            else{
                    inorder(2*idx);
                    System.out.print(arr[idx]+" ->");
                    inorder(2*idx+1);
            }
        }

        void preorder(int idx){
            if(root==-1)
                System.out.println("Tree is empty");

            else if(idx>top) {
                return;
            }
            else{
                System.out.print(arr[idx]+" ->");
                preorder(2*idx);
                preorder(2*idx+1);
            }
        }

        void postorder(int idx){
            if(root==-1)
                System.out.println("Tree is empty");

            else if(idx>top) {
                return;
            }
            else{
                postorder(2*idx);
                postorder(2*idx+1);
                System.out.print(arr[idx]+" ->");
            }

        }

        void levelorder(int idx){
            if(root==-1)
                System.out.println("Tree is empty");
            // since in an array based implementation the tree is already stored in level order
            // so we directly print the emelemnts

            for(int i=0;i<=top;i++)
                System.out.print(arr[i]+" ->");
        }

        void delete(int val){
            if(root==0)
                System.out.println("Tree is empty");
            else{
                for(int i=0;i<=top;i++){
                    if(arr[i]==val){
                        int temp;
                        temp=arr[top];
                        arr[top]=arr[i];
                        arr[i]=temp;
                        arr[top]=0;
                        top--;
                        return;
                    }
                }
                System.out.println("Element not found in the tree");
            }
        }

    }

public class Binarytreearray {
    public static void main(String[] args) {
        Binary bin = new Binary(10);
        bin.insert(23);
        bin.insert(3);
        bin.insert(2);
        bin.insert(234);
        bin.insert(232);
        bin.insert(2343);
        bin.insert(236);
        bin.insert(253);
        bin.search(234);
        bin.inorder(1);
        System.out.println("\n");
        bin.postorder(1);
        System.out.println("\n");
        bin.delete(2);
        bin.levelorder(1);
        System.out.println("\n");
    }

}
