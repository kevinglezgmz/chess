package Chess.ChessPieces.Pieces;

import Chess.ChessPieces.ChessPiece;

public class Bishop extends ChessPiece {
  public static char symbol = 'B';

  public Bishop(char xAxis, char yAxis, boolean isWhite) {
    super(xAxis, yAxis, isWhite);
  }

  protected boolean validateMovement(ChessPiece[][] board, char xAxis, char yAxis) {
    // if distance in x does not equal distance in y it is not a valid movement
    if (absoluteDifferenceX(xAxis) != absoluteDifferenceY(yAxis)) {
      return false;
    }
    int xDirection = moveDirectionX(xAxis);
    int yDirection = moveDirectionY(yAxis);
    return isLineWithClearPath(board, xAxis, yAxis, xDirection, yDirection);
  }

  @Override
  public char getClassSymbol() {
    return Bishop.symbol;
  }
}