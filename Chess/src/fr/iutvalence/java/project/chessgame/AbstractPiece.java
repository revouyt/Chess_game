package fr.iutvalence.java.project.chessgame;


import java.util.List;


/**
 * Une pièce type
 */
public abstract class AbstractPiece
{
      /**
       * Le type de la pièce
       */
      protected PieceType Piecetype;

      /**
       * Le nom de la pièce
       */
      protected ListPieces PieceName;

      /**
       * La couleur de la pièce
       */
      protected final ColorEnum couleur;

      /**
       * Default : 0 when it hasn't moved yet, 1 when it already moved
       */
      protected boolean hasAlreadyMove;

      /**
       * Créer une pièce de couleur donnée
       *
       * @param couleur la couleur
       */
      protected AbstractPiece(ColorEnum couleur)
      {
            this.couleur = couleur;
            this.hasAlreadyMove = false;
      }

      /**
       * Obtenir le nom de la piece
       *
       * @return le nom
       */
      public ListPieces getPieceName()
      {
            return this.PieceName;
      }

      /**
       * Obtenir le type de la piece
       *
       * @return le type
       */
      public PieceType getPieceType()
      {
            return this.Piecetype;
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
            return this.couleur;
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
            return this.couleur.toString();
      }
}