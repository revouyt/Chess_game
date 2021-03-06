package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;



public class Queen extends AbstractPiece
{

      /**
       * La liste des différentes positions possible terme de coordonnées
       */
      private final int[][] listPosition = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };


      public Queen(ColorEnum couleur)
      {
            super(couleur);
            this.pieceType = PieceType.QUEEN;
            if (couleur == ColorEnum.BLACK)
            {
                  this.pieceName = ListPieces.BLACK_QUEEN;
            }
            else
            {
                  this.pieceName = ListPieces.WHITE_QUEEN;
            }
      }

      @Override
      public List<Position> possibleMovements(Position positionDepart)
      {
            List<Position> possibleMovement = new ArrayList<Position>();
            Square positionDeFin;
            Position newPosition;
            int i, j;
            for (int[] direction : listPosition)
            {
                  for (int compteurDirection = 1; compteurDirection < 8; compteurDirection++)
                  {
                        i = positionDepart.obtenirNumeroDeLigne() + direction[0] * compteurDirection;
                        j = positionDepart.obtenirNumeroDeColonne() + direction[1] * compteurDirection;
                        if (i >= 0 && i < Echiquier.NOMBRE_DE_CASES_PAR_LIGNES && j < Echiquier.NOMBRE_DE_CASES_PAR_COLONNES && j >= 0)
                        {
                              positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                              if (positionDeFin.getPiece() != null)
                              {
                                    if (positionDeFin.getPiece().obtenirCouleur() == this.pieceCouleur)
                                    {
                                          break;
                                    }
                                    possibleMovement.add(newPosition);
                                    break;
                              }
                              else
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
            return "r" + super.toString();
      }

}
