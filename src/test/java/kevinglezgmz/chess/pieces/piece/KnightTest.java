package kevinglezgmz.chess.pieces.piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import kevinglezgmz.chess.pieces.ChessPiece;

public class KnightTest {
  Knight knight;
  ChessPiece[][] board;

  @Before
  public void setUp() {
    // Initial position = b1
    knight = new Knight('b', '1', true);
    board = new ChessPiece[8][8];
    board[ChessPiece.indexOfY('1')][ChessPiece.indexOfX('d')] = knight;
  }

  @Test
  public void knightOnlyMovesInLShape() {
    int expectedNumberOfValidMovements = 3;
    int numberOfValidNumbers = 0;
    for (char i = 'a'; i <= 'h'; i++) {
      for (char j = '1'; j <= '8'; j++) {
        if (knight.isValidMovement(board, i, j)) {
          numberOfValidNumbers++;
        }
      }
    }
    assertEquals(expectedNumberOfValidMovements, numberOfValidNumbers);
  }
}