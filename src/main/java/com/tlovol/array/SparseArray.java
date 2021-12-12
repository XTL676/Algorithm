package com.tlovol.array;

/**
 * 稀疏数组
 */
public class SparseArray {
    /**
     * 将复杂数组转为稀疏数组
     *
     * @param complexArray 复杂数组
     * @return 稀疏数组
     */
    public int[][] toSparseArray(int[][] complexArray) {
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
        System.out.println("复杂数组中有" + sum + "个有效数据");

        //创建稀疏数组,
        // 固定行和列的写法：行=有效数据个数+1,列=3
        int[][] sparseArray = new int[sum + 1][3];

        //赋值稀疏数组的第一行(复杂数组的信息)
        sparseArray[0][0] = 11;//复杂数组的行数
        sparseArray[0][1] = 11;//复杂数组的列数
        sparseArray[0][2] = sum;//复杂数组的有效数据总个数

        //创建指针,用以记录在稀疏数组的第几行写入复杂数组的有效数据和信息
        int row = 1;//从1开始,因为0已经记录了复杂数组的信息

        //将有效数据以及其信息存入稀疏数组
        // 遍历复杂数组
        for (int i = 0; i < complexArray.length; i++) {
            //行
            for (int j = 0; j < complexArray.length; j++) {
                //列
                if (complexArray[i][j] != 0) {
                    sparseArray[row][0] = i;//有效数据在复杂数组的行
                    sparseArray[row][1] = j;//有效数据在复杂数组的列
                    sparseArray[row][2] = complexArray[i][j];//有效数据的值
                    row++;//指向稀疏数组的下一行
                }
            }
        }
        return sparseArray;
    }

    /**
     * 将稀疏数组转为复杂数组
     *
     * @param sparseArray 稀疏数组
     * @return 复杂数组
     */
    public int[][] toComplexArray(int[][] sparseArray) {
        //将稀疏数组转为复杂数组
        // 创建转换后的数组
        int[][] complexArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        //复杂数组添加有效数据
        for (int i = 1; i <= sparseArray[0][2]; i++) {
            // 有效数据所在的行数 sparseArrayTest[i][0]
            // 有效数据所在的列数 sparseArrayTest[i][1]
            // 有效数据 sparseArrayTest[i][2]
            complexArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return complexArray;
    }

    public static void sparseArrayTest() {
        SparseArray sparseArrayObj = new SparseArray();

        //创建测试用复杂数组(要压缩的数组)
        int[][] testArr = new int[11][11];

        //初始化复杂数组,添加有效数据1,2,3,其它默认为0(无效数据)
        testArr[1][2] = 1;
        testArr[2][4] = 2;
        testArr[8][6] = 3;

        //输出复杂数组
        System.out.println("复杂数组：");
        for (int[] ints : testArr) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }

        //将复杂数组转为稀疏数组
        int[][] sparseArray = sparseArrayObj.toSparseArray(testArr);

        //输出稀疏数组
        System.out.println("\n稀疏数组：");
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        //将稀疏数组转为复杂数组
        int[][] complexArray = sparseArrayObj.toComplexArray(sparseArray);

        System.out.println("\n稀疏数组转为复杂数组：");
        //输出转换后的数组
        for (int[] ints : complexArray) {
            for (int anInt : ints) {
                System.out.print(anInt);
            }
            System.out.println();
        }
    }
}
