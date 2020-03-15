/* 请实现一个函数用来判断字符串是否表示数值
（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。*/

public class StringRepresentANumericValue {
    public static void main(String[] args) {
        StringRepresentANumericValue stringRepresentANumericValue = new StringRepresentANumericValue();
        System.out.println(stringRepresentANumericValue.isNumeric(new char[]{'+', '1', '0', '0'}));
        System.out.println(stringRepresentANumericValue.isNumeric(new char[]{'5', 'e', '2'}));
        System.out.println(stringRepresentANumericValue.isNumeric(new char[]{'-', '1', '2', '3'}));
        System.out.println(stringRepresentANumericValue.isNumeric(new char[]{'3', '.', '1', '4', '1', '5'}));
        System.out.println(stringRepresentANumericValue.isNumeric(new char[]{'-', '1', 'E', '-', '1', '6'}));
        System.out.println(stringRepresentANumericValue.isNumeric(new char[]{'+', '5'}));
        System.out.println("-------------------------");
        System.out.println(stringRepresentANumericValue.isNumeric(new char[]{'1', '2', 'e'}));
        System.out.println(stringRepresentANumericValue.isNumeric(new char[]{'1', 'a', '3', '.', '1', '4'}));
        System.out.println(stringRepresentANumericValue.isNumeric(new char[]{'1', '.', '2', '.', '3'}));
        System.out.println(stringRepresentANumericValue.isNumeric(new char[]{'+', '-', '5'}));
        System.out.println(stringRepresentANumericValue.isNumeric(new char[]{'1', '2', 'e', '+', '4', '.', '3'}));


    }
    public boolean isNumeric(char[] str) {
        String string = new String(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([Ee][+-]?[0-9]+)?");
    }
}
