package Pieces;

public class Queen extends ChessPiece {
  public static char symbol = 'Q';

  public boolean moveTo(ChessPiece[][] board, char xAxis, char yAxis) {
    if (!isValidPosition(xAxis, yAxis))
      return false;
    if ((Math.abs(this.xAxis - xAxis) != Math.abs(this.yAxis - yAxis))
        && (this.xAxis != xAxis && this.yAxis != yAxis)) {
      return false;
    }
    int xSign = xAxis < this.xAxis ? 1 : -1;
    int ySign = yAxis < this.yAxis ? 1 : -1;
    if (this.xAxis == xAxis) {
      xSign = 0;
    }
    if (this.yAxis == yAxis) {
      ySign = 0;
    }
    xAxis += xSign;
    yAxis += ySign;
    while (this.xAxis != xAxis && this.yAxis != yAxis) {
      int row = 7 - (yAxis - '1');
      int col = xAxis - 'a';
      System.out.println(this.xAxis + " " + this.yAxis + " a " + xAxis + " " + yAxis);
      System.err.println(row + " y " + col);
      if (board[row][col] != null)
        return false;
      xAxis += xSign;
      yAxis += ySign;
    }
    return true;
  }

  @Override
  public char getClassSymbol() {
    return Queen.symbol;
  }
}