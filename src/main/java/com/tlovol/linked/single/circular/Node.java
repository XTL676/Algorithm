package com.tlovol.linked.single.circular;

/**
 * 单向环形链表(约瑟夫环)的结点
 */
public class Node {
    //data域,存放数据
    private int data;//唯一标识符数据,不可重复
    //next域,存放下一个对象的地址
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data=" + data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
