package kevinglezgmz.chess.pieces.piece;

import kevinglezgmz.chess.pieces.ChessPiece;

public class Knight extends ChessPiece {
  public static char symbol = 'H';

  public Knight(char xAxis, char yAxis, boolean isWhite) {
    super(xAxis, yAxis, isWhite);
  }

  protected boolean validateMovement(ChessPiece[][] board, char xAxis, char yAxis) {
    // can only move in 'L' shape (2 hor and 1 ver or viceversa)
    if (this.absoluteDifferenceX(xAxis) == 2 && this.absoluteDifferenceY(yAxis) == 1) {
      return true;
    } else if (this.absoluteDifferenceX(xAxis) == 1 && this.absoluteDifferenceY(yAxis) == 2) {
      return true;
    }
    return false;
  }

  @Override
  public char getClassSymbol() {
    return Knight.symbol;
  }
}