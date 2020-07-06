package Chess;

import Chess.ChessPieces.Pieces.*;

import java.io.IOException;
import java.util.Scanner;

import Chess.ChessPieces.*;

public class GameEngine {
  private boolean isPlayerOne;
  private ChessPiece[][] board;
  private static final Scanner sc = new Scanner(System.in);

  public GameEngine() {
    isPlayerOne = true;
    board = createBoard();
  }

  public static void clrscr() {
    // Clears Screen in java
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {
    }
  }

  public void drawBoard() {
    clrscr();
    System.out.println(this);
  }

  public void startGame() {
    char[] playerSelectedTile;
    char[] playerMoveToTile;
    while (true) {
      drawBoard();
      playerSelectedTile = handlePlayersPieceInput(isPlayerOne);
      if (hasPiece(playerSelectedTile)) {
        if (isPlayerPiece(isPlayerOne, playerSelectedTile)) {
          playerMoveToTile = handlePlayersMoveToInput();
          if (!canMovePieceTo(playerSelectedTile, playerMoveToTile, isPlayerOne)) {
            handleErrorMovingPiece();
            continue;
          }
        } else {
          handleNotPlayersPiece(isPlayerOne);
          continue;
        }
      } else {
        handleEmptyTile();
        continue;
      }
      isPlayerOne = !isPlayerOne;
    }
  }

  private int[] getMatrixIndexes(char[] selectedTile) {
    int[] coords = new int[2];
    coords[0] = ChessPiece.indexOfY(selectedTile[1]);
    coords[1] = ChessPiece.indexOfX(selectedTile[0]);
    return coords;
  }

  private ChessPiece getPiece(char[] selectedTile) {
    int[] coords = getMatrixIndexes(selectedTile);
    int row = coords[0];
    int col = coords[1];
    return board[row][col];
  }

  private void movePiece(char[] playerSelectedTile, char[] playerMoveToTile) {
    int[] pieceCoords = getMatrixIndexes(playerSelectedTile);
    int pieceRow = pieceCoords[0];
    int pieceCol = pieceCoords[1];
    int[] moveToCoords = getMatrixIndexes(playerMoveToTile);
    int moveToRow = moveToCoords[0];
    int moveToCol = moveToCoords[1];
    ChessPiece tmp = board[pieceRow][pieceCol];
    board[pieceRow][pieceCol] = null;
    board[moveToRow][moveToCol] = tmp;
    tmp.setPosition(playerMoveToTile[0], playerMoveToTile[1]);
  }

  private boolean canMovePieceTo(char[] playerSelectedTile, char[] playerMoveToTile, boolean isPlayerOne) {
    ChessPiece piece = getPiece(playerSelectedTile);
    ChessPiece moveToPiece = getPiece(playerMoveToTile);
    boolean isValidMovement = piece.isValidMovement(this.board, playerMoveToTile[0], playerMoveToTile[1]);
    System.out.println(isValidMovement);
    sc.nextLine();
    if (isValidMovement && moveToPiece == null) {
      movePiece(playerSelectedTile, playerMoveToTile);
      return true;
    } else if (isValidMovement && piece.isWhite() != moveToPiece.isWhite()) {
      movePiece(playerSelectedTile, playerMoveToTile);
      return true;
    } else {
      return false;
    }
  }

  private static void handleEmptyTile() {
    System.out.println("Selected tile does not have a piece in it or is out of range. Please try again.");
    enterToContinue();
  }

  private static void handleNotPlayersPiece(boolean isPlayerOne) {
    System.out
        .println("Selected piece does not belong to player " + (isPlayerOne ? "one" : "two") + ". Please try again.");
    enterToContinue();
  }

  private static void enterToContinue() {
    System.out.print("Press enter to continue...");
    sc.nextLine();
  }

