public class Question05_replace_Spaces {

    /*请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/

    public String replaceSpace2(StringBuffer str) {
        StringBuffer newString = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                newString.append(str.charAt(i));
            } else {
                newString.append("%20");
            }
        }
        return newString.toString();
        // Stringbuffer 会自动 resize.......
    }

    // 方法2：书上的方法

    public static String replaceSpace(StringBuffer str) {
        int numOfSpaces = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                numOfSpaces++;
            }
        }
        if (numOfSpaces == 0) {
            return str.toString();
        } else {
            char[] newString = new char[numOfSpaces * 2 + str.length()];
            int i = str.length() - 1;
            int j = newString.length - 1;
            while (i >= 0) {
                if (str.charAt(i) == ' ') {
                    newString[j] = '0';
                    newString[j - 1] = '2';
                    newString[j - 2] = '%';
                    j = j - 3;
                } else {
                    newString[j] = str.charAt(i);
                    j = j - 1;
                }
                i--;
            }
            return new String(newString);
        }
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append('H');
        str.append('e');
        str.append('l');
        str.append('l');
        str.append('o');
        str.append(' ');
        str.append('W');
        str.append('o');
        str.append('r');
        str.append('l');
        str.append('d');
        String s = replaceSpace(str);
        System.out.println(s);
    }
}
