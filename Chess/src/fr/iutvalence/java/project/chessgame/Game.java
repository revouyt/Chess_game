package fr.iutvalence.java.project.chessgame;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
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

      /** Description du plateau. */
      public static Echiquier board;

      public static GameGUI userInterface;

      // public static List<Position> canSomeOneHelp(ColorEnum color, Echiquier
      // board, Game game)
      // {
      // List<Position> allPossibleMoves = new ArrayList<Position>();
      // List<Position> possibleMove;
      // ListIterator<Position> li;
      // Position posCourante;
      //
      // for (Map.Entry<Position, AbstractPiece> entry :
      // board.getAllPieces(color).entrySet())
      // {
      // possibleMove = entry.getValue().possibleMovements(entry.getKey());
      // li = possibleMove.listIterator();
      // while (li.hasNext())
      // {
      // posCourante = li.next();
      // game.getUserInterface().getBoardGui();
      // BoardGUI.setLastPiece(entry.getValue());
      // BoardGUI.setLastPosition(posCourante);
      // BoardGUI.setLastImage(BoardGUI.buttonsPosition.get(entry.getKey()).getPiece());
      // if (Echiquier.square.get(posCourante).getPiece() != null)
      // {
      // Game._moves.add(new Movement(BoardGUI.getLastPosition(), posCourante,
      // BoardGUI.getLastPiece(),
      // Echiquier.square.get(posCourante).getPiece(), BoardGUI.getLastImage(),
      // BoardGUI.buttonsPosition
      // .get(posCourante).getPiece(), board));
      // BoardGUI.buttonsPosition.get(BoardGUI.getLastPosition()).setPiece(null);
      // BoardGUI.buttonsPosition.get(BoardGUI.getLastPosition()).repaint();
      // BoardGUI.buttonsPosition.get(posCourante).setPiece(BoardGUI.getLastImage());
      // BoardGUI.buttonsPosition.get(posCourante).repaint();
      // board.deplacerPiece(entry.getKey(), posCourante);
      // Game.currentMove++;
      // Game.userInterface.getBoardGui().cleanSelectedButton(BoardGUI.PossiblePosition);
      // if (color == ColorEnum.WHITE)
      // {
      // King whiteKing = board.getWhiteKing();
      // if (whiteKing.isCheck(whiteKing.getKingPosition()))
      // {
      // BoardGUI.undo();
      // continue;
      // }
      // else
      // {
      // BoardGUI.undo();
      // allPossibleMoves.add(posCourante);
      // }
      // }
      // else
      // {
      // King blackKing = Game.board.getBlackKing();
      // if (blackKing.isCheck(blackKing.getKingPosition()))
      // {
      // BoardGUI.undo();
      // continue;
      // }
      // else
      // {
      // BoardGUI.undo();
      // allPossibleMoves.add(posCourante);
      // }
      // }
      // }
      // // move case vide
      // else
      // {
      // Game._moves.add(new Movement(BoardGUI.getLastPosition(), posCourante,
      // BoardGUI.getLastPiece(), null, BoardGUI
      // .getLastImage(), null, board));
      // BoardGUI.buttonsPosition.get(BoardGUI.getLastPosition()).setPiece(null);
      // BoardGUI.buttonsPosition.get(BoardGUI.getLastPosition()).repaint();
      // BoardGUI.buttonsPosition.get(posCourante).setPiece(BoardGUI.getLastImage());
      // BoardGUI.buttonsPosition.get(posCourante).repaint();
      // board.deplacerPiece(entry.getKey(), posCourante);
      // Game.currentMove++;
      // Game.userInterface.getBoardGui().cleanSelectedButton(BoardGUI.PossiblePosition);
      // if (color == ColorEnum.WHITE)
      // {
      // King whiteKing = board.getWhiteKing();
      // if (whiteKing.isCheck(whiteKing.getKingPosition()))
      // {
      // BoardGUI.undo();
      // continue;
      // }
      // else
      // {
      // BoardGUI.undo();
      // allPossibleMoves.add(posCourante);
      // }
      // }
      // else
      // {
      // King blackKing = Game.board.getBlackKing();
      // if (blackKing.isCheck(blackKing.getKingPosition()))
      // {
      // BoardGUI.undo();
      // continue;
      // }
      // else
      // {
      // BoardGUI.undo();
      // allPossibleMoves.add(posCourante);
      // }
      // }
      // }
      // }
      // }
      // return allPossibleMoves;
      // }

      public static ColorEnum curPlayer;

      public static ColorEnum lastPlayer;

      /** Description du joueur noir. */
      private final Player blackPlayer;

      private boolean isWhiteTurn;

      /** Description du joueur blanc. */
      private final Player whitePlayer;

      /** Valeur courante du compteur de temps des noirs. */
      long blackTimer;

      /** Timer de l'horloge. */
      private Timer timer;

      // private BoardGUI graphicInterface;

      /** Dernier temps de jeu */
      private long lastTimerTick;

      /** Valeur courante du compteur de temps des blancs. */
      long whiteTimer;

      /**
       * Instancie une nouvelle partie.
       */
      public Game()
      {
            Game.userInterface = new GameGUI(this);
            this.blackPlayer = new Player(ColorEnum.BLACK);
            this.whitePlayer = new Player(ColorEnum.WHITE);
            this.itIsWhiteTurn();
            Game.curPlayer = ColorEnum.WHITE;
            Game.lastPlayer = null;
            Game.currentMove = -1;
            Game.board = new Echiquier();
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
            return Game.curPlayer;
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
      public boolean isEndOfGame(ColorEnum color)
      {
            if (color == ColorEnum.WHITE)
            {
                  King whiteKing = Game.board.getWhiteKing();
                  if (whiteKing.isCheck(whiteKing.getKingPosition()) && whiteKing.possibleMovements(whiteKing.getKingPosition()).isEmpty())
                        // && canSomeOneHelp(ColorEnum.WHITE, this.board,
                        // this).isEmpty())
                  {
                        return true;
                  }
            }
            else
            {
                  King blackKing = Game.board.getBlackKing();
                  if (blackKing.isCheck(blackKing.getKingPosition()) && blackKing.possibleMovements(blackKing.getKingPosition()).isEmpty())
                        // && canSomeOneHelp(ColorEnum.BLACK, this.board,
                        // this).isEmpty())
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

            this.getUserInterface();
            GameGUI.joueur1.setBackground(Color.LIGHT_GRAY);
            this.getUserInterface();
            GameGUI.joueur2.setBackground(Color.WHITE);
            this.isWhiteTurn = false;

      }

      public void itIsWhiteTurn()
      {

            this.getUserInterface();
            GameGUI.joueur1.setBackground(Color.WHITE);
            this.getUserInterface();
            GameGUI.joueur2.setBackground(Color.LIGHT_GRAY);
            this.isWhiteTurn = true;
      }

      /**
       * Progress of the game
       */
      // public void play()
      // {
      // this.blackTimer = GAME_DURATION;
      // this.whiteTimer = GAME_DURATION;
      // System.out.println("temps des blackos : " + this.blackTimer);
      // System.out.println("temps des ptits blancs : " + this.whiteTimer);
      // if (this.timer != null)
      // {
      // this.timer.cancel();
      // }
      // this.timer = new Timer();
      // this.lastTimerTick = System.currentTimeMillis();
      // this.timer.scheduleAtFixedRate(new TimerTask()
      // {
      //
      // /**
      // * Action déclenchée périodiquement par le timer gérant
      // * l'horloge.
      // */
      // @Override
      // public void run()
      // {
      // if (!isEndOfGame(ColorEnum.BLACK) && !isEndOfGame(ColorEnum.WHITE))
      // {
      // final long time = System.currentTimeMillis();
      // if (isWhiteTurn())
      // {
      // System.out.println("temps des ptits  : " + whiteTimer);
      // // whiteTimer -= time - lastTimerTick;
      // while (true)
      // {
      // if (Game.curPlayer != ColorEnum.WHITE)
      // {
      // break;
      // }
      // }
      // itIsBlackTurn();
      // }
      // else
      // {
      // System.out.println("temps des blackos : " + blackTimer);
      // // blackTimer -= time - lastTimerTick;
      // while (true)
      // {
      // if (Game.curPlayer != ColorEnum.BLACK)
      // {
      // break;
      // }
      // }
      // itIsWhiteTurn();
      // }
      // // lastTimerTick = time;
      // if (Game.lastPlayer == ColorEnum.WHITE)
      // {
      // System.out.println("Bravo! " + GameGUI.joueur1 + "vous avez gagnez!");
      // }
      // else
      // {
      // System.out.println("Bravo! " + GameGUI.joueur2 + "vous avez gagnez!");
      // }
      // }
      //
      // else
      // {
      // return;
      // }
      // }
      // }, 250, 1000);
      //
      // }

      /**
       * @param curPlayer the curPlayer to set
       */
      public void setCurPlayer(ColorEnum curPlayer)
      {
            Game.curPlayer = curPlayer;
      }

      public void setLastPlayer(ColorEnum color)
      {
            Game.lastPlayer = color;

      }

      /**
       * @param isWhiteTurn the isWhiteTurn to set
       */
      public void setWhiteTurn(boolean isWhiteTurn)
      {
            this.isWhiteTurn = isWhiteTurn;
      }
}
