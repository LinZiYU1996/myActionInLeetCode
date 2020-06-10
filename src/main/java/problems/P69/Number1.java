package problems.P69;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/6/9
 * \* Time: 21:06
 * \* Description:
 *
 * 第796题：给定两个字符串, A 和 B。A 的旋转操作就是将 A 最左边的
 * 字符移动到最右边。例如, 若 A = 'abcde'，在移动一次之后结果就
 * 是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回
 * True。
 *示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 *注意：A 和 B 长度不超过 100。
 *
 *
 * \
 */
public class Number1 {

    public static String rotate(String s) {
        String s1 = s.substring(0,1);
        String s2 = s.substring(1,s.length());
        return  s2 + s1;
    }


    //只需要判断 B 是否为 A + A 的子串就可以了：


    public static boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }


    //注意我们上面问题，其实已经转化为了：判断 B 是否为 A + A 的子串。那
    //我们就可以引申答出 KMP，SUNDAY，BF 等字符串匹配策略。（当然，这里
    //其实 SUNDAY 并不是特别适合）
    //然后就是用相应的匹配策略，来实现转化后的问题。




    public static void main(String[] args) {


        System.out.println(rotate("abcde"));


        /*

        // 细节

         */
        System.out.println("bcdea".contains("cde"));


    }
}
