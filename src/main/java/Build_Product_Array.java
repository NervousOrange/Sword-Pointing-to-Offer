/* 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];） */

import java.util.ArrayList;
import java.util.Arrays;

public class Build_Product_Array {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        Build_Product_Array build_product_array = new Build_Product_Array();
        System.out.println(Arrays.toString(build_product_array.multiply(A)));
    }

    /* 书上 313 页 */
    public int[] multiply(int[] A) {
        int lengthOfA = A.length;
        int[] B = new int[lengthOfA];
        B[0] = 1;
        for (int i = 1; i < lengthOfA; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        int temp = 1;
        for (int j = lengthOfA - 2; j >= 0; j--) {
            temp *= A[j + 1];
            B[j] *= temp;
        }
        return B;
    }
}
