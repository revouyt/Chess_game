package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import fr.iutvalence.java.project.chessgame.Echiquier;
import fr.iutvalence.java.project.chessgame.ListPieces;
import fr.iutvalence.java.project.chessgame.Position;


/**
 * Créer et afficher l'échiquier
 */
public class BoardGUI extends JPanel implements ActionListener
{
      // private PieceGUI images = null;

      private static HashMap<Position, SquareButton> buttonsPosition = new HashMap<Position, SquareButton>();

      public static List<SquareButton> PossiblePosition = new ArrayList<SquareButton>();

      private Image imageCourante = null;

      public BoardGUI()
      {
            this.putAllButtons();
            this.putAllInitialPieces();
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
            SquareButton currentPiece = ((SquareButton) e.getSource());
            this.imageCourante = currentPiece.getPiece();
            this.cleanSelectedButton(this.PossiblePosition);
            if (this.imageCourante != null)
            {
                  Thread t = new Thread()
                  {
                        @Override
                        public void run()
                        {
                              if (currentPiece.getPiece() == null)
                              {
                                    // currentPiece.paintComponent(new
                                    // ImageIcon(this.getClass().getResource("img/caseBlanche.png").get));
                              }
                              else if (currentPiece.getPiece() == PieceGUI.piecesImage.get(ListPieces.BLACK_KING)
                                          || currentPiece.getPiece() == PieceGUI.piecesImage.get(ListPieces.WHITE_KING))
                              {

                              }
                              else
                              {

                                    ListIterator<Position> li = Echiquier.square.get(currentPiece.getPosition()).getPiece()
                                                .possibleMovements(currentPiece.getPosition()).listIterator();
                                    SquareButton button;
                                    while (li.hasNext())
                                    {
                                          button = BoardGUI.buttonsPosition.get(li.next());
                                          BoardGUI.PossiblePosition.add(button);
                                          System.out.println(li.next());
                                          button.isSelected = true;
                                    }
                                    repaint();
                                    /*
                                     * if (this.imageCourante == null) {
                                     * this.imageCourante =
                                     * currentPiece.getPiece();
                                     * currentPiece.setPiece(null); } else { if
                                     * (currentPiece.getPiece() == null) {
                                     * currentPiece
                                     * .setPiece(this.imageCourante);
                                     * this.imageCourante = null;
                                     * currentPiece.repaint(); } }
                                     */
                              }
                        }
                  };
                  SwingUtilities.invokeLater(t);
            }

      }

      private void cleanSelectedButton(List<SquareButton> list)
      {
            Thread thread = new Thread()
            {
                  @Override
                  public void run()
                  {
                        ListIterator<SquareButton> li = list.listIterator();
                        while (li.hasNext())
                        {
                              li.next().isSelected = false;
                        }
                        repaint();
                  }
            };
            SwingUtilities.invokeLater(thread);
      }

      /*
       * @Override public void paint(final Graphics pGraph) { }
       */

      public void putAllButtons()
      {

            // les bouttons
            SquareButton currentButton;

            for (int lignCounter = 0; lignCounter < Echiquier.NOMBRE_DE_LIGNES; lignCounter++)
            {
                  for (int columnCounter = 0; columnCounter < Echiquier.NOMBRE_DE_COLONNES; columnCounter++)
                  {

                        // couleurs de l'échiquier
                        if ((lignCounter + columnCounter) % 2 == 0)
                        {
                              currentButton = new SquareButton(Color.DARK_GRAY, lignCounter, columnCounter);

                        }
                        else
                        {
                              currentButton = new SquareButton(Color.white, lignCounter, columnCounter);
                        }
                        currentButton.addActionListener(this);
                        this.buttonsPosition.put(new Position(lignCounter, columnCounter), currentButton);
                        this.add(currentButton);
                  }
            }
      }

      private void putAllInitialPieces()
      {

            // les pièces

            new PieceGUI();

            // blanches
            this.buttonsPosition.get(new Position(7, 0)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_ROOK));
            this.buttonsPosition.get(new Position(7, 1)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_KNIGHT));
            this.buttonsPosition.get(new Position(7, 2)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_BISHOP));
            this.buttonsPosition.get(new Position(7, 3)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_QUEEN));
            this.buttonsPosition.get(new Position(7, 4)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_KING));
            this.buttonsPosition.get(new Position(7, 5)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_BISHOP));
            this.buttonsPosition.get(new Position(7, 6)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_KNIGHT));
            this.buttonsPosition.get(new Position(7, 7)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_ROOK));

            // pions
            for (int pions = 0; pions < Echiquier.NOMBRE_DE_COLONNES; pions++)
            {
                  this.buttonsPosition.get(new Position(6, pions)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_PAWN));
                  this.buttonsPosition.get(new Position(1, pions)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_PAWN));
            }

            // noires
            this.buttonsPosition.get(new Position(0, 0)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_ROOK));
            this.buttonsPosition.get(new Position(0, 1)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_KNIGHT));
            this.buttonsPosition.get(new Position(0, 2)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_BISHOP));
            this.buttonsPosition.get(new Position(0, 3)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_QUEEN));
            this.buttonsPosition.get(new Position(0, 4)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_KING));
            this.buttonsPosition.get(new Position(0, 5)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_BISHOP));
            this.buttonsPosition.get(new Position(0, 6)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_KNIGHT));
            this.buttonsPosition.get(new Position(0, 7)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_ROOK));

      }
}
