package com.company.queue;

class Linearqueue<T>{
    Node top=null;
    Node start=null;
    int size=0;

    class Node{
        Node next;
        T val;
        Node(T val){
            this.val=val;
            next=null;
        }
    }

    void enQ(T val){

        if(top==null){
            Node temp= new Node(val);
            top=temp;
            start=top;
            size++;
        }
        else{
                Node temp= new Node(val);
                top.next=temp;
                top= temp;
                size++;
        }
    }

    void deQ(){
        if(top==null)
            System.out.println("queue is empty");
        T dat=  start.val;
        System.out.println("Element deleted: "+ dat);
        start= start.next;
        size--;
    }
    void peek(){
        System.out.println("Top of queue: "+ top.val);
    }

}

public class Queue {
    public static void main(String[] args) {
        Linearqueue<String> q = new Linearqueue<>();
        q.enQ("Hello");
        q.enQ("HI");
        q.enQ("Bonjour");
        q.peek();
        q.deQ();
        q.peek();
    }
}
