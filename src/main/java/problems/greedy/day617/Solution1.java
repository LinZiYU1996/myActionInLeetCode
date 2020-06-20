package problems.greedy.day617;

import java.util.Arrays;
import java.util.Comparator;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/17
 * \* Time: 20:15
 * \* Description:
 * \
 */
public class Solution1 {
//在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要
// ，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
//
//一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足
//  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，
// 所需的弓箭的最小数量。
//
//Example:
//
//输入:
//[[10,16], [2,8], [1,6], [7,12]]
//
//输出:
//2
//
//解释:
//对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    // 也是计算不重叠的区间个数，不过和 Non-overlapping Intervals 的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间。


    /*
    执行结果：
通过
显示详情
执行用时 :
25 ms
, 在所有 Java 提交中击败了
34.41%
的用户
内存消耗 :
47.3 MB
, 在所有 Java 提交中击败了
83.33%
的用户
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }

    //针对二维数组排序
    //最简单的写法：使用lambda表达式
    //对行：Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
    //对列：Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));



    public static void main(String[] args) {

        int[][] ds =
                {
                        {10,16},
                        {2,8},
                        {1,6},
                        {7,12}
                };
        Arrays.sort(ds, Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i <ds.length ; i++) {
            System.out.println(Arrays.toString(ds[i]));
        }

        //[1, 6]
        //[2, 8]
        //[7, 12]
        //[10, 16]

        int[][] dss=
                {
                        {10,16},
                        {2,8},
                        {1,6},
                        {7,12}
                };

        Arrays.sort(dss, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i <dss.length ; i++) {
            System.out.println(Arrays.toString(dss[i]));
        }


    }
}
