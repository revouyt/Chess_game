package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class LoadGUI extends JFrame
{

      private JButton buttonLoad = new JButton("Charger");

      private JButton buttonMenu = new JButton("Menu");

      public LoadGUI()
      {
            this.setTitle("Blitzkrieg");
            this.setSize(800, 350);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setAlwaysOnTop(false);

            JPanel pane1 = new JPanel();
            JPanel pane3 = new JPanel();
            JPanel title = new JPanel();
            JPanel saves = new JPanel();
            JPanel buttons = new JPanel();

            Font police = new Font("Arial", Font.BOLD, 35);
            Font police2 = new Font("Arial", Font.BOLD, 25);
            title.add(new JLabel("Sauvegarde(s) réalisée(s)")).setFont(police);
            title.setBackground(Color.WHITE);
            pane3.add(new JLabel("Veuillez sélectionner une sauvegarde.")).setFont(police2);
            pane3.setBackground(Color.WHITE);
            pane1.setBackground(Color.WHITE);
            buttonLoad.setBackground(Color.WHITE);
            buttonMenu.setBackground(Color.WHITE);

            buttons.setLayout(new GridLayout(0, 2));
            buttons.add(buttonLoad);
            buttons.add(buttonMenu);

            JSplitPane splitButtons = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pane3, buttons);
            splitButtons.setDividerSize(2);
            splitButtons.setDividerLocation(600);

            JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pane1, saves);
            splitPane1.setDividerSize(2);
            splitPane1.setDividerLocation(50);

            JSplitPane splitPane3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane1, splitButtons);
            splitPane3.setDividerSize(0);
            splitPane3.setDividerLocation(200);

            JSplitPane splitTitle = new JSplitPane(JSplitPane.VERTICAL_SPLIT, title, splitPane3);
            splitTitle.setDividerSize(0);
            splitTitle.setDividerLocation(50);

            this.getContentPane().add(splitTitle);
      }
}