
class SudukoSolver {
    public static boolean solve(char[][] suduko) {
        for (int i = 0; i < suduko.length; i++) {
            for (int j = 0; j < suduko[i].length; j++) {
                if (suduko[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (validate(suduko, i, j, c)) {
                            suduko[i][j] = c;
                            if (solve(suduko) == true) {
                                return true;
                            } else
                                suduko[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean validate(char[][] suduko, int row, int col, char c) {
        for (int i = 0; i < suduko.length; i++) {
            if (suduko[i][col] == c)
                return false;
            if (suduko[row][i] == c)
                return false;

            if (suduko[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] suduko = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        solve(suduko);
        for (int i = 0; i < suduko.length; i++) {
            for (int j = 0; j < suduko.length; j++) {
                System.out.print(suduko[i][j] + " ");
            }
            System.out.println();
        }
    }
}