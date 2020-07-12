package kevinglezgmz.chess.pieces.piece;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import kevinglezgmz.chess.pieces.ChessPiece;

public class QueenTest {
  Queen queen;
  ChessPiece[][] board;

  @Before
  public void setUp() {
    // Initial position = c1
    queen = new Queen('d', '1', true);
    board = new ChessPiece[8][8];
    board[ChessPiece.indexOfY('1')][ChessPiece.indexOfX('d')] = queen;
  }

  @Test
  public void queenMovesBothDiagonalAndLinear() {
    int expectedNumberOfValidMovements = 21;
    int numberOfValidNumbers = 0;
    for (char i = 'a'; i <= 'h'; i++) {
      for (char j = '1'; j <= '8'; j++) {
        if (queen.isValidMovement(board, i, j)) {
          numberOfValidNumbers++;
        }
      }
    }
    assertEquals(expectedNumberOfValidMovements, numberOfValidNumbers);
  }
}