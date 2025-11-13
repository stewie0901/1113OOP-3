import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {

    @Test
    public void testHorizontalWin() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0);
        game.set(1, 0);
        game.set(0, 1);
        game.set(1, 1);
        game.set(0, 2);
        assertTrue(game.isGameEnded());
        assertEquals("X", game.getWinner());
    }

    @Test
    public void testVerticalWin() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0);
        game.set(0, 1);
        game.set(1, 0);
        game.set(1, 1);
        game.set(2, 0);
        assertTrue(game.isGameEnded());
        assertEquals("X", game.getWinner());
    }

    @Test
    public void testDraw() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); // X
        game.set(0, 1); // O
        game.set(0, 2); // X
        game.set(1, 1); // O
        game.set(1, 0); // X
        game.set(1, 2); // O
        game.set(2, 1); // X
        game.set(2, 0); // O
        game.set(2, 2); // X
        assertTrue(game.isGameEnded());
        assertEquals("Draw", game.getWinner());
    }
}
