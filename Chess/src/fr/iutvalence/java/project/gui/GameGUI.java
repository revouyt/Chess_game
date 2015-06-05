package fr.iutvalence.java.project.gui;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import fr.iutvalence.java.project.chessgame.Echiquier;
import fr.iutvalence.java.project.chessgame.Position;


public class GameGUI extends JFrame
{
      // attributs

      static final int WIDTH = 350, HEIGHT = 350;

      private HashMap<Position, JButton> pieceImage = new HashMap<Position, JButton>();

      private JPanel echiquier, annexe;

      private JMenuBar menu;

      private BoardGUI board;

      public GameGUI()
      {
            // Affichage de la fenêtre
            this.setTitle("jeu d'échecs");
            this.setSize(1500, 1100);
            this.setResizable(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setAlwaysOnTop(true);
            // this.setUndecorated(true);
            this.getContentPane().setLayout(new BorderLayout());

            // Affichage de l'echiquier
            this.board = new BoardGUI();
            this.board.setLayout(new GridLayout(Echiquier.NOMBRE_DE_LIGNES, Echiquier.NOMBRE_DE_COLONNES));
            this.add(board);

            // Affichage de l'annexe
            this.annexe = new JPanel();
            this.annexe.add(new JTextField(
                        "yololollololoollolloollolloollolloollolloollolloollolloollolloollolloollolloollolloollolloollolo"));
            this.add(annexe, BorderLayout.EAST);
      }
}
