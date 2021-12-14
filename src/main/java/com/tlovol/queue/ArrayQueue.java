package com.tlovol.queue;

/**
 * 数组实现队列
 */
public class ArrayQueue {
    private final int[] array;
    private final int maxSize;//数组的最大存储数
    private int frontPoint;//front指针指向队头
    private int rearPoint;//rear指针指向队尾

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];

        //初始化指针
        frontPoint = -1;
        rearPoint = -1;
    }

    /**
     * 判断当前队列是否为满
     */
    public boolean isFull() {
        //rear指针是否指向数组的最后一个位置
        return rearPoint == maxSize - 1;
    }

    /**
     * 判断是否为空队列
     */
    public boolean isEmpty() {
        return frontPoint == rearPoint;
    }

    /**
     * 添加元素到队列里面
     */
    public void add(int i) {
        //判断队列是否已满
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }

        //rear指针指向添加的元素
        rearPoint++;
        this.array[rearPoint] = i;
        //front指针指向队头的元素
        frontPoint = 0;
    }

    /**
     * 将元素移除队列
     */
    public int remove() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        frontPoint++;
        rearPoint--;
        return this.array[frontPoint];
    }


    /**
     * 获取队列的队头元素
     */
    public int getFront() {
        return this.array[frontPoint];
    }

    /**
     * 列出队列中的所有元素
     */
    public void list() {
        for (int i = 0; i < rearPoint + 1; i++) {
            System.out.print(this.array[frontPoint] + "  ");
            frontPoint++;
        }
        System.out.println();
        //复位front指针
        frontPoint = 0;
    }

    /**
     * 队列数组的测试方法
     */
    public static void arrayQueueTest() {
        ArrayQueue arrayQueue = new ArrayQueue(8);

        //添加元素
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(4);
        arrayQueue.add(5);
        arrayQueue.add(6);
        arrayQueue.add(7);
        arrayQueue.add(8);

        //获取队头元素
        System.out.println(arrayQueue.getFront());

        //获取所有元素
        arrayQueue.list();

        //移除元素
        arrayQueue.remove();

        //获取所有元素
        arrayQueue.list();
    }
}