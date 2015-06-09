package fr.iutvalence.java.project.chessgame;


public class Movement
{
      private final Position initialPosition;

      private final Position finalPosition;

      public Movement(Position init, Position finalP)
      {
            this.initialPosition = init;
            this.finalPosition = finalP;
      }

      /**
       * @return the finalPosition
       */
      public Position getFinalPosition()
      {
            return finalPosition;
      }

      /**
       * @return the initialPosition
       */
      public Position getInitialPosition()
      {
            return initialPosition;
      }
}
