package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import fr.iutvalence.java.project.chessgame.Game;


public class FieldPlayerGUI extends JFrame implements ActionListener
{

      public static Game game;

      public static String player1Name = "";

      public static String player2Name = "";

      public static JTextField player1 = new JTextField();

      public static JTextField player2 = new JTextField();

      private JButton buttonPlay = new JButton("Jouer");

      private JButton buttonCancel = new JButton("Annuler");

      public FieldPlayerGUI()
      {

            this.setTitle("Blitzkrieg");
            this.setSize(400, 200);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setAlwaysOnTop(false);
            this.setUndecorated(true);

            JPanel title = new JPanel();
            JPanel players = new JPanel();

            Font police = new Font("Arial", Font.BOLD, 35);
            title.add(new JLabel("Noms des joueurs")).setFont(police);

            player1.setFont(police);
            player2.setFont(police);

            players.setLayout(new GridLayout(2, 2));
            players.add(player1);
            players.add(player2);
            players.add(buttonPlay);
            players.add(buttonCancel);

            buttonPlay.setBackground(Color.WHITE);
            buttonCancel.setBackground(Color.WHITE);
            title.setBackground(Color.WHITE);
            player1.setBackground(Color.WHITE);
            player2.setBackground(Color.WHITE);

            JSplitPane splitTitle = new JSplitPane(JSplitPane.VERTICAL_SPLIT, title, players);
            splitTitle.setDividerSize(0);
            splitTitle.setDividerLocation(80);

            this.getContentPane().add(splitTitle);

            this.buttonPlay.addActionListener(new ActionListener()
            {

                  @Override
                  public void actionPerformed(ActionEvent e)
                  {
                        dispose();
                        player2Name = player2.getText();
                        player1Name = player1.getText();
                        MenuGUI.menuGUI.dispose();
                        FieldPlayerGUI.game = new Game();

                  }
            });

            this.buttonCancel.addActionListener(new ActionListener()
            {

                  @Override
                  public void actionPerformed(ActionEvent e)
                  {
                        dispose();
                  }
            });

      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
            
      }
}