import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
//        关键在于找规律...旋转是4个数字的规律调换，画一下图就知道了
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - i - 1; j++) {
                swap(matrix, i, j, j, len - i - 1, len - i - 1, len - j - 1, len - j - 1, i);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2, int i3, int j3, int i4, int j4) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i4][j4];
        matrix[i4][j4] = matrix[i3][j3];
        matrix[i3][j3] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public static void main(String[] args) {
        RotateImage test = new RotateImage();
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        test.rotate(nums);
        System.out.println(Arrays.deepToString(nums));
    }
}
