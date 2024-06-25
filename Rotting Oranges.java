class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0; // need to keep track of fresh.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j}); // add the (i, j) as an array.
                } else if (grid[i][j] == 1) {
                    fresh++; // we count the total no. of fresh oranges initially for the edge ase of "impossible to happen".
                }
            }
        }
        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty() && fresh != 0) {
            count += 1;
            int qSize  = queue.size();
            for (int i = 0; i < qSize; i++) {
                int[] rotten = queue.poll();
                int r = rotten[0];
                int c = rotten[1];
                for (int[] dir : directions) {
                    int x = r + dir[0], y = c + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[] {x, y});
                        fresh -= 1;
                    }

                }
            }
        }
        return fresh == 0 ? count : -1; 
    }

}
