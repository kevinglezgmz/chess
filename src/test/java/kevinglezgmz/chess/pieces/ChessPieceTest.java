package kevinglezgmz.chess.pieces;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import kevinglezgmz.chess.pieces.piece.Bishop;

public class ChessPieceTest {
  ChessPiece testPiece;

  @Before
  public void setUp() {
    // As we are testing the methods of the ChessPiece superclass we can instantiate
    // any of its subclasses
    testPiece = new Bishop('a', '1', true);
  }

  @Test
  public void returnsTrueIfAValidTileIsReceived() {
    // valid range of valid tiles
    for (char i = 'a'; i <= 'h'; i++) {
      for (char j = '1'; j <= '8'; j++) {
        assertTrue(ChessPiece.isValidTile(i, j));
      }
    }
    // any other combination must return false
    for (char i = 'i'; i <= 'z'; i++) {
      for (char j = '0'; j <= '9'; j++) {
        assertFalse(ChessPiece.isValidTile(i, j));
      }
    }
  }

  @Test
  public void returnsTheCorrespondentIndexGivenAValidXAxis() {
    for (char i = 'a', j = 0; i <= 'h'; i++, j++) {
      assertEquals((int) j, ChessPiece.indexOfX(i));
    }
  }

  @Test
  public void returnsTheCorrespondentIndexGivenAValidYAxis() {
    for (char i = '1', j = 7; i <= '8'; i++, j--) {
      assertEquals((int) j, ChessPiece.indexOfY(i));
    }
  }

  @Test
  public void returnsTheCorrectAbsoluteDifferenceInTheXAxis() {
    int i = 0;
    for (char c = 'a'; c <= 'h'; c++, i++) {
      assertEquals(i, testPiece.absoluteDifferenceX(c));
    }
  }

  @Test
  public void returnsTheCorrectAbsoluteDifferenceInTheYAxis() {
    int i = 0;
    for (char c = '1'; c <= '8'; c++, i++) {
      assertEquals(i, testPiece.absoluteDifferenceY(c));
    }
  }

  @Test
  public void correctlySetsAndReturnsPiecePosition() {
    char[] position = testPiece.getPosition();
    assertArrayEquals(new char[] { 'a', '1' }, position);

    testPiece.setPosition('h', '7');
    position = testPiece.getPosition();
    assertArrayEquals(new char[] { 'h', '7' }, position);
  }

  @Test
  public void calculatesDirectionOnWhichTileWouldMoveTowardsActualPiece() {
    assertEquals(-1, testPiece.moveDirectionX('h'));
    assertEquals(-1, testPiece.moveDirectionY('8'));

    testPiece.setPosition('h', '8');
    assertEquals(1, testPiece.moveDirectionX('a'));
    assertEquals(1, testPiece.moveDirectionY('1'));
  }
}