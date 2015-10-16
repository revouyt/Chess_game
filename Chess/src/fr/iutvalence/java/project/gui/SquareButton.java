package fr.iutvalence.java.project.gui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JButton;
import fr.iutvalence.java.project.chessgame.Position;


public class SquareButton extends JButton
{
      private Color hoverColor;

      public boolean isSelected = false;

      private Image piece;

      private Position position;

      public SquareButton(Color backGround, int lign, int column)
      {
            super.setContentAreaFilled(false);
            this.piece = null;
            this.position = new Position(lign, column);
            this.setBackground(backGround);
            this.hoverColor = getBackground().darker();
      }


      public Color getHoverColor()
      {
            return hoverColor;
      }


      public Image getPiece()
      {
            return this.piece;
      }


      public Position getPosition()
      {
            return position;
      }

      @Override
      protected void paintComponent(Graphics g)
      {

            super.paintComponent(g);
            if (getModel().isRollover())
            {
                  g.setColor(hoverColor);
            }
            else if (this.isSelected)
            {
                  g.setColor(Color.GREEN);
            }
            else
            {
                  g.setColor(getBackground());
            }
            g.fillRect(0, 0, getWidth(), getHeight());
            g.drawImage(piece, 0, 0, getWidth(), getHeight(), null);

      }


      public void setHoverColor(Color hoverColor)
      {
            this.hoverColor = hoverColor;
      }


      public void setPiece(Image piece)
      {
            this.piece = piece;
      }
}
