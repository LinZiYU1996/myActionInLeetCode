package problems.greedy.day619;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/19
 * \* Time: 20:31
 * \* Description:
 * \
 */
public class Solution {

//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
//
//注意：
//总人数少于1100人。
//
//示例
//
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]


    //为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。
    //
    //身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中。

/*
执行结果：
通过
显示详情
执行用时：
8 ms
, 在所有 Java 提交中击败了
95.25%
的用户
内存消耗：
40.7 MB
, 在所有 Java 提交中击败了
83.33%
的用户


 */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }

    public static void main(String[] args) {

        int[][] d = new int[10][2];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                d[i][j] = random.nextInt(100);
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("");
        System.out.println("");
        Arrays.sort(d, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
//  0 52
//73 29
//43 93
//80 71
//18 24
//75 50
//8 72
//8 21
//6 65
//97 65
//
//
//97 65
//80 71
//75 50
//73 29
//43 93
//18 24
//8 21
//8 72
//6 65
//0 52

