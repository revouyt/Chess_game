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


      public ColorEnum getColor()
      {
            return color;
      }

      public boolean isEnable()
      {
            return this.isEnable;
      }


      public void setEnableFalse()
      {
            this.isEnable = false;
      }


      public void setEnableTrue()
      {
            this.isEnable = true;
      }

}
