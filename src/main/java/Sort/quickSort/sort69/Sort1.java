package Sort.quickSort.sort69;

import java.util.Arrays;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/9
 * \* Time: 20:48
 * \* Description:
 * \
 */
public class Sort1 {


    public static int divide(int[] data, int start, int end) {

        int base = data[end];

        while (start < end) {
            while (start < end && data[start] <= base) {

                start++;

            }

            if (start < end) {

                swap(start,end,data);
                end--;
            }

            while (start < end && data[end] >= base) {
                end--;
            }

            if (start < end) {
//                int temp = data[start];
//                data[start] = data[end];
//                data[end] = temp;
                swap(start,end,data);

                start++;
            }
        }
        return end;
    }


    public static void swap(int a, int b,int[] d) {
        int t = d[a];
        d[a] = d[b];
        d[b] = t;
    }


    public static void sort(int[] a, int start, int end){
        if(start > end){
            //如果只有一个元素，就不用再排下去了
            return;
        }
        else{
            //如果不止一个元素，继续划分两边递归排序下去
            int partition = divide(a, start, end);
            sort(a, start, partition-1);
            sort(a, partition+1, end);
        }

    }


    public static void main(String[] args) {


        int[] a = new int[]{2,7,4,5,10,1,9,3,8,6};
        int[] b = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] c = new int[]{10,9,8,7,6,5,4,3,2,1};
        int[] d = new int[]{1,10,2,9,3,2,4,7,5,6};

        sort(a, 0, a.length-1);

        System.out.println("排序后的结果：");
        for(int x : a){
            System.out.print(x+" ");
        }

        System.out.println("================================");


        Random random = new Random();

        int[] test = new int[100];

        for (int i = 0; i < test.length; i++) {
            test[i] = random.nextInt(300);
        }

        System.out.println(Arrays.toString(test));

        System.out.println("================================");

        sort(test, 0 ,test.length - 1);
        System.out.println(Arrays.toString(test));



    }


}
