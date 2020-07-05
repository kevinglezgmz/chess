package Pieces;

public abstract class ChessPiece {
  protected boolean isWhite = true;
  protected boolean isAlive = true;
  protected char xAxis = 'a';
  protected char yAxis = '1';

  public abstract boolean moveTo(ChessPiece[][] board, char xAxis, char yAxis);

  public abstract char getClassSymbol();

  public boolean isValidPosition(char xAxis, char yAxis) {
    if (xAxis < 'a' || xAxis > 'h' || yAxis < '1' || yAxis > '8' || (this.xAxis == xAxis && this.yAxis == yAxis))
      return false;
    return true;
  }

  public char get_xAxis() {
    return this.xAxis;
  }

  public char get_yAxis() {
    return this.yAxis;
  }

  protected void set_xAxis(char xAxis) {
    this.xAxis = xAxis;
  }

  protected void set_yAxis(char yAxis) {
    this.yAxis = yAxis;
  }

  public char[] getPosition() {
    return new char[] { this.xAxis, this.yAxis };
  }
}