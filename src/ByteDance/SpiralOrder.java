package ByteDance;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-05-25
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        while (res.size() < row * col) {
            for (int i = left; i <= right && res.size() < row * col; i++) res.add(matrix[top][i]);
            top++;
            for (int i = top; i <= bottom && res.size() < row * col; i++) res.add(matrix[i][right]);
            right--;
            for (int i = right; i >= left && res.size() < row * col; i--) res.add(matrix[bottom][i]);
            bottom--;
            for (int i = bottom; i >= top && res.size() < row * col; i--) res.add(matrix[i][left]);
            left++;
        }
        return res;
    }
}
