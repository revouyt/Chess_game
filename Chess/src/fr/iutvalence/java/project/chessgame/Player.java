package fr.iutvalence.java.project.chessgame;


public class Player
{

      private boolean hasPlayed;

      private String name;

      private final ColorEnum color;

      private boolean isEnable;

      public Player(ColorEnum color)
      {
            this.isEnable = false;
            this.color = color;
            this.name = "";
      }

      /**
       * @return the color
       */
      public ColorEnum getColor()
      {
            return color;
      }

      public boolean isEnable()
      {
            return this.isEnable;
      }

      /**
       * @param isEnable the isEnable to set
       */
      public void setEnableFalse()
      {
            this.isEnable = false;
      }

      /**
       * @param isEnable the isEnable to set
       */
      public void setEnableTrue()
      {
            this.isEnable = true;
      }

}
