package com.company.Trie;
import java.util.*;
class Trie{
    Node root;
    Trie(){
        this.root= new Node();
    }

    void insert(String s){
        Node current=root;
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            Node node= current.child.get(c);
            if(node==null) {
                node = new Node();
                current.child.put(c, node);
            }
            current = node;
        }
    current.end= true;
        System.out.println("String inserted successfully");
    }

    boolean search(String s){
        Node current= root;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            Node node = current.child.get(ch);
            if (node == null) {
                System.out.println("String not present in the trie");
                return false;
            }
                current = node;
        }
            if(current.end==true){
                  System.out.println("String found in the trie");
            }
            else{
                System.out.println("String prseent as a substring of another string");
            }
            return current.end;
        }

    public void delete(String word) {
        if (search(word) == true) {
            delete(root, word, 0);
        }
    }




    // Returns true if parent should delete the mapping
    private boolean delete(Node parentNode, String word, int index) {

        // CASE#1 -- Some other word's prefix is same as Prefix of this word (BCDE, BCKG)
        // CASE#2 -- We are at last character of this word and This word is a Prefix of some other word (BCDE, BCDEFG)
        // CASE#3 -- Some other word is a Prefix of this word (BCDE, BC)
        // CASE#4 -- No one is dependent on this Word (BCDE, BCDE)

        char ch = word.charAt(index);
        Node currentNode = parentNode.child.get(ch);

        boolean canThisNodeBeDeleted;

        if (currentNode.child.size() > 1) {
            System.out.println("Entering Case#1");
            delete(currentNode, word, index + 1); // CASE#1
            return false;
        }



        if (index == word.length() - 1) { // CASE#2
            System.out.println("Entering Case#2");
            if (currentNode.child.size() >= 1) {
                currentNode.end = false;//updating endOfWord will signify that this word is not there in Trie
                return false;
            } else {
                System.out.println("Character " + ch + " has no dependency, hence deleting it from last");
                parentNode.child.remove(ch);
                return true;// If this word is not a prefix of some other word, and since this is last
                // character, we should
                // return true, indicating we are ok to delete this node
            }
        }


        if (currentNode.end == true) { // CASE#3
            System.out.println("Entering Case#3");
            delete(currentNode, word, index + 1);
            return false;
        }


        System.out.println("Entering Case#1");
        canThisNodeBeDeleted = delete(currentNode, word, index + 1); // CASE#4
        if (canThisNodeBeDeleted == true) {
            System.out.println("Character " + ch + " has no dependency, hence deleting it");
            parentNode.child.remove(ch);
            return true; // Current node can also be deleted
        } else {
            return false; // Someone is dependent on this node, hence dont delete it
        }

    }
}

public class Stringsearch {
    public static void main(String[] args) {
        Trie t= new Trie();
        t.insert("air");
        t.insert("airdrop");
        t.insert("rob");
        t.search("rop");
        t.search("rope");
        t.delete("rope");
    }
}
