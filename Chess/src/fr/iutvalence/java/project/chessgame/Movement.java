package fr.iutvalence.java.project.chessgame;


import java.awt.Image;
import fr.iutvalence.java.project.gui.BoardGUI;
import fr.iutvalence.java.project.gui.PieceGUI;


public class Movement
{
      private final Position initialPosition;

      private final Position finalPosition;

      private final AbstractPiece initialPositionPiece;

      private final AbstractPiece finalPositionPiece;

      private final Image initialPositionImage;

      private final Image finalPositionImage;

      public final Echiquier board;

      public final Position initialPositionTour;

      public final Position finalPositionTour;

      public Image Tour;

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
            this.initialPositionTour = null;
            this.finalPositionTour = null;
      }

      public Movement(String string, Echiquier theBoard)
      {
            switch (string)
            {
                  case "ROQUE1":
                        this.initialPosition = new Position(0, 4);
                        this.finalPosition = King.ROQUE1;
                        this.initialPositionTour = new Position(0, 0);
                        this.finalPositionTour = new Position(0, 3);
                        this.initialPositionPiece = Echiquier.square.get(new Position(0, 4)).getPiece();
                        this.finalPositionPiece = Echiquier.square.get(King.ROQUE1).getPiece();
                        this.initialPositionImage = BoardGUI.buttonsPosition.get(new Position(0, 4)).getPiece();
                        this.finalPositionImage = BoardGUI.buttonsPosition.get(King.ROQUE1).getPiece();
                        this.board = theBoard;
                        this.Tour = PieceGUI.piecesImage.get(ListPieces.BLACK_ROOK);
                        break;

                  case "ROQUE2":
                        this.initialPosition = new Position(0, 4);
                        this.finalPosition = King.ROQUE2;
                        this.initialPositionTour = new Position(0, 7);
                        this.finalPositionTour = new Position(0, 5);
                        this.initialPositionPiece = Echiquier.square.get(new Position(0, 4)).getPiece();
                        this.finalPositionPiece = Echiquier.square.get(King.ROQUE2).getPiece();
                        this.initialPositionImage = BoardGUI.buttonsPosition.get(new Position(0, 4)).getPiece();
                        this.finalPositionImage = BoardGUI.buttonsPosition.get(King.ROQUE2).getPiece();
                        this.board = theBoard;
                        this.Tour = PieceGUI.piecesImage.get(ListPieces.BLACK_ROOK);
                        break;

                  case "ROQUE3":
                        this.initialPosition = new Position(7, 4);
                        this.finalPosition = King.ROQUE3;
                        this.initialPositionTour = new Position(7, 0);
                        this.finalPositionTour = new Position(7, 3);
                        this.initialPositionPiece = Echiquier.square.get(new Position(7, 4)).getPiece();
                        this.finalPositionPiece = Echiquier.square.get(King.ROQUE3).getPiece();
                        this.initialPositionImage = BoardGUI.buttonsPosition.get(new Position(7, 4)).getPiece();
                        this.finalPositionImage = BoardGUI.buttonsPosition.get(King.ROQUE3).getPiece();
                        this.board = theBoard;
                        this.Tour = PieceGUI.piecesImage.get(ListPieces.WHITE_ROOK);
                        break;

                  case "ROQUE4":
                        this.initialPosition = new Position(7, 4);
                        this.finalPosition = King.ROQUE4;
                        this.initialPositionTour = new Position(7, 7);
                        this.finalPositionTour = new Position(7, 5);
                        this.initialPositionPiece = Echiquier.square.get(new Position(7, 4)).getPiece();
                        this.finalPositionPiece = Echiquier.square.get(King.ROQUE4).getPiece();
                        this.initialPositionImage = BoardGUI.buttonsPosition.get(new Position(7, 4)).getPiece();
                        this.finalPositionImage = BoardGUI.buttonsPosition.get(King.ROQUE4).getPiece();
                        this.board = theBoard;
                        this.Tour = PieceGUI.piecesImage.get(ListPieces.WHITE_ROOK);
                        break;
                  default:
                        this.initialPosition = new Position(0, 4);
                        this.finalPosition = King.ROQUE1;
                        this.initialPositionTour = new Position(0, 0);
                        this.finalPositionTour = new Position(0, 3);
                        this.initialPositionPiece = Echiquier.square.get(new Position(0, 4)).getPiece();
                        this.finalPositionPiece = Echiquier.square.get(new Position(0, 0)).getPiece();
                        this.initialPositionImage = BoardGUI.buttonsPosition.get(new Position(0, 4)).getPiece();
                        this.finalPositionImage = BoardGUI.buttonsPosition.get(new Position(0, 0)).getPiece();
                        this.board = theBoard;
                        break;

            }
      }


      public Position getFinalPosition()
      {
            return finalPosition;
      }


      public Image getFinalPositionImage()
      {
            return finalPositionImage;
      }


      public AbstractPiece getFinalPositionPiece()
      {
            return finalPositionPiece;
      }


      public Position getFinalPositionTour()
      {
            return finalPositionTour;
      }


      public Position getInitialPosition()
      {
            return initialPosition;
      }


      public Image getInitialPositionImage()
      {
            return initialPositionImage;
      }


      public AbstractPiece getInitialPositionPiece()
      {
            return initialPositionPiece;
      }


      public Position getInitialPositionTour()
      {
            return initialPositionTour;
      }
}
