package kevinglezgmz.chess.pieces.piece;

import static org.junit.Assert.assertEquals;
import org.junit.*;

import kevinglezgmz.chess.pieces.ChessPiece;

public class KingTest {
  King king;
  ChessPiece[][] board;

  @Before
  public void setUp() {
    // Initial position = d1
    king = new King('e', '1', true);
    board = new ChessPiece[8][8];
    board[ChessPiece.indexOfY('1')][ChessPiece.indexOfX('e')] = king;
  }

  @Test
  public void kingMovesOnlyOneBlockInAnyDirection() {
    int expectedNumberOfValidMovements = 5;
    int numberOfValidNumbers = 0;
    for (char i = 'a'; i <= 'h'; i++) {
      for (char j = '1'; j <= '8'; j++) {
        if (king.isValidMovement(board, i, j)) {
          numberOfValidNumbers++;
        }
      }
    }
    assertEquals(expectedNumberOfValidMovements, numberOfValidNumbers);
  }
}