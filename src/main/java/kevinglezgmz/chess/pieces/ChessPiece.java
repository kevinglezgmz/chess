package kevinglezgmz.chess.pieces;

public abstract class ChessPiece {
  protected boolean isWhite;
  protected char xAxis;
  protected char yAxis;

  public ChessPiece(char xAxis, char yAxis, boolean isWhite) {
    this.xAxis = xAxis;
    this.yAxis = yAxis;
    this.isWhite = isWhite;
  }

  protected abstract boolean validateMovement(ChessPiece[][] board, char xAxis, char yAxis);

  public abstract char getClassSymbol();

  public boolean isValidMovement(ChessPiece[][] board, char xAxis, char yAxis) {
    if (!isValidPosition(xAxis, yAxis)) {
      return false;
    } else {
      return validateMovement(board, xAxis, yAxis);
    }
  }

  public boolean isValidPosition(char xAxis, char yAxis) {
    if (this.xAxis == xAxis && this.yAxis == yAxis) {
      return false;
    }
    return isValidTile(xAxis, yAxis);
  }

  public void setPosition(char xAxis, char yAxis) {
    this.xAxis = xAxis;
    this.yAxis = yAxis;
  }

  public boolean isWhite() {
    return isWhite;
  }

  public static boolean isValidTile(char xAxis, char yAxis) {
    boolean isInsideXAxis = xAxis >= 'a' && xAxis <= 'h';
    boolean isInsideYAxis = yAxis >= '1' && yAxis <= '8';

    return isInsideXAxis && isInsideYAxis;
  }

  public char[] getPosition() {
    return new char[] { this.xAxis, this.yAxis };
  }

  public int absoluteDifferenceX(char xAxis) {
    return Math.abs(this.xAxis - xAxis);
  }

  public int absoluteDifferenceY(char yAxis) {
    return Math.abs(this.yAxis - yAxis);
  }

  protected int moveDirectionX(char xAxis) {
    return xAxis < this.xAxis ? 1 : -1;
  }

  protected int moveDirectionY(char yAxis) {
    return yAxis < this.yAxis ? 1 : -1;
  }

  public static int indexOfX(char xAxis) {
    return xAxis - 'a';
  }

  public static int indexOfY(char yAxis) {
    return 7 - (yAxis - '1');
  }

  protected boolean isLineWithClearPath(ChessPiece[][] board, char xAxis, char yAxis, int xDirection, int yDirection) {
    xAxis += xDirection;
    yAxis += yDirection;
    while (this.xAxis != xAxis || this.yAxis != yAxis) {
      System.out.println("Checking " + xAxis + "" + yAxis);
      int row = indexOfY(yAxis);
      int col = indexOfX(xAxis);
      if (board[row][col] != null)
        return false;
      xAxis += xDirection;
      yAxis += yDirection;
    }
    return true;
  }
}