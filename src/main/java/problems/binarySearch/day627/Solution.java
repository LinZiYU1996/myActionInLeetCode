package problems.binarySearch.day627;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/27
 * \* Time: 20:50
 * \* Description:
 * \
 */
public class Solution {



    //给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
    //
    //在比较时，字母是依序循环出现的。举个例子：
    //
    //如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
    // 
    //
    //示例：
    //
    //输入:
    //letters = ["c", "f", "j"]
    //target = "a"
    //输出: "c"
    //
    //输入:
    //letters = ["c", "f", "j"]
    //target = "c"
    //输出: "f"
    //
    //输入:
    //letters = ["c", "f", "j"]
    //target = "d"
    //输出: "f"
    //
    //输入:
    //letters = ["c", "f", "j"]
    //target = "g"
    //输出: "j"
    //
    //输入:
    //letters = ["c", "f", "j"]
    //target = "j"
    //输出: "c"
    //
    //输入:
    //letters = ["c", "f", "j"]
    //target = "k"
    //输出: "c"
    // 
    //
    //提示：
    //
    //letters长度范围在[2, 10000]区间内。
    //letters 仅由小写字母组成，最少包含两个不同的字母。
    //目标字母target 是一个小写字母。
//，如果找不到就返回第 1 个字符。


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
39.9 MB
, 在所有 Java 提交中击败了
11.11%
的用户
     */
    public char nextGreatestLetter(char[] letters, char target) {

        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }


    public static void main(String[] args) {
        System.out.println('a' > 'b');


    }

}
