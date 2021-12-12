package com.tlovol.linked.doubled;

/**
 * 双向链表的结点
 */
public class Node {
    //data域,存放数据
    public int data;//唯一标识符数据,不可重复
    public int value;//可重复数据
    //pre域,存放上一个对象的地址 直接前驱
    public Node pre;
    //next域,存放下一个对象的地址 直接后继
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
