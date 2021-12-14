package com.tlovol.boot;

import static com.tlovol.queue.ArrayQueue.arrayQueueTest;

public class TestMain {
    public static void main(String[] args) {
        //数组模拟栈测试一个字符串是否是回文数据
        //ArrayStack.detectionPalindrome();
        //计算String类型的表达式
        //System.out.println(ArrayStack.stringCalc("4+3*10-30"));

        //带头结点的单链表测试方法
        //SingleNodeLinkedList.singleNodeLinkedListTest();
        //带头结点的双向链表测试方法
        //DoubleLinkedList.doubleLinkedListTest();
        //单向环形链表(约瑟夫环)测试方法
        //OneWayCircularLinkedList.oneWayCircularLinkedListTest();

        //稀疏数组
        //SparseArray.sparseArrayTest();

        //数组实现队列
        arrayQueueTest();
    }
}
