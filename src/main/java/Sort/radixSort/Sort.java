package Sort.radixSort;

import java.util.ArrayList;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/17
 * \* Time: 19:53
 * \* Description:
 * \
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[] { 321, 1234, 543, 324, 24, 960, 540, 672, 783, 1000 };
        radixSort(arr);
        printArray(arr);

        System.out.println("\n-------------------------------------------------------\n");

        Random random = new Random();

        int[] arrs = new int[25];

        for (int i = 0; i < arrs.length; i++) {

            arrs[i] = random.nextInt(100);

        }

        radixSort(arrs);

        printArray(arrs);
    }

    public static void radixSort(int[] arr) {
        int digit = getMaxDigit(arr); // 获取最大的数是多少位
        for (int i = 0; i < digit; i++) {
            bucketSort(arr, i); // 执行 digit 次 bucketSort 排序即可
        }
    }

    public static int getMaxDigit(int[] arr) {
        int digit = 1; // 默认只有一位
        int base = 10; // 十进制每多一位，代表其值大了10倍
        for (int i : arr) {
            while (i > base) {
                digit++;
                base *= 10;
            }
        }
        return digit;
    }

    public static void bucketSort(int[] arr, int digit) {
        int base = (int) Math.pow(10, digit);
        // init buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) { // 只有0~9这十个数，所以准备十个桶
            buckets.add(new ArrayList<Integer>());
        }
        // sort
        for (int i : arr) {
            int index = i / base % 10;
            buckets.get(index).add(i);
        }
        // output: copy back to arr
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int i : bucket) {
                arr[index++] = i;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }





}
