package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;


/**
 * Une pièce de roi
 */
public class King extends AbstractPiece
{
      /**
       * Default : 0 when it hasn't moved yet, 1 when it already moved
       */
      private boolean hasAlreadyMove;

      /**
       * Valeur de la coordonnée de la pièce
       */
      private int position;

      /**
       * Les listes des différentes positions possible en terme de coordonnées
       */
      private final int[][] listPositionDiagonale = { { position, position }, { position, -position }, { -position, -position },
                  { -position, position } };

      private final int[][] listPositionPion = { { 1, 1 }, { 1, -1 } };

      private final int[][] listPositionLigne = { { position, 0 }, { 0, -position }, { -position, 0 }, { 0, position } };

      private final int[][] listPositionCavalier = { { 2, -1 }, { 2, 1 }, { -2, -1 }, { -2, 1 }, { 1, -2 }, { 1, 2 }, { -1, -2 }, { -1, 2 } };

      private final int[][] listPositionRoi = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, -1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };

      private final int[][] listPositionRoque = { { 0, -2 }, { 0, 2 } };

      /**
       * Créer un roi de couleur donnée
       *
       * @param couleur La couleur du roi
       */
      public King(ColorEnum couleur)
      {
            super(couleur);
            this.hasAlreadyMove = false;
            this.PieceName = PieceType.KING;
      }

      /**
       * Determine if there is check
       *
       * @param positionDepart the position of the king
       * @return true if the square is under attack
       */
      private boolean isCheck(Position positionDepart)
      {
            Square squareTest;
            int i;
            int j;
            /* boucle-test des pions */
            for (int[] direction1 : this.listPositionPion)
            {
                  i = positionDepart.obtenirNumeroDeLigne() + direction1[0];
                  j = positionDepart.obtenirNumeroDeColonne() + direction1[1];
                  if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0)
                  {
                        squareTest = Echiquier.square.get(new Position(i, j));
                        if (squareTest.getPiece().getPieceName() == PieceType.PAWN)
                        {
                              return true;
                        }
                  }
            }
            /* boucle-test des diagonales Fou */
            for (int[] direction2 : this.listPositionDiagonale)
            {
                  i = positionDepart.obtenirNumeroDeLigne() + direction2[0];
                  j = positionDepart.obtenirNumeroDeColonne() + direction2[1];
                  if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0)
                  {
                        squareTest = Echiquier.square.get(new Position(i, j));
                        for (position = 1; position < 8; position++)
                        {
                              if (squareTest.getPiece().getPieceName() == PieceType.BISHOP
                                          && squareTest.getPiece().getPieceName() == PieceType.QUEEN)
                              {
                                    return true;
                              }
                        }
                  }
            }

            /* boucle-test des lignes Tour */
            for (int[] direction3 : this.listPositionLigne)
            {
                  i = positionDepart.obtenirNumeroDeLigne() + direction3[0];
                  j = positionDepart.obtenirNumeroDeColonne() + direction3[1];
                  if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0)
                  {
                        squareTest = Echiquier.square.get(new Position(i, j));
                        for (position = 1; position < 8; position++)
                        {
                              if (squareTest.getPiece().getPieceName() == PieceType.ROOK
                                          && squareTest.getPiece().getPieceName() == PieceType.QUEEN)
                              {
                                    return true;
                              }
                        }
                  }
            }

            /* boucle-test des cavaliers */
            for (int[] direction4 : this.listPositionCavalier)
            {
                  i = positionDepart.obtenirNumeroDeLigne() + direction4[0];
                  j = positionDepart.obtenirNumeroDeColonne() + direction4[1];
                  if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0)
                  {
                        squareTest = Echiquier.square.get(new Position(i, j));
                        if (squareTest.getPiece().getPieceName() == PieceType.KNIGHT)
                        {
                              return true;
                        }
                  }
            }
            return false;
      }

      /**
       * Détermine les différents movements possible à partir d'une position de
       * départ donnée
       *
       * @param positionDepart La position actuelle de la pièce
       * @return Une liste de tout les déplacements possible à partir d'une
       *         position
       */
      @Override
      public List<Position> possibleMovements(Position positionDepart)
      {
            List<Position> possibleMovement = new ArrayList<Position>();
            Position newPosition;
            int i, j;
            /* boucle des déplacements possible du roi */
            for (int[] direction : this.listPositionRoi)
            {
                  i = positionDepart.obtenirNumeroDeLigne() + direction[0];
                  j = positionDepart.obtenirNumeroDeColonne() + direction[1];
                  newPosition = new Position(i, j);
                  if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0 && !isCheck(newPosition))
                  {
                        possibleMovement.add(newPosition);
                  }
            }
            if (!this.hasAlreadyMove)
            {
                  int indiceRoque = -1;
                  for (int[] direction : this.listPositionRoque)
                  {
                        indiceRoque++;
                        i = positionDepart.obtenirNumeroDeLigne() + direction[0];
                        j = positionDepart.obtenirNumeroDeColonne() + direction[1];
                        newPosition = new Position(i, j);
                        if (!isCheck(newPosition) && possibleMovement.contains(new Position(i, j + listPositionPion[1][indiceRoque])))
                        {
                              possibleMovement.add(newPosition);
                        }
                  }
            }
            return possibleMovement;
      }

      /**
       * @see java.lang.Object#toString()
       */
      @Override
      public String toString()
      {
            return "R" + super.toString();
      }

}
