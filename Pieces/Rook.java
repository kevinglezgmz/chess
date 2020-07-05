package Pieces;

public class Rook extends ChessPiece {
  public static char symbol = 'R';

  public boolean moveTo(ChessPiece[][] board, char xAxis, char yAxis) {
    if (!isValidPosition(xAxis, yAxis))
      return false;
    if (this.xAxis != xAxis && this.yAxis != yAxis) {
      return false;
    }
    int xSign;
    int ySign;
    if (this.xAxis == xAxis) {
      xSign = 0;
      ySign = yAxis < this.yAxis ? 1 : -1;
    } else {
      ySign = 0;
      xSign = xAxis < this.xAxis ? 1 : -1;
    }
    xAxis += xSign;
    yAxis += ySign;
    while (this.xAxis != xAxis && this.yAxis != yAxis) {
      int row = 7 - (yAxis - '1');
      int col = xAxis - 'a';
      if (board[row][col] != null)
        return false;
      xAxis += xSign;
      yAxis += ySign;
    }
    return true;
  }

  @Override
  public char getClassSymbol() {
    return Rook.symbol;
  }
}