package com.github.arithmetic;

/**
 * 已知一棵完全二叉树，求其节点个数
 * @Author: Zer01ne
 * @Date: 2019/1/28 17:28
 * @Version 1.0
 */
public class HowManyNode {
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
        TreeNode<Integer> node7 = new TreeNode<>(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = new TreeNode<>(8);
        System.out.println(howManyNode(node1));
    }

    private static int howManyNode(TreeNode<Integer> head){
        if (head == null){
            return 0;
        }
        //整棵树的高度
        int treeHeight = getHight(head);
        //右子树的高度
        int rightHight = getHight(head.right);
        //如果相差1，说明左子树是满的，右子树没满
        if (rightHight == treeHeight - 1){
            //左子树节点直接算出来
            int leftNodeNum = (int) (Math.pow(2,getHight(head.left)) - 1);
            //返回左子树节点 + 右子树递归过程
            return leftNodeNum + howManyNode(head.right) + 1;
            //否则，右子树满的（（只不过少一层）），左子树没满
        }else {
            //返回右子树节点 + 左子树递归过程
            int rightNodeNum = (int) (Math.pow(2,getHight(head.right)) - 1);
            return rightNodeNum + howManyNode(head.left) + 1;
        }

    }

    private static int getHight(TreeNode<Integer> head) {

        int height = 0;
        while (head != null){
            head = head.left;
            height++;
        }
        return height;
    }
}
