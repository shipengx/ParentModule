package aa;

import java.util.ArrayList;
import java.util.List;

/*
 * Set matrix zeroes
 * 
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 */

public class SetMatrixZeros {
	
	public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        List<Integer> rowNum = new ArrayList<Integer>();
        List<Integer> colNum = new ArrayList<Integer>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowNum.add(i);
                    colNum.add(j);
                }
            }
        }
        
        for (Integer row: rowNum) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
        
        for (Integer col: colNum) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
        
    }
	
}
