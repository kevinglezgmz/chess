package Chess.ChessPieces.Pieces;

import Chess.ChessPieces.ChessPiece;

public class Rook extends ChessPiece {
  public static char symbol = 'R';

  public Rook(char xAxis, char yAxis, boolean isWhite) {
    super(xAxis, yAxis, isWhite);
  }

  protected boolean validateMovement(ChessPiece[][] board, char xAxis, char yAxis) {
    // if both are different, means piece is not moving in a straight line
    if (this.xAxis != xAxis && this.yAxis != yAxis) {
      return false;
    }
    int xDirection = moveDirectionX(xAxis);
    int yDirection = moveDirectionY(yAxis);
    if (this.xAxis == xAxis) {
      xDirection = 0;
    } else {
      yDirection = 0;
    }
    return isLineWithClearPath(board, xAxis, yAxis, xDirection, yDirection);
  }

  @Override
  public char getClassSymbol() {
    return Rook.symbol;
  }
}