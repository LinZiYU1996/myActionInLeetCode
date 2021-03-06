package problems.greedy.day625;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/25
 * \* Time: 22:05
 * \* Description:
 * \
 */
public class Solution1 {

    //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //
    //示例:
    //
    //输入: [-2,1,-3,4,-1,2,1,-5,4],
    //输出: 6
    //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    //进阶:
    //
    //如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。


/*
执行结果：
通过
显示详情
执行用时：
1 ms
, 在所有 Java 提交中击败了
95.17%
的用户
内存消耗：
40 MB
, 在所有 Java 提交中击败了
34.83%
的用户
 */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }

}
