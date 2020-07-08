package com.company.Graphs;
import javax.swing.plaf.BorderUIResource;
import java.util.*;

class Graph{
List<Node> list ; // list to store the elments
int v; // number of vertices
 Graph(){
    this.list= new ArrayList<>();
    this.v=0;
    }
    void add(Node node){
     list.add(node);
     v++;
    }

    /*
    Braedth First Search
     */
    void BFS(Node n){ // Takes any node from the user and then applies BFS on it
        if(!n.isVisited);
            visit(n);
        for (Node node:list) { // if a node is unvisited then run bfs on it
        if(!node.isVisited)
            visit(node);
        }
    }

 // BFS internal method to visit the unvisited nodes
    void visit(Node node){
        Queue<Node> lis= new LinkedList<>();
        lis.add(node);
        while (!lis.isEmpty()){
        Node present = lis.remove();
        node.isVisited=true; // set the current node as visited
            System.out.print(present.val+"->");
            for (Node connect:present.connection) { // for each niegbors prsent for the prsent node insert them
                // in the quqeue and mark them viisted
                if(!connect.isVisited) { // checks if the nieghbors of the nodes are vsisted or not if not then the neighbors are visited
                    lis.add(connect);
                    connect.isVisited = true;
                }
            }
        }
    }
    //******************************************************             BFS                 ***************************************

    void DFS(Node n){
        if(!n.isVisited)
            visitDFS(n);
        for(Node node: list){
            if(!node.isVisited)
                visitDFS(node);
        }
    }

     void visitDFS(Node n) {
        Stack<Node> stack = new Stack<>();
        stack.push(n);
        while (!stack.isEmpty()) {
            Node present = stack.pop();
            present.isVisited = true;
            System.out.print(present.val + "->");
            for (Node neighbors : present.connection) {
                if (!neighbors.isVisited) {
                    stack.push(neighbors);
                    neighbors.isVisited = true;
                }

            }
        }
    }

    void addEdge(int vertices1, int vertices2){ // takes index of two vertices which have a common edge
        Node first= list.get(vertices2-1);// retrieve the 1st Node frome the main list
        Node sec= list.get(vertices1-1);// retrieve the 2nd Node fromthe the main list
        first.connection.add(sec); // Stores the connection of between vertices1 and vertices2
        sec.connection.add(first); // store the connection between vertices2 and vertices1
    }
    public String toString(){
        return list.toString();
    }
}
public class Graphstructure {
    public static void main(String[] args) {
        Graph graph= new Graph();

        for(int i=1;i<11; i++) {
            graph.add(new Node("V"+i,i));
        }
        System.out.println(graph.v);
        System.out.println(graph);
        System.out.println(graph.list.get(2).connection);
        //add edges
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,5);
        graph.addEdge(3,6);
        graph.addEdge(3,10);
        graph.addEdge(4,7);
        graph.addEdge(5,8);
        graph.addEdge(6,9);
        graph.addEdge(7,8);
        graph.addEdge(8,9);
        graph.addEdge(9,10);
        System.out.println(graph.list.get(2).connection);
      System.out.println("BFS:");
      graph.BFS(graph.list.get(2));

        // set all visited nodes to default false
        for (Node li:graph.list) {
            li.isVisited=false;
        }
      //  RUN DFS again on the graph
        System.out.println("\nDFS:");
        graph.DFS(graph.list.get(2));
    }
}
