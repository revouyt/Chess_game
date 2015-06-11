package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class MenuGUI extends JFrame implements ActionListener
{

      public static MenuGUI menuGUI;

      private JButton quit = new JButton("Quitter");

      private JButton play = new JButton("Jouer");

      private JButton load = new JButton("Charger");

      private JButton setting = new JButton("Option");

      public MenuGUI()
      {

            this.setTitle("Blitzkrieg");
            this.setSize(1200, 800);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setAlwaysOnTop(false);

            JPanel annexe1 = new JPanel();
            JPanel annexe2 = new JPanel();
            JPanel menu = new JPanel();
            JPanel blitzkrieg = new JPanel();

            play.setBackground(Color.WHITE);
            load.setBackground(Color.WHITE);
            quit.setBackground(Color.WHITE);
            setting.setBackground(Color.WHITE);

            blitzkrieg.add(new JLabel(new ImageIcon(getClass().getResource("/img/Blitzkrieg4.png"))));
            annexe1.add(new JLabel(new ImageIcon(getClass().getResource("/img/Blitzkrieg2.png"))));
            annexe2.add(new JLabel(new ImageIcon(getClass().getResource("/img/Blitzkrieg3.png"))));

            menu.setLayout(new GridLayout(4, 0));
            menu.add(play);
            menu.add(load);
            menu.add(setting);
            menu.add(quit);

            JSplitPane splitMenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, annexe1, menu);
            splitMenu.setDividerLocation(450);
            splitMenu.setDividerSize(0);

            JSplitPane splitAnnexe = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitMenu, annexe2);
            splitAnnexe.setDividerLocation(750);
            splitAnnexe.setDividerSize(0);

            JSplitPane splitBlitzkrieg = new JSplitPane(JSplitPane.VERTICAL_SPLIT, blitzkrieg, splitAnnexe);
            splitBlitzkrieg.setDividerLocation(400);
            splitBlitzkrieg.setDividerSize(0);

            this.getContentPane().add(splitBlitzkrieg);

            this.play.addActionListener(new ActionListener()
            {

                  @Override
                  public void actionPerformed(ActionEvent e)
                  {

                        FieldPlayerGUI fieldPlayer = new FieldPlayerGUI();
                        fieldPlayer.setVisible(true);

                  }
            });

            this.load.addActionListener(new ActionListener()
            {

                  @Override
                  public void actionPerformed(ActionEvent e)
                  {

                        LoadGUI menu = new LoadGUI();
                        menu.setVisible(true);
                  }
            });

            this.setting.addActionListener(new ActionListener()
            {

                  @Override
                  public void actionPerformed(ActionEvent e)
                  {
                        SettingGUI option = new SettingGUI();
                        option.setVisible(true);
                  }
            });

            this.quit.addActionListener(new ActionListener()
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
            // NOTHING TO DO
      }
}