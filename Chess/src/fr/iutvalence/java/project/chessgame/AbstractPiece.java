package fr.iutvalence.java.project.chessgame;


import java.util.List;


/**
 * Une pièce type
 */
public abstract class AbstractPiece
{

      protected PieceType pieceType;

      protected ListPieces pieceName;

      /**
       * La couleur de la pièce
       */
      protected final ColorEnum pieceCouleur;

      /**
       * Default : 0 when it hasn't moved yet, 1 when it already moved
       */
      public boolean hasAlreadyMove;

      /**
       * Créer une pièce de couleur donnée
       *
       * @param couleur la couleur
       */
      protected AbstractPiece(ColorEnum couleur)
      {
            this.pieceCouleur = couleur;
            this.hasAlreadyMove = false;
      }

      /**
       * Obtenir le nom de la piece
       *
       * @return le nom
       */
      public ListPieces getPieceName()
      {
            return this.pieceName;
      }

      /**
       * Obtenir le type de la piece
       *
       * @return le type
       */
      public PieceType getPieceType()
      {
            return this.pieceType;
      }

      /**
       * @return the hasAlreadyMove
       */
      public boolean isHasAlreadyMove()
      {
            return hasAlreadyMove;
      }

      public void itDidntMoved()
      {
            this.hasAlreadyMove = false;
      }

      /**
       * This piece has moved
       */
      public void itMoved()
      {
            this.hasAlreadyMove = true;
      }

      /**
       * Obtenir la couleur de la piece
       *
       * @return la couleur de la piece
       */
      public ColorEnum obtenirCouleur()
      {
            return this.pieceCouleur;
      }

      /**
       * Détermine les différents movements possible à partir d'une position de
       * départ donnée
       *
       * @param positionDepart La position actuelle de la pièce
       * @return Une liste de tout les déplacements possible à partir d'une
       *         position
       */
      public abstract List<Position> possibleMovements(Position positionDepart);

      /**
       * @see java.lang.Object#toString()
       */
      @Override
      public String toString()
      {
            return this.pieceCouleur.toString();
      }
}