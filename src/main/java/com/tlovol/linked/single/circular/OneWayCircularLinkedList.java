package com.tlovol.linked.single.circular;

/**
 * 单向环形链表(约瑟夫环)
 */
public class OneWayCircularLinkedList {
    //第一个结点
    private Node first = new Node(-1);

    /**
     * 构建环形链表
     *
     * @param nums 环形链表的结点个数
     */
    public void add(int nums) {
        if (nums < 1) {
            System.out.println("要创建的结点个数太小");
            return;
        }

        Node tmp = null;

        for (int i = 1; i <= nums; i++) {
            Node node = new Node(i);

            //判断是否为第一个结点
            if (i == 1) {
                first = node;
                //自己指向自己
                first.setNext(first);
                //为辅助结点赋值
                tmp = first;
            } else {
                //不是第一个结点
                tmp.setNext(node);
                node.setNext(first);
                tmp = node;
            }
        }
    }

    /**
     * 查看链表中的所有元素
     */
    public void list() {
        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        Node tmp = first;
        //当当前的结点的下一个指向第一个结点时,表示当前的结点为最后的结点,
        // 退出循环tmp.getNext() == first
        while (tmp.getNext() != first) {
            tmp = tmp.getNext();
            System.out.println(tmp.getData());
        }
    }

    /**
     * 约瑟夫问题
     *
     * @param start    第几个开始数
     * @param countNum 数几次
     * @param nums     有几个人(结点)
     */
    public void josephProblem(int start, int countNum, int nums) {
        if (first == null || start < 1 || start > nums) {
            System.out.println("参数输入有误");
            return;
        }

        //定义赋值指针helper
        Node helper = first;
        //先获取最后一个元素并赋值helper
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

        //寻找起始位置
        for (int i = 0; i < start - 1; i++) {
            //将first定义为起始位置
            first = first.getNext();
            helper = helper.getNext();
        }

        //删除数到规定数的人(数到m的人出列)
        while (helper != first) {
            for (int i = 0; i < countNum - 1; i++) {
                //将first指向要被删除的元素
                first = first.getNext();
                //将helper指向first的前面一个元素,即新的尾部元素
                helper = helper.getNext();
            }

            System.out.println(first.getData() + " 出列");
            //设置被删除的下面一个元素为新的起始位置
            first = first.getNext();
            //设置被删除的前一个元素的指向下一个元素为被删除的下面一个元素
            helper.setNext(first);
        }
        System.out.println(first.getData() + " 最后出列");
    }

    /**
     * 单向环形链表(约瑟夫环)测试方法
     */
    public static void oneWayCircularLinkedListTest() {
        //创建单向环形链表(约瑟夫环)
        OneWayCircularLinkedList oneWayCircularLinkedList = new OneWayCircularLinkedList();

        //添加结点
        oneWayCircularLinkedList.add(5);

        //输出所有结点数据
        oneWayCircularLinkedList.list();

        System.out.println("\n解决约瑟夫问题：");
        //解决约瑟夫问题,
        // 从第一个人开始,数到2出列,链表中共有5个结点
        oneWayCircularLinkedList.josephProblem(1, 2, 5);
    }
}
