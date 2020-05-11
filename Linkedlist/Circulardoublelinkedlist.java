package com.company.Linkedlist;
import java.io.*;
import java.util.*;

class Doublecircular<T> {
    Node head;
    Node tail;
    int size = 0;

    class Node {
        Node next;
        Node prev;
        T data;

        Node(T data) {
            next = null;
            prev = null;
            this.data = data;
        }
    }
    // member functions of Doublecircular class

    public boolean isEmpty() {
        return (size == 0);
    }

    void addLast(T data) {
        if (isEmpty()) {
            Node temp = new Node(data);
            head = tail = temp;
            tail.next = head;
            size++;
        }
        else {
            Node temp = new Node(data);

            temp.prev = tail;
            tail.next = temp;
            tail = temp;
            tail.next=head;
            size++;
        }
    }

    void addFirst( T data){
        if(isEmpty()){
            Node temp= new Node(data);
            head=tail= temp;
            tail.next= head;
            size++;
        }
        else{
            Node temp =  new Node(data);
            temp.next=head;
            head.prev=temp;
            head= temp;
            tail.next=head;
            head.prev=tail;
            size++;
        }
    }

    void insertAt(T data, int position) {
        if(position==0)
            System.out.println("Please enter a position starting from 1");
        else if (position == 1)
            addFirst(data);
        else if (position == size)
            addLast(data);
        else {
            Node trav=head;
            Node back=null;
            int i;
            for(trav=head, i=0;i<=position-2;i++){
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

        T delete(int position){
            Node trav;
            T dat= null;
            int index= position-1;
            if(index==0)
            {
               dat= head.data;
                head=head.next;
                tail.next=head;
                size--;
                return dat;
            }
            else if(index==size-1){
                dat= tail.data;
                tail= tail.prev;
                tail.next= head;
                size--;
                return dat;
            }
            else{
                int i;
                Node nex= null;
                for(i=0,trav=head;i<index-1;i++){
                    trav=trav.next;
                    nex=trav.next;
                }
                dat=nex.data;
                trav.next=nex.next;
                nex.prev=trav;
                return dat;
            }

        }

        void search(T value){
            Node trav;
            int i=0;
            for(trav=head,i=0;i!=size;trav=trav.next,i++){
                if(trav.data==value){
                    System.out.println("the index of the element "+"\""+value+"\""+ " is: "+ i);
                    break;
                }

            }
            if(i==size)
                System.out.println("Element not found in the linked list");
        }

    void display() {
        Node trav;
        int i;
        for(i=0,trav=head;i<size;i++) {
            System.out.print(trav.data + "<-> ");
            trav = trav.next;
        }
        System.out.println(head.data+"(Head)");
    }
}

public class Circulardoublelinkedlist<T> {
    public static void main(String[] args) {

        Doublecircular<Integer> list = new Doublecircular<>();
        list.addLast(4);
        System.out.println("size:"+list.size);
        list.addLast(5);
        System.out.println("size:"+list.size);

        for(int i=0;i<4;i++){
            list.addLast((i+1)*6);
           // System.out.println("size:"+list.size);
        }
        list.insertAt(23,3);
        list.addFirst(67);
        list.addFirst(34);
        list.display();
        System.out.println("size:"+list.size);

        int del= list.delete(1);
        System.out.println("deleted item:"+del);
        list.display();
        int dl= list.delete(3);
        System.out.println("deleted item:"+dl);

        System.out.println("size: "+ list.size);
        list.display();

        list.search(5);

    }
}
