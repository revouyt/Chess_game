package fr.iutvalence.java.project.chessgame;


import java.util.HashMap;


/**
 * Représente un échiquier
 */
public class Echiquier
{
      /**
       * Le nombre de cases par ligne
       */
      public static final int NOMBRE_DE_LIGNES = 8;

      /**
       * Le nombre de cases par colonne
       */
      public static final int NOMBRE_DE_COLONNES = 8;

      /**
       * Les cases de l'échiquier
       */
      public static HashMap<Position, Square> square = new HashMap<Position, Square>();

      private final King blackKing;

      private final King whiteKing;

      /**
       * Créer un nouvel échiquier et placer les pièces à leurs places initiales
       */
      public Echiquier()
      {
            this.blackKing = new King(ColorEnum.BLACK);
            this.whiteKing = new King(ColorEnum.WHITE);
            this.creerEchiquier();
            this.poserPieces();
      }

      public Echiquier(String string)
      {

            this.blackKing = new King(ColorEnum.BLACK);
            this.whiteKing = new King(ColorEnum.WHITE);
            this.creerEchiquier();
      }

      /**
       * Création de l'échiquier
       */
      private void creerEchiquier()
      {
            for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++)
            {
                  for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
                  {
                        if ((numeroDeLigne + numeroDeColonne) % 2 == 0)
                        {
                              square.put(new Position(numeroDeLigne, numeroDeColonne), new Square(ColorEnum.WHITE));
                        }
                        else
                        {
                              square.put(new Position(numeroDeLigne, numeroDeColonne), new Square(ColorEnum.BLACK));
                        }
                  }
            }
      }

      /**
       * Déplacer une pièce
       *
       * @param positionDepart la case de départ
       * @param positionArrivee la case d'arrivée
       */
      public void deplacerPiece(Position positionDepart, Position positionArrivee)
      {
            AbstractPiece pieceADeplacer = this.obtenirPiece(positionDepart);
            if (pieceADeplacer == null)
            {
                  return;
            }
            this.poserPiece(positionArrivee, pieceADeplacer);
            this.obtenirCase(positionDepart).removePiece();
      }

      /**
       * @return the blackKing
       */
      public King getBlackKing()
      {
            return blackKing;
      }

      /**
       * @return the whiteKing
       */
      public King getWhiteKing()
      {
            return whiteKing;
      }

      /**
       * Obtenir une case à une position donnée
       *
       * @param position la position de la case
       * @return la case de l'échiquier à la position donnée
       */
      private Square obtenirCase(Position position)
      {
            return square.get(position);
      }

      /**
       * Obtenir la pièce à une position donnée
       *
       * @param position la position
       * @return la pièce posée sur la case ou <tt>null</tt> s'il n'y a pas de
       *         pièce
       */
      public AbstractPiece obtenirPiece(Position position)
      {
            return square.get(position).getPiece();
      }

      /**
       * Pose une pièce à une position donnée
       *
       * @param position La position d'arrivée
       * @param piece La pièce à poser
       */
      public void poserPiece(Position position, AbstractPiece piece)
      {
            this.obtenirCase(position).setPiece(piece);
      }

      /**
       * Posage de toutes les pièces à leurs positions d'origine
       */
      private void poserPieces()
      {
            this.poserPiece(new Position(0, 0), new ROOK(ColorEnum.BLACK));
            this.poserPiece(new Position(0, 1), new Knight(ColorEnum.BLACK));
            this.poserPiece(new Position(0, 2), new Bishop(ColorEnum.BLACK));
            this.poserPiece(new Position(0, 3), new Queen(ColorEnum.BLACK));
            this.poserPiece(new Position(0, 4), this.blackKing);
            this.blackKing.setKingPosition(new Position(0, 4));
            this.poserPiece(new Position(0, 5), new Bishop(ColorEnum.BLACK));
            this.poserPiece(new Position(0, 6), new Knight(ColorEnum.BLACK));
            this.poserPiece(new Position(0, 7), new ROOK(ColorEnum.BLACK));

            for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
            {
                  this.poserPiece(new Position(1, numeroDeColonne), new Pawn(ColorEnum.BLACK));
                  this.poserPiece(new Position(6, numeroDeColonne), new Pawn(ColorEnum.WHITE));
            }

            this.poserPiece(new Position(7, 0), new ROOK(ColorEnum.WHITE));
            this.poserPiece(new Position(7, 1), new Knight(ColorEnum.WHITE));
            this.poserPiece(new Position(7, 2), new Bishop(ColorEnum.WHITE));
            this.poserPiece(new Position(7, 3), new Queen(ColorEnum.WHITE));
            this.poserPiece(new Position(7, 4), this.whiteKing);
            this.whiteKing.setKingPosition(new Position(0, 4));
            this.poserPiece(new Position(7, 5), new Bishop(ColorEnum.WHITE));
            this.poserPiece(new Position(7, 6), new Knight(ColorEnum.WHITE));
            this.poserPiece(new Position(7, 7), new ROOK(ColorEnum.WHITE));
      }

}
