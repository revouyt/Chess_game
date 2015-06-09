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
import fr.iutvalence.java.project.chessgame.AbstractPiece;
import fr.iutvalence.java.project.chessgame.ColorEnum;
import fr.iutvalence.java.project.chessgame.Echiquier;
import fr.iutvalence.java.project.chessgame.Game;
import fr.iutvalence.java.project.chessgame.King;
import fr.iutvalence.java.project.chessgame.ListPieces;
import fr.iutvalence.java.project.chessgame.Movement;
import fr.iutvalence.java.project.chessgame.PieceType;
import fr.iutvalence.java.project.chessgame.Position;


/**
 * Créer et afficher l'échiquier
 */
public class BoardGUI extends JPanel implements ActionListener
{
      // private PieceGUI images = null;

      private static HashMap<Position, SquareButton> buttonsPosition = new HashMap<Position, SquareButton>();

      public static List<SquareButton> PossiblePosition = new ArrayList<SquareButton>();

      private Image lastImage;

      private AbstractPiece lastPiece;

      private Game theGame;

      private Position lastPosition;

      public BoardGUI(Game game)
      {
            this.theGame = game;
            this.putAllButtons();
            this.putAllInitialPieces();
            this.lastImage = null;
            this.lastPiece = null;
            this.lastPosition = null;
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
            SquareButton currentPiece = ((SquareButton) e.getSource());
            Image currentImage = currentPiece.getPiece();
            if (this.lastPiece == null)
            {
                  if (currentImage != null)
                  {
                        this.lastPiece = Echiquier.square.get(currentPiece.getPosition()).getPiece();
                        this.lastPosition = currentPiece.getPosition();
                        this.lastImage = currentPiece.getPiece();
                        this.showPossibleTarget(currentPiece);
                  }
                  else
                  {
                  }
            }
            else
            {
                  if (this.lastPiece.getPieceType() == PieceType.KING)
                  {
                        if (this.lastPosition == currentPiece.getPosition())
                        {
                              this.cleanSelectedButton(BoardGUI.PossiblePosition);
                        }
                        else if (this.lastPiece.possibleMovements(this.lastPosition).contains(currentPiece.getPosition()))
                        {
                              if (currentPiece.getPosition().equals(King.ROQUE1))
                              {
                                    // on bouge le roi
                                    Echiquier.square.get(this.lastPosition).getPiece().itMoved();
                                    BoardGUI.buttonsPosition.get(this.lastPosition).setPiece(null);
                                    repaint();
                                    BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(this.lastImage);
                                    repaint();
                                    this.theGame.getBoard().deplacerPiece(this.lastPosition, currentPiece.getPosition());
                                    // on bouge la tour
                                    BoardGUI.buttonsPosition.get(new Position(0, 3)).setPiece(
                                                BoardGUI.buttonsPosition.get(new Position(0, 0)).getPiece());
                                    repaint();
                                    BoardGUI.buttonsPosition.get(new Position(0, 0)).setPiece(null);
                                    repaint();
                                    this.theGame.getBoard().deplacerPiece(new Position(0, 0), new Position(0, 3));
                                    theGame.get_moves().add(new Movement(this.lastPosition, King.ROQUE1));
                                    theGame.incrementCurrentMove();
                                    this.theGame.getBoard().getBlackKing().setKingPosition(King.ROQUE1);
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);

                              }
                              else if (currentPiece.getPosition().equals(King.ROQUE2))
                              {
                                    // on bouge le roi
                                    Echiquier.square.get(this.lastPosition).getPiece().itMoved();
                                    BoardGUI.buttonsPosition.get(this.lastPosition).setPiece(null);
                                    repaint();
                                    BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(this.lastImage);
                                    repaint();
                                    this.theGame.getBoard().deplacerPiece(this.lastPosition, currentPiece.getPosition());
                                    // on bouge la tour
                                    BoardGUI.buttonsPosition.get(new Position(0, 5)).setPiece(
                                                BoardGUI.buttonsPosition.get(new Position(0, 7)).getPiece());
                                    repaint();
                                    BoardGUI.buttonsPosition.get(new Position(0, 7)).setPiece(null);
                                    repaint();
                                    this.theGame.getBoard().deplacerPiece(new Position(0, 7), new Position(0, 5));
                                    theGame.get_moves().add(new Movement(this.lastPosition, King.ROQUE2));
                                    theGame.incrementCurrentMove();
                                    this.theGame.getBoard().getBlackKing().setKingPosition(King.ROQUE2);
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);
                              }
                              else if (currentPiece.getPosition().equals(King.ROQUE3))
                              {
                                    // on bouge le roi
                                    Echiquier.square.get(this.lastPosition).getPiece().itMoved();
                                    BoardGUI.buttonsPosition.get(this.lastPosition).setPiece(null);
                                    repaint();
                                    BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(this.lastImage);
                                    repaint();
                                    this.theGame.getBoard().deplacerPiece(this.lastPosition, currentPiece.getPosition());
                                    // on bouge la tour
                                    BoardGUI.buttonsPosition.get(new Position(7, 3)).setPiece(
                                                BoardGUI.buttonsPosition.get(new Position(7, 0)).getPiece());
                                    repaint();
                                    BoardGUI.buttonsPosition.get(new Position(7, 0)).setPiece(null);
                                    repaint();
                                    this.theGame.getBoard().deplacerPiece(new Position(7, 0), new Position(7, 3));
                                    theGame.get_moves().add(new Movement(this.lastPosition, King.ROQUE3));
                                    theGame.incrementCurrentMove();
                                    this.theGame.getBoard().getWhiteKing().setKingPosition(King.ROQUE3);
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);
                              }
                              else if (currentPiece.getPosition().equals(King.ROQUE4))
                              {
                                    // on bouge le roi
                                    Echiquier.square.get(this.lastPosition).getPiece().itMoved();
                                    BoardGUI.buttonsPosition.get(this.lastPosition).setPiece(null);
                                    repaint();
                                    BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(this.lastImage);
                                    repaint();
                                    this.theGame.getBoard().deplacerPiece(this.lastPosition, currentPiece.getPosition());
                                    // on bouge la tour
                                    BoardGUI.buttonsPosition.get(new Position(7, 5)).setPiece(
                                                BoardGUI.buttonsPosition.get(new Position(7, 7)).getPiece());
                                    repaint();
                                    BoardGUI.buttonsPosition.get(new Position(7, 7)).setPiece(null);
                                    repaint();
                                    this.theGame.getBoard().deplacerPiece(new Position(7, 7), new Position(7, 5));
                                    theGame.get_moves().add(new Movement(this.lastPosition, King.ROQUE4));
                                    theGame.incrementCurrentMove();
                                    this.theGame.getBoard().getWhiteKing().setKingPosition(King.ROQUE4);
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);
                              }
                              else
                              {
                                    Echiquier.square.get(this.lastPosition).getPiece().itMoved();
                                    BoardGUI.buttonsPosition.get(this.lastPosition).setPiece(null);
                                    repaint();
                                    BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(this.lastImage);
                                    repaint();
                                    this.theGame.getBoard().deplacerPiece(this.lastPosition, currentPiece.getPosition());
                                    theGame.get_moves().add(new Movement(this.lastPosition, currentPiece.getPosition()));
                                    theGame.incrementCurrentMove();
                                    if (this.lastPiece.obtenirCouleur() == ColorEnum.WHITE)
                                    {

                                          this.theGame.getBoard().getWhiteKing().setKingPosition(currentPiece.getPosition());
                                    }
                                    else
                                    {
                                          this.theGame.getBoard().getBlackKing().setKingPosition(currentPiece.getPosition());
                                    }
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);
                              }
                        }
                        else
                        {
                              if (currentPiece.getPiece() != null)
                              {
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);
                                    this.lastPiece = Echiquier.square.get(currentPiece.getPosition()).getPiece();
                                    this.lastPosition = currentPiece.getPosition();
                                    this.lastImage = currentPiece.getPiece();
                                    this.showPossibleTarget(currentPiece);
                              }
                        }
                  }
                  else
                  {
                        if (this.lastPosition == currentPiece.getPosition())
                        {
                              this.cleanSelectedButton(BoardGUI.PossiblePosition);
                        }
                        else if (this.lastPiece.possibleMovements(this.lastPosition).contains(currentPiece.getPosition()))
                        {
                              Echiquier.square.get(this.lastPosition).getPiece().itMoved();
                              BoardGUI.buttonsPosition.get(this.lastPosition).setPiece(null);
                              repaint();
                              BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(this.lastImage);
                              repaint();
                              this.theGame.getBoard().deplacerPiece(this.lastPosition, currentPiece.getPosition());
                              theGame.get_moves().add(new Movement(this.lastPosition, currentPiece.getPosition()));
                              theGame.incrementCurrentMove();
                              this.cleanSelectedButton(BoardGUI.PossiblePosition);
                        }
                        else
                        {
                              if (currentPiece.getPiece() != null)
                              {
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);
                                    this.lastPiece = Echiquier.square.get(currentPiece.getPosition()).getPiece();
                                    this.lastPosition = currentPiece.getPosition();
                                    this.lastImage = currentPiece.getPiece();
                                    this.showPossibleTarget(currentPiece);
                              }
                        }
                  }
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
            this.lastImage = null;
            this.lastPosition = null;
            this.lastPiece = null;
            SwingUtilities.invokeLater(thread);
      }

      public Image getimageCourante()
      {
            return this.lastImage;
      }

      public Position getLastPosition()
      {
            return this.lastPosition;
      }

      public AbstractPiece getPieceCourante()
      {
            return this.lastPiece;
      }

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
                              currentButton = new SquareButton(Color.WHITE, lignCounter, columnCounter);

                        }
                        else
                        {
                              currentButton = new SquareButton(Color.DARK_GRAY, lignCounter, columnCounter);
                        }
                        currentButton.addActionListener(this);
                        BoardGUI.buttonsPosition.put(new Position(lignCounter, columnCounter), currentButton);
                        this.add(currentButton);
                  }
            }
      }

      private void putAllInitialPieces()
      {

            // les pièces

            new PieceGUI();

            // blanches
            BoardGUI.buttonsPosition.get(new Position(7, 0)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_ROOK));
            BoardGUI.buttonsPosition.get(new Position(7, 1)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_KNIGHT));
            BoardGUI.buttonsPosition.get(new Position(7, 2)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_BISHOP));
            BoardGUI.buttonsPosition.get(new Position(7, 3)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_QUEEN));
            BoardGUI.buttonsPosition.get(new Position(7, 4)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_KING));
            BoardGUI.buttonsPosition.get(new Position(7, 5)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_BISHOP));
            BoardGUI.buttonsPosition.get(new Position(7, 6)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_KNIGHT));
            BoardGUI.buttonsPosition.get(new Position(7, 7)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_ROOK));

            // pions
            for (int pions = 0; pions < Echiquier.NOMBRE_DE_COLONNES; pions++)
            {
                  BoardGUI.buttonsPosition.get(new Position(6, pions)).setPiece(PieceGUI.piecesImage.get(ListPieces.WHITE_PAWN));
                  BoardGUI.buttonsPosition.get(new Position(1, pions)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_PAWN));
            }

            // noires
            BoardGUI.buttonsPosition.get(new Position(0, 0)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_ROOK));
            BoardGUI.buttonsPosition.get(new Position(0, 1)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_KNIGHT));
            BoardGUI.buttonsPosition.get(new Position(0, 2)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_BISHOP));
            BoardGUI.buttonsPosition.get(new Position(0, 3)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_QUEEN));
            BoardGUI.buttonsPosition.get(new Position(0, 4)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_KING));
            BoardGUI.buttonsPosition.get(new Position(0, 5)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_BISHOP));
            BoardGUI.buttonsPosition.get(new Position(0, 6)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_KNIGHT));
            BoardGUI.buttonsPosition.get(new Position(0, 7)).setPiece(PieceGUI.piecesImage.get(ListPieces.BLACK_ROOK));

      }

      public void showPossibleTarget(SquareButton currentPiece)
      {
            Thread t = new Thread()
            {
                  @Override
                  public void run()
                  {

                        ListIterator<Position> li = getPieceCourante().possibleMovements(currentPiece.getPosition()).listIterator();
                        SquareButton possibleMoveSquare;
                        if (currentPiece.getPiece() == null)
                        {
                              return;
                        }
                        else if (currentPiece.getPiece() == PieceGUI.piecesImage.get(ListPieces.BLACK_KING)
                                    || currentPiece.getPiece() == PieceGUI.piecesImage.get(ListPieces.WHITE_KING))
                        {
                              while (li.hasNext())
                              {
                                    possibleMoveSquare = BoardGUI.buttonsPosition.get(li.next());
                                    BoardGUI.PossiblePosition.add(possibleMoveSquare);
                                    possibleMoveSquare.isSelected = true;
                                    repaint();
                              }
                        }
                        else
                        {
                              while (li.hasNext())
                              {
                                    possibleMoveSquare = BoardGUI.buttonsPosition.get(li.next());
                                    BoardGUI.PossiblePosition.add(possibleMoveSquare);
                                    possibleMoveSquare.isSelected = true;
                                    repaint();
                              }
                        }
                  }
            };
            SwingUtilities.invokeLater(t);
      }
}
