/**
 * Solution with 3 Hash Sets to check row, col & diagonal constraints.
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        if (n < 0) {
            return result;
        }
        Set<Integer> negativeDiagonal = new HashSet<>(); // row - col
        Set<Integer> positiveDiagonal = new HashSet<>(); // row + col
        Set<Integer> colSet = new HashSet<>(); // Column Constraint.
        dfs(n, result, cur, negativeDiagonal, positiveDiagonal, colSet);
        return result; 
    }

    private void dfs(int n, List<List<String>> result, List<String> cur, Set<Integer> negativeDiagonal, Set<Integer> positiveDiagonal, Set<Integer> colSet) {
        if (cur.size() == n) {
            result.add(new ArrayList(cur));
            return;
        }
        int row = cur.size();
        // i is column index.
        for (int i = 0; i < n; i++) {
            if (negativeDiagonal.contains(row - i) || positiveDiagonal.contains(row + i) || colSet.contains(i)) {
                continue;
            }
            // current col index is added to the solution list cur
            cur.add(convert(n, i)); // this is the row representation of all "." but "Q" at i th position.
            negativeDiagonal.add(row - i);
            positiveDiagonal.add(row + i);
            colSet.add(i);
            // go to dfs next level
            dfs(n, result, cur, negativeDiagonal, positiveDiagonal, colSet);
            //backtrack
            cur.remove(cur.size() - 1);
            negativeDiagonal.remove(row - i);
            positiveDiagonal.remove(row + i);
            colSet.remove(i);
        }
    }

    private String convert(int n, int col) {
        StringBuilder res = new StringBuilder();
        // Never use String Concatenation inside loop, use StringBuilder.
        for (int i = 0; i < n; i++) {
            if (i == col) {
                res.append("Q");
            } else {
                res.append(".");
            }
        }
        return res.toString();

    }
}
