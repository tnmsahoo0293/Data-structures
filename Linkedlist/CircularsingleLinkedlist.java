package com.company.Linkedlist;

class Circular<T>{
    Node head;
    Node tail;
    int size = 0;

    // Node class
    class Node{
        Node next;
        T data;

        Node(T val){
            data= val;
            this.next = null;
        }
    }

    // check the size of Linked list
    public boolean isEmpty(){return size==0;}


    // Add node to the last of the linked ist
    void addLast(T data){
        if(isEmpty()){
            Node temp = new Node(data);
            head=tail=temp;
            temp.next=head;
            size++;
        }

        else{
            Node temp = new Node(data);
            temp.next= head;
            tail.next=temp;
            tail=temp;
            size++;

        }
    }

    // add node to the first of linked list
    void addFirst(T data){
        if(isEmpty()){
            Node temp = new Node(data);
            head=tail=temp;
            temp.next=head;
            size++;
        }

        else{
            Node temp = new Node(data);
            temp.next= head;
            tail.next=temp;
            head=temp;
            size++;

        }
    }


// add Node to any position in the linked list
    void insertAt(T data, int pos){
        if(isEmpty()){
            System.out.println("No element in the linked list, inserting the element on the first place.");
            Node temp = new Node(data);
            head=tail=temp;
            temp.next=head;
            size++;
        }

        else{
            Node trav= head;
            for(int i=0;i<pos;i++){
                trav=trav.next;
            }
            Node temp = new Node(data);
            temp.next= trav.next;
            trav.next= temp;
            size++;
        }
    }


    // Display all the nodes
    void Display(){
        Node trav;
        int i;
        for(trav=head,i=0;i<size;trav=trav.next,i++){
            System.out.print(trav.data+"-> ");
        }
        System.out.println();
    }

    // Search element in the linked list
    void search(T data){
        int i=0;
        Node trav=head;

        while( i!=size){
            if(trav.data==data){
                System.out.println("element found at index " + i);
                break;
            }

            trav=trav.next;
            i++;
        }
    }

    T delete(int position) {   // O(n) , space complexity- O(1)
        Node trav;
        T dat = null;

        if (size == 1) {
            dat = head.data;
            head = tail = null;
            size--;
            return dat;
        }

        if (position == 1) {
            dat = head.data;
            head = head.next;
            tail.next = head;
            size--;
            return dat;
        }

        else if (position == size) {
            int i;
            int index = position - 1;

            for (trav = head, i = 0; i < index - 1; i++)
                {
                trav = trav.next;
                }

            trav.next.data = dat;
            trav.next = trav.next.next;
            tail=trav;
            size--;
            return dat;

        }

        else {
            int i;
            int index = position - 1;
            for (trav = head, i = 0; i < index - 1; i++) {
                trav = trav.next;
            }

            trav.next.data = dat;
            trav.next = trav.next.next;
            size--;
            return dat;
        }
    }

   void reset(){ // O(1), sapce complexity- O(1)
        head= null;
        tail.next=null;
        tail= null;
        size=0;
        System.out.println("Linked list deleted");
    }

}

public class CircularsingleLinkedlist {
    public static void main(String[] args) {
        Circular<Integer>list =  new Circular<>();
        list.addLast(2);
        list.addLast(4);
        list.addLast(6);
        list.insertAt(7,1);
        list.addFirst(10);
        System.out.println("size of linked list is " +list.size);
        list.addLast(8);
        list.Display();
        System.out.println("size of linked list is " +list.size);
        list.search(4);
        Integer val=list.delete(6);
        System.out.println(val);
        list.Display();
        list.reset();
        //list.Display();
        System.out.println("size of linked list is " +list.size);
    }
}
