package com.company.Binarytree;

 class Node<T> {
    T value;
    Node left;
    Node right;
     int height;

     Node(T val){
         this.value= val;
         left= null;
         right= null;
     }

     int getHeight(){
         return height;
     }

     public T getValue() {
         return value;
     }//end of method

     public Node getLeft() {
         return left;
     }

     public Node getRight() {
         return right; }



     public String toString() {
         return value + "";
     }//end of method




}
