package kevinglezgmz.chess.pieces.piece;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import kevinglezgmz.chess.pieces.ChessPiece;

public class RookTest {
  Rook rook;
  ChessPiece[][] board;

  @Before
  public void setUp() {
    // Initial position = c1
    rook = new Rook('a', '1', true);
    board = new ChessPiece[8][8];
    board[ChessPiece.indexOfY('1')][ChessPiece.indexOfX('a')] = rook;
  }

  @Test
  public void rookMovesOnlyInLinear() {
    int expectedNumberOfValidMovements = 14;
    int numberOfValidNumbers = 0;
    for (char i = 'a'; i <= 'h'; i++) {
      for (char j = '1'; j <= '8'; j++) {
        if (rook.isValidMovement(board, i, j)) {
          numberOfValidNumbers++;
        }
      }
    }
    assertEquals(expectedNumberOfValidMovements, numberOfValidNumbers);
  }
}