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
        if(this.pieceType == PieceType.ROOK){
//  want to make sure that the row and column are each not greater than 8
//  location I move to is not filled by same color piece OR should I just test for any piece at all
            ChessPosition newRookPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
        } else if(this.pieceType == PieceType.KNIGHT){
            ChessPosition newKingPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
        } else if(this.pieceType == PieceType.BISHOP){
            ChessPosition newKingPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
        } else if(this.pieceType == PieceType.QUEEN){
            ChessPosition newKingPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
        } else if(this.pieceType == PieceType.KING){
            ChessPosition newKingPosition = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
        } else if(this.pieceType == PieceType.PAWN) {
            while((myPosition.getRow() >= 1 && myPosition.getRow() < 8) && (myPosition.getColumn() <= 8 && myPosition.getColumn() >= 1)){
                ChessPosition frontMove = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn());
                ChessPosition diagonalRightMove = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()-1);
                ChessPosition diagonalLeftMove = new ChessPosition(myPosition.getRow()+1, myPosition.getColumn()+1);
            }

        }
        return new ArrayList<ChessMove>(
                // all possible move positions of each chess piece on the board
        );
    }
}
