package com.github.arithmetic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是否是完全二叉树
 * @Author: Zer01ne
 * @Date: 2019/1/28 17:12
 * @Version 1.0
 */
public class IsPerfectTree {
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
        node4.right = new TreeNode<>(8);
        System.out.println(isPerfectTree(node1));
    }
    private static boolean isPerfectTree(TreeNode<Integer> head){
        if (head == null){
            return true;
        }
        //忽然发现可以使用队列来进行树的层级遍历，哈哈
        Queue<TreeNode> queue = new LinkedList();
        boolean allLeaf = false;
        queue.offer(head);
        while (!queue.isEmpty()){
            //取出一个元素
            TreeNode ele = queue.poll();
            if (allLeaf && isLeaf(ele)){
                continue;
                //如果开启了必须全是叶节点的阶段，并且接下来不全是叶节点，返回false
            }else if (allLeaf && !isLeaf(ele)){
                return false;
            }
            //左子树没有，右子树有东西，直接返回false
            if (ele.left == null && ele.right != null){
                return false;
                //左子树有东西，右子树没有，那么接下来必须全是叶子节点：开启全是叶节点的阶段
            }else if (ele.left != null && ele.right == null){
                allLeaf = true;
            }
            //子节点入栈
            queue.offer(ele.left);
            queue.offer(ele.right);
        }

        return true;
    }
    //是否是叶子节点
    private static boolean isLeaf(TreeNode ele) {
        return ele == null || (ele.left == null &&  ele.right == null);
    }
}
