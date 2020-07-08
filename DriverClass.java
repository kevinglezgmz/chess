import Chess.GameEngine;

public class DriverClass {

  public static void main(String[] args) {
    GameEngine game = new GameEngine();
    game.startGame();
    // Quick way to test all possible movements for a piece
    // ChessPiece[][] board = new ChessPiece[8][8];
    // board[1][3] = new Pawn('d', '7', false);
    // int count = 0;
    // for (char i = 'a'; i <= 'h'; i++) {
    // for (char j = '1'; j <= '8'; j++) {
    // System.out.println(i + "" + j + ": " + board[1][3].isValidMovement(board, i,
    // j));
    // if (board[1][3].isValidMovement(board, i, j))
    // count++;
    // }
    // }
    // System.out.println(count);
  }
}