package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import fr.iutvalence.java.project.chessgame.Game;


public class PopUpWin extends JFrame implements ActionListener
{
      public PopUpWin()
      {
            this.setTitle("Blitzkrieg");
            this.setSize(225, 70);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setAlwaysOnTop(true);
            this.setUndecorated(true);
            this.setBackground(Color.ORANGE);
            Font police = new Font("Arial", Font.BOLD, 35);

            JButton messageB = new JButton("Checkmate");
            messageB.addActionListener(this);

            messageB.setFont(police);
            this.add(messageB);
      }

      @Override
      public void actionPerformed(ActionEvent e)
      {
            dispose();
            Game.userInterface.setVisible(false);

      }
}
