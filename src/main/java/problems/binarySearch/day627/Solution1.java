package problems.binarySearch.day627;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/27
 * \* Time: 20:59
 * \* Description:
 * \
 */
public class Solution1 {

    //给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
    //
    //示例 1:
    //
    //输入: [1,1,2,3,3,4,4,8,8]
    //输出: 2
    //示例 2:
    //
    //输入: [3,3,7,7,10,11,11]
    //输出: 10
    //注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。

    //要求以 O(logN) 时间复杂度进行求解，因此不能遍历数组并进行异或操作来求解，这么做的时间复杂度为 O(N)。
    //
    //令 index 为 Single Element 在数组中的位置。在 index 之后，
    // 数组中原来存在的成对状态被改变。如果 m 为偶数，并且 m + 1 < index，
    // 那么 nums[m] == nums[m + 1]；m + 1 >= index，那么 nums[m] != nums[m + 1]。
    //
    //从上面的规律可以知道，如果 nums[m] == nums[m + 1]，那么 index 所在的数组位置为
    // [m + 2, h]，此时令 l = m + 2；如果 nums[m] != nums[m + 1]，那么 index 所在的数组位置为 [l, m]，此时令 h = m。
    //
    //因为 h 的赋值表达式为 h = m，那么循环条件也就只能使用 l < h 这种形式。


/*
执行结果：
通过
显示详情
执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
40 MB
, 在所有 Java 提交中击败了
20.00%
的用户
 */
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
