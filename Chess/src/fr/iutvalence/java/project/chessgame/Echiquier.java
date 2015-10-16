package fr.iutvalence.java.project.chessgame;


import java.util.HashMap;
import java.util.Map;



public class Echiquier
{

      public static final int NOMBRE_DE_CASES_PAR_LIGNES = 8;


      public static final int NOMBRE_DE_CASES_PAR_COLONNES = 8;

      /**
       * Les cases de l'échiquier
       */
      public static HashMap<Position, Square> square = new HashMap<Position, Square>();

      /**
       * Pose une pièce à une position donnée
       *
       * @param position La position d'arrivée
       * @param piece La pièce à poser
       */
      public static void poserPiece(Echiquier board, Position position, AbstractPiece piece)
      {
            board.obtenirCase(position).setPiece(piece);
      }

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


      private void creerEchiquier()
      {
            for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_CASES_PAR_LIGNES; numeroDeLigne++)
            {
                  for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_CASES_PAR_COLONNES; numeroDeColonne++)
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
            Echiquier.poserPiece(this, positionArrivee, pieceADeplacer);
            this.obtenirCase(positionDepart).removePiece();
      }

      public HashMap<Position, AbstractPiece> getAllPieces(ColorEnum Color)
      {
            HashMap<Position, AbstractPiece> pieces = new HashMap<Position, AbstractPiece>();
            for (Map.Entry<Position, Square> entry : Echiquier.square.entrySet())
            {
                  if (entry.getValue().getPiece() != null)
                  {
                        if (entry.getValue().getPiece().obtenirCouleur() == Color)
                        {
                              pieces.put(entry.getKey(), entry.getValue().getPiece());
                        }
                  }
            }
            return pieces;
      }


      public King getBlackKing()
      {
            return blackKing;
      }


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


      private void poserPieces()
      {
            Echiquier.poserPiece(this, new Position(0, 0), new ROOK(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 1), new Knight(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 2), new Bishop(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 3), new Queen(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 4), this.blackKing);
            this.blackKing.setKingPosition(new Position(0, 4));
            Echiquier.poserPiece(this, new Position(0, 5), new Bishop(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 6), new Knight(ColorEnum.BLACK));
            Echiquier.poserPiece(this, new Position(0, 7), new ROOK(ColorEnum.BLACK));

            for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_CASES_PAR_COLONNES; numeroDeColonne++)
            {
                  Echiquier.poserPiece(this, new Position(1, numeroDeColonne), new Pawn(ColorEnum.BLACK));
                  Echiquier.poserPiece(this, new Position(6, numeroDeColonne), new Pawn(ColorEnum.WHITE));
            }

            Echiquier.poserPiece(this, new Position(7, 0), new ROOK(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 1), new Knight(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 2), new Bishop(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 3), new Queen(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 4), this.whiteKing);
            this.whiteKing.setKingPosition(new Position(7, 4));
            Echiquier.poserPiece(this, new Position(7, 5), new Bishop(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 6), new Knight(ColorEnum.WHITE));
            Echiquier.poserPiece(this, new Position(7, 7), new ROOK(ColorEnum.WHITE));
      }

}
