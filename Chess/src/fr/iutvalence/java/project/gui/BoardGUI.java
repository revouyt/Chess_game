package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import fr.iutvalence.java.project.chessgame.Echiquier;
import fr.iutvalence.java.project.chessgame.ListPieces;


/**
 * Créer et afficher l'échiquier
 */
public class BoardGUI extends JPanel implements ActionListener
{
      private PieceGUI images;

      private Image imageCourante = null;

      private List<SquareButton> buttons = new ArrayList<SquareButton>();

      // private Image caseBlanche = new
      // ImageIcon(getClass().getResource("/img/caseBlanc.png")).getImage();

      // private Image caseNoire = new
      // ImageIcon(getClass().getResource("/img/caseNoir.png")).getImage();

      public BoardGUI()
      {

            // les bouttons
            SquareButton currentButton;
            boolean isWhite = true;

            for (int lignCounter = 0; lignCounter < Echiquier.NOMBRE_DE_LIGNES; lignCounter++)
            {
                  for (int columnCounter = 0; columnCounter < Echiquier.NOMBRE_DE_COLONNES; columnCounter++)
                  {
                        currentButton = new SquareButton();
                        currentButton.addActionListener(this);
                        buttons.add(currentButton);

                        // couleurs de l'échiquier
                        if (isWhite)
                        {
                              currentButton.setBackground(Color.DARK_GRAY);
                        }
                        else
                        {
                              currentButton.setBackground(Color.white);
                        }
                        isWhite = !isWhite;

                        this.add(currentButton);
                  }
                  isWhite = !isWhite;
            }

            // les pièces

            images = new PieceGUI();

            // blanches
            this.buttons.get(56).setPiece(images.piecesImage.get(ListPieces.WHITE_ROOK));
            this.buttons.get(57).setPiece(images.piecesImage.get(ListPieces.WHITE_KNIGHT));
            this.buttons.get(58).setPiece(images.piecesImage.get(ListPieces.WHITE_BISHOP));
            this.buttons.get(59).setPiece(images.piecesImage.get(ListPieces.WHITE_QUEEN));
            this.buttons.get(60).setPiece(images.piecesImage.get(ListPieces.WHITE_KING));
            this.buttons.get(61).setPiece(images.piecesImage.get(ListPieces.WHITE_BISHOP));
            this.buttons.get(62).setPiece(images.piecesImage.get(ListPieces.WHITE_KNIGHT));
            this.buttons.get(63).setPiece(images.piecesImage.get(ListPieces.WHITE_ROOK));

            for (int pions = 48; pions < 56; pions++)
            {
                  this.buttons.get(pions).setPiece(images.piecesImage.get(ListPieces.WHITE_PAWN));
            }

            // noires
            this.buttons.get(0).setPiece(images.piecesImage.get(ListPieces.BLACK_ROOK));
            this.buttons.get(1).setPiece(images.piecesImage.get(ListPieces.BLACK_KNIGHT));
            this.buttons.get(2).setPiece(images.piecesImage.get(ListPieces.BLACK_BISHOP));
            this.buttons.get(3).setPiece(images.piecesImage.get(ListPieces.BLACK_QUEEN));
            this.buttons.get(4).setPiece(images.piecesImage.get(ListPieces.BLACK_KING));
            this.buttons.get(5).setPiece(images.piecesImage.get(ListPieces.BLACK_BISHOP));
            this.buttons.get(6).setPiece(images.piecesImage.get(ListPieces.BLACK_KNIGHT));
            this.buttons.get(7).setPiece(images.piecesImage.get(ListPieces.BLACK_ROOK));

            for (int pions = 8; pions < 16; pions++)
            {
                  this.buttons.get(pions).setPiece(images.piecesImage.get(ListPieces.BLACK_PAWN));
            }
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {

      }
}
