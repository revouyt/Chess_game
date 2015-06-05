package fr.iutvalence.java.project.gui;


import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;
import fr.iutvalence.java.project.chessgame.ListPieces;


public class PieceGUI
{
      public static HashMap<ListPieces, Image> piecesImage = new HashMap<ListPieces, Image>();

      public PieceGUI()
      {
            for (ListPieces pieceName : ListPieces.values())
            {
                  this.piecesImage.put(pieceName, new ImageIcon(getClass().getResource("/img/" + pieceName + ".png")).getImage());
            }
            /*
             * // WHITE this.piecesImage.put(ListPieces.WHITE_ROOK, new
             * ImageIcon
             * (getClass().getResource("/img/WHITE_ROOK.png")).getImage());
             * this.piecesImage.put(ListPieces.WHITE_KNIGHT, new
             * ImageIcon(getClass
             * ().getResource("/img/WHITE_KNIGHT.png")).getImage());
             * this.piecesImage.put(ListPieces.WHITE_BISHOP, new
             * ImageIcon(getClass
             * ().getResource("/img/WHITE_BISHOP.png")).getImage());
             * this.piecesImage.put(ListPieces.WHITE_QUEEN, new
             * ImageIcon(getClass
             * ().getResource("/img/WHITE_QUEEN.png")).getImage());
             * this.piecesImage.put(ListPieces.WHITE_KING, new
             * ImageIcon(getClass
             * ().getResource("/img/WHITE_KING.png")).getImage());
             * this.piecesImage.put(ListPieces.WHITE_PAWN, new
             * ImageIcon(getClass
             * ().getResource("/img/WHITE_PAWN.png")).getImage()); // BLACK
             * this.piecesImage.put(ListPieces.BLACK_ROOK, new
             * ImageIcon(getClass
             * ().getResource("/img/BLACK_ROOK.png")).getImage());
             * this.piecesImage.put(ListPieces.BLACK_KNIGHT, new
             * ImageIcon(getClass
             * ().getResource("/img/BLACK_KNIGHT.png")).getImage());
             * this.piecesImage.put(ListPieces.BLACK_BISHOP, new
             * ImageIcon(getClass
             * ().getResource("/img/BLACK_BISHOP.png")).getImage());
             * this.piecesImage.put(ListPieces.BLACK_QUEEN, new
             * ImageIcon(getClass
             * ().getResource("/img/BLACK_QUEEN.png")).getImage());
             * this.piecesImage.put(ListPieces.BLACK_KING, new
             * ImageIcon(getClass
             * ().getResource("/img/BLACK_KING.png")).getImage());
             * this.piecesImage.put(ListPieces.BLACK_PAWN, new
             * ImageIcon(getClass
             * ().getResource("/img/BLACK_PAWN.png")).getImage());
             */
      }
}
