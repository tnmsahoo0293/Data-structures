package com.company.AVLtree;

public class Node {
    int value;
    Node left;
    Node right;
    int height;

    Node(int val){
        this.value= val;
        left= null;
        right= null;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }//end of method

    int getHeight(){
        return height;
    }

    public int getValue() {
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
