package com.github.arithmetic.structure;

import org.apache.poi.ss.formula.functions.T;

import java.util.Stack;

/**
 * 遍历二叉树，先序，中序，后序，递归非递归,非递归版，感觉挺难理解的。。我哭了。。
 * @Author: Zer01ne
 * @Date: 2019/1/22 10:26
 * @Version 1.0
 */
public class TraversalTree {

    static class TreeNode<T>{
        TreeNode left;
        TreeNode right;
        T data;

        public TreeNode(T data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        DLR(node1);
        System.out.println("\n======================");
        DLR_WithoutRecursive(node1);
        System.out.println("\n======================");
        LDR(node1);
        System.out.println("\n======================");
        LDR_WithoutRecursive(node1);
        System.out.println("\n======================");
        LRD(node1);
        System.out.println("\n======================");
        LRD_WithoutRecursive(node1);
        System.out.println("\n======================");
        LRD_WithOneStack(node1);
    }
    //使用递归的三种方式
    //先序遍历
    private static void DLR(TreeNode<Integer> head){
        if (head != null){
            System.out.print(head.data + "\t");
            DLR(head.left);
            DLR(head.right);
        }
    }

    //中序遍历
    private static void LDR(TreeNode<Integer> head){
        if (head != null){
            LDR(head.left);
            System.out.print(head.data + "\t");
            LDR(head.right);
        }
    }

    //后序遍历
    private static void LRD(TreeNode<Integer> head){
        if (head != null){
            LRD(head.left);
            LRD(head.right);
            System.out.print(head.data + "\t");
        }
    }
    //非递归的实现，使用栈
    //先序遍历，先压右孩子，再压左孩子，出栈的时候就构成了，根左右的顺序
    private static void DLR_WithoutRecursive(TreeNode<Integer> head){

        if (head != null){

            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.data + "\t");
                if (head.right != null){
                    stack.push(head.right);
                }
                if (head.left != null){
                    stack.push(head.left);
                }

            }

        }
    }
    //中序遍历，当前节点不为空，压栈，当前节点往左移动，当前节点为空，出栈并打印，当前节点往右移动
    //这个有点难理解
    private static void LDR_WithoutRecursive(TreeNode<Integer> head){
        if (head != null){
            Stack<TreeNode> stack = new Stack();
            while (!stack.isEmpty() || head != null){

               if (head != null){
                   stack.push(head);
                   head = head.left;
               }else {
                   head = stack.pop();
                   System.out.print(head.data + "\t");
                   head = head.right;
               }
            }

        }
    }
    //后序遍历，在先序遍历的基础上，在该打印的时候压入另一个栈，最后另一个栈依次弹出
    private static void LRD_WithoutRecursive(TreeNode<Integer> head){

        if (head != null){

            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> popStack = new Stack<>();

            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                popStack.push(head.data);
                if (head.left != null){
                    stack.push(head.left);
                }

                if (head.right != null){
                    stack.push(head.right);
                }

            }

            while (!popStack.isEmpty()){
                System.out.print(popStack.pop()+ "\t");
            }
        }
    }
    //后序遍历，只用一个栈实现？ 该怎么理解呢
    private static void LRD_WithOneStack(TreeNode<Integer> head){
        System.out.print("pos-order: ");
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            TreeNode c = null;
            while (!stack.isEmpty()){
                c = stack.peek();
                if (c.left != null && head != c.left && head != c.right){
                    stack.push(c.left);
                }else if (c.right != null && head != c.right){
                    stack.push(c.right);
                }else {
                    System.out.print(stack.pop().data + "\t");
                    head = c;
                }
            }
        }
    }
}
