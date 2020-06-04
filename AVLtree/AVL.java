package com.company.AVLtree;

import java.util.LinkedList;
import java.util.Queue;

// IN AVL TREE WE HAVE TO KEEP CHECK ON THE HEIGHT TO CHECK THE BALANCE OF THE TREE AND CHECK IF IT NEEDS ROTATION

class Atree{
    Node root;

    Atree(){
        this.root=null;
        System.out.println("tree is created");
        root.setHeight(0);
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

//Insertion of values

    Node insert (Node node, int value){
        if(node==null){
            System.out.println("Succesfully inserted value in the AVL tree");
            Node temp= new Node(value);
            return temp;
        }
        else if(node.value> value)
            node.left=insert(node.left, value);
        else
            node.right =insert(node.right,value);
//
        int balance = checkBal(node.getLeft(), node.getRight());
        if (balance > 1) {
            if (checkBal(node.getLeft().getLeft(), node.getLeft().getRight()) > 0) {
                node = rightRotate(node);// LL Condition
            } else {
                node.left=leftRotate(node.getLeft()); // LR Condition
                node = rightRotate(node);
            }
        } else if (balance < -1) {
            if (checkBal(node.getRight().getRight(), node.getRight().getLeft()) > 0) {
                node = leftRotate(node);// RR Condition

            } else {
                node.right=rightRotate(node.getRight());// RL Condition
                node = leftRotate(node);

            }
        }

        if (node.getLeft() != null) {
            node.getLeft().setHeight(calculateHeight(node.getLeft()));
        }
        if (node.getRight() != null) {
            node.getRight().setHeight(calculateHeight(node.getRight()));
        }
        node.setHeight(calculateHeight(node));
        return node;
    }

    int checkBal( Node left, Node right){
        if((left == null) && (right == null)) { //if current node is a leaf node then no need to check balance of its children
            return 0;
        }
        else if (left == null) {
            return -1 * (right.getHeight() + 1); // if left node node is not there then simply return right node's
            // height + 1
            // we need to make it -1 because blank height is considered
            // having height as '-1'
        }
        else if (right == null) {
            return left.getHeight() + 1; // since rightchild is null so the -1 turns into +1(-(-1)) while subtracting
        }
        else {
            return left.getHeight() - right.getHeight(); // +1 is not required, as both right and left child
            // exits and 1 gets nullified
        }
    }// end of method

    private int calculateHeight(Node currentNode) {
        if (currentNode == null) {
            return 0;
        }
        return 1 + Math.max((currentNode.getLeft() != null ? currentNode.getLeft().getHeight() : -1),
                (currentNode.getRight() != null ? currentNode.getRight().getHeight() : -1));
    }

    void insert_val(int val){

    }

   Node rightRotate(Node current){
       Node newroot= current.left;
        current.left= current.left.right;
        newroot.right=current;
        current.setHeight(calculateHeight(current));
        newroot.setHeight(calculateHeight(newroot));
        return newroot;  // the new root is returned which is then used in the main isert function to change the rot of the tree
    }

    Node leftRotate (Node node){ // "the left child of the current ode is passed to the function as parameter"
        Node newroot= node.right;
        node.right = node.right.left;
        newroot.left=node;
        node.height=calculateHeight(node);
        newroot.height= calculateHeight(newroot);
        return newroot;
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

    int search(Node node, int val){
        if(node==null) {
            System.out.println("Tree is empty");
            return -1;
        }
        else if (node.value==val){
            return root.value;
        }
        else if (node.getValue()>val)
            return search(node.right, val);
        else
            return search(node.left, val);

    }

    public void deleteNode(int value) {
        System.out.println("\n\nDeleting " + value + " from BST...");
        del(root,value);
    }


    public Node del(Node node, int value) {
        if (node == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < node.getValue()) {
            node.left = (del(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.right = (del(node.getRight(), value));
        } else { // If currentNode is the node to be deleted

            if (node.getLeft() != null && node.getRight() != null) { // if nodeToBeDeleted have both children
                Node temp = node;
                Node minNodeForRight = minimumElement(temp.getRight());// Finding minimum element from right subtree
                node.value = minNodeForRight.getValue(); // Replacing current node with minimum node from right subtree
                node.right = del(node.getRight(), minNodeForRight.getValue());  // Deleting minimum node from right now
            } else if (node.getLeft() != null) {// if nodeToBeDeleted has only left child
                node = node.getLeft();
            } else if (node.getRight() != null) {// if nodeToBeDeleted has only right child
                node = node.getRight();
            } else // if nodeToBeDeleted do not have child (Leaf node)
                node = null;
            return node;
        }
        int balance = checkBal(node.getLeft(), node.getRight());
        if (balance > 1) {
            if (checkBal(node.getLeft().getLeft(), node.getLeft().getRight()) > 0) {
                node = rightRotate(node);// LL Condition
            } else {
                node.left=leftRotate(node.getLeft()); // LR Condition
                node = rightRotate(node);
            }
        } else if (balance < -1) {
            if (checkBal(node.getRight().getRight(), node.getRight().getLeft()) > 0) {
                node = leftRotate(node);// RR Condition

            } else {
                node.right=rightRotate(node.getRight());// RL Condition
                node = leftRotate(node);

            }
        }

        if (node.getLeft() != null) {
            node.getLeft().setHeight(calculateHeight(node.getLeft()));
        }
        if (node.getRight() != null) {
            node.getRight().setHeight(calculateHeight(node.getRight()));
        }
        node.setHeight(calculateHeight(node));
        return node;

    }

   Node minimumElement(Node root) {
       if (root.getLeft() == null)
           return root;
       else {
           return minimumElement(root.getLeft());
       }
   }
}
public class AVL {

    public static void main(String[] args) {
        Atree t = new Atree();
        t.insert_val(23);
        t.insert_val(34);
        t.insert_val(3);
        t.insert_val(2);
        t.insert_val(234);
        t.insert_val(232);
        t.insert_val(2343);
        t.insert_val(236);
        t.insert_val(253);
        t.deleteNode(234);
        t.insert_val(1);
        t.deleteNode(2);

        t.inorder(t.root);


    }
}
