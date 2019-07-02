package com.github.arithmetic.structure;

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
        LDR(node1);
        System.out.println();
        System.out.println("=======================");
        System.out.println(findDescendantNode(node1).data);
        System.out.println(findDescendantNode(node4).data);
        System.out.println(findDescendantNode(node2).data);
        System.out.println(findDescendantNode(node5).data);
        System.out.println(findDescendantNode(node6).data);
        System.out.println(findDescendantNode(node3));
    }
    //如果当前节点有右子树，那么下一个打印的是它右子树最左的节点；
    // 如果没有右子树，那么下一个打印的是，先找当前节点的父节点，如果这个节点不是它的父节点的左孩子，就继续往上找
    private static TreeNode findDescendantNode(TreeNode node){

        if (node == null){
            return node;
        }

        if (node.right != null){
            return getRightTreeMostLeft(node.right);
        }else {
            TreeNode parentNode = node.parent;
            while (parentNode!= null && parentNode.left != node){
                node = parentNode;
                parentNode = node.parent;
            }
            return parentNode;
        }
    }

    private static TreeNode getRightTreeMostLeft(TreeNode node){
        if (node.left == null){
            return node;
        }else {
            while (node.left != null){
                node = node.left;
            }
            return node;
        }
    }

    private static void LDR(TreeNode<Integer> head){
        if (head != null){
            LDR(head.left);
            System.out.print(head.data + "\t");
            LDR(head.right);
        }
    }
}
