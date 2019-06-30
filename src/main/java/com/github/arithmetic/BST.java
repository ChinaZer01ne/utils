package com.github.arithmetic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        System.out.println("===========");
        bst.removeElementNoRecursive(6);
        System.out.println(bst);
        System.out.println("===========");
        bst.removeElementNoRecursive(9);
        System.out.println(bst);
        System.out.println("===========");
        bst.removeElementNoRecursive(7);
        System.out.println(bst);
        System.out.println("===========");
    }

    //寻找二分搜索树最小元素
    public E minmum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return minmum(root).e;
    }
    //返回以node为根的二分搜索树的最小值所在的节点
    public Node<E> minmum(Node<E> node){

        if (node.left == null){
            return node;
        }

        return minmum(node.left);

    }

    //寻找二分搜索树最大元素
    public E maxmum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }
        return maxmum(root).e;
    }
    //返回以node为根的二分搜索树的最大值所在的节点
    public Node<E> maxmum(Node<E> node){

        if (node.right == null){
            return node;
        }

        return maxmum(node.right);

    }

    //删除最小值所在的节点，并返回,非递归
    public E removeMin() {

        if (root == null){
            return null;
        }


        //如果没有左子树
        if (root.left == null){
            Node<E> resNode = root;
            resNode.right = null;
            root = root.right;
            return resNode.e;
        }


        Node<E> prev = root;
        E res = minmum();
        while (prev.left.e != res){
           prev = prev.left;
        }

        //当前节点可能有右子树
        Node<E> cur = prev.left;
        if (cur.right != null){
            Node<E> rightTeee = cur.right;
            prev.left = rightTeee;
        }else{
            prev.left = null;
        }

        return res;

    }

    //删除最小值所在的节点，并返回,递归
    public E removeMin2() {

        E res = minmum();

        root = removeMin(root);

        return res;

    }

    private Node<E> removeMin(Node<E> node) {
        if (node.left == null){
            Node<E> rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    //删除最大值所在的节点，并返回,递归
    public E removeMax2() {

        E res = minmum();

        root = removeMax(root);

        return res;

    }

    private Node<E> removeMax(Node<E> node) {
        if (node.right == null){
            Node<E> leftTree = node.left;
            node.left = null;
            size--;
            return leftTree;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public E removeMax() {

        if (root == null){
            return null;
        }
        if (size == 1){
            Node<E> resNode = root;
            root = null;
            return resNode.e;
        }

        Node<E> cur = root;
        Node<E> prev = new Node<>(null);
        prev.right = root;

        while (cur.right != null){
            prev = prev.right;
            cur = cur.right;
        }
        Node<E> res = prev.right;
        prev.right = null;
        return res.e;
    }

    //删除任意元素,非递归
    public void removeElement(E e){
        //TODO
    }

    public void removeElementNoRecursive(E e){
        //TODO
        root = removeElement2(root,e);
    }
    //删除任意元素,递归
    public Node<E> removeElement2(Node<E> node, E e){
        //TODO
        if (node == null){
            return null;
        }

        if (node.e.compareTo(e) > 0){
            node.left = removeElement2(node.left,e);
        }else if (node.e.compareTo(e) < 0){
            node.right = removeElement2(node.right,e);
        }else{
            //如果没有左孩子
            if (node.left == null){
                Node<E> rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null){
                Node<E> leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //找到右子树的最小值
            Node<E> minNode = minmum(node.right);
            minNode.right = removeMin(node.right);
            minNode.left = node.left;
            node.left = null;
            node.right = null;
            return minNode;
        }
        return node;
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
    public void midOrder1() {
        midOrder1(root);
    }

    public void midOrder(Node<E> node) {
        if (node == null){
            return;
        }
        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);
    }

    public void midOrder1(Node<E> node) {

        if (node == null){
            return;
        }
        Stack<Node<E>> stack = new Stack<>();

        if (node.right != null){
            stack.push(node.right);
        }
        stack.push(node);
        if (node.left != null){
            stack.push(node.left);
        }



    }

    public void preOrder() {
        preOrder(root);
    }
    public void preOrder2() {
        preOrder2(root);
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

        Stack<Node<E>> stack = new Stack<>();

        stack.push(node);

        while (!stack.isEmpty()){
            Node<E> pNode = stack.pop();
            System.out.println(pNode.e);
            if (pNode.right != null){
                stack.push(pNode.right);
            }
            if (pNode.left != null){
                stack.push(pNode.left);
            }
        }

    }

    //dfs思想，优先向左子树访问,然后每次出栈后，再访问右子树
    public void preOrder3(Node<E> node) {

        Stack<Node<E>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                System.out.println(root.e);
                root = root.left;
            }

            root = stack.pop();

            root = root.right;
        }

    }

    //dfs思想，优先向左子树访问,然后每次出栈后，再访问右子树
    public void midOrder2(Node<E> node) {

        Stack<Node<E>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            System.out.println(root.e);

            root = root.right;
        }

    }

    public void midOrder3(Node<E> node) {

        Stack<Node<E>> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                System.out.println(root.e);
                root = root.right;
            }
        }

    }

    //dfs
    public void postOrder2(Node<E> node) {

        Stack<Node<E>> stack = new Stack<>();
        LinkedList<E> linkedList = new LinkedList<>();

        while (root != null || stack.isEmpty()){
            while (root != null){
                stack.push(root);
                linkedList.offerFirst(root.e);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }

        for (E e:
             linkedList) {
            System.out.println(e);
        }
    }
    //保存根，先压右，在押左
    public Stack<E> postOrder3(Node<E> node) {

        Stack<E> answer = new Stack<>();
        if (root == null){
            return answer;
        }
        Stack<Node<E>> stack = new Stack<>();

        stack.push(root);

        while (stack.isEmpty()){
            root = stack.pop();
            answer.push(root.e);
            if (root.right != null){
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }
        }

        return answer;
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
