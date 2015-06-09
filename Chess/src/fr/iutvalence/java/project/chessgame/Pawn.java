package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;


/**
 * Une pièce de pion
 */
public class Pawn extends AbstractPiece
{
      /**
       * La liste des différentes positions possible terme de coordonnées pour
       * un pion (ici une seule case)
       */
      private final int[][] listPosition = { { 1, 0 } };

      /**
       * La liste des différentes positions possible de prise de pièce en terme
       * de coordonnées
       */
      private final int[][] listPosition2 = { { 1, 1 }, { 1, -1 } };

      /**
       * Créer un pion de couleur donnée
       *
       * @param couleur La couleur du pion
       */
      public Pawn(ColorEnum couleur)
      {
            super(couleur);
            this.Piecetype = PieceType.PAWN;
            if (couleur == ColorEnum.BLACK)
            {
                  this.PieceName = ListPieces.BLACK_PAWN;
            }
            else
            {
                  this.PieceName = ListPieces.WHITE_PAWN;
            }
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
            Square positionDeFin;
            Square positionDeFin2;
            Position newPosition;
            int i, j;
            for (int[] direction : listPosition)
            {
                  if (this.couleur == ColorEnum.BLACK)
                  {
                        i = positionDepart.obtenirNumeroDeLigne() + direction[0];
                  }
                  else
                  {
                        i = positionDepart.obtenirNumeroDeLigne() - direction[0];
                  }
                  j = positionDepart.obtenirNumeroDeColonne() + direction[1];
                  if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                  {
                        positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                        if (positionDeFin.getPiece() != null)
                        {
                              break;
                        }
                        else
                        {
                              possibleMovement.add(newPosition);
                              if (this.couleur == ColorEnum.BLACK)
                              {
                                    i = positionDepart.obtenirNumeroDeLigne() + 2;
                              }
                              else
                              {
                                    i = positionDepart.obtenirNumeroDeLigne() - 2;
                              }
                              if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES)
                              {
                                    positionDeFin2 = Echiquier.square.get(newPosition = new Position(i, j));
                                    if (!this.hasAlreadyMove && positionDeFin2.getPiece() == null)
                                    {
                                          possibleMovement.add(newPosition);
                                    }
                              }
                        }
                  }
            }
            for (int[] direction2 : listPosition2)
            {
                  if (this.couleur == ColorEnum.BLACK)
                  {
                        i = positionDepart.obtenirNumeroDeLigne() + direction2[0];
                  }
                  else
                  {
                        i = positionDepart.obtenirNumeroDeLigne() - direction2[0];
                  }
                  j = positionDepart.obtenirNumeroDeColonne() + direction2[1];
                  if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                  {
                        positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                        if (positionDeFin.getPiece() == null)
                        {
                              continue;
                        }
                        else
                        {
                              if (positionDeFin.getPiece().obtenirCouleur() != this.couleur)
                              {
                                    possibleMovement.add(newPosition);
                              }
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
            return "P" + super.toString();
      }

}
