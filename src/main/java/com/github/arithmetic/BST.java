package com.github.arithmetic;

import org.apache.commons.collections4.SplitMapUtils;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/27 13:35
 */
public class BST<E extends Comparable<E>> {


    private Node<E> root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add2(7);
        bst.add2(5);
        bst.add2(6);
        bst.add2(11);
        bst.add2(9);
        bst.add2(13);
        bst.add2(2);
        System.out.println(bst);

        System.out.println(bst.contains(9));

        //bst.preOrder();
        //bst.midOrder();
        bst.behindOrder();
    }

    public void behindOrder() {
        behindOrder(root);
    }

    public void behindOrder(Node<E> node) {
        if (node == null){
            return;
        }
        behindOrder(node.left);
        behindOrder(node.right);
        System.out.println(node.e);
    }

    public void midOrder() {
        midOrder(root);
    }

    public void midOrder(Node<E> node) {
        if (node == null){
            return;
        }
        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node<E> node) {
        if (node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrder2(Node<E> node) {

        while (node != null){

        }
    }


    public boolean contains(E e){

        return contains(root,e);
        //return contains2(root,e);
    }

    private boolean contains(Node<E> node, E e) {
        if (node == null){
            return false;
        }

        Node<E> cur = root;

        while (cur != null){
            if (cur.e.compareTo(e) > 0){
                cur = cur.left;
            }else if (cur.e.compareTo(e) < 0){
                cur = cur.right;
            }else{
                return true;
            }
        }

        return false;
    }
    /**
     * 递归
     * */
    private boolean contains2(Node<E> node, E e) {
        if (node == null){
            return false;
        }

        if (node.e.compareTo(e) == 0){
            return true;
        }else if (node.e.compareTo(e) > 0){
            return contains2(node.left,e);
        }else{
            return contains2(node.right,e);
        }
    }
    /**
     * 非递归版本
     */
    public void add2(E e){
        if (root == null){

            root = new Node<>(e);

        }else{

            Node<E> tempNode = root;
            //boolean found = false;
            //while (found){
            while (true){
                if (e.compareTo(tempNode.e) > 0){
                    if (tempNode.right == null){
                        tempNode.right = new Node<>(e);
                        size ++;
                        //found = true;
                        break;
                    }else {
                        tempNode = tempNode.right;
                    }
                }else if (e.compareTo(tempNode.e) < 0){

                    if (tempNode.left == null){
                        tempNode.left = new Node<>(e);
                        size ++;
                        //found = true;
                        break;
                    }else {
                        tempNode = tempNode.left;
                    }

                }
            }
        }
    }

    /**
     * 递归版本
     */
    public void add(E e){
        root = add(root,e);
    }

    private Node<E> add(Node<E> node,E e){

        if (node == null){
            return new Node<>(e);
        }

        if (node.e.compareTo(e) > 0){
           node.left = add(node.left,e);
        }else if(node.e.compareTo(e) < 0){
            node.right = add(node.right,e);
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node<E> poll = queue.poll();
            sb.append(poll);
            sb.append(",");
            if (poll.left != null){
                queue.add(poll.left);
            }
            if (poll.right != null){
                queue.add(poll.right);
            }
        }
        return sb.toString();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }



    private class Node<E>{
        private E e;
        private Node<E> left;
        private Node<E> right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
