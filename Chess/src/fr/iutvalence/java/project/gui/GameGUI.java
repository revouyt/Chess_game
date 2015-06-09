package fr.iutvalence.java.project.gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import fr.iutvalence.java.project.chessgame.Echiquier;


public class GameGUI extends JFrame
{
      // attributs

      static final int WIDTH = 350, HEIGHT = 350;

      private JPanel echiquier, annexe;

      private JMenuBar menu;

      private BoardGUI boardGui;

      private Echiquier board;

      public GameGUI(Echiquier board)
      {
            // Affichage de la fenêtre
            this.setTitle("jeu d'échecs");
            this.setSize(700, 700);
            this.setResizable(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setAlwaysOnTop(true);
            this.getContentPane().setLayout(new BorderLayout());
            this.board = board;

            // Affichage de l'echiquier
            this.boardGui = new BoardGUI(this.board);
            this.boardGui.setLayout(new GridLayout(Echiquier.NOMBRE_DE_LIGNES, Echiquier.NOMBRE_DE_COLONNES));
            this.add(boardGui);

            // Affichage de l'annexe
            this.annexe = new JPanel();
            this.annexe.add(new JTextField("yololollololoollollllolloollolloollolloollolloollolloollolloollolo"));
            this.add(annexe, BorderLayout.EAST);
      }
}
