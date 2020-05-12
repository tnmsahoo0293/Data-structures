package com.company.Binarytree;

import java.util.LinkedList;
import java.util.Queue;

class Tree{
  Node root;

  Tree(){
      this.root =null;
  }

  void insert(Object val){
      Node temp = new Node(val);
        if(root==null){
            root=temp;
            return;
        }
        else{               // insert value in the first vacant node
            Queue<Node> qu = new LinkedList<>();
            qu.add(root);
            while(!qu.isEmpty()){
                Node presentNode = qu.remove();
                if (presentNode.getLeft() == null) {
                    presentNode.left=temp;
                    System.out.println("Successfully inserted new node !");
                    break;
                }else if (presentNode.getRight() == null) {
                    presentNode.right=temp;
                    System.out.println("Successfully inserted new node !");
                    break;
                } else {
                    qu.add(presentNode.getLeft());
                    qu.add(presentNode.getRight());
                }//end of else-if
            }//end of loop
        }
  }

  void preorder(Node root){
      if(root==null)
          return;
         // System.out.println("tree is empty");
      else{
          System.out.print(root+" ->");
          preorder(root.left);
          preorder(root.right);

      }
  }

  void inorder(Node root){
      if(root==null){
          return;
          //System.out.println("Tree is null");
      }

      else{
          inorder(root.left);
          System.out.print(root+" ->");
          inorder(root.right);

      }
  }

  void postorder(Node root){
      if(root==null)
          return;
      else{
          postorder(root.left);
          postorder(root.right);
          System.out.print(root+",");
      }

  }
  void levelorder(Node root){
        if(root==null)
            System.out.println("Tree is null");
        else{                                        // Queue is an interface and LinkedList is a class
            Queue<Node> qu = new LinkedList<>();
            qu.add(root);
            while(!qu.isEmpty()){
                Node presentNode = qu.remove();
                System.out.print(presentNode.getValue()+" ->");
                if (presentNode.getLeft() != null) {
                    qu.add(presentNode.getLeft());
                }
                if (presentNode.getRight() != null)
                    qu.add(presentNode.getRight());
            }
        }
  }

  void search(Object val){
        if(root==null)
            System.out.println("Tree is empty");
        else{
            Queue<Node> que= new LinkedList<>();
            que.add(root);
            while (!que.isEmpty()) {
                Node presentNode = que.remove();
                if (presentNode.getValue() == val) {
                    System.out.println("Value-"+val+" is found in Tree !");
                    return;
                }
                else {
                    if (presentNode.getLeft()!=null)
                        que.add(presentNode.getLeft());
                    if (presentNode.getRight()!=null)
                        que.add(presentNode.getRight());
                }
            }//end of loop
            System.out.println("Value-"+val+" is not found in Tree !"); }

  }

  void delete(Object val){
            if(root == null)
                System.out.println("Tree is empty");
            else
            {
                Queue<Node> qu = new LinkedList<>();
                qu.add(root);

                while(!qu.isEmpty()){
                    Node pres= qu.remove();
                    if(pres.getValue()==val){
                        pres.value=getdeepestnode().value;
                        deldeepest();
                        System.out.println("Node deletd from the tree");
                        return;
                    }
                    else{
                        if(pres.getLeft()!=null)
                            qu.add(pres.getLeft());
                        else if(pres.getRight()!=null)
                            qu.add(pres.getLeft());
                    }
                }
                System.out.println("Node not found in the tree");
            }
  }

  Node getdeepestnode(){
      Queue<Node> qu =  new LinkedList<>();
      qu.add(root);
      Node pres= null;
      while(!qu.isEmpty()){
          pres= qu.remove();
          if(pres.getLeft()!=null)
              qu.add(pres.getLeft());
          if(pres.getRight()!=null)
              qu.add(pres.getRight());
      }
        return pres;
  }
  void deldeepest(){
            Queue<Node> qu =  new LinkedList<>();
            qu.add(root);
            Node prev, pres = null;
      while (!qu.isEmpty()) {
          prev = pres;
          pres = qu.remove();
          if (pres.getLeft() == null) {
              prev.right=null; // if there are no left child then the right most child of previous node in the queue is made null.
              return;
          }else if ((pres.getRight() == null)) {
              pres.left=null;   // if there are no right child then the left child of current (present) node in the queue is made null.
              return;
          }
          qu.add(pres.getLeft());
          qu.add(pres.getRight());
      }
  }

}

public class Binarytree {
    public static void main(String[] args) {
        Tree bin = new Tree();
        //Node<Integer> node = new Node<>(59);
       // bin.root=node;
        bin.insert(78);
        bin.insert(25);
        bin.insert(45);
        bin.insert(267);
        bin.insert(23);
        bin.search(23);
        System.out.println("Preorder***************");
        bin.preorder(bin.root);
        System.out.println("\nLevel order*****************");
        bin.levelorder(bin.root);
        System.out.println("\nPostorder***************");
        bin.postorder(bin.root);
        bin.delete(25);
        bin.inorder(bin.root);
    }
}
