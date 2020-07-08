package kevinglezgmz.chess.pieces.piece;

import static org.junit.Assert.assertEquals;

import kevinglezgmz.chess.pieces.ChessPiece;
import org.junit.*;

public class BishopTest {
  Bishop bishop;
  ChessPiece[][] board;

  @Before
  public void setUp() {
    // Initial position = c1
    bishop = new Bishop('c', '1', true);
    board = new ChessPiece[8][8];
    board[ChessPiece.indexOfY('1')][ChessPiece.indexOfX('c')] = bishop;
  }

  @Test
  public void bishopMovesOnlyInDiagonal() {
    int expectedNumberOfValidMovements = 7;
    int numberOfValidNumbers = 0;
    for (char i = 'a'; i <= 'h'; i++) {
      for (char j = '1'; j <= '8'; j++) {
        if (bishop.isValidMovement(board, i, j)) {
          numberOfValidNumbers++;
        }
      }
    }
    assertEquals(expectedNumberOfValidMovements, numberOfValidNumbers);
  }
}