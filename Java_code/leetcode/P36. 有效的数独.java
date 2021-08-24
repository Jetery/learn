class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            TreeSet<Character> set = new TreeSet<>();
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            TreeSet<Character> set = new TreeSet<>();
            for (int j = 0; j < 9; j ++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) {
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            int a = i;
            for (int j = 0; j < 9; j += 3) {
                int b = j;
                TreeSet<Character> set = new TreeSet<>();
                for (int ii = a; ii < a + 3; ii++) {
                    for (int jj = b; jj < b + 3; jj++) {
                        if (board[ii][jj] != '.') {
                            if (set.contains(board[ii][jj])) {
                                return false;
                            }
                            set.add(board[ii][jj]);
                        }
                    }
                }
            }
        }
        return true;
    }
}