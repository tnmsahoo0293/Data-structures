package com.company.Linkedlist;
import java.util.*;
import java.io.*;
import java.util.Arrays.*;

class Single{
    Node head;
    int size=0;
    Node tail;
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
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
            temp.next= head;
            head=temp;
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
            Node temp= new Node(x);
            tail.next=temp;
            tail= temp;
            size++;
        }
    }

    public void remove(int x){
        if(isEmpty())
            System.out.println("Exception List is empty, cant pop any ");
        else{
            Node trav= head;
            Node prev= null;
            while(  trav!= null && trav.data!=x){
                prev= trav;
                trav = trav.next;
            }
            prev.next= trav.next;
            size--;

        }
    }


    public void pop(){
        if(isEmpty())
            System.out.println("Exception List is empty, cant pop any ");
        else{
            head= head.next;
            size--;
        }
    }


    public void removeAt(int idx){
        if(isEmpty())
            System.out.println("Exception List is empty, cant pop any ");
        else{
            Node trav=head;
            Node prev =null;
            for(int i=0; trav!=null && i!=idx;i++){
                prev=trav;
                trav= trav.next;
            }
            prev.next= trav.next;
        }
        size--;
    }


    public void Display(){
        Node trav = head;

        while(trav!=null){
            System.out.print(trav.data+", ");
            trav = trav.next;
        }
        System.out.println("\nsize is:"+ size);
    }

    public  void printMiddle(){
        Node trav= head;
        for(int i=0;i!=size/2;i++){
            trav = trav.next;
        }
        System.out.println(trav.data);
    }

    public  void reverse(){
        Node trav= head;
        Node prev= null;
        Node next = null;
        for(trav= head;trav!=null;trav=next){
            next = trav.next;
            trav.next=prev;
            prev = trav;
        }
        head= prev;
    }
}



public class singleLinkedlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();

        Single l = new Single();
        l.addFirst(n);
        n = sc.nextInt();
        l.addLast(n);
        for(int i=0;i<4;i++){
            n=sc.nextInt();
            l.addLast(n);
        }
        l.Display();
        //l.remove(8);
        l.Display();
        l.pop();
        //l.removeAt(2);
        l.Display();
        l.printMiddle();
        l.reverse();
        l.Display();

    }
}
