package kevinglezgmz.chess.pieces.piece;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import kevinglezgmz.chess.pieces.ChessPiece;

public class PawnTest {
  Pawn pawn;
  ChessPiece[][] board;

  @Before
  public void setUp() {
    pawn = new Pawn('a', '2', true);
    board = new ChessPiece[8][8];
    board[ChessPiece.indexOfY('2')][ChessPiece.indexOfX('a')] = pawn;
  }

  @Test
  public void pawnCanMoveTwoTilesIfInStartingPosition() {
    int expectedNumberOfValidMovements = 2;
    int numberOfValidNumbers = 0;
    for (char i = 'a'; i <= 'h'; i++) {
      for (char j = '1'; j <= '8'; j++) {
        if (pawn.isValidMovement(board, i, j)) {
          numberOfValidNumbers++;
        }
      }
    }
    assertEquals(expectedNumberOfValidMovements, numberOfValidNumbers);
  }

  @Test
  public void pawnMovesFowardOneTileIfNotInStartingPosition() {
    pawn.setPosition('a', '4');
    board[ChessPiece.indexOfY('4')][ChessPiece.indexOfX('a')] = pawn;
    board[ChessPiece.indexOfY('2')][ChessPiece.indexOfX('a')] = null;

    int expectedNumberOfValidMovements = 1;
    int numberOfValidNumbers = 0;
    for (char i = 'a'; i <= 'h'; i++) {
      for (char j = '1'; j <= '8'; j++) {
        if (pawn.isValidMovement(board, i, j)) {
          numberOfValidNumbers++;
        }
      }
    }
    assertEquals(expectedNumberOfValidMovements, numberOfValidNumbers);
  }

  @Test
  public void pawnCanMoveOneTileDiagonalToEatAnotherPiece() {
    pawn = new Pawn('b', '2', true);
    board = new ChessPiece[8][8];
    board[ChessPiece.indexOfY('2')][ChessPiece.indexOfX('b')] = pawn;

    Pawn newPawn1 = new Pawn('a', '3', false);
    board[ChessPiece.indexOfY('3')][ChessPiece.indexOfX('a')] = newPawn1;
    Pawn newPawn2 = new Pawn('b', '3', false);
    board[ChessPiece.indexOfY('3')][ChessPiece.indexOfX('b')] = newPawn2;
    Pawn newPawn3 = new Pawn('c', '3', false);
    board[ChessPiece.indexOfY('3')][ChessPiece.indexOfX('c')] = newPawn3;

    int expectedNumberOfValidMovements = 2;
    int numberOfValidNumbers = 0;
    for (char i = 'a'; i <= 'h'; i++) {
      for (char j = '1'; j <= '8'; j++) {
        if (pawn.isValidMovement(board, i, j)) {
          numberOfValidNumbers++;
        }
      }
    }
    assertEquals(expectedNumberOfValidMovements, numberOfValidNumbers);
  }
}