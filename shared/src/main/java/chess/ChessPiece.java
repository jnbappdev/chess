package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    private ChessGame.TeamColor teamColor;
    private ChessPiece.PieceType pieceType;
    public ChessPiece(ChessGame.TeamColor teamColor, ChessPiece.PieceType pieceType) {
        this.teamColor = teamColor;
        this.pieceType = pieceType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return teamColor == that.teamColor && pieceType == that.pieceType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamColor, pieceType);
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "teamColor=" + teamColor +
                ", pieceType=" + pieceType +
                '}';
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return teamColor;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return pieceType;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
//        this says we now havea  collection that we can store and it stores chessmoves, called possible moves
        Collection<ChessMove> possibleMoves = new ArrayList<>();

//        1. is the piece staying on the board *
//        2. is the piece moving to an empty space **
//        3. is the piece going to capture another piece ***

        if(this.pieceType == PieceType.ROOK){
            if((myPosition.getRow() >= 1 && myPosition.getRow() < 8) && (myPosition.getColumn() <= 8 && myPosition.getColumn() >= 1)){

            }
//  want to make sure that the row and column are each not greater than 8
//  location I move to is not filled by same color piece OR should I just test for any piece at all
            ChessPosition newRookPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
        } else if(this.pieceType == PieceType.KNIGHT){
            if((myPosition.getRow() >= 1 && myPosition.getRow() < 8) && (myPosition.getColumn() <= 8 && myPosition.getColumn() >= 1)){

            }
            ChessPosition newKingPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
        } else if(this.pieceType == PieceType.BISHOP){
            if((myPosition.getRow() >= 1 && myPosition.getRow() < 8) && (myPosition.getColumn() <= 8 && myPosition.getColumn() >= 1)){

            }
            ChessPosition newKingPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
        } else if(this.pieceType == PieceType.QUEEN){
            if((myPosition.getRow() >= 1 && myPosition.getRow() < 8) && (myPosition.getColumn() <= 8 && myPosition.getColumn() >= 1)){

            }
            ChessPosition newKingPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
        } else if(this.pieceType == PieceType.KING){
            if((myPosition.getRow() >= 1 && myPosition.getRow() < 8) && (myPosition.getColumn() <= 8 && myPosition.getColumn() >= 1)){
                ChessPosition frontMove = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn());
                ChessPiece frontpiece = board.getPiece(frontMove);
                if (frontpiece == null) { // will return null if empty **
                    possibleMoves.add(new ChessMove(myPosition, frontMove, null));
//                    still need to check if it hits the 8th rank for white, or 1st for black if it can promote you put options
                }
                if (frontpiece.teamColor != board.getPiece(myPosition).teamColor) {
                    possibleMoves.add(new ChessMove(myPosition, frontMove, null));
                }

//                KING RIGHT
                ChessPosition rightMove = new ChessPosition(myPosition.getRow(), myPosition.getColumn()+1);
                ChessPiece rightPiece = board.getPiece(rightMove);
                if(rightPiece != null){
                    possibleMoves.add(new ChessMove(myPosition, rightMove, null));
                }

//                KING LEFT
                ChessPosition leftMove = new ChessPosition(myPosition.getRow(), myPosition.getColumn()-1);
                ChessPiece leftPiece = board.getPiece(leftMove);
                if(leftPiece != null){
                    possibleMoves.add(new ChessMove(myPosition, leftMove, null));
                }

//                KING DIAGONAL RIGHT
                ChessPosition diagonalRightMove = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()-1);
                ChessPiece diagonalRightPiece = board.getPiece(diagonalRightMove);
                if(diagonalRightPiece != null){
                    possibleMoves.add(new ChessMove(myPosition, diagonalRightMove, null));
                }
//                KING DIAGONAL LEFT
                ChessPosition diagonalLeftMove = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
                ChessPiece diagonalLeftPiece = board.getPiece(diagonalLeftMove);
                if(diagonalLeftPiece != null){
                    possibleMoves.add(new ChessMove(myPosition, diagonalLeftMove, null));
                }
//                KING DIAGONAL BOTTOM RIGHT
                ChessPosition diagonalBottomRightMove = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()+1);
                ChessPiece diagonalBottomRightPiece = board.getPiece(diagonalRightMove);
                if(diagonalBottomRightPiece != null){
                    possibleMoves.add(new ChessMove(myPosition, diagonalBottomRightMove, null));
                }
//                KING DIAGONAL BOTTOM LEFT
                ChessPosition diagonalBottomLeftMove = new ChessPosition(myPosition.getRow()-1, myPosition.getColumn()-1);
                ChessPiece diagonalBottomLeftPiece = board.getPiece(diagonalBottomLeftMove);
                if(diagonalBottomLeftPiece != null){
                    possibleMoves.add(new ChessMove(myPosition, diagonalBottomLeftMove, null));
                }
            }
            ChessPosition newKingPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
        } else if(this.pieceType == PieceType.PAWN) {
            if((myPosition.getRow() >= 1 && myPosition.getRow() < 8) && (myPosition.getColumn() <= 8 && myPosition.getColumn() >= 1)) {
//                how do I check if the space is empty or filled with another piece (the same team)
//                FRONT MOVE
                ChessPosition frontMove = new ChessPosition(myPosition.getRow() + 1, myPosition.getColumn());
                ChessPiece frontpiece = board.getPiece(frontMove);
                if (frontpiece == null) { // will return null if empty **
                    possibleMoves.add(new ChessMove(myPosition, frontMove, null));
//                    still need to check if it hits the 8th rank for white, or 1st for black if it can promote you put options
                    if (frontpiece.getPieceType() == null) {
                        possibleMoves.add(new ChessMove(myPosition, myPosition, PieceType.QUEEN));
                        possibleMoves.add(new ChessMove(myPosition, myPosition, PieceType.ROOK));
                        possibleMoves.add(new ChessMove(myPosition, myPosition, PieceType.KNIGHT));
                        possibleMoves.add(new ChessMove(myPosition, myPosition, PieceType.BISHOP));
                    }
                }
//                DIAGONAL RIGHT
                ChessPosition diagonalRightMove = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()-1);
                ChessPiece diagonalRightPiece = board.getPiece(diagonalRightMove);
                if(diagonalRightPiece != null){
                    possibleMoves.add(new ChessMove(myPosition, diagonalRightMove, null));
                }
//                DIAGONAL LEFT
                ChessPosition diagonalLeftMove = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
                ChessPiece diagonalLeftPiece = board.getPiece(diagonalLeftMove);
                if(diagonalLeftPiece != null){
                    possibleMoves.add(new ChessMove(myPosition, diagonalLeftMove, null));
                }
//              ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                if (frontpiece.teamColor != board.getPiece(myPosition).teamColor){
                    frontpiece = board.getPiece(myPosition);
//              3. is the piece going to capture another piece ***
//                    set the old space to equal the new piece
//                    board[[1][3]] = null;
                }
//              +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//                QUESTIONS TO ASK NEXT TIME
//                - How do you check to make sure the direction the piece is going is not outside of the board
//                but also not just checking for null because that could just be an empty space
//                - Difference between "null" and "out of bounds"?


            }
        }
        return new ArrayList<ChessMove>(
                // all possible move positions of each chess piece on the board
        );
    }
}
