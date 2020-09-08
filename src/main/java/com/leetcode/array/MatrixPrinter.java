package com.leetcode.array;

import com.leetcode.utils.FakerData;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mao
 * Date：2020/9/8
 * Description：【54】螺旋矩阵
 */
public class MatrixPrinter {
    public static void main(String[] args) {
        MatrixPrinter matrixPrinter = new MatrixPrinter();
        int[][] matrix = FakerData.initMatrix(4, 4);
        System.out.println(matrixPrinter.spiralOrder(matrix));

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        int x = 0, y = 0;
        while (left <= right && up <= down) {
            for (y = left; y <= right && avoid(left, right, up, down); y++) {
                res.add(matrix[x][y]);
            }
            y--;
            up++;
            for (x = up; x <= down && avoid(left, right, up, down); x++) {
                res.add(matrix[x][y]);
            }
            x--;
            right--;
            for (y = right; y >= left && avoid(left, right, up, down); y--) {
                res.add(matrix[x][y]);
            }
            y++;
            down--;
            for (x = down; x >= up && avoid(left, right, up, down); x--) {
                res.add(matrix[x][y]);
            }
            x++;
            left++;
        }

        return res;
    }

    private boolean avoid(int left, int right, int up, int down) {
        return up <= down && left <= right;
    }

    /**
     * [59]生成螺旋矩阵
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * <p>
     * 示例:
     * 输入: 3
     * 输出:
     * [
     * [ 1, 2, 3 ],
     * [ 8, 9, 4 ],
     * [ 7, 6, 5 ]
     * ]
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix= new int[n][n];


        return matrix;
    }
}
