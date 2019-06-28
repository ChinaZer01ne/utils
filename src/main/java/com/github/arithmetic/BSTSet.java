package com.github.arithmetic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/28 16:05
 */
public class BSTSet<E extends Comparable<E>> implements MySet<E> {

    private BST<E> bst;

    public BSTSet() {
        this.bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
