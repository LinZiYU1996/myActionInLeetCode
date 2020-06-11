package Sort.bubblesort.sort610;

import java.util.Arrays;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/10
 * \* Time: 19:56
 * \* Description:
 * \
 */
public class Sort_1 {

    public static void Sort(int[] data, int n) {

        int i, j;

        for (i = 0; i < n; i++) {
            for (j = 1; j < n - i; j++) {
                if (data[j-1] > data[j]) {
                    int t;
                    t = data[j-1];
                    data[j-1] = data[j];
                    data[j] = t;
                }
            }
        }

    }


    //下面开始考虑优化，
    // 如果对于一个本身有序的序列，
    // 或则序列后面一大部分都是有序的序列，
    // 上面的算法就会浪费很多的时间开销，
    // 这里设置一个标志flag，如果这一趟发生了交换，
    // 则为true，否则为false。明显如果有一趟没有发生交换，
    // 说明排序已经完成。

    /**
     * 设置一个标志，如果这一趟发生了交换，则为true，否则为false。明显如果有一趟没有发生交换，说明排序已经完成。
     * @param a
     * @param n
     */
    public static void bubbleSort2(int [] a, int n){
        int j, k = n;
        boolean flag = true;//发生了交换就为true, 没发生就为false，第一次判断时必须标志位true。
        while (flag){
            flag=false;//每次开始排序前，都设置flag为未排序过
            for(j=1; j<k; j++){
                if(a[j-1] > a[j]){//前面的数字大于后面的数字就交换
                    //交换a[j-1]和a[j]
                    int temp;
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j]=temp;

                    //表示交换过数据;
                    flag = true;
                }
            }
            k--;//减小一次排序的尾边界
        }//end while
    }//end




    public static void main(String[] args) {
        int[] src = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            src[i] = random.nextInt(150);
        }

        System.out.println(Arrays.toString(src));

        Sort(src, src.length);

        System.out.println(Arrays.toString(src));

    }

}
