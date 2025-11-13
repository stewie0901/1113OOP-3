public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;
    private String winner;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        gameEnded = false;
        winner = null;

        // 初始化空白棋盤
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // 玩家設定位置
    public boolean set(int row, int col) {
        if (gameEnded || board[row][col] != ' ') {
            return false; // 遊戲結束或該格已被使用
        }

        board[row][col] = currentPlayer;
        evaluate(); // 每次下棋後檢查結果

        if (!gameEnded) {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        return true;
    }

    // 檢查勝負或平手
    private void evaluate() {
        // 檢查列與行
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                gameEnded = true;
                winner = String.valueOf(board[i][0]);
                return;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                gameEnded = true;
                winner = String.valueOf(board[0][i]);
                return;
            }
        }

        // 檢查對角線
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            gameEnded = true;
            winner = String.valueOf(board[0][0]);
            return;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            gameEnded = true;
            winner = String.valueOf(board[0][2]);
            return;
        }

        // 檢查是否平手
        boolean full = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    full = false;
                    break;
                }
            }
        }
        if (full) {
            gameEnded = true;
            winner = "Draw";
        }
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public String getWinner() {
        return winner;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }
}
