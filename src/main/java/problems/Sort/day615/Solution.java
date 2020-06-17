package problems.Sort.day615;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/15
 * \* Time: 19:59
 * \* Description:
 * \
 */
public class Solution {

    //给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
    //
    // 
    //
    //示例 1:
    //
    //输入: nums = [1,1,1,2,2,3], k = 2
    //输出: [1,2]
    //示例 2:
    //
    //输入: nums = [1], k = 1
    //输出: [1]
    // 
    //
    //提示：
    //
    //你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
    //你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
    //题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
    //你可以按任意顺序返回答案。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/top-k-frequent-elements
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




    //执行结果：
    //通过
    //显示详情
    //执行用时 :
    //13 ms
    //, 在所有 Java 提交中击败了
    //96.53%
    //的用户
    //内存消耗 :
    //42 MB
    //, 在所有 Java 提交中击败了
    //10.00%
    //的用户



    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }

        int[] res = new int[topK.size()];
        int i = 0;
        for (Integer integer : topK) {
            res[i] = integer;
            i++;
        }

        return res;
    }



}
