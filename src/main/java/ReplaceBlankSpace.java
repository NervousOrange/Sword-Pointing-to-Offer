/* 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。 */

public class ReplaceBlankSpace {
    public static void main(String[] args) {
        ReplaceBlankSpace replaceBlankSpace = new ReplaceBlankSpace();
        replaceBlankSpace.replaceSpace(new StringBuffer("We Are Happy."));
    }

    public String replaceSpace(StringBuffer str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i< str.length(); i++) {
            char cha;
            if ((cha = str.charAt(i)) != ' ')  {
                stringBuilder.append(cha);
            } else {
                stringBuilder.append("%20");
            }
        }
        return stringBuilder.toString();
    }
}
