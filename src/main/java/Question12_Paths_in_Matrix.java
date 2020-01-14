public class Solution {
/*	请设计一个函数，用来判断在一个矩阵中
	是否存在一条包含某字符串所有字符的路径。
	路径可以从矩阵中的任意一个格子开始，
	每一步可以在矩阵中向左，向右，向上，
	向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，
	则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 
	矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
	因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
	路径不能再次进入该格子。*/

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
    	// 标记格子是否已经被访问过
    	boolean[] flag = new boolean[matrix.length];
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
    			// 遍历找到 str[0]
    			if (judge(matrix, rows, cols, i, j, str, flag, 0)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }

    private boolean judge(char[] matrix, int rows, int cols, int i, int j, char[] str, boolean[]flag, int k) {
    	
    	// 二维数组对应的在一维空间位置
    	int index = i * cols + j;
    	// 走出边界 or 没找到 or 已经找过了 返回 false
    	if (i >= rows || j >= cols || i < 0 || j < 0 || flag[index] || matrix[index] != str[k]) {
    		return false;
    	}
    	// 找到了str的最后一个字符
    	if (k == str.length -1) {
    		return true;
    	}

    	flag[index] = true;

    	// 判断 Maxtrix[index] 周围是否有 str[k+1]
    	if (judge(matrix, rows, cols, i+1, j, str, flag, k+1) ||
    		judge(matrix, rows, cols, i, j+1, str, flag, k+1) ||
    		judge(matrix, rows, cols, i-1, j, str, flag, k+1) ||
    		judge(matrix, rows, cols, i, j-1, str, flag, k+1) ) {
    		return true;
    	}
    	// 如果当前的 Matrix[index] 四周都没有找到 str(k+1) 
    	// 则将 flag 标记重置
    	flag[index] = false;
    	return false;
    }
}
