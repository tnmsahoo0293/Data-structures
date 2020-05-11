package com.company.Linkedlist;

import java.io.*;
import java.util.*;
import java.util.Arrays.*;

class Double{
    Node head;
    int size=0;
    Node tail;
    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public boolean isEmpty(){
        return (size==0);
    }

    public void addFirst(int x){

        if(isEmpty()){
            Node n = new Node(x);
            head= tail=n;
            size++;
        }

        else{
            Node temp = new Node(x);
            temp.next=head;
            temp.prev=null;
            head= temp;
            size++;
        }
    }


    public void addLast(int x){
        if(isEmpty()){
            Node temp = new Node(x);
            temp = head= tail;
            size++;
        }
        else{
            Node temp = new Node(x);
            tail.next=temp;
            temp.prev=tail;
            tail=temp;
            size++;
        }
    }

    public void  insertAt(int data, int position){
        if(position==1)
            addFirst(data);
        else if(position==size)
            addLast(data);
        else{
            int index=position-1;
            int i;
            Node trav, back=null;


            for(trav=head, i=0;i<=index-1;i++){
                back=trav;
                trav=trav.next;
                }

            Node temp= new Node(data);
            temp.next=trav;
            trav.prev=temp;
            temp.prev=back;
            back.next=temp;
            size++;
        }
    }

    public void remove(int x){
        Node prev=null;
        Node trav = head;
        if(head== null){
            System.out.println("Empty linked list, nothing to print");
        }
        else
        {
            while(trav!=null && trav.data!=x){
                prev=trav;
                trav= trav.next;
            }
            prev.next=trav.next;
            size--;
        }
    }


    public void reverseList(){
        Node trav= head;
        Node prev= null;
        Node next = null;
        for(trav= head;trav!=null;trav=next){
            next = trav.next;
            trav.next=prev;
            trav.prev=next;
            prev = trav;
        }
        head= prev;
    }


    public void Display(){
        Node trav = head;

        for(trav= head;trav!=null;trav=trav.next){
            System.out.print(trav.data + "<->");
        }
        System.out.println("null");
        System.out.println("Size: "+ size);
    }
}


public class DoubleLinkedlist {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter a first number to add into the linked list");
        n = sc.nextInt();

        Double l = new Double();
        l.addFirst(n);
        System.out.println("Enter the number of extra moreNodes you want to create");
        n = sc.nextInt();

        System.out.println("enter the values for each node");
        for(int i = 0;i<n;i++){
            int d = sc.nextInt();
            l.addLast(d);
        }

        l.Display();
        l.insertAt(4,3);
        l.Display();
        l.reverseList();
        l.Display();

    }
}
