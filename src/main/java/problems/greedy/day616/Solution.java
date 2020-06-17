package problems.greedy.day616;

import java.util.Arrays;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/16
 * \* Time: 20:14
 * \* Description:
 * \
 */
public class Solution {
//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，
// 这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i
// ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
//
//注意：
//
//你可以假设胃口值为正。
//一个小朋友最多只能拥有一块饼干。
//
//示例 1:
//
//输入: [1,2,3], [1,1]
//
//输出: 1
//
//解释:
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
//示例 2:
//
//输入: [1,2], [1,2,3]
//
//输出: 2
//
//解释:
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/assign-cookies
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //题目描述：每个孩子都有一个满足度 grid，每个饼干都有一个大小 size，只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。求解最多可以获得满足的孩子数量。
    //
    //给一个孩子的饼干应当尽量小并且又能满足该孩子，这样大饼干才能拿来给满足度比较大的孩子。
    //因为满足度最小的孩子最容易得到满足，所以先满足满足度最小的孩子。
    //在以上的解法中，我们只在每次分配时饼干时选择一种看起来是当前最优的分配方法，
    // 但无法保证这种局部最优的分配方法最后能得到全局最优解。我们假设能得到全局最优解，
    // 并使用反证法进行证明，即假设存在一种比我们使用的贪心策略更优的最优策略。如果不存在这种最优策略，
    // 表示贪心策略就是最优策略，得到的解也就是全局最优解。
    //
    //证明：假设在某次选择中，贪心策略选择给当前满足度最小的孩子分配第 m 个饼干，第 m 个饼干为可以满足该孩子的最小饼干
    // 。假设存在一种最优策略，可以给该孩子分配第 n 个饼干，并且 m < n。我们可以发现，经过这一轮分配，
    // 贪心策略分配后剩下的饼干一定有一个比最优策略来得大。因此在后续的分配中，贪心策略一定能满足更多的孩子。也就是说不存在比贪心策略更优的策略，即贪心策略就是最优策略。


    /*
    执行结果：
通过
显示详情
执行用时 :
9 ms
, 在所有 Java 提交中击败了
32.07%
的用户
内存消耗 :
40.8 MB
, 在所有 Java 提交中击败了
9.52%
的用户
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }


}
