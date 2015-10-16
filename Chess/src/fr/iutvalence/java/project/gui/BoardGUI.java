package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JFrame;
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

      public static HashMap<Position, SquareButton> buttonsPosition = new HashMap<Position, SquareButton>();

      public static List<SquareButton> PossiblePosition = new ArrayList<SquareButton>();

      private static Image lastImage;

      private static AbstractPiece lastPiece;

      private static Position lastPosition;

      public static JFrame PopUpWin;

      /**
       * @return the lastImage
       */
      public static Image getLastImage()
      {
            return lastImage;
      }

      /**
       * @return the lastPiece
       */
      public static AbstractPiece getLastPiece()
      {
            return lastPiece;
      }

      public static Position getLastPosition()
      {
            return BoardGUI.lastPosition;
      }

      /**
       * @param lastImage the lastImage to set
       */
      public static void setLastImage(Image lastImage)
      {
            BoardGUI.lastImage = lastImage;
      }

      /**
       * @param lastPiece the lastPiece to set
       */
      public static void setLastPiece(AbstractPiece lastPiece)
      {
            BoardGUI.lastPiece = lastPiece;
      }

      /**
       * @param lastPosition the lastPosition to set
       */
      public static void setLastPosition(Position lastPosition)
      {
            BoardGUI.lastPosition = lastPosition;
      }

      public static void undo()
      {
            Thread graphicT = new Thread()
            {

                  @Override
                  public void run()
                  {
                        if (Game.currentMove >= 0)
                        {
                              try
                              {
                                    Movement lastMovement = Game._moves.get(Game.currentMove);
                                    if (BoardGUI.PopUpWin != null)
                                    {
                                          BoardGUI.PopUpWin.setVisible(false);
                                    }
                                    if (lastMovement.getInitialPositionTour() != null || lastMovement.getFinalPositionTour() != null)
                                    {

                                          BoardGUI.buttonsPosition.get(lastMovement.getInitialPosition()).setPiece(
                                                      lastMovement.getInitialPositionImage());
                                          BoardGUI.buttonsPosition.get(lastMovement.getInitialPosition()).repaint();
                                          BoardGUI.buttonsPosition.get(lastMovement.getInitialPositionTour()).setPiece(lastMovement.Tour);
                                          BoardGUI.buttonsPosition.get(lastMovement.getInitialPositionTour()).repaint();

                                          BoardGUI.buttonsPosition.get(lastMovement.getFinalPosition()).setPiece(null);
                                          BoardGUI.buttonsPosition.get(lastMovement.getFinalPosition()).repaint();
                                          BoardGUI.buttonsPosition.get(lastMovement.getFinalPositionTour()).setPiece(null);
                                          BoardGUI.buttonsPosition.get(lastMovement.getFinalPositionTour()).repaint();

                                          lastMovement.board.deplacerPiece(lastMovement.getFinalPosition(),
                                                      lastMovement.getInitialPosition());
                                          lastMovement.board.deplacerPiece(lastMovement.getFinalPositionTour(),
                                                      lastMovement.getInitialPositionTour());
                                          Echiquier.square.get(lastMovement.getInitialPosition()).getPiece().itDidntMoved();
                                          Echiquier.square.get(lastMovement.getInitialPositionTour()).getPiece().itDidntMoved();
                                    }
                                    else
                                    {
                                          lastMovement.getInitialPositionPiece().itDidntMoved();
                                          // on dessine la pièce déplacée
                                          // à sa
                                          // position d'origine
                                          BoardGUI.buttonsPosition.get(lastMovement.getInitialPosition()).setPiece(
                                                      lastMovement.getInitialPositionImage());
                                          BoardGUI.buttonsPosition.get(lastMovement.getInitialPosition()).repaint();
                                          // on dessine la pièce mangée à
                                          // sa
                                          // position d'origine
                                          BoardGUI.buttonsPosition.get(lastMovement.getFinalPosition()).setPiece(
                                                      lastMovement.getFinalPositionImage());
                                          BoardGUI.buttonsPosition.get(lastMovement.getFinalPosition()).repaint();
                                          // on place la pièce déplacée
                                          // à sa
                                          // position d'origine
                                          Echiquier.poserPiece(lastMovement.board, lastMovement.getInitialPosition(),
                                                      lastMovement.getInitialPositionPiece());
                                          // on dessine la pièce déplacée
                                          // à sa
                                          // position d'origine
                                          Echiquier.poserPiece(lastMovement.board, lastMovement.getFinalPosition(),
                                                      lastMovement.getFinalPositionPiece());
                                    }
                                    if (lastMovement.getInitialPositionPiece().getPieceName() == ListPieces.BLACK_KING)
                                    {
                                          lastMovement.board.getBlackKing().setKingPosition(lastMovement.getInitialPosition());
                                    }
                                    else if (lastMovement.getInitialPositionPiece().getPieceName() == ListPieces.WHITE_KING)
                                    {
                                          lastMovement.board.getBlackKing().setKingPosition(lastMovement.getInitialPosition());
                                    }
                                    BoardGUI.lastImage = null;
                                    BoardGUI.lastPiece = null;
                                    BoardGUI.lastPosition = null;
                                    if (Game.currentMove == 0)
                                    {
                                          Game.curPlayer = ColorEnum.WHITE;
                                          Game.lastPlayer = ColorEnum.BLACK;

                                          GameGUI.joueur1.setBackground(Color.WHITE);
                                          GameGUI.joueur2.setBackground(Color.LIGHT_GRAY);
                                    }
                                    else
                                    {
                                          if (GameGUI.joueur1.getBackground() == Color.WHITE)
                                          {

                                                GameGUI.joueur2.setBackground(Color.WHITE);
                                                GameGUI.joueur1.setBackground(Color.LIGHT_GRAY);
                                          }
                                          else
                                          {

                                                GameGUI.joueur1.setBackground(Color.WHITE);
                                                GameGUI.joueur2.setBackground(Color.LIGHT_GRAY);
                                          }
                                          Game.curPlayer = Game.lastPlayer;
                                    }
                                    Game._moves.remove(Game.currentMove);
                              }
                              catch (IndexOutOfBoundsException e)
                              {
                              }
                        }
                        else
                        {
                              return;
                        }

                        Game.currentMove--;

                  }
            };
            SwingUtilities.invokeLater(graphicT);
      }

      private GameGUI theUserInterface;

      public BoardGUI(GameGUI userInterface)
      {
            this.theUserInterface = userInterface;
            this.putAllButtons();
            this.putAllInitialPieces();
            BoardGUI.lastImage = null;
            BoardGUI.lastPiece = null;
            BoardGUI.lastPosition = null;
            BoardGUI.PopUpWin = null;
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {

            SquareButton currentPiece = ((SquareButton) e.getSource());
            Image currentImage = currentPiece.getPiece();
            if (BoardGUI.lastPiece == null)
            {
                  // clic case non vide
                  if (currentImage != null)
                  {
                        this.cleanSelectedButton(BoardGUI.PossiblePosition);
                        this.showOwnMove(e);
                  }
            }

            // clic piece, essaie deplacement
            else
            {
                  // clic roi, essaie deplacement
                  if (BoardGUI.lastPiece.getPieceType() == PieceType.KING)
                  {
                        if (BoardGUI.lastPosition == currentPiece.getPosition())
                        {
                              this.cleanSelectedButton(BoardGUI.PossiblePosition);
                        }
                        // deplacement valide roi
                        else if (BoardGUI.lastPiece.possibleMovements(BoardGUI.lastPosition).contains(currentPiece.getPosition()))
                        {
                              if (currentPiece.getPosition().equals(King.ROQUE1))
                              {
                                    // on bouge le roi
                                    Echiquier.square.get(BoardGUI.lastPosition).getPiece().itMoved();
                                    this.theUserInterface.getTheGame().get_moves()
                                    .add(new Movement("ROQUE1", this.theUserInterface.getBoard()));
                                    BoardGUI.buttonsPosition.get(BoardGUI.lastPosition).setPiece(null);
                                    repaint();
                                    BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(BoardGUI.lastImage);
                                    repaint();
                                    this.theUserInterface.getTheGame().getBoard()
                                    .deplacerPiece(BoardGUI.lastPosition, currentPiece.getPosition());
                                    // on bouge la tour
                                    BoardGUI.buttonsPosition.get(new Position(0, 3)).setPiece(
                                                BoardGUI.buttonsPosition.get(new Position(0, 0)).getPiece());
                                    repaint();
                                    BoardGUI.buttonsPosition.get(new Position(0, 0)).setPiece(null);
                                    repaint();
                                    this.theUserInterface.getTheGame().getBoard().deplacerPiece(new Position(0, 0), new Position(0, 3));

                                    Game.currentMove++;
                                    this.theUserInterface.getBoard().getBlackKing().setKingPosition(King.ROQUE1);
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);
                                    if (this.theUserInterface.getTheGame().getCurPlayer() == ColorEnum.WHITE)
                                    {
                                          this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.BLACK);
                                          this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.WHITE);
                                          this.theUserInterface.getTheGame().itIsBlackTurn();
                                    }
                                    else
                                    {
                                          this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.WHITE);
                                          this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.BLACK);
                                          this.theUserInterface.getTheGame().itIsWhiteTurn();
                                    }

                              }
                              else if (currentPiece.getPosition().equals(King.ROQUE2))
                              {
                                    // on bouge le roi
                                    Echiquier.square.get(BoardGUI.lastPosition).getPiece().itMoved();
                                    this.theUserInterface.getTheGame().get_moves()
                                    .add(new Movement("ROQUE2", this.theUserInterface.getBoard()));
                                    BoardGUI.buttonsPosition.get(BoardGUI.lastPosition).setPiece(null);
                                    repaint();
                                    BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(BoardGUI.lastImage);
                                    repaint();
                                    this.theUserInterface.getBoard().deplacerPiece(BoardGUI.lastPosition, currentPiece.getPosition());
                                    // on bouge la tour
                                    BoardGUI.buttonsPosition.get(new Position(0, 5)).setPiece(
                                                BoardGUI.buttonsPosition.get(new Position(0, 7)).getPiece());
                                    repaint();
                                    BoardGUI.buttonsPosition.get(new Position(0, 7)).setPiece(null);
                                    repaint();
                                    this.theUserInterface.getTheGame().getBoard().deplacerPiece(new Position(0, 7), new Position(0, 5));

                                    Game.currentMove++;
                                    this.theUserInterface.getBoard().getBlackKing().setKingPosition(King.ROQUE2);
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);
                                    if (this.theUserInterface.getTheGame().getCurPlayer() == ColorEnum.WHITE)
                                    {
                                          this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.BLACK);
                                          this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.WHITE);
                                          this.theUserInterface.getTheGame().itIsBlackTurn();
                                    }
                                    else
                                    {
                                          this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.WHITE);
                                          this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.BLACK);
                                          this.theUserInterface.getTheGame().itIsWhiteTurn();
                                    }
                              }
                              else if (currentPiece.getPosition().equals(King.ROQUE3))
                              {
                                    // on bouge le roi
                                    Echiquier.square.get(BoardGUI.lastPosition).getPiece().itMoved();
                                    this.theUserInterface.getTheGame().get_moves()
                                    .add(new Movement("ROQUE3", this.theUserInterface.getBoard()));
                                    BoardGUI.buttonsPosition.get(BoardGUI.lastPosition).setPiece(null);
                                    repaint();
                                    BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(BoardGUI.lastImage);
                                    repaint();
                                    this.theUserInterface.getBoard().deplacerPiece(BoardGUI.lastPosition, currentPiece.getPosition());
                                    // on bouge la tour
                                    BoardGUI.buttonsPosition.get(new Position(7, 3)).setPiece(
                                                BoardGUI.buttonsPosition.get(new Position(7, 0)).getPiece());
                                    repaint();
                                    BoardGUI.buttonsPosition.get(new Position(7, 0)).setPiece(null);
                                    repaint();
                                    this.theUserInterface.getTheGame().getBoard().deplacerPiece(new Position(7, 0), new Position(7, 3));

                                    Game.currentMove++;
                                    this.theUserInterface.getBoard().getWhiteKing().setKingPosition(King.ROQUE3);
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);
                                    if (this.theUserInterface.getTheGame().getCurPlayer() == ColorEnum.WHITE)
                                    {
                                          this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.BLACK);
                                          this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.WHITE);
                                          this.theUserInterface.getTheGame().itIsBlackTurn();
                                    }
                                    else
                                    {
                                          this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.WHITE);
                                          this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.BLACK);
                                          this.theUserInterface.getTheGame().itIsWhiteTurn();
                                    }
                              }
                              else if (currentPiece.getPosition().equals(King.ROQUE4))
                              {
                                    // on bouge le roi
                                    Echiquier.square.get(BoardGUI.lastPosition).getPiece().itMoved();
                                    this.theUserInterface.getTheGame().get_moves()
                                    .add(new Movement("ROQUE4", this.theUserInterface.getBoard()));
                                    BoardGUI.buttonsPosition.get(BoardGUI.lastPosition).setPiece(null);
                                    repaint();
                                    BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(BoardGUI.lastImage);
                                    repaint();
                                    this.theUserInterface.getBoard().deplacerPiece(BoardGUI.lastPosition, currentPiece.getPosition());
                                    // on bouge la tour
                                    BoardGUI.buttonsPosition.get(new Position(7, 5)).setPiece(
                                                BoardGUI.buttonsPosition.get(new Position(7, 7)).getPiece());
                                    repaint();
                                    BoardGUI.buttonsPosition.get(new Position(7, 7)).setPiece(null);
                                    repaint();
                                    this.theUserInterface.getTheGame().getBoard().deplacerPiece(new Position(7, 7), new Position(7, 5));

                                    Game.currentMove++;
                                    this.theUserInterface.getBoard().getWhiteKing().setKingPosition(King.ROQUE4);
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);
                                    if (this.theUserInterface.getTheGame().getCurPlayer() == ColorEnum.WHITE)
                                    {
                                          this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.BLACK);
                                          this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.WHITE);
                                          this.theUserInterface.getTheGame().itIsBlackTurn();
                                    }
                                    else
                                    {
                                          this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.WHITE);
                                          this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.BLACK);
                                          this.theUserInterface.getTheGame().itIsWhiteTurn();
                                    }
                              }
                              // deplacement roi != roque
                              else
                              {
                                    Echiquier.square.get(BoardGUI.lastPosition).getPiece().itMoved();
                                    this.theUserInterface
                                    .getTheGame()
                                    .get_moves()
                                    .add(new Movement(BoardGUI.lastPosition, currentPiece.getPosition(), BoardGUI.lastPiece,
                                                Echiquier.square.get(currentPiece.getPosition()).getPiece(),
                                                BoardGUI.lastImage, currentPiece.getPiece(), this.theUserInterface.getBoard()));
                                    BoardGUI.buttonsPosition.get(BoardGUI.lastPosition).setPiece(null);
                                    repaint();
                                    BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(BoardGUI.lastImage);
                                    repaint();
                                    this.theUserInterface.getTheGame().getBoard()
                                    .deplacerPiece(BoardGUI.lastPosition, currentPiece.getPosition());
                                    if (BoardGUI.lastPiece.obtenirCouleur() == ColorEnum.WHITE)
                                    {

                                          this.theUserInterface.getBoard().getWhiteKing().setKingPosition(currentPiece.getPosition());
                                    }
                                    else
                                    {
                                          this.theUserInterface.getBoard().getBlackKing().setKingPosition(currentPiece.getPosition());
                                    }
                                    Game.currentMove++;
                                    this.cleanSelectedButton(BoardGUI.PossiblePosition);
                                    if (this.theUserInterface.getTheGame().getCurPlayer() == ColorEnum.WHITE)
                                    {
                                          this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.BLACK);
                                          this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.WHITE);
                                          this.theUserInterface.getTheGame().itIsBlackTurn();
                                    }
                                    else
                                    {
                                          this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.WHITE);
                                          this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.BLACK);
                                          this.theUserInterface.getTheGame().itIsWhiteTurn();
                                    }
                              }
                        }
                        // clic sur une autre pièce a partir du roi
                        else
                        {
                              this.cleanSelectedButton(BoardGUI.PossiblePosition);
                              this.showOwnMove(e);
                        }
                  }
                  else
                  {
                        if (BoardGUI.lastPosition == currentPiece.getPosition())
                        {
                              this.cleanSelectedButton(BoardGUI.PossiblePosition);
                        }
                        else if (BoardGUI.lastPiece.possibleMovements(BoardGUI.lastPosition).contains(currentPiece.getPosition()))
                        {
                              Echiquier.square.get(BoardGUI.lastPosition).getPiece().itMoved();
                              this.theUserInterface
                              .getTheGame()
                              .get_moves()
                              .add(new Movement(BoardGUI.lastPosition, currentPiece.getPosition(), BoardGUI.lastPiece,
                                          Echiquier.square.get(currentPiece.getPosition()).getPiece(), BoardGUI.lastImage,
                                          currentPiece.getPiece(), this.theUserInterface.getBoard()));
                              BoardGUI.buttonsPosition.get(BoardGUI.lastPosition).setPiece(null);
                              repaint();
                              BoardGUI.buttonsPosition.get(currentPiece.getPosition()).setPiece(BoardGUI.lastImage);
                              repaint();
                              this.theUserInterface.getTheGame().getBoard()
                              .deplacerPiece(BoardGUI.lastPosition, currentPiece.getPosition());
                              Game.currentMove++;
                              this.cleanSelectedButton(BoardGUI.PossiblePosition);
                              if (this.theUserInterface.getTheGame().getCurPlayer() == ColorEnum.WHITE)
                              {
                                    this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.BLACK);
                                    this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.WHITE);
                                    this.theUserInterface.getTheGame().itIsBlackTurn();
                              }
                              else
                              {
                                    this.theUserInterface.getTheGame().setCurPlayer(ColorEnum.WHITE);
                                    this.theUserInterface.getTheGame().setLastPlayer(ColorEnum.BLACK);
                                    this.theUserInterface.getTheGame().itIsWhiteTurn();
                              }
                        }
                        else
                        {
                              this.cleanSelectedButton(BoardGUI.PossiblePosition);
                              this.showOwnMove(e);
                        }
                  }
            }

            if (this.theUserInterface.getTheGame().isEndOfGame(ColorEnum.BLACK)
                        || this.theUserInterface.getTheGame().isEndOfGame(ColorEnum.WHITE))
            {
                  BoardGUI.PopUpWin = new PopUpWin();
                  BoardGUI.PopUpWin.setVisible(true);
            }
      }

      public void cleanSelectedButton(List<SquareButton> list)
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
            BoardGUI.lastImage = null;
            BoardGUI.lastPosition = null;
            BoardGUI.lastPiece = null;
            SwingUtilities.invokeLater(thread);
      }

      public Image getimageCourante()
      {
            return BoardGUI.lastImage;
      }

      public AbstractPiece getPieceCourante()
      {
            return BoardGUI.lastPiece;
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

      public void showOwnMove(ActionEvent e)
      {
            SquareButton currentPiece = ((SquareButton) e.getSource());
            // clic piece noire, affichage positions
            if (this.theUserInterface.getTheGame().getCurPlayer() == ColorEnum.BLACK)
            {
                  if (this.theUserInterface.getBoard().getAllPieces(ColorEnum.BLACK).containsKey(currentPiece.getPosition()))
                  {
                        
                        BoardGUI.lastPiece = Echiquier.square.get(currentPiece.getPosition()).getPiece();
                        BoardGUI.lastPosition = currentPiece.getPosition();
                        BoardGUI.lastImage = currentPiece.getPiece();
                        this.showPossibleTarget(currentPiece);

                     
                  }
            }
           
            else
            {
                  if (this.theUserInterface.getBoard().getAllPieces(ColorEnum.WHITE).containsKey(currentPiece.getPosition()))
                  {
                        
                        BoardGUI.lastPiece = Echiquier.square.get(currentPiece.getPosition()).getPiece();
                        BoardGUI.lastPosition = currentPiece.getPosition();
                        BoardGUI.lastImage = currentPiece.getPiece();
                        this.showPossibleTarget(currentPiece);

                      
                  }
            }
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
