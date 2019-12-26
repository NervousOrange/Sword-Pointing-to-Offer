import java.util.ArrayList;

public class Question11_Minimum_in_the_Rotating_Array {
/*    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/

    public int minNumberInRotateArray(int[] array) {
        int size = array.length;
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return array[0];
        }

        for (int i = 0; i < size; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            } else if (i + 1 == size - 1) {
                return array[0];
            }
        }
        return 0;
    }
    // 二分法写来写去通过去牛客的测试，罢了罢了。
}
