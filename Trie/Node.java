package com.company.Trie;
import java.util.*;
import java.io.*;

public class Node {
    Map<Character,Node> child;
    boolean end;

    Node(){
        this.child= new HashMap<>();
        end=false;
    }

}