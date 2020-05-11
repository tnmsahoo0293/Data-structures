package com.company.queue;

class Circularqueue{
    int top;
    int[] arr;
    int start;
    int size=-1;
    Circularqueue(int cap){
        this.arr = new int[cap];            // O(1); space complexity: O(n)
        top=-1;
        start=-1;
        size=0;

        System.out.println("Created an array of size: "+arr.length);
    }
    boolean isFull(){
            if(top+1==start)
                return true;
            else if(top+1==arr.length && start==0)
                return true;
            else
                return false;
    }

    boolean isEmpty(){
        if(top==-1)
            return true;
        else if(arr==null)
            return true;
        else
            return false;

    }
    void enQ(int val){
        if(size==-1){
            System.out.println("Array not created");
        }
        else if(isFull())
            System.out.println("Queue is full");
        else {
//            if(start==-1)
//                    start=0;
            if (top + 1 == arr.length) {
                top = 0;
                size++;
            }
            else {
                if(start==-1)
                    start=0;
                top++;
            }

            arr[top] = val;
            size++;
        }
    }

    void deQ(){                         // O(1) ; space complexity: O(1)
        if(isEmpty()){
            System.out.println("Queue elements not available");
        }
        System.out.println(arr[start]+ "............deleted");

        if(start==top){
            //System.out.println(arr[start]);
            start=top=-1;
        }
        else{
            if(start+1==arr.length)
                start=0;
            else
                start++;
        }
    }

    void peek(){              //O(1)
        if(isEmpty()){
            System.out.println("Queue elements not available");
        }
        System.out.println(arr[start]);
    }

    void display(){
        if(isEmpty())
                System.out.println("Queue is empty");
        else if(start==top)
            System.out.println(arr[start]);
        else if(top+1==arr.length){
            for(int i=start;i<=top;i++)
            System.out.print(arr[i]+"|");
            System.out.println();
        }
        else if(top+1==start){
            for(int i=start;i!=top;i++){
                if(i==arr.length)
                    i=0;
                System.out.print(arr[i]+ "|");
            }
            System.out.println(arr[top]);
        }
    }

}
public class Queuecircle {
    public static void main(String[] args) {
        Circularqueue Q = new Circularqueue(5);
        Q.enQ(12);
        for(int i=0;i<4;i++)
            Q.enQ((i+1)*(i+2));
        Q.display();
        Q.deQ();
        Q.deQ();
        Q.peek();
        Q.enQ(45);
        Q.enQ(56);
        System.out.println("inserted element");
        Q.display();
    }
}
