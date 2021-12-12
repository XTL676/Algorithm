package com.tlovol.linked.single;

/**
 * 带头部的单结点链表
 */
public class SingleNodeLinkedList {
    //结点对象,初始化为头结点
    private final Node head = new Node(0, 0);

    /**
     * 往链表中添加结点
     * (往最后一个元素后面添加新的结点)
     *
     * @param node 要添加的结点
     */
    public void add(Node node) {
        Node tmp = this.head;//头结点
        //判断结点是否有next,即是否有下一个元素
        while (tmp.next != null) {
            //不将头结点添加进去
            //有下一个元素,取出下一个元素,
            // 再次取判断取出的元素是否有下一个元素,
            // 直到该元素为最后一个元素,往最后一个元素后面添加新的结点
            tmp = tmp.next;
        }
        //往最后一个元素后面添加新的结点
        tmp.next = node;
    }

    /**
     * 根据结点中的data数据,来按照data从小到大的顺序插入结点
     *
     * @param node 要添加的结点
     */
    public void addOrder(Node node) {
        Node tmp = this.head;//头结点
        boolean repeat = false;//data是否相同标记
        //当 没有结点时 或者 当前结点的data大于要插入结点的data 或者 没有重复的data值 时添加
        while (tmp.next != null) {
            if (tmp.next.data > node.data) {
                break;
            }
            //重复的data值
            if (tmp.next.data == node.data) {
                repeat = true;
                break;
            }
            tmp = tmp.next;
        }

        if (repeat) {
            System.out.println("重复添加");
        } else {
            //要添加的结点的下一个指向data比自己大的元素
            node.next = tmp.next;
            //当前指向的下一个元素变为要添加的元素
            tmp.next = node;
        }
    }

    /**
     * 修改结点
     *
     * @param node 新的结点
     */
    public void update(Node node) {
        Node tmp = this.head.next;
        if (tmp.next == null) {
            //链表为空
            System.out.println("链表为空");
            return;
        }

        //链表中到最后一个结点时还没有找到要修改的结点 或者 找到了结点 时,直接结束
        while (true) {
            if (tmp == null) {
                //没有找到要修改的结点
                System.out.println("没有找到相同data的数据");
                return;
            }
            if (tmp.data == node.data) {
                //找到了结点
                break;
            }

            tmp = tmp.next;
        }
        //修改结点
        tmp.value = node.value;
    }

    /**
     * 删除结点
     *
     * @param data 要删除的结点data唯一标识符数据
     */
    public void remove(int data) {
        Node tmp = this.head;
        while (true) {
            //链表为空
            if (tmp.next == null) {
                System.out.println("链表为空");
                return;
            }
            //找到了相同data的结点
            if (tmp.next.data == data) {
                break;
            }
            //循环
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
    }

    /**
     * 查看链表中的所有元素
     */
    public void list() {
        Node tmp = this.head;
        if (tmp.next == null) {
            System.out.println("链表为空");
        }

        while (tmp.next != null) {
            //获取下一个对象
            tmp = tmp.next;
            //输出
            System.out.println(tmp);
        }
    }

    /**
     * 获取当前链表的结点总个数(不包含头结点)
     *
     * @return 当前链表的结点总个数
     */
    public int length() {
        if (this.head.next == null) {
            return 0;
        }
        Node tmp = this.head.next;
        int len = 0;
        while (tmp != null) {
            len++;//结点个数
            tmp = tmp.next;
        }
        return len;
    }

    /**
     * 带头结点的单链表测试方法
     */
    public static void singleNodeLinkedListTest() {
        //创建结点(数据)
        Node[] nodes = {new Node(1, 100),
                new Node(2, 200),
                new Node(3, 300),
                new Node(6, 200),
                new Node(5, 500)};

        //创建带头结点的单链表
        SingleNodeLinkedList singleNodeLinkedList = new SingleNodeLinkedList();
        //循环添加结点至带头结点的单链表(无顺序存入)
        for (Node node : nodes) {
            singleNodeLinkedList.add(node);
        }

        System.out.println("无顺序存入：");
        //输出链表内的所有数据
        singleNodeLinkedList.list();
        //获取当前结点个数
        System.out.println("当前结点个数：" + singleNodeLinkedList.length());

        //创建带头结点的单链表
        SingleNodeLinkedList singleNodeLinkedList2 = new SingleNodeLinkedList();

        //循环添加结点至带头结点的单链表(有顺序存入)
        for (Node node : nodes) {
            singleNodeLinkedList2.addOrder(node);
        }

        System.out.println("\n有顺序存入：");
        //输出链表内的所有数据
        singleNodeLinkedList2.list();
        //获取当前结点个数
        System.out.println("当前结点个数：" + singleNodeLinkedList2.length());

        //修改3号数据
        singleNodeLinkedList2.update(new Node(3, 888));

        System.out.println("\n修改后的数据：");
        //输出链表内的所有数据
        singleNodeLinkedList2.list();
        //获取当前结点个数
        System.out.println("当前结点个数：" + singleNodeLinkedList2.length());

        //删除5号结点
        singleNodeLinkedList2.remove(5);

        System.out.println("\n删除后的数据：");
        //输出链表内的所有数据
        singleNodeLinkedList2.list();
        //获取当前结点个数
        System.out.println("当前结点个数：" + singleNodeLinkedList2.length());
    }
}
