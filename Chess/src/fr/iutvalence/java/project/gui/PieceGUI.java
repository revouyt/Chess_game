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

      }
}
