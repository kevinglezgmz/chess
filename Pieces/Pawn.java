package Pieces;

public class Pawn extends ChessPiece {
  public static char symbol = 'P';

  public boolean moveTo(ChessPiece[][] board, char xAxis, char yAxis) {
    if (!isValidPosition(xAxis, yAxis))
      return false;
    if (Math.abs(this.yAxis - yAxis) == 1) {
      int row = 7 - (this.yAxis - '1');
      int col = this.xAxis - 'a';
      if (this.isWhite) {
        try {
          if (board[row - 1][col] != null)
            return false;
        } catch (NullPointerException e) {
          return false;
        }
      } else {
        try {
          if (board[row + 1][col] != null)
            return false;
        } catch (NullPointerException e) {
          return false;
        }
      }
    }
    if (this.xAxis == xAxis && Math.abs(this.yAxis - yAxis) == 2) {
      int col = this.xAxis - 'a';
      if (this.isWhite && this.yAxis == '2' && board[5][col] == null && board[4][col] == null)
        return true;
      else if (!this.isWhite && this.yAxis == '7' && board[2][col] == null && board[3][col] == null)
        return true;
      else
        return false;
    }
    if (this.isWhite && this.yAxis - yAxis != -1)
      return false;
    if (!this.isWhite && this.yAxis - yAxis != 1)
      return false;
    if (Math.abs(this.xAxis - xAxis) > 1)
      return false;
    if (Math.abs(this.xAxis - xAxis) == 1) {
      int xSign = xAxis < this.xAxis ? 1 : -1;
      int row = 7 - (this.yAxis - '1');
      int col = this.xAxis - 'a' - xSign;
      if (col < 0 || col > 7)
        return false;
      if (this.isWhite && board[row - 1][col] == null)
        return false;
      if (!this.isWhite && board[row + 1][col] == null)
        return false;
    }
    return true;
  }

  @Override
  public char getClassSymbol() {
    return Pawn.symbol;
  }
}