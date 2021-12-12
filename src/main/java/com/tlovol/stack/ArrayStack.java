package com.tlovol.stack;

/**
 * 使用数组模拟栈
 */
public class ArrayStack {
    //栈的大小
    private int maxStack;

    //数组模拟栈
    private int[] stack;

    //栈顶所在的位置,没有数据时为-1
    private int top = -1;

    public ArrayStack(int maxStack) {
        this.maxStack = maxStack;
        this.stack = new int[maxStack];//初始化当前数组容量
    }

    /**
     * 判断是否满栈
     *
     * @return 是否满栈
     */
    public boolean isFull() {
        return this.top == this.maxStack - 1;
    }

    /**
     * 判断是否为空栈
     *
     * @return 是否为空栈
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 压栈
     *
     * @param val 要存入的元素
     */
    public void push(int val) {
        if (isFull()) {
            throw new RuntimeException("此栈已满");
        }
        top++;//将指针指向要存入元素的位置
        stack[top] = val;//在指定位置存入元素
    }

    /**
     * 弹栈
     *
     * @return 出栈的数据
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("此栈为空");
        } else {
            int val = stack[top];//获取顶端索引位置的数据(要弹出的数据)
            top--;//将指针向下移动
            return val;//返回弹出的数据
        }
    }

    /**
     * 查看栈中的所有元素
     */
    public void listAll() {
        if (isEmpty()) {
            throw new RuntimeException("此栈为空");
        }
        for (int i : stack) {
            System.out.println(i);
        }
    }

    /**
     * 返回栈中元素所占的长度
     *
     * @return 栈中元素所占的长度
     */
    public int length() {
        return this.top + 1;
    }

    /**
     * 返回栈的总容量
     *
     * @return 栈的总容量
     */
    public int stackLength() {
        return this.stack.length;
    }

    /**
     * 查看栈顶数据
     *
     * @return 栈顶数据
     */
    public int peek() {
        return this.stack[top];
    }

    /**
     * 数组模拟栈测试一个字符串是否是回文数据
     * 即传入栈中的字符在弹栈后组成的字符串是否和原先的字符串相同
     */
    public static void detectionPalindrome() {
        //原字符串
        String str1 = "Hello World";//不为回文数据,弹栈字符串为dlroW olleH,与原字符串不相同
        String str2 = "aba";//为回文数据,弹栈字符串为aba,与原字符串相同
        String testStr = str2;//要测试的字符串

        //初始化栈对象
        ArrayStack arrayStack = new ArrayStack(20);

        //压栈
        for (int i = 0; i < testStr.length(); i++) {
            arrayStack.push(testStr.charAt(i));
        }

        //弹栈
        StringBuilder builder = new StringBuilder();
        int length = arrayStack.length();//保存弹栈前栈中拥有的元素个数
        for (int i = 0; i < length; i++) {
            if (!arrayStack.isEmpty()) {
                builder.append((char) arrayStack.pop());
            }
        }

        //判断是否为回文
        System.out.println(testStr.equals(builder.toString()));
    }

    /**
     * 判断是否为运算符号
     *
     * @param c 要判断的符号
     * @return 是否运算符
     */
    public boolean isOp(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * 判断运算符的优先级
     *
     * @param op 运算符
     * @return 优先级, 数字越大, 优先级越大
     */
    public int priority(char op) {
        if (op == '*' || op == '/') {
            return 1;
        } else if (op == '+' || op == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 计算两个数的结果
     *
     * @param num1 数1
     * @param num2 数2
     * @param op   运算符
     * @return 结果
     */
    public int calculate(int num1, int num2, int op) {
        //计算结果
        return switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num2 - num1;
            case '*' -> num1 * num2;
            case '/' -> num2 / num1;
            default -> 0;
        };
    }

    /**
     * 计算String类型的表达式
     *
     * @param expr 表达式
     * @return int型计算结果
     */
    public static int stringCalc(String expr) {
        //表达式实例：1+2+3+4*5
        //初始化数字栈
        ArrayStack numStack = new ArrayStack(1024);
        //初始化符号栈
        ArrayStack symbolStack = new ArrayStack(1024);

        //临时变量
        int tmp1 = 0;
        int tmp2 = 0;
        int symbolChar = 0;
        int result = 0;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (symbolStack.isOp(c)) {
                //字符为运算符
                if (!symbolStack.isEmpty()) {
                    //符号栈不是空栈
                    if (symbolStack.priority(c) <= symbolStack.priority((char) symbolStack.peek())) {
                        tmp1 = numStack.pop();
                        tmp2 = numStack.pop();
                        symbolChar = symbolStack.pop();
                        result = numStack.calculate(tmp1, tmp2, symbolChar);

                        //将运算结果放入数字栈中
                        numStack.push(result);
                        //当前符号压入符号栈中
                        symbolStack.push(c);
                    } else {
                        //运算符优先级大的,直接压入符号栈
                        symbolStack.push(c);
                    }
                } else {
                    //为空的符号栈,直接压入符号栈
                    symbolStack.push(c);
                }
            } else {
                //不是运算符
                //比如33 388
                //拼接数字
                builder.append(c);

                if (i == expr.length() - 1) {
                    //当前字符为表达式的最后一个(单个数字)
                    numStack.push(Integer.parseInt(builder.toString()));
                } else {
                    //不是最后一个
                    char data = expr.substring(i + 1, i + 2).charAt(0);
                    if (symbolStack.isOp(data)) {
                        //当前是符号
                        numStack.push(Integer.parseInt(builder.toString()));
                        //清空拼接字符串
                        builder = new StringBuilder();
                    }
                }
            }
        }

        while (!symbolStack.isEmpty()) {
            tmp1 = numStack.pop();
            tmp2 = numStack.pop();

            symbolChar = symbolStack.pop();

            result = numStack.calculate(tmp1, tmp2, symbolChar);

            numStack.push(result);
        }

        //结果
        return numStack.pop();
    }
}
