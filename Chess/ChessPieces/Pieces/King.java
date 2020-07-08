package Chess.ChessPieces.Pieces;

import Chess.ChessPieces.ChessPiece;

public class King extends ChessPiece {
  public static char symbol = 'K';

  public King(char xAxis, char yAxis, boolean isWhite) {
    super(xAxis, yAxis, isWhite);
  }

  protected boolean validateMovement(ChessPiece[][] board, char xAxis, char yAxis) {
    // can only move 1 block in any direction
    if (absoluteDifferenceX(xAxis) > 1 || absoluteDifferenceY(yAxis) > 1) {
      return false;
    }
    return true;
  }

  @Override
  public char getClassSymbol() {
    return King.symbol;
  }
}