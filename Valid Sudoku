class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++ ) {
            Set<Character> rowset = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                    if (!rowset.contains(board[i][j])) {
                        rowset.add(board[i][j]);
                    } else {
                        return false;
                    }
                
            }
        }
        for (int i = 0; i < 9; i++ ) {
            Set<Character> colset = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                    if (!colset.contains(board[j][i])) {
                        colset.add(board[j][i]);
                    } else {
                        return false;
                    }
                
            }
        }
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!checkBlock(i, j, board)) {
                    return false;
                }         
        }
        }
  
        return true;
    }              
    public boolean checkBlock(int idxI, int idxJ, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        //if idxI = 3 and indJ = 0
        //rows = 6 and cols = 3
        int rows = idxI + 3;
        int cols = idxJ + 3;
        //and because i initializes to idxI but only goes to rows, we loop 3 times (once for each row)
        for (int i = idxI; i < rows; i++) {
            //same for columns
            for (int j = idxJ; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                
                if (blockSet.contains(board[i][j])) {
                    return false;
                }

                blockSet.add(board[i][j]);
            }
        }

        return true;
    }
      
}
