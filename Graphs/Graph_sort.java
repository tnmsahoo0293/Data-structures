package com.company.Graphs;

// above import is not necessary since all default access modifier class can be accessed within the same package

public class Graph_sort {
    public static void main(String[] args) {
     Graph g= new Graph();
        for(int i=1;i<11; i++) {
            g.add(new Node("V"+i,i));
        }
        //add edges
        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(2,3);
        g.addEdge(2,5);
        g.addEdge(3,6);
        g.addEdge(3,10);
        g.addEdge(4,7);
        g.addEdge(5,8);
        g.addEdge(6,9);
        g.addEdge(7,8);
        g.addEdge(8,9);
        g.addEdge(9,10);

    }
}
