package fr.iutvalence.java.project.chessgame;


import java.util.List;


/**
 * Une pièce type
 */
public abstract class AbstractPiece
{

      protected PieceType pieceType;

      protected ListPieces pieceName;

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

      
      public ListPieces getPieceName()
      {
            return this.pieceName;
      }

     
      public PieceType getPieceType()
      {
            return this.pieceType;
      }

      
      public boolean isHasAlreadyMove()
      {
            return hasAlreadyMove;
      }

      public void itDidntMoved()
      {
            this.hasAlreadyMove = false;
      }

      
      public void itMoved()
      {
            this.hasAlreadyMove = true;
      }

     
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