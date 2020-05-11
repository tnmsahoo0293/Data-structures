package com.company.queue;

class Arrayqueue{
    int top;
    int start;
    int size=0;
    int[] arr;

  public  Arrayqueue(int size)
    {
           this.arr= new int[size];
            this.start=-1;
            this.top=-1;
           System.out.println("Array created of size: "+arr.length);
    }

    void enqueue(int val){

        if(top==(arr.length)-1)
        {
            System.out.println("Queue is full");
        }
        else
            {
                if(top==(-1))
                {
                    ++top;
                   // System.out.println(top);
                    arr[top]=val;
                    start=0;
                    size++;
                }
                else {
                    ++top;
                    arr[top] = val;
                    size++;
                }
        }
    }
    void dequeue(){
        if(top==-1)
            System.out.println("Queue is empty");
        else{

            int del = arr[start];
            start++;
            if(size==1){
                top=start=-1;
            }
            System.out.println(del + " removed from the queue");
            size--;
        }
    }
    void peek(){
        if(top==-1)
            System.out.println("Queue is empty");
        else
            System.out.println(arr[start]);
    }

}

 class Queuearray {
    public static void main(String[] args) {
        Arrayqueue queue= new Arrayqueue(10);
        queue.enqueue(67);
        queue.enqueue(12);
        queue.enqueue(23);
        queue.enqueue(34);
        queue.enqueue(56);
        queue.peek();
        queue.dequeue();
        System.out.println("top value: " +queue.top);

    }
}
