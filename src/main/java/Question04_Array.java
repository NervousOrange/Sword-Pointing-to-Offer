import static org.junit.Assert.*;
import org.junit.Test;

public class Question04_Array{

/*在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。*/

	public boolean Find(int target, int [][] array) {
		if (array == null) {
			return false;
		}
		int row = 0;
		int column = array[0].length - 1;

		while (row < array.length && column >= 0) {
			if (target == array[row][column]) {
				return true;
			} else if (target > array[row][column]) {
				row++;
			} else {
				column--;
			}
		}
		return  false;
	}



	@Test
	public void testFind() {
		int[][] testMatrix = {{1, 3, 4, 6, 9},
				{2, 5, 8, 10, 13},
				{7, 13, 17, 19, 21},
				{11, 16, 19, 22, 29},
				{13, 19, 23, 27, 33}};

		assertTrue(Find(17, testMatrix));
		assertFalse(Find(12, testMatrix));
		assertFalse(Find(20, testMatrix));
		assertTrue(Find(21, testMatrix));
		assertTrue(Find(29, testMatrix));
		assertFalse(Find(30, testMatrix));
		assertFalse(Find(17, null));

	}

}
