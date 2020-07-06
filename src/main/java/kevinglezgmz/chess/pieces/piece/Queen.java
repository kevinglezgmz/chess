package kevinglezgmz.chess.pieces.piece;

import kevinglezgmz.chess.pieces.ChessPiece;

public class Queen extends ChessPiece {
  public static char symbol = 'Q';

  public Queen(char xAxis, char yAxis, boolean isWhite) {
    super(xAxis, yAxis, isWhite);
  }

  protected boolean validateMovement(ChessPiece[][] board, char xAxis, char yAxis) {

    // if piece is not moving in diagonal or straight line we return false
    if (absoluteDifferenceX(xAxis) != absoluteDifferenceY(yAxis)) {
      if (this.xAxis != xAxis && this.yAxis != yAxis) {
        return false;
      }
    }
    int xDirection = moveDirectionX(xAxis);
    int yDirection = moveDirectionY(yAxis);
    if (this.xAxis == xAxis) {
      xDirection = 0;
    }
    if (this.yAxis == yAxis) {
      yDirection = 0;
    }
    return isLineWithClearPath(board, xAxis, yAxis, xDirection, yDirection);
  }

  @Override
  public char getClassSymbol() {
    return Queen.symbol;
  }
}