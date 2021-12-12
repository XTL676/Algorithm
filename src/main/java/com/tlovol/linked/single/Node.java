package com.tlovol.linked.single;

/**
 * 单链表的结点
 */
public class Node {
    //data域,存放数据
    public int data;//唯一标识符数据,不可重复
    public int value;//可重复数据
    //next域,存放下一个对象的地址
    public Node next;

    public Node(int data, int value) {
        this.data = data;
        this.value = value;
    }

    @Override
    public String toString() {
        return "data=" + data +
                ", value=" + value;
    }
}
