package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;


public class SettingGUI extends JFrame
{

      private JRadioButton music2 = new JRadioButton("ON");

      private JRadioButton music3 = new JRadioButton("OFF");

      private JButton menu = new JButton("Menu");

      private ButtonGroup onOff = new ButtonGroup();

      public SettingGUI()
      {
            this.setTitle("Blitzkrieg");
            this.setSize(350, 250);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setAlwaysOnTop(false);

            JPanel title = new JPanel();
            JPanel music = new JPanel();
            JPanel time1 = new JPanel();
            JPanel time2 = new JPanel();
            JPanel music1 = new JPanel();

            Font police = new Font("Arial", Font.BOLD, 35);
            Font police2 = new Font("Arial", Font.BOLD, 15);
            title.add(new JLabel("Paramètres")).setFont(police);
            title.setBackground(Color.WHITE);
            time1.add(new JLabel("Temps de jeu")).setFont(police2);
            time1.setBackground(Color.WHITE);
            time2.setBackground(Color.WHITE);
            music1.add(new JLabel("Musique")).setFont(police2);
            music1.setBackground(Color.WHITE);
            music2.setBackground(Color.WHITE);
            music3.setBackground(Color.WHITE);

            String[] selectTime = { "Lent (2 heures)", "Normal (1 heure)", "Blitzkrieg (30 minutes)" };

            JComboBox optionTime = new JComboBox();

            optionTime.setPreferredSize(new Dimension(150, 30));
            optionTime.addItem(selectTime[0]);
            optionTime.addItem(selectTime[1]);
            optionTime.addItem(selectTime[2]);

            time2.add(optionTime);

            music.setLayout(new GridLayout(1, 3));
            onOff.add(music2);
            onOff.add(music3);

            JSplitPane splitTimes = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, time1, time2);
            splitTimes.setDividerSize(0);
            splitTimes.setDividerLocation(150);

            JSplitPane splitMusics = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, music2, music3);
            splitMusics.setDividerSize(0);
            splitMusics.setDividerLocation(50);

            JSplitPane splitMusics2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, music1, splitMusics);
            splitMusics2.setDividerSize(0);
            splitMusics2.setDividerLocation(150);

            JSplitPane splitMusic = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitMusics2, menu);
            splitMusic.setDividerSize(1);
            splitMusic.setDividerLocation(50);

            JSplitPane splitTime = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitTimes, splitMusic);
            splitTime.setDividerSize(1);
            splitTime.setDividerLocation(50);

            JSplitPane splitSetting = new JSplitPane(JSplitPane.VERTICAL_SPLIT, title, splitTime);
            splitSetting.setDividerSize(1);
            splitSetting.setDividerLocation(75);

            this.getContentPane().add(splitSetting);

      }
}