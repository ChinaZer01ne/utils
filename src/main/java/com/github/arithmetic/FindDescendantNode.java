package com.github.arithmetic;

/**
 * 找到一棵二叉树的后继节点（中序遍历）
 * @Author: Zer01ne
 * @Date: 2019/1/23 9:37
 * @Version 1.0
 */
public class FindDescendantNode {

    static class TreeNode<T>{
        TreeNode parent;
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
        node2.parent = node1;
        node1.right = node3;
        node3.parent = node1;
        node2.left = node4;
        node4.parent = node2;
        node2.right = node5;
        node5.parent = node2;
        node3.left = node6;
        node6.parent = node3;
    }

    private static void findDescendantNode(){


    }
}
