package com.github.arithmetic.structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 序列化一棵树
 *
 * @Author: Zer01ne
 * @Date: 2019/1/28 10:37
 * @Version 1.0
 */
public class SerializeTree {
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

        String treeStr = serializeTree(node1);
        System.out.println(treeStr);
        TreeNode<Integer> head = deserialize(treeStr);
    }
    //反序列化
    private static TreeNode<Integer> deserialize(String treeStr) {
        String[] treeEle = treeStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String ele:
             treeEle) {
            queue.offer(ele);
        }
        return reconPreOrder(queue);
    }

    private static TreeNode<Integer> reconPreOrder(Queue<String> queue) {
        String ele = queue.poll();
        if ("#".equals(ele)){
            return null;
        }
        TreeNode<Integer> head = new TreeNode<>(Integer.parseInt(ele));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    //序列化
    private static String serializeTree(TreeNode<Integer> head) {
        if (head == null){
            return "#!";
        }

        return head.data + "!" + serializeTree(head.left) +  serializeTree(head.right);
    }
}
