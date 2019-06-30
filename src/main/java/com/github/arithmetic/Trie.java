package com.github.arithmetic;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private Node root;
    private int size;

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord){
            cur.isWord = true;
            size ++;
        }
    }

    private class Node{
        private boolean isWord;
        private Map<Character,Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node() {
            this.isWord = false;
        }
    }
}
