package Pieces;

public class Bishop extends ChessPiece {
  public static char symbol = 'B';

  public boolean moveTo(ChessPiece[][] board, char xAxis, char yAxis) {
    if (!isValidPosition(xAxis, yAxis))
      return false;
    if (Math.abs(this.xAxis - xAxis) != Math.abs(this.yAxis - yAxis)) {
      return false;
    }
    int xSign = xAxis < this.xAxis ? 1 : -1;
    int ySign = yAxis < this.yAxis ? 1 : -1;
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
    return Bishop.symbol;
  }
}