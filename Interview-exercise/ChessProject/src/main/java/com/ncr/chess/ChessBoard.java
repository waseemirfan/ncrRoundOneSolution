package com.ncr.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        try {
            boolean isEmptyAndLegal = pieces[xCoordinate][yCoordinate] == null && isLegalBoardPosition(xCoordinate, yCoordinate);
            pawn.setXCoordinate(isEmptyAndLegal ? xCoordinate : -1);
            pawn.setYCoordinate(isEmptyAndLegal ? yCoordinate : -1);
            pieces[xCoordinate][yCoordinate] = isEmptyAndLegal ? pawn : pieces[xCoordinate][yCoordinate];
            pawn.setPieceColor(pieceColor);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            pawn.setPieceColor(pieceColor);
        }
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= 0 && xCoordinate <= MAX_BOARD_WIDTH && yCoordinate >= 0 && yCoordinate <= MAX_BOARD_HEIGHT);
    }
}
