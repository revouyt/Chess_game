package fr.iutvalence.java.project.chessgame;


public class Player
{

      private boolean isEnable;

      private String name;

      private final ColorEnum color;

      public Player(ColorEnum color)
      {
            this.isEnable = false;
            this.color = color;
            this.name = "";
      }

      /**
       * @return the isEnable
       */
      public boolean isEnable()
      {
            return isEnable;
      }

      /**
       * @param isEnable the isEnable to set
       */
      public void setEnable(boolean isEnable)
      {
            this.isEnable = isEnable;
      }

}
