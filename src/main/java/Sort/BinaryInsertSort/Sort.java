package Sort.BinaryInsertSort;

import java.util.Arrays;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/14
 * \* Time: 21:11
 * \* Description:
 * \
 */
public class Sort {

    public static void binaryInsertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i] < data[i - 1]) {
                // 缓存i处的元素值
                int tmp = data[i];
                // 记录搜索范围的左边界
                int low = 0;
                // 记录搜索范围的右边界
                int high = i - 1;
                while (low <= high) {
                    // 记录中间位置
                    int mid = (low + high) / 2;
                    // 比较中间位置数据和i处数据大小，以缩小搜索范围
                    if (data[mid] < tmp) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                //将low~i处数据整体向后移动1位
                for (int j = i; j > low; j--) {
                    data[j] = data[j - 1];
                }
                data[low] = tmp;

            }
        }
    }



    public static void main(String[] args) {
        int[] src = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            src[i] = random.nextInt(150);
        }

        System.out.println(Arrays.toString(src));

        binaryInsertSort(src);

        System.out.println(Arrays.toString(src));
    }
}
