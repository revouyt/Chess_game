package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import fr.iutvalence.java.project.chessgame.Echiquier;
import fr.iutvalence.java.project.chessgame.Game;


public class GameGUI extends JFrame
{
      // attributs

      static final int WIDTH = 350, HEIGHT = 350;

      private JSplitPane splitGame, splitEchiquier, splitGame1, splitGame2, splitTemps, splitQuitLoad, splitJoueur;

      private JMenuBar menu;

      private JButton quitB = new JButton("Quitter");

      private JButton loadB = new JButton("Charger une partie");

      private BoardGUI boardGui;

      private Echiquier board;

      private Game theGame;

      public GameGUI(Game game)
      {
            // Affichage de la fenêtre
            this.setTitle("jeu d'échecs");
            this.setSize(1200, 800);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setAlwaysOnTop(false);

            JPanel coor1 = new JPanel();
            JPanel coor2 = new JPanel();
            JPanel divers = new JPanel();
            JPanel joueur = new JPanel();
            JPanel temps = new JPanel();

            quitB.setBackground(Color.WHITE);
            loadB.setBackground(Color.WHITE);

            coor2.setLayout(new GridLayout(0, 8));
            for (int iNbCoor2 = 1; iNbCoor2 < 9; iNbCoor2++)
            {
                  coor2.add(new JLabel(new ImageIcon(getClass().getResource("/img/Coor2" + iNbCoor2 + ".png"))));
            }

            coor1.setLayout(new GridLayout(8, 0));
            for (int iNbCoor1 = 8; iNbCoor1 > 0; iNbCoor1--)
            {
                  coor1.add(new JLabel(new ImageIcon(getClass().getResource("/img/Coor1" + iNbCoor1 + ".png"))));
            }

            divers.setLayout(new GridLayout(1, 1));
            divers.add(new JLabel(new ImageIcon(getClass().getResource("/img/Divers.png"))));

            joueur.setLayout(new GridLayout(1, 1));
            joueur.setBackground(Color.WHITE);
            Font police = new Font("Arial", Font.BOLD, 50);
            joueur.add(new JTextField("Joueur")).setFont(police);
            joueur.add(new JTextField("Joueur")).setFont(police);

            temps.setLayout(new GridLayout(1, 1));
            temps.add(new JLabel(new ImageIcon(getClass().getResource("/img/bois.png"))));

            /*
             * JLabel labelCoor2 = new JLabel(new
             * ImageIcon(getClass().getResource( "/img/Coor2.png")));
             * coor2.add(labelCoor2); this.getContentPane().setLayout(new
             * BorderLayout());
             */

            this.board = game.getBoard();
            this.theGame = game;

            // Affichage de l'echiquier
            this.boardGui = new BoardGUI(this.theGame);
            this.boardGui.setLayout(new GridLayout(Echiquier.NOMBRE_DE_LIGNES, Echiquier.NOMBRE_DE_COLONNES));
            this.add(boardGui);

            splitQuitLoad = new JSplitPane(JSplitPane.VERTICAL_SPLIT, quitB, loadB);
            splitQuitLoad.setDividerSize(0);
            splitQuitLoad.setDividerLocation(75);

            splitTemps = new JSplitPane(JSplitPane.VERTICAL_SPLIT, temps, splitQuitLoad);
            splitTemps.setDividerSize(0);
            splitTemps.setDividerLocation(400);

            splitJoueur = new JSplitPane(JSplitPane.VERTICAL_SPLIT, joueur, splitTemps);
            splitJoueur.setDividerSize(0);
            splitJoueur.setDividerLocation(200);

            splitGame1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, coor1, boardGui);
            splitGame1.setDividerSize(0);
            splitGame1.setDividerLocation(25);

            splitGame2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, divers, coor2);
            splitGame2.setDividerSize(0);
            splitGame2.setDividerLocation(25);

            splitEchiquier = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitGame2, splitGame1);
            splitEchiquier.setDividerSize(0);
            splitEchiquier.setDividerLocation(25);

            splitGame = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitEchiquier, splitJoueur);
            splitGame.setDividerSize(0);
            splitGame.setDividerLocation(800);

            this.getContentPane().add(splitGame);

            /*
             * Affichage de l'annexe this.annexe = new JPanel();
             * this.annexe.add(new JTextField(
             * "yololollololoollollllolloollolloollolloollolloollolloollolloollolo"
             * )); this.add(annexe, BorderLayout.EAST);
             */
      }
}