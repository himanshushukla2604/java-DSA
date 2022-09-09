import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class NqueenProblum {
    public static void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    public static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }
        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }

        return true;
    }

    public static List<String> construct(char[][] board) {
        List<String> fboard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String str = new String(board[i]);
            fboard.add(str);
        }
        return fboard;
    }

    public static List<List<String>> solveNQueene(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        }

        solve(0, board, ans, n);
        return ans;

    }

    public static void main(String[] args) {

        List<List<String>> ans = solveNQueene(8);

        Iterator<List<String>> itr = ans.iterator();

        while (itr.hasNext()) {
            List<String> list = itr.next();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            System.out.println();
        }
    }
}
