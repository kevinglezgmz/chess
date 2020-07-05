package Pieces;

public class Knight extends ChessPiece {
  public static char symbol = 'H';

  public boolean moveTo(ChessPiece[][] board, char xAxis, char yAxis) {
    if (!isValidPosition(xAxis, yAxis))
      return false;
    // can only move in 'L' shape (2 hor and 1 ver or viceversa)
    if ((Math.abs(this.xAxis - xAxis) == 2 && Math.abs(this.yAxis - yAxis) == 1)
        || (Math.abs(this.xAxis - xAxis) == 1 && Math.abs(this.yAxis - yAxis) == 2)) {
      return true;
    }
    return false;
  }

  @Override
  public char getClassSymbol() {
    return Knight.symbol;
  }
}