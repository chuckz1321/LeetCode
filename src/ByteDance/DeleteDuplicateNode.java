package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-06
 */
public class DeleteDuplicateNode {

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ma = {{1,2,3},{4,5,6},{7,8,9}};
        DeleteDuplicateNode d = new DeleteDuplicateNode();
        d.rotate(ma);
    }
}
