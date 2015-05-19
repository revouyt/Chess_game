package fr.iutvalence.java.project.chessgame;


/**
 * The game launcher
 *
 * @author Jocelyn
 *
 */
public class GameLauncher
{
      /**
       * Game's board
       */
      public Echiquier board;

      /**
       * Créer une partie de jeux d'échec
       *
       * @param board the board of the game
       */
      public GameLauncher()
      {
            this.board = new Echiquier();
      }

      /**
       * Determine if it is the end of the game
       *
       * @return false if the game isn't over
       */
      private boolean isEndOfGame()
      {
            return true;
      }

      /**
       * Progress of the game
       */
      public void play()
      {
            while (!isEndOfGame())
            {

            }

      }
}
