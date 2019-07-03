package com.github.arithmetic.structure;

/**
 *
 *
 *         黑                黑     左旋转       黑    右旋转      黑       颜色翻转      红
 *        /       ——>       /      ——>         /     ——>       /  \      ——>         / \
 *      红                 红                 红              红    红               黑   黑
 *                          |                /
 *                           红             红
 *
 *       ①                ②               ③                  ④                    ⑤
 *
 * 在不同位置插入元素，需要调整颜色的三种情况
 *     ①②③④⑤
 *     ①③④⑤
 *     ①④⑤
 *
 *
 *
 *
 * 红黑树
 * @author peach
 * @since 2019/7/2 下午11:06
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }



    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isRed(Node node){
        if (node == null)
            return BLACK;
        return node.color;
    }
    /**
     * 左旋转，当红色节点往右倾斜了，就需要左旋转
     *
     *          42（黑）                         60（黑）
     *            \         ------>             /
     *             60（红）                    42（红）
     *
     */
    private Node leftRotate(Node node){
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        newRoot.color = node.color;
        node.color = RED;
        return newRoot;
    }

    /**
     * 颜色翻转
     * 当在根节点两边分别添加一个节点导致三节点分裂的时候，就需要颜色翻转
     *
     *                                                    42（红）
     *   38（红） - 42（黑） - 60（红）    ------>         /    \
     *                                              38（黑）  60（黑）
     *
     *
     */
    private void flipColors(Node node){
        node.color = RED;
        node.left.color = node.right.color = BLACK;
    }

    /**
     * 右旋转
     * 当在根节点一边连续添加两个个节点导致三节点分裂的时候，就需要右旋转
     *             42（黑）
     *            /             right rotate           38（与之前父相同颜色）        flipColor         38（红）
     *          38（红）          ------>               /      \                 ------->           /      \
     *          /             相当于2-3树三节点的情况    20（红）   42（红）                           20（黑）   42（黑）
     *        20（红）
     *
     */
    private Node rightRotate(Node node){
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        newRoot.color = node.color;
        node.color = RED;
        return newRoot;
    }

    // 向红黑树中添加新的元素(key, value)
    public void add(K key, V value){
        root = add(root, key, value);
        root.color = BLACK;
    }

    // 向以node为根的红黑树中插入元素(key, value)，递归算法
    // 返回插入新节点后红黑树的根
    private Node add(Node node, K key, V value){

        if(node == null){
            size ++;
            return new Node(key, value);        //默认红色节点
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0
            node.value = value;

        //右孩子是红色并且左孩子不是红色，那么左旋转
        if (isRed(node.right) && !isRed(node.left)){
            node = leftRotate(node);
        }
        //满足右旋转
        if (isRed(node.left) && isRed(node.left.left)){
            node = rightRotate(node);
        }
        //颜色翻转
        if (isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }
        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除键为key的节点
    public V remove(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if( node == null )
            return null;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            return node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            return node;
        }
        else{   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }



    public static void main(String[] args){


    }
}
