package com.company.Graphs;
import java.util.*;
class Node{
    String val; // string value storing the value for the node
    int index; // used for adjacency matrix
    List<Node> connection= new ArrayList<>(); // Stores all the connection a particular node with al other node
    //the list basically stores the edges

boolean isVisited= false;// keeps check if the node is visited during traversal or not
Node parent;

Node(String name, int index){
    this.val=name;
    this.index= index;

}


    public void setConnection(List<Node> connection) {
        this.connection = connection;
    }

    public String toString(){
    return val;
    }

}
