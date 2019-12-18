public class Question05_replace_Spaces {
    /*请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/
    public String replaceSpace(StringBuffer str) {    // 没有考虑append超出StringBuffer容量的问题？
        StringBuffer newString = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                newString.append(str.charAt(i));
            } else {
                newString.append("%20");
            }
        }
        return newString.toString();
    }
}
