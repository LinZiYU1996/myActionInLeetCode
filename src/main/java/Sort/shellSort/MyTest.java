package Sort.shellSort;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/12
 * \* Time: 20:10
 * \* Description:
 * \
 */
public class MyTest {


    public static void insert(int[] src) {

        int t = src[src.length-1];

        int i;

        for (i = src.length-2; i >=0 && src[i] > t; i--) {
            src[i+1] = src[i];
        }

        src[i+1] = t;


    }

    // 将小的数往数组前面移动

    public static void main(String[] args) {

        int[] d = {10,9,8,7,0};

        int t = d[d.length - 1];
        int i;
        for (i = d.length-2; i >=0&& d[i] > t ; i--) {
            d[i+1] = d[i];
        }

        d[i+1] = 0;

        System.out.println(Arrays.toString(d));

        int[] dd = {1,4,5,3};

        insert(dd);

        System.out.println(Arrays.toString(dd));
    }
}
