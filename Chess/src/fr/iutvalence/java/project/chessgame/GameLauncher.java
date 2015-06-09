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
            Game theGame = new Game();
            new GameGUI(theGame).setVisible(true);
      }
}
