package problems.Double_Pointer.day611;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/11
 * \* Time: 21:43
 * \* Description:
 *
 * \
 */
public class judgeSquareSum {


    //给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
    //
    //示例1:
    //
    //输入: 5
    //输出: True
    //解释: 1 * 1 + 2 * 2 = 5
    // 
    //
    //示例2:
    //
    //输入: 3
    //输出: False
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/sum-of-square-numbers
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//可以看成是在元素为 0~target 的有序数组中查找两个数，使得这两个数的平方和为 target，如果能找到，则返回 true，表示 target 是两个整数的平方和。
//
//本题和 167. Two Sum II - Input array is sorted 类似，只有一个明显区别：一个是和为 target，一个是平方和为 target。本题同样可以使用双指针得到两个数，使其平方和为 target。
//
//本题的关键是右指针的初始化，实现剪枝，从而降低时间复杂度。设右指针为 x，左指针固定为 0，为了使 02 + x2 的值尽可能接近 target，我们可以将 x 取为 sqrt(target)。
//
//因为最多只需要遍历一次 0~sqrt(target)，所以时间复杂度为 O(sqrt(target))。又因为只使用了两个额外的变量，因此空间复杂度为 O(1)。


    public boolean judgeSquareSumS(int c) {

        if (c < 0) return false;
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                return true;
            } else if (powSum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
