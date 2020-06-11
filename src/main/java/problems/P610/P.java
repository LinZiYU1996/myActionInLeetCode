package problems.P610;

import java.io.DataInputStream;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/10
 * \* Time: 20:05
 * \* Description:
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标
 * 值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数
 *
 * 示例 1:
 * 输入:
 * matrix = [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * 输入
 *
 * matrix = [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * \
 */
public class P {

    //每行的第一个整数大于前一行的最后一个整数。
    //每行中的整数从左到右按升序排列。
    //第一个条件意味着可以通过二分搜索确定哪行；
    //第二个条件意味着可以在行里进行二分搜索确定哪个元素；

//如何使用二分查找找到哪行呢？只需要一个上下边界，再每次拿着中间行最大的
//值和目标值比一比。


    public static int getROW(int[][] m, int target) {

        int top = 0, bottom = m.length - 1;
        int col = m[0].length - 1;
        while (top < bottom) {
            int mid = (top + bottom) / 2;
            if (m[mid][col] < target) {
                top = mid + 1;
            } else {
                bottom = mid;
            }
        }

        return  top;
    }

    public static boolean find(int[] d, int target) {
        int l = 0;

        int r = d.length - 1;

        while (l < r) {

            int mid = ( l + r) /2;

            if (d[mid] == target) {
                return true;
            } else if (d[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;

            }

        }

        return false;
    }


    public static  boolean searchMatrix(int[][] matrix, int target) {
         if (matrix.length < 1) return false;
         int row = getROW(matrix, target);
         return find(matrix[row], target);
    }



}
