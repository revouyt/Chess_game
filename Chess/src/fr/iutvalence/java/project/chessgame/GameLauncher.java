package fr.iutvalence.java.project.chessgame;


import fr.iutvalence.java.project.gui.GameGUI;


/**
 * The game launcher
 *
 * @author Jocelyn
 *
 */
public class GameLauncher
{
      public static void main(String[] args)
      {
            new Echiquier();
            new GameGUI().setVisible(true);
      }

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
