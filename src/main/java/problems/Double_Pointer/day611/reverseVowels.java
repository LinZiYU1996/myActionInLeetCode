package problems.Double_Pointer.day611;

import java.util.Arrays;
import java.util.HashSet;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/11
 * \* Time: 22:06
 * \* Description:
 * \
 */
public class reverseVowels {

    //编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
    //
    //示例 1:
    //
    //输入: "hello"
    //输出: "holle"
    //示例 2:
    //
    //输入: "leetcode"
    //输出: "leotcede"
    //说明:
    //元音字母不包含字母"y"。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public String reverseVowelss(String s) {
            int i = 0;
            int j = s.length() - 1;

            while (i < j) {
                if (isal(s.charAt(i)) && isal(s.charAt(j)) ) {
                    char t = s.charAt(i);
                    s.replace(s.charAt(i), s.charAt(j));
                    s.replace(s.charAt(j), t);
                    i++;
                    j--;
                } else if (isal(s.charAt(i)) && !isal(s.charAt(j))) {
                    j--;
                } else if (!isal(s.charAt(i)) && isal(s.charAt(j))) {
                    i++;
                }
            }

            return s;
    }

    public boolean isal(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }



    // 使用双指针，一个指针从头向尾遍历，一个指针从尾到头遍历，当两个指针都遍历到元音字符时，交换这两个元音字符。
    //
    //为了快速判断一个字符是不是元音字符，我们将全部元音字符添加到集合 HashSet 中，从而以 O(1) 的时间复杂度进行该操作。
    //
    //时间复杂度为 O(N)：只需要遍历所有元素一次
    //空间复杂度 O(1)：只需要使用两个额外变量


    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
