package com.tlovol.linked.doubled;

/**
 * 带头结点的双向链表
 */
public class DoubleLinkedList {
    //头结点
    private final Node head = new Node(0, 0);

    /**
     * 往链表中添加结点
     * (往最后一个元素后面添加新的结点)
     *
     * @param node 要添加的结点
     */
    public void add(Node node) {
        Node tmp = this.head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        //添加的元素的前驱指向当前元素
        node.pre = tmp;
        //当前元素的后继指向添加的元素
        tmp.next = node;
    }

    /**
     * 修改结点
     *
     * @param node 新的结点
     */
    public void update(Node node) {
        if (head.next == null) {
            //当前链表为空
            System.out.println("链表为空");
            return;
        }

        //先取出第一个结点
        Node tmp = head.next;
        while (true) {
            if (tmp == null) {
                System.out.println("未找到要修改的结点");
                return;
            }
            if (tmp.data == node.data) {
                //找到相同data的结点
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
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        Node tmp = head.next;
        while (true) {
            if (tmp == null) {
                System.out.println("未找到要删除的结点");
                return;
            }
            if (tmp.data == data) {
                //找到了要删除的结点
                break;
            }
            tmp = tmp.next;
        }

        if (tmp.next == null) {
            //如果被删除的元素位于链表的最后
            tmp.pre.next = null;
        } else {
            //被删除元素的后继结点的前驱指向
            // 被删除元素的前驱结点
            tmp.next.pre = tmp.pre;

            //被删除元素的前驱结点的后继指向
            // 被删除元素的后继结点
            tmp.pre.next = tmp.next;
        }
    }

    /**
     * 查看链表中的所有元素
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        Node tmp = head.next;
        while (tmp != null) {
            //输出
            System.out.println(tmp);
            //获取下一个对象
            tmp = tmp.next;
        }
    }

    /**
     * 带头结点的双向链表测试方法
     */
    public static void doubleLinkedListTest() {
        //创建结点(数据)
        Node[] nodes = {new Node(1, 100),
                new Node(2, 200),
                new Node(3, 300),
                new Node(6, 200),
                new Node(5, 500)};

        //创建带头结点的双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //循环添加
        for (Node node : nodes) {
            doubleLinkedList.add(node);
        }

        //输出所有元素
        doubleLinkedList.list();

        //删除3结点
        doubleLinkedList.remove(3);
        System.out.println("\n删除后的数据：");
        //输出所有元素
        doubleLinkedList.list();

        //更改2的数据
        doubleLinkedList.update(new Node(2, 666));
        System.out.println("\n更改后的数据：");
        //输出所有元素
        doubleLinkedList.list();
    }
}
