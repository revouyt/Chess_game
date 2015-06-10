package fr.iutvalence.java.project.chessgame;


import java.awt.Image;


public class Movement
{
      private final Position initialPosition;

      private final Position finalPosition;

      private final AbstractPiece initialPositionPiece;

      private final AbstractPiece finalPositionPiece;

      private final Image initialPositionImage;

      private final Image finalPositionImage;

      public final Echiquier board;

      public Movement(Position init, Position finalP, AbstractPiece initPiece, AbstractPiece finalPiece, Image initImage, Image finalImage,
                  Echiquier theBoard)
      {
            this.initialPosition = init;
            this.finalPosition = finalP;
            this.initialPositionPiece = initPiece;
            this.finalPositionPiece = finalPiece;
            this.initialPositionImage = initImage;
            this.finalPositionImage = finalImage;
            this.board = theBoard;
      }

      /**
       * @return the finalPosition
       */
      public Position getFinalPosition()
      {
            return finalPosition;
      }

      /**
       * @return the finalPositionImage
       */
      public Image getFinalPositionImage()
      {
            return finalPositionImage;
      }

      /**
       * @return the finalPositionPiece
       */
      public AbstractPiece getFinalPositionPiece()
      {
            return finalPositionPiece;
      }

      /**
       * @return the initialPosition
       */
      public Position getInitialPosition()
      {
            return initialPosition;
      }

      /**
       * @return the initialPositionImage
       */
      public Image getInitialPositionImage()
      {
            return initialPositionImage;
      }

      /**
       * @return the initialPositionPiece
       */
      public AbstractPiece getInitialPositionPiece()
      {
            return initialPositionPiece;
      }
}
