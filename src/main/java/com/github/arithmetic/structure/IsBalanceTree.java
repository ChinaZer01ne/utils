package com.github.arithmetic.structure;

/**
 * 是否是平衡树
 * @Author: Zer01ne
 * @Date: 2019/1/28 16:28
 * @Version 1.0
 */
public class IsBalanceTree {

    static class TreeNode<T> {
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

        System.out.println(isBalanceTree(node1));
    }


    private static ReturnData isBalanceTree(TreeNode<Integer> head) {
        if (head == null){
            return new ReturnData(true,0);
        }
        ReturnData leftData = isBalanceTree(head.left);
        if (!leftData.isB){
            return new ReturnData(false,0);
        }
        ReturnData rightData = isBalanceTree(head.right);
        if (!rightData.isB){
            return new ReturnData(false,0);
        }
        if (Math.abs(leftData.h - rightData.h) > 1){
            return new ReturnData(false,0);
        }

        return new ReturnData(true,Math.max(leftData.h,rightData.h) + 1);
    }

    public static class ReturnData{
        private boolean isB;
        private int h;

        public ReturnData(boolean isB, int h) {
            this.isB = isB;
            this.h = h;
        }

        @Override
        public String toString() {
            return "这棵树是平衡的？" + isB + "，高度是" + h;
        }
    }

}
