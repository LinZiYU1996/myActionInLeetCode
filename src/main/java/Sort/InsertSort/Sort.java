package Sort.InsertSort;

import java.util.Arrays;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/11
 * \* Time: 21:17
 * \* Description:
 * \
 */
public class Sort {



    public static void  sort(int[] src) {

        int j; // 已排序列表下标
        int t; // 待排序元素
        for (int i = 1; i < src.length; i++) {
            if (src[i] < src[i - 1]) {
                t = src[i]; // 赋值给待排序元素
                for (j = i - 1; j >= 0 && src[j] > t; j--) {
                    src[j + 1] = src[j]; // 从后往前遍历已排序列表，逐个和待排序元素比较，如果已排序元素较大，则将它后移
                }
                src[j + 1] = t; // 将待排序元素插入到正确的位置
            }
        }

    }


    public static void main(String[] args) {

        Random random = new Random();

        int[] src = new int[12];

        for (int i = 0; i < src.length; i++) {
            src[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(src));

        sort(src);

        System.out.println(Arrays.toString(src));

    }



}
