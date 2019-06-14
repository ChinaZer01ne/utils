package com.github.arithmetic.leetcode;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *
 *
 * binary-tree-postorder-traversal
 * 时间限制：1秒 空间限制：32768K 热度指数：43985
 * 本题知识点： 树 leetcode
 *  算法知识视频讲解
 * 题目描述
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree{1,#,2,3},
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * return[3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/14 14:27
 */
public class BinaryTreePostorderTraversal {



    /**
     * 使用迭代进行后序遍历，用栈吧
     *
     *      后序遍历是左右根的顺序，压栈顺序应该是根右左的顺序
     *
     *
     *      链接：https://www.nowcoder.com/questionTerminal/32af374b322342b68460e6fd2641dd1b
     * 来源：牛客网
     *
     * // 要保证根结点在左孩子和右孩子访问之后才能访问，因此对于任一结点P，先将其入栈。
     *     // 如果P不存在左孩子和右孩子，则可以直接访问它；
     *     // 或者P存在孩子，但是其孩子都已被访问过了，则同样可以直接访问该结点
     *     // 若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了
     *     // 每次取栈顶元素的时候，左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
     * */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode pre = null;

        stack.push(root);

        while (!stack.isEmpty()){

            TreeNode node = stack.peek();

            if ((node.left == null && node.right == null)
                    || (pre != null && (pre == node.left || pre == node.right))){

                result.add(node.val);
                stack.pop();
                pre = node;
            }else {
                if (root.right != null){
                    stack.push(root.right);
                }

                if (root.left != null){
                    stack.push(root.left);
                }
            }

        }

        return result;

    }

    /**
     * // 巧妙的方法：前序遍历 根->左->右 变成 根->右->左 结果再reverse一下
     * */
    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()){

            TreeNode pop = stack.pop();

            if (pop.left != null){
                stack.push(pop.left);
            }
            if (pop.right != null){
                stack.push(pop.right);
            }
            result.add(pop.val);

        }
        Collections.reverse(result);
        return result;
    }



    /**
     * 链接：https://www.nowcoder.com/questionTerminal/32af374b322342b68460e6fd2641dd1b
     *     来源：牛客网
     *
     * 这个解法可能是最佳实践，思路清晰，易于理解。
     * 核心思想是用栈做辅助空间，先从根往左一直入栈，直到为空，然后判断栈顶元素的右孩子，如果不为空且未被访问过，
     * 则从它开始重复左孩子入栈的过程；否则说明此时栈顶为要访问的节点（因为左右孩子都是要么为空要么已访问过了），
     * 出栈然后访问即可，接下来再判断栈顶元素的右孩子...直到栈空。
     *
     *
     * //感觉这个挺清晰的
     */
    public ArrayList<Integer> postorderTraversal3(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        TreeNode p = root, r = null;

        Stack<TreeNode> stack = new Stack<>();


        while (!stack.isEmpty()){

            if (p != null){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.peek();
                p = p.right;
                if(p != null && p != r) {   //如果栈顶元素的右孩子不为空，且未被访问过
                    stack.push(p);              //则右孩子进栈，然后重复左孩子一直进栈直到为空的过程
                    p = p.left;
                } else {
                    p = stack.pop();            //否则出栈，访问，r记录刚刚访问的节点
                    result.add(p.val);
                    r = p;
                    p = null;
                }
            }

        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
