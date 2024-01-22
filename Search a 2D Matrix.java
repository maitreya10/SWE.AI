class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        int l = 0;
        int h = matrix.length - 1;
        int mid = 0, mid2 = 0;
        while(l <= h) {
            mid = l + (h - l) / 2;
            if (matrix[mid][0] <= target  && target <= matrix[mid][matrix[0].length - 1]) {
                break;
            }
            if (target < matrix[mid][0]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        int low = 0;
        int high = matrix[0].length - 1;
        while (low <= high) {
            mid2 = low + (high - low) / 2;
            if (target == matrix[mid][mid2]) {
                return true;
            }
            if (target < matrix[mid][mid2]) {
                high = mid2 - 1;
            } else {
                low = mid2 + 1;
            } 
        }
        return false;
    }
}
