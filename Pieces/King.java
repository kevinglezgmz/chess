package Pieces;

public class King extends ChessPiece {
  public static char symbol = 'K';

  public boolean moveTo(ChessPiece[][] board, char xAxis, char yAxis) {
    if (!isValidPosition(xAxis, yAxis))
      return false;
    // can move only 1 block in diagonal
    if (Math.abs(this.xAxis - xAxis) == 1 && Math.abs(this.yAxis - yAxis) == 1) {
      return true;
    }
    // can move only 1 block in the x axis
    if (Math.abs(this.xAxis - xAxis) == 1 && Math.abs(this.yAxis - yAxis) == 0) {
      return true;
    }
    // can move only 1 block in the y axis
    if (Math.abs(this.xAxis - xAxis) == 0 && Math.abs(this.yAxis - yAxis) == 1) {
      return true;
    }
    return false;
  }

  @Override
  public char getClassSymbol() {
    return King.symbol;
  }
}