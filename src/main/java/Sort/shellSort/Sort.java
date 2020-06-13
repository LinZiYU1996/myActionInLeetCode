package Sort.shellSort;

import java.util.Arrays;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/12
 * \* Time: 20:02
 * \* Description:
 * \
 */
public class Sort {

    public static void shellSortSmallToBig(int[] data) {
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                // System.out.println("i:" + i);
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    // System.out.println("j:" + j);
                    // System.out.println("temp:" + temp);
                    // System.out.println("data[" + j + "]:" + data[j]);
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }

        }
    }


    public static void main(String[] args) {

        Random random = new Random();

        int[] ds = new int[15];

        for (int i = 0; i < 15; i++) {
            ds[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(ds));

        shellSortSmallToBig(ds);

        System.out.println(Arrays.toString(ds));
    }
}
