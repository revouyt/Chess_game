package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;


public class SquareButton extends JButton
{
      private Color hoverColor;

      private Image piece;

      public SquareButton()
      {
            super.setContentAreaFilled(false);
            this.piece = null;
      }

      /**
       * @return the piece
       */
      public Image getPiece()
      {
            return piece;
      }

      @Override
      protected void paintComponent(Graphics g)
      {
            /*
             * if (getModel().isPressed()) { g.setColor(pressedBackgroundColor);
             * } else
             */
            if (getModel().isRollover())
            {
                  this.hoverColor = getBackground().darker();
                  g.setColor(hoverColor);
            }
            else
            {
                  g.setColor(getBackground());
            }
            g.fillRect(0, 0, getWidth(), getHeight());
            g.drawImage(piece, 0, 0, getWidth(), getHeight(), null);
            // super.paintComponent(g);
      }

      /**
       * @param piece the piece to set
       */
      public void setPiece(Image piece)
      {
            this.piece = piece;
      }
}
