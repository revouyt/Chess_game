package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Timer;
import fr.iutvalence.java.project.gui.BoardGUI;
import fr.iutvalence.java.project.gui.GameGUI;


public class Game
{
      /** Enumération des états possibles d'une partie. */
      public static enum State
      {
            /** En cours. */
            IN_PROGRESS,

            /** Victoire des noirs. */
            BLACK_MATES,

            /** Victoire des blancs. */
            WHITE_MATES,

            /** Pat. */
            STALEMATE,

            /**
             * Terminée suite à la répétition de la même position 3 fois ou
             * plus.
             */
            DRAWN_BY_TRIPLE_REPETITION,

            /** Terminée par la règle des 50 coups. */
            DRAWN_BY_50_MOVE_RULE;
      }

      /** Temps (en ms) alloué à un joueur, pour une partie. */
      private static final long GAME_DURATION = 15 * 60 * 1000;

      /** Mouvement courant (>= 0). */
      public static int currentMove;

      /** Liste des mouvements éxécutés. */
      public static List<Movement> _moves = new ArrayList<Movement>();

      /** Description du joueur noir. */
      private final Player blackPlayer;

      private boolean isWhiteTurn;

      /** Description du joueur blanc. */
      private final Player whitePlayer;

      /** Description du plateau. */
      private Echiquier board;

      private ColorEnum curPlayer;

      /** Valeur courante du compteur de temps des noirs. */
      long blackTimer;

      /** Timer de l'horloge. */
      private Timer timer;

      /** Dernier temps de jeu */
      private long lastTimerTick;

      private final GameGUI userInterface;

      // private BoardGUI graphicInterface;

      /** Valeur courante du compteur de temps des blancs. */
      long whiteTimer;

      /**
       * Instancie une nouvelle partie.
       */
      public Game()
      {
            this.blackPlayer = new Player(ColorEnum.BLACK);
            this.whitePlayer = new Player(ColorEnum.WHITE);
            this.itIsWhiteTurn();
            this.curPlayer = ColorEnum.WHITE;
            Game.currentMove = 0;
            this.board = new Echiquier();
            this.userInterface = new GameGUI(this);
      }

      private List<Position> canSomeOneHelp(ColorEnum color)
      {
            List<Position> allPossibleMoves = new ArrayList<Position>();
            List<Position> possibleMove;
            ListIterator<Position> li;
            for (Map.Entry<Position, AbstractPiece> entry : this.board.getAllPieces(color).entrySet())
            {
                  possibleMove = entry.getValue().possibleMovements(entry.getKey());
                  li = possibleMove.listIterator();
                  while (li.hasNext())
                  {
                        Echiquier.square.get(BoardGUI.getLastPosition()).getPiece().itMoved();
                        this.userInterface
                        .getTheGame()
                        .get_moves()
                        .add(new Movement(BoardGUI.getLastPosition(), li.next(), BoardGUI.getLastPiece(), Echiquier.square.get(
                                    li.next()).getPiece(), BoardGUI.getLastImage(), BoardGUI.buttonsPosition.get(li.next())
                                    .getPiece(), this.userInterface.getBoard()));
                        BoardGUI.buttonsPosition.get(BoardGUI.getLastPosition()).setPiece(null);
                        BoardGUI.buttonsPosition.get(BoardGUI.getLastPosition()).repaint();
                        BoardGUI.buttonsPosition.get(li.next()).setPiece(BoardGUI.getLastImage());
                        BoardGUI.buttonsPosition.get(li.next()).repaint();
                        this.userInterface.getTheGame().getBoard().deplacerPiece(entry.getKey(), li.next());
                        Game.currentMove++;
                        this.userInterface.getBoardGui().cleanSelectedButton(BoardGUI.PossiblePosition);
                        if (color == ColorEnum.WHITE)
                        {
                              King whiteKing = this.board.getWhiteKing();
                              if (whiteKing.isCheck(whiteKing.getKingPosition()))
                              {
                                    BoardGUI.undo();
                                    continue;
                              }
                              else
                              {
                                    BoardGUI.undo();
                                    allPossibleMoves.add(li.next());
                              }
                        }
                        else
                        {
                              King blackKing = this.board.getBlackKing();
                              if (blackKing.isCheck(blackKing.getKingPosition()))
                              {
                                    BoardGUI.undo();
                                    continue;
                              }
                              else
                              {
                                    BoardGUI.undo();
                                    allPossibleMoves.add(li.next());
                              }
                        }
                  }
            }
            return allPossibleMoves;
      }

      /**
       * @return the _moves
       */
       public List<Movement> get_moves()
       {
             return Game._moves;
       }

       /**
        * @return the board
        */
       public Echiquier getBoard()
       {
             return board;
       }

       /**
        * @return the curPlayer
        */
       public ColorEnum getCurPlayer()
       {
             return this.curPlayer;
       }

       /**
        * @return the currentMove
        */
       public int getCurrentMove()
       {
             return Game.currentMove;
       }

       /**
        * @return the userInterface
        */
       public GameGUI getUserInterface()
       {
             return userInterface;
       }

       /**
        * Determine if it is the end of the game
        *
        * @return false if the game isn't over
        */
       private boolean isEndOfGame(ColorEnum color)
       {
             if (color == ColorEnum.WHITE)
             {
                   King whiteKing = this.board.getWhiteKing();
                   if (whiteKing.isCheck(whiteKing.getKingPosition()) && whiteKing.possibleMovements(whiteKing.getKingPosition()).isEmpty()
                               && canSomeOneHelp(ColorEnum.WHITE).isEmpty())
                   {
                         return true;
                   }
             }
             else
             {
                   King blackKing = this.board.getBlackKing();
                   if (blackKing.isCheck(blackKing.getKingPosition()) && blackKing.possibleMovements(blackKing.getKingPosition()).isEmpty()
                               && canSomeOneHelp(ColorEnum.BLACK).isEmpty())
                   {
                         return true;
                   }
             }
             return false;
       }

       /**
        * @return the isWhiteTurn
        */
       public boolean isWhiteTurn()
       {
             return isWhiteTurn;
       }

       public void itIsBlackTurn()
       {
             this.isWhiteTurn = false;

       }

       public void itIsWhiteTurn()
       {
             this.isWhiteTurn = true;
       }

       /**
        * Progress of the game
        */
       public void play()
       {
             while (!isEndOfGame(ColorEnum.BLACK) || !isEndOfGame(ColorEnum.WHITE))
             {
                   ColorEnum playerCourant = this.getCurPlayer();
                   if (isWhiteTurn())
                   {
                         while (true)
                         {
                               if (this.curPlayer != playerCourant)
                               {
                                     break;
                               }
                         }

                   }
                   else
                   {
                         while (true)
                         {
                               if (this.curPlayer != playerCourant)
                               {
                                     break;
                               }
                         }
                         this.itIsWhiteTurn();
                   }

             }

       }

       /**
        * @param curPlayer the curPlayer to set
        */
       public void setCurPlayer(ColorEnum curPlayer)
       {
             this.curPlayer = curPlayer;
       }

       /**
        * @param isWhiteTurn the isWhiteTurn to set
        */
       public void setWhiteTurn(boolean isWhiteTurn)
       {
             this.isWhiteTurn = isWhiteTurn;
       }
}
