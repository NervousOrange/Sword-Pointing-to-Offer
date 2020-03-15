/* 在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。*/

public class Search_in_two_dimensional_Array {
    public static void main(String[] args) {
        int[][] twoDimensionalArray = {{1, 5, 7}, {2, 6, 11}, {7, 9, 13}};
        Search_in_two_dimensional_Array solution = new Search_in_two_dimensional_Array();
        System.out.println("false: " + solution.Find(3, twoDimensionalArray));
        System.out.println("true: " + solution.Find(5, twoDimensionalArray));
        System.out.println("true: " + solution.Find(13, twoDimensionalArray));
        System.out.println("false: " + solution.Find(0, twoDimensionalArray));
    }

    /* 思路：将目标与最右列对比，小于某行最右列时，在该行往做查找 */
    public boolean Find(int target, int [][] array) {
        int column = array[0].length;
        int rows = array.length;
        int row = 0;
        while (row < rows && column -1 >= 0) {
            if (target == array[row][column - 1]) {
                return true;
            }
            if (target < array[row][column - 1]) {
                for (int j = column - 2; j >= 0; j--) {
                    if (target == array[row][j]) {
                        return true;
                    }
                }
            }
            row++;
        }
        return false;
    }
}
