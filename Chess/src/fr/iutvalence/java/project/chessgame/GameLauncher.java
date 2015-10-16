package fr.iutvalence.java.project.chessgame;


import fr.iutvalence.java.project.gui.MenuGUI;



public class GameLauncher
{
      public static void main(String[] args)
      {
            MenuGUI menu = new MenuGUI();
            menu.setVisible(true);

            MenuGUI.menuGUI = menu;
      }
}
