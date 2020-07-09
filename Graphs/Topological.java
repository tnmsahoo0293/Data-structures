package com.company.Graphs;
import java.util.*;

public class Topological {
 static void topological(Graph g){
     Stack<Node> stack= new Stack<>();
    for(Node x: g.list){ // check all the Nodes in the Graph and check if they are visited
        if (!x.isVisited)
            topoVisit(x, stack);
    }
    while(!stack.isEmpty()){
        System.out.printf("%s->",stack.pop());
    }
}
static void topoVisit(Node x, Stack<Node> stack) {
    for (Node li : x.connection) { // check all the dependencies of the nodes and if any visit them first & push them in the stack
        if (!li.isVisited)
            topoVisit(li, stack);
    }
        x.isVisited = true;
        stack.push(x);
}

static void addEdge(Graph y, int x, int k){
Node f=y.list.get(x-1);
Node s= y.list.get(k-1);
f.connection.add(s);  // stores one way connection from first node f to the second node s
 }

    public static void main(String[] args) {
        Graph graph= new Graph();

        for(int i=1;i<11; i++) {
            graph.add(new Node("V"+i,i));
        }
        System.out.println(graph.v); //size of the Graph list
        System.out.println(graph);
      // System.out.println(graph.list.get(2).connection);
        //add edges
       addEdge(graph,1,3);
       addEdge(graph,2,3);
        addEdge(graph,2,4);
        addEdge(graph,3,5);
        addEdge(graph,3,10);
        addEdge(graph,4,6);
        addEdge(graph,5,8);
        addEdge(graph,5,6);
        addEdge(graph,6,7);
        addEdge(graph,7,8);
       addEdge(graph,8,9);
        addEdge(graph,9,10);
        topological(graph);
    }
}
