package com.javadroider.interviewprep.ds.matrix;

public class PrintMatrixDiagonally {

    public static void main(String[] args) {
        int mat [][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10,11,12},
                {13,14,15,16}
        };

        int rows = mat.length;
        int cols = mat[0].length;
        int rp = 0;//row pointer
        int cp = 0; //column pointer
        System.out.println();
        for (int i = 0; i < rows; i++) {
            rp = i;//move to next row
            cp = 0;//start from column zero
            while (rp >= 0) {
                System.out.print(mat[rp][cp] + " ");
                rp = rp - 1;
                cp = cp + 1;
            }
        }

        for (int i = 1; i < cols; i++) {
            rp = rows - 1; // repoint to last row
            cp = i; //move to next column
            while (cp < cols) {
                System.out.print(mat[rp][cp] + " ");
                rp = rp - 1;
                cp = cp + 1;
            }
        }
    }
}
