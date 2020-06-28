package problems.binarySearch.day627;

import java.util.Arrays;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/27
 * \* Time: 21:07
 * \* Description:
 * \
 */
public class Solution2 {
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//
//请找出其中最小的元素。
//
//你可以假设数组中不存在重复元素。
//
//示例 1:
//
//输入: [3,4,5,1,2]
//输出: 1
//示例 2:
//
//输入: [4,5,6,7,0,1,2]
//输出: 0


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
38.9 MB
, 在所有 Java 提交中击败了
5.55%
的用户
 */
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }

// OK
    //    Arrays.sort(nums);
    //        return nums[0];
//执行结果：
//通过
//显示详情
//执行用时：
//2 ms
//, 在所有 Java 提交中击败了
//6.19%
//的用户
//内存消耗：
//39.6 MB
//, 在所有 Java 提交中击败了
//5.55%
//的用户

}