  private boolean isPlayerPiece(boolean isPlayerOne, char[] playerSelectedTile) {
    ChessPiece piece = getPiece(playerSelectedTile);
    if (piece == null) {
      return false;
    } else {
      return piece.isWhite() == isPlayerOne;
    }
  }

  private boolean hasPiece(char[] playerSelectedTile) {
    ChessPiece piece = getPiece(playerSelectedTile);
    return piece != null;
  }

  private static void handleErrorMovingPiece() {
    System.out.println("Chosen movement is invalid. Please try again.");
    enterToContinue();
  }

  private static char[] handleInput(String message, String errMessage) {
    char[] selection = new char[2];
    String input = "";
    System.out.print(message);
    input = sc.nextLine();
    while (input.length() != 2 || !ChessPiece.isValidTile(input.charAt(0), input.charAt(1))) {
      System.out.print(errMessage);
      input = sc.nextLine();
    }
    selection[0] = input.charAt(0);
    selection[1] = input.charAt(1);
    return selection;
  }

  private static char[] handlePlayersPieceInput(boolean isPlayerOne) {
    String message = "\tWhat piece do you want to move?: ";
    String errMessage = "\tNot a valid input. What piece do you want to move?: ";
    System.out.println("Player " + (isPlayerOne ? "one" : "two") + "'s turn.");
    return handleInput(message, errMessage);
  }

  private static char[] handlePlayersMoveToInput() {
    String message = "\tWhere do you want to move your selected piece?: ";
    String errMessage = "\tNot a valid position. Where do you want to move the selected piece?: ";
    return handleInput(message, errMessage);
  }

  private static ChessPiece[][] createBoard() {
    ChessPiece[][] board = new ChessPiece[8][8];

    // set pawns
    for (char i = 'a'; i <= 'h'; i++) {
      int col = ChessPiece.indexOfX(i);
      // white pawns
      board[6][col] = new Pawn(i, '2', true);
      // black pawns
      board[1][col] = new Pawn(i, '7', false);
    }

    // set white rooks
    board[7][0] = new Rook('a', '1', true);
    board[7][7] = new Rook('h', '1', true);
    // set black rooks
    board[0][0] = new Rook('a', '8', false);
    board[0][7] = new Rook('h', '8', false);

    // set white knights
    board[7][1] = new Knight('b', '1', true);
    board[7][6] = new Knight('g', '1', true);
    // set black knights
    board[0][1] = new Knight('b', '8', false);
    board[0][6] = new Knight('g', '8', false);

    // set white bishops
    board[7][2] = new Bishop('c', '1', true);
    board[7][5] = new Bishop('f', '1', true);
    // set black bishops
    board[0][2] = new Bishop('c', '8', false);
    board[0][5] = new Bishop('f', '8', false);

    // set white king and queen
    board[7][3] = new King('d', '1', true);
    board[7][4] = new Queen('e', '1', true);
    // set black king and queen
    board[0][3] = new King('d', '8', false);
    board[0][4] = new Queen('e', '8', false);

    return board;
  }

  public String toString() {
    System.out.println();
    boolean isBrownTile = true;
    String text = "       a  b  c  d  e  f  g  h \n";
    for (int i = 0; i < 8; i++) {
      text += "    " + (8 - i) + " ";
      for (int j = 0; j < 8; j++) {
        text += (isBrownTile ? Colors.ANSI_BLUE_BACKGROUND : Colors.ANSI_CYAN_BACKGROUND) + " "
            + (board[i][j] == null ? ' '
                : (board[i][j].isWhite() ? Colors.ANSI_WHITE : Colors.ANSI_BLACK) + board[i][j].getClassSymbol())
            + " ";
        isBrownTile = !isBrownTile;
      }
      isBrownTile = !isBrownTile;
      text += Colors.ANSI_RESET + " " + (8 - i) + "\n";
    }
    text += "       a  b  c  d  e  f  g  h ";
    return text;
  }

  static class Colors {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

  }
}