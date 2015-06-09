package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


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

      /** Description du joueur noir. */
      private final Player blackPlayer;

      private boolean isWhiteTurn;

      /** Liste des mouvements éxécutés. */
      private List<Movement> _moves = new ArrayList<Movement>();

      /** Description du joueur blanc. */
      private final Player whitePlayer;

      /** Description du plateau. */
      private Echiquier board;

      /** Valeur courante du compteur de temps des noirs. */
      long blackTimer;

      /** Mouvement courant (>= 0). */
      private int currentMove;

      /** Timer de l'horloge. */
      private Timer timer;

      /** Dernier temps de jeu */
      private long lastTimerTick;

      /** Valeur courante du compteur de temps des blancs. */
      long whiteTimer;

      /**
       * Instancie une nouvelle partie.
       */
      public Game()
      {
            this.isWhiteTurn = true;
            this.currentMove = 0;
            this.board = new Echiquier();
            this.blackPlayer = new Player(ColorEnum.BLACK);
            this.whitePlayer = new Player(ColorEnum.WHITE);
      }

      /**
       * @return the _moves
       */
      public List<Movement> get_moves()
      {
            return _moves;
      }

      /**
       * @return the board
       */
      public Echiquier getBoard()
      {
            return board;
      }

      /**
       * @return the currentMove
       */
      public int getCurrentMove()
      {
            return currentMove;
      }

      /**
       * @param currentMove +1
       */
      public void incrementCurrentMove()
      {
            this.currentMove++;
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
                  if (whiteKing.isCheck(whiteKing.getKingPosition()) && whiteKing.possibleMovements(whiteKing.getKingPosition()).isEmpty())
                  {
                        return true;
                  }
            }
            else
            {
                  King blackKing = this.board.getBlackKing();
                  if (blackKing.isCheck(blackKing.getKingPosition()) && blackKing.possibleMovements(blackKing.getKingPosition()).isEmpty())
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

      /**
       * Progress of the game
       */
      public void play()
      {
            while (!isEndOfGame(ColorEnum.BLACK) || !isEndOfGame(ColorEnum.WHITE))
            {

            }

      }

      /**
       * @param currentMove the currentMove to set
       */
      public void setCurrentMove(int currentMove)
      {
            this.currentMove = currentMove;
      }

      /**
       * @param isWhiteTurn the isWhiteTurn to set
       */
      public void setWhiteTurn(boolean isWhiteTurn)
      {
            this.isWhiteTurn = isWhiteTurn;
      }

}
