package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import fr.iutvalence.java.project.chessgame.Echiquier;
import fr.iutvalence.java.project.chessgame.Game;


public class GameGUI extends JFrame implements ActionListener
{
      // attributs
      public static GameGUI gameGUI;

      static final int WIDTH = 350, HEIGHT = 350;

      public static JPanel joueur1;

      public static JPanel joueur2;

      private JSplitPane splitGame, splitEchiquier, splitGame1, splitGame2, splitTemps, splitQuitLoad, splitJoueur;

      private JMenuBar menu;

      private JButton menuB = new JButton("Menu");

      public JButton undoB = new JButton("Undo");

      private JButton loadB = new JButton("Charger une partie");

      private JButton saveB = new JButton("Sauvgarder une partie");

      private BoardGUI boardGui;

      private final Echiquier board;

      private final Game theGame;

      public GameGUI(Game game)
      {
            // Affichage de la fenêtre
            this.setTitle("Blitzkrieg");
            this.setSize(1200, 800);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setAlwaysOnTop(false);
            this.setUndecorated(true);

            JPanel quitLoad = new JPanel();
            JPanel coor1 = new JPanel();
            JPanel coor2 = new JPanel();
            JPanel divers = new JPanel();
            JPanel temps = new JPanel();
            GameGUI.joueur1 = new JPanel();
            GameGUI.joueur2 = new JPanel();

            this.menuB.setBackground(Color.WHITE);
            this.loadB.setBackground(Color.WHITE);
            this.saveB.setBackground(Color.WHITE);
            this.undoB.setBackground(Color.WHITE);

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

            Font police = new Font("Arial", Font.BOLD, 50);
            joueur1.add(new JLabel(FieldPlayerGUI.player1Name)).setFont(police);
            joueur2.add(new JLabel(FieldPlayerGUI.player2Name)).setFont(police);

            temps.setLayout(new GridLayout(1, 1));
            temps.add(new JLabel(new ImageIcon(getClass().getResource("/img/bois.png"))));

            this.board = game.getBoard();
            this.theGame = game;

            // Affichage de l'echiquier
            this.boardGui = new BoardGUI(this);
            this.boardGui.setLayout(new GridLayout(Echiquier.NOMBRE_DE_CASES_PAR_LIGNES, Echiquier.NOMBRE_DE_CASES_PAR_COLONNES));
            this.add(boardGui);

            quitLoad.setLayout(new GridLayout(4, 0));
            quitLoad.add(this.undoB);
            quitLoad.add(this.loadB);
            quitLoad.add(this.saveB);
            quitLoad.add(this.menuB);

            joueur1.setBackground(Color.WHITE);
            joueur2.setBackground(Color.LIGHT_GRAY);

            JSplitPane splitPlayerDisplay = new JSplitPane(JSplitPane.VERTICAL_SPLIT, joueur1, joueur2);
            splitPlayerDisplay.setDividerSize(0);
            splitPlayerDisplay.setDividerLocation(100);

            splitTemps = new JSplitPane(JSplitPane.VERTICAL_SPLIT, temps, quitLoad);
            splitTemps.setDividerSize(0);
            splitTemps.setDividerLocation(400);

            splitJoueur = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPlayerDisplay, splitTemps);
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
            this.setVisible(true);

            this.undoB.addActionListener(new ActionListener()
            {

                  @Override
                  public void actionPerformed(ActionEvent e)
                  {
                        BoardGUI.undo();
                  }
            });
            this.menuB.addActionListener(new ActionListener()
            {

                  @Override
                  public void actionPerformed(ActionEvent e)
                  {
                        dispose();
                        MenuGUI menu = new MenuGUI();
                        menu.setVisible(true);
                        MenuGUI.menuGUI = menu;
                  }
            });
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
            // NOTHING TODO

      }

      /**
       * @return the board
       */
      public Echiquier getBoard()
      {
            return board;
      }

      /**
       * @return the boardGui
       */
      public BoardGUI getBoardGui()
      {
            return boardGui;
      }

      /**
       * @return the theGame
       */
      public Game getTheGame()
      {
            return theGame;
      }
}