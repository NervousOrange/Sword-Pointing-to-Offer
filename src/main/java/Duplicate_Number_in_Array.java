/* 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
*/


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Duplicate_Number_in_Array {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /*使用HashSet：空间复杂度 O(n)，时间复杂度 O(n)*/
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (set.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                set.add(numbers[i]);
            }
        }
        return false;
    }

    /* 排序后检查相邻数字是否相等，空间复杂度 0，时间复杂度 O(nlogn)*/
    public boolean duplicate2(int numbers[],int length,int [] duplication) {
        if (numbers == null | length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < length; i++) {
            if (numbers[i] == numbers[i+1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers= {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        Duplicate_Number_in_Array duplicate_number_in_array = new Duplicate_Number_in_Array();
        if (duplicate_number_in_array.duplicate2(numbers, 7, duplication)) {
            System.out.println("true, the input array have a duplicate number: " + duplication[0]);
        } else {
            System.out.println("false, the input array does not have a duplicate !");
        }
    }
}