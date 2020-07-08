package kevinglezgmz.chess.pieces.piece;

import kevinglezgmz.chess.pieces.ChessPiece;

public class Pawn extends ChessPiece {
  public static char symbol = 'P';

  public Pawn(char xAxis, char yAxis, boolean isWhite) {
    super(xAxis, yAxis, isWhite);
  }

  protected boolean validateMovement(ChessPiece[][] board, char xAxis, char yAxis) {
    boolean isRightDirection = this.validateMovementDirection(xAxis, yAxis);
    if (this.xAxis == xAxis) {
      return isRightDirection && validatePawnVerticalMovement(board, xAxis, yAxis);

    } else if (absoluteDifferenceX(xAxis) == 1) {
      return isRightDirection && validatePawnDiagonalMovement(board, xAxis, yAxis);
    }

    return false;
  }

  private boolean validateMovementDirection(char xAxis, char yAxis) {
    if (this.isWhite && this.yAxis > yAxis) {
      return false;
    }

    if (!this.isWhite && this.yAxis < yAxis) {
      return false;
    }

    return true;
  }

  private boolean validatePawnDiagonalMovement(ChessPiece[][] board, char xAxis, char yAxis) {
    if (this.absoluteDifferenceY(yAxis) != 1) {
      return false;
    }

    int xDirection = moveDirectionX(xAxis);
    int row = indexOfY(this.yAxis);
    int col = indexOfX((char) (this.xAxis - xDirection));
    int res = this.isWhite ? 1 : -1;

    if (col < 0 || col > 7) {
      return false;
    }

    if (board[row - res][col] == null) {
      return false;
    }
    return true;
  }

  private boolean validatePawnVerticalMovement(ChessPiece[][] board, char xAxis, char yAxis) {
    if (this.absoluteDifferenceY(yAxis) == 1) {
      int row = indexOfY(this.yAxis);
      int col = indexOfX(this.xAxis);
      int res = this.isWhite ? 1 : -1;

      if (row - res < 0 || row + res > 7) {
        return false;
      }

      if (board[row - res][col] != null) {
        return false;
      }
      return true;
    } else if (this.absoluteDifferenceY(yAxis) == 2) {
      int col = indexOfX(this.xAxis);

      if (this.isWhite) {
        return validateWhitePawnFirstMovement(board, col);
      }
      return validateBlackPawnFirstMovement(board, col);
    }

    return false;
  }

  private boolean validateWhitePawnFirstMovement(ChessPiece[][] board, int col) {
    if (this.isWhite && this.yAxis == '2' && board[5][col] == null && board[4][col] == null) {
      return true;
    }

    return false;

  }

  private boolean validateBlackPawnFirstMovement(ChessPiece[][] board, int col) {
    if (!this.isWhite && this.yAxis == '7' && board[2][col] == null && board[3][col] == null) {
      return true;
    }

    return false;
  }

  @Override
  public char getClassSymbol() {
    return Pawn.symbol;
  }
}