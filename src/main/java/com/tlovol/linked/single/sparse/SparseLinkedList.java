package com.tlovol.linked.single.sparse;

import java.util.ArrayList;

/**
 * 链式存储压缩
 */
public class SparseLinkedList {
    public static void main(String[] args) {
        SparseLinkedList sparseLinkedList = new SparseLinkedList();
        //创建测试用复杂数组(要压缩的数组)
        int[][] testArr = new int[11][11];

        //初始化复杂数组,添加有效数据1,2,3,其它默认为0(无效数据)
        testArr[1][2] = 1;
        testArr[2][4] = 2;
        testArr[8][6] = 3;

        sparseLinkedList.convertToSparseLinkedList(testArr).list();
    }

    private Node head = new Node(-1, -1, 0);

    /**
     * 往链表中添加结点
     * (往最后一个元素后面添加新的结点)
     *
     * @param node 要添加的结点
     */
    public void add(Node node) {
        Node tmp = this.head;//头结点
        //判断结点是否有next,即是否有下一个元素
        while (tmp.getNext() != null) {
            //不将头结点添加进去
            //有下一个元素,取出下一个元素,
            // 再次取判断取出的元素是否有下一个元素,
            // 直到该元素为最后一个元素,往最后一个元素后面添加新的结点
            tmp = tmp.getNext();
        }
        //往最后一个元素后面添加新的结点
        tmp.setNext(node);
    }

    /**
     * 查看链表中的所有元素
     */
    public void list() {
        Node tmp = this.head;
        if (tmp.getNext() == null) {
            System.out.println("链表为空");
        }

        while (tmp.getNext() != null) {
            //获取下一个对象
            tmp = tmp.getNext();
            //输出
            System.out.println(tmp);
        }
    }

    public SparseLinkedList convertToSparseLinkedList(int[][] complexArray) {
        //计算复杂数组中的有效数据个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                //设定不为0的数据为有效数据
                if (complexArray[i][j] != 0) {
                    sum++;
                }
            }
        }

        //创建稀疏数组的信息行
        Node infoNode = new Node(sum + 1, 3, sum);
        //创建结点数组
        ArrayList<Node> nodes = new ArrayList<>();
        //添加信息行结点
        nodes.add(infoNode);

        //创建指针,用以记录在稀疏数组的第几行写入复杂数组的有效数据和信息
        int row = 1;//从1开始,因为0已经记录了复杂数组的信息

        //将有效数据以及其信息存入稀疏数组
        // 遍历复杂数组
        for (int i = 0; i < complexArray.length; i++) {
            //行
            for (int j = 0; j < complexArray.length; j++) {
                //列
                if (complexArray[i][j] != 0) {
                    nodes.add(new Node(i, j, complexArray[i][j]));
                    row++;//指向稀疏数组的下一行
                }
            }
        }

        SparseLinkedList sparseLinkedList = new SparseLinkedList();
        for (Node node : nodes) {
            sparseLinkedList.add(node);
        }

        //将结点添加入链表
        return sparseLinkedList;
    }
}
