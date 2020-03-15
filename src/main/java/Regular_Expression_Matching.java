/* 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配 */

public class Regular_Expression_Matching {
    public static void main(String[] args) {
        Regular_Expression_Matching regular_expression_matching = new Regular_Expression_Matching();
        System.out.println(regular_expression_matching.match(new char[]{}, new char[]{'.', '*'}));
        System.out.println(regular_expression_matching.match(new char[]{'a'}, new char[]{'.', '*'}));
        System.out.println(regular_expression_matching.match(new char[]{'a', 'a', 'a'}, new char[]{'a', '.', 'a'}));
        System.out.println(regular_expression_matching.match(new char[]{'a', 'a', 'a'}, new char[]{'a', 'b', '*', 'a', 'c', '*', 'a'}));
        System.out.println("------------------------");
        System.out.println(regular_expression_matching.match(new char[]{'a', 'a', 'a'}, new char[]{'a', 'a', '.', 'a'}));
        System.out.println(regular_expression_matching.match(new char[]{'a', 'a', 'a'}, new char[]{'a', 'b', '*', 'a'}));
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null && pattern == null) {
            return true;
        }
        if (str !=null && pattern == null) {
            return false;
        }
        return matchHelper(str, 0, pattern, 0);
    }

    private boolean matchHelper(char[] str, int strIndex, char[] pattern, int patternIndex) {
        // 同时到末尾，匹配成功
        if (strIndex == str.length && pattern.length == patternIndex) {
            return true;
        }

        // pattern 先到尾，匹配失败
        if (strIndex < str.length && pattern.length == patternIndex) {
            return false;
        }

        if (patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*') {
            if (strIndex < str.length && str[strIndex] == pattern[patternIndex] ||
                    strIndex < str.length && pattern[patternIndex] == '.') {
                return matchHelper(str, strIndex, pattern, patternIndex + 2)  // 直接后推2位
                        || matchHelper(str, strIndex + 1, pattern, patternIndex + 2)
                        || matchHelper(str, strIndex + 1, pattern, patternIndex);
            } else {
                return matchHelper(str, strIndex, pattern, patternIndex + 2);
            }
        }

        // pattern第二个不是*，且str第一个和pattern第一个匹配，则都后移一位；否则匹配失败
        if ((strIndex < str.length && str[strIndex] == pattern[patternIndex])
                || (strIndex < str.length && pattern[patternIndex] == '.')) {
            return matchHelper(str, strIndex + 1, pattern, patternIndex + 1);
        } else {
            return false;
        }
    }
}
