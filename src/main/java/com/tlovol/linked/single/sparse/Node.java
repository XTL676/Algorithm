package com.tlovol.linked.single.sparse;

/**
 * 链式存储压缩的结点
 */
public class Node {
    //行
    private int row;
    //列
    private int col;
    //有效数值
    private int val;

    private Node next;

    public Node(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "row=" + row +
                ", col=" + col +
                ", val=" + val +
                '}';
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
