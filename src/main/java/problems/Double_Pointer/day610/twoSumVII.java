package problems.Double_Pointer.day610;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/10
 * \* Time: 20:55
 * \* Description:
 * \
 */
public class twoSumVII {

    //描述
    //中文
    //English
    //给定一个已经 按绝对值升序排列 的数组，找到两个数使他们加起来的和等于特定数。
    //
    //函数应该返回这两个数的下标，index1必须小于index2。注意返回的值是0-based。
    //
    //你不能对该数组进行排序。

    //输入:
    //[0,-1,2,-3,4]
    //1
    //输出: [[1,2],[3,4]]
    //说明: nums[1] + nums[2] = -1 + 2 = 1, nums[3] + nums[4] = -3 + 4 = 1
    //你也可以返回 [[3,4],[1,2]]，系统将自动帮你排序成 [[1,2],[3,4]]。但是[[2,1],[3,4]]是不合法的。


    /**
     * @param nums: the input array
     * @param target: the target number
     * @return: return the target pair
     */
    public List<List<Integer>> twoSumVII(int[] nums, int target) {
        // write your code here

        List<List<Integer>> answer = new LinkedList<List<Integer>>();

        int start = 0;

        int end = nums.length - 1;

        while (start < end) {

            int  sum = nums[start] + nums[end];

            if (sum == target) {
                List<Integer> list = new LinkedList<Integer>();
                list.add(start);
                list.add(end);
                answer.add(list);
            }

            if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return answer;
    }



    /*

    对这个数组以index 0做一个pivot，想象它成为一个index从 -(nums.length-1) 到 (nums.length-1)
    的新数组pivotNums，那么pivotNums[i]=nums[Math.abs(i)]。

比如：
nums = [0,-1,2,-3,4] index = 0 -> 4
pivotNums = [4,-3,2,-1,0,-1,2,-3,4] index = -4 -> 4

由于nums按绝对值排序，那么当我们只考虑pivotNums index 0左边的负数和index 0右边的正数时，
pivotNums相当于一个从大到小排序好的数组（只看黑体的部分），我们就可以直接使用从两边往中间走的two sum方法了。

题目要求O(n) time complexity and O(1) extra space

pivotNums并需要真的被创建，直接利用pivotNums[i]=nums[Math.abs(i)]的性质，
只是我们最小的index需要是最大index的负值，所以可以达到O(1)空间。
只循环数组一次，所以可以达到O(n)时间。


     */
    public List<List<Integer>> solu(int[] nums, int target) {
        List<List<Integer>> answer = new LinkedList<List<Integer>>();

        int sm = -(nums.length - 1), lg = nums.length - 1;

        while (sm < lg) {
            if ((long) sm * nums[Math.abs(sm)] < 0) {
                sm++;
            } else if ((long) lg * nums[Math.abs(lg)] < 0) {
                lg--;
            } else {
                int sum = nums[Math.abs(sm)] + nums[Math.abs(lg)];
                if (sum == target) {
                    answer.add(Arrays.asList(Math.min(Math.abs(sm), Math.abs(lg)), Math.max(Math.abs(sm), Math.abs(lg))));
                    sm++;
                    lg--;
                } else if (sum > target) {
                    lg--;
                } else {
                    sm++;
                }
            }
        }

           return answer;



    }







}
