package com.github.arithmetic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/25 10:08
 */
public class MyArrayList<T> {

    private int size;
    private Object[] array;


    public MyArrayList(int capacity) {
        array = new Object[capacity];
        size = 0;
    }

    public MyArrayList() {
        this(10);
    }


    public void add(T ele){
        if (size == array.length){
            array = resize(array.length * 2);
        }
        array[size++] = ele;
    }

    public void addLast(T ele){
        add(size,ele);
    }

    public void addFirse(T ele){
        add(0,ele);
    }

    public void add(int index, T ele){

        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("非法的索引下标");
        }

        if (size == array.length){
            array = resize(array.length * 2);
        }

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = ele;
        size++;
    }
    @SuppressWarnings("unchecked")
    public T get(int index){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("非法的索引下标");
        }
        return (T) array[index];
    }

    public T getFirst(){

        return get(0);
    }

    public T getLast(){

        return get(size - 1);
    }


    public void set(int index,T ele){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException("非法的索引下标");
        }

        array[index] = ele;

    }

    public boolean contains(T ele){
        for (int i = 0; i < size; i++) {
            if (array[i] == ele){
                return true;
            }
        }
        return false;
    }

    public int find(T ele){
        for (int i = 0; i < size; i++) {
            if (array[i] == ele){
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public T remove(){
        if (size < 0){
            throw new IndexOutOfBoundsException("集合空了");
        }
        return (T) array[--size];
    }
    @SuppressWarnings("unchecked")
    public T remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("非法索引下标");
        }

        T removeEle = (T) array[index];

        System.arraycopy(array,index + 1,array,index, size - index - 1);

        size --;

        array[size] = null;

        if (size == array.length / 4 && array.length / 2 != 0){
            array = resize(array.length / 2);
        }
        return removeEle;
    }


    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size - 1);
    }

    public void removeElement(T ele){
        int i = this.find(ele);
        if  (i != -1) {
            remove(i);
        }

    }

    private Object[] resize(int resize) {
        Object[] newArray = new Object[resize];
        System.arraycopy(array,0,newArray,0,size);
        return newArray;
    }

    public int size(){
        return size;
    }

    public int capacity(){
        return array.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size = %d, capacity = %d\n",size,array.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i != size - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        //System.out.println(list.toString());
        //
        //System.out.println(list.get(9));
        //
        //System.out.println(list.toString());
        //
        //System.out.println(list.remove());
        //
        //System.out.println(list.toString());
        //
        //list.add(3,33);
        //
        //System.out.println(list.toString());
        //
        //System.out.println(list.size);
        //
        //list.add(10,100);
        //
        //System.out.println(list.toString());
        System.out.println(list.toString());
        for (int i = 0; i < 10; i++) {
            list.remove(3);
        }

        System.out.println(list.toString());
    }
}
