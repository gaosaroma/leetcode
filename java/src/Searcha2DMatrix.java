public class Searcha2DMatrix {
    // 两次二分法，一定要注意！！边界条件啊！
    //
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;
        if (matrix.length == 0 || matrix[0].length == 0) return false; // a. 在取值之前判断能不能取；
        if (target < matrix[0][0]) return false;  // 根据后文的逻辑添加的边界条件

        int length = matrix[0].length, weight = matrix.length;
        int low = 0, high = weight;

        // 考虑到向下取，因此[l,r)，默认在matrix[low-1]中：
        // 此处要做好low=0的防护，即：预防target比matrix[0][0]小。
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (matrix[mid][0] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        // 此处在[l,r]中
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[low - 1][mid] == target) return true;
            if (matrix[low - 1][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Searcha2DMatrix t = new Searcha2DMatrix();
        int[][] matrix = {{1, 2,10},{11,12,34},{36,40,56}};

        System.out.println(t.searchMatrix(matrix, 0));
    }
}
