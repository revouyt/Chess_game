package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class King extends AbstractPiece
{

      public final static Position ROQUE1 = new Position(0, 2);


      public final static Position ROQUE2 = new Position(0, 6);


      public final static Position ROQUE3 = new Position(7, 2);


      public final static Position ROQUE4 = new Position(7, 6);

      private Position kingPosition;

      /**
       * Les listes des différentes positions possible en terme de coordonnées
       */
      private final int[][] listPositionDiagonale = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

      private final int[][] listPositionPionBlanc = { { 1, 1 }, { 1, -1 } };

      private final int[][] listPositionPionNoir = { { -1, 1 }, { -1, -1 } };

      private final int[][] listPositionLigne = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

      private final int[][] listPositionCavalier = { { 2, -1 }, { 2, 1 }, { -2, -1 }, { -2, 1 }, { 1, -2 }, { 1, 2 }, { -1, -2 }, { -1, 2 } };

      private final int[][] listPositionRoi = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };

      private final int[][] listPositionRoqueGauche = { { 0, -2 } };

      private final int[][] listPositionRoqueDroite = { { 0, 2 } };


      public King(ColorEnum couleur)
      {
            super(couleur);
            this.hasAlreadyMove = false;
            this.pieceType = PieceType.KING;
            if (couleur == ColorEnum.BLACK)
            {
                  this.pieceName = ListPieces.BLACK_KING;
            }
            else
            {
                  this.pieceName = ListPieces.WHITE_KING;
            }
      }

      public boolean canBeSaved(HashMap<Position, AbstractPiece> listPiecesMonoColor)
      {

            return true;
      }

      public Position getKingPosition()
      {
            return this.kingPosition;
      }


      public boolean isCheck(Position position)
      {
            Square squareTest;
            int i;
            int j;
            if (this.pieceCouleur == ColorEnum.BLACK)
            {
                  /* boucle-test des Pions */
                  for (int[] direction1 : this.listPositionPionBlanc)
                  {
                        i = position.obtenirNumeroDeLigne() + direction1[0];
                        j = position.obtenirNumeroDeColonne() + direction1[1];
                        if (i >= 0 && i < Echiquier.NOMBRE_DE_CASES_PAR_LIGNES && j < Echiquier.NOMBRE_DE_CASES_PAR_COLONNES && j >= 0)
                        {
                              squareTest = Echiquier.square.get(new Position(i, j));
                              if (squareTest.getPiece() != null)
                              {
                                    if (squareTest.getPiece().getPieceName() == ListPieces.WHITE_PAWN)
                                    {
                                          return true;
                                    }
                              }
                        }
                  }
            }
            else
            {

                  /* boucle-test des pions */
                  for (int[] direction1 : this.listPositionPionNoir)
                  {
                        i = position.obtenirNumeroDeLigne() + direction1[0];
                        j = position.obtenirNumeroDeColonne() + direction1[1];
                        if (i >= 0 && i < Echiquier.NOMBRE_DE_CASES_PAR_LIGNES && j < Echiquier.NOMBRE_DE_CASES_PAR_COLONNES && j >= 0)
                        {
                              squareTest = Echiquier.square.get(new Position(i, j));
                              if (squareTest.getPiece() != null)
                              {
                                    if (squareTest.getPiece().getPieceName() == ListPieces.BLACK_PAWN)
                                    {
                                          return true;
                                    }
                              }
                        }
                  }
            }
            /* boucle-test des diagonales Fou */
            for (int[] direction2 : this.listPositionDiagonale)
            {
                  for (int compteurDirection = 1; compteurDirection < 8; compteurDirection++)
                  {
                        i = position.obtenirNumeroDeLigne() + direction2[0] * compteurDirection;
                        j = position.obtenirNumeroDeColonne() + direction2[1] * compteurDirection;
                        if (i >= 0 && i < Echiquier.NOMBRE_DE_CASES_PAR_LIGNES && j < Echiquier.NOMBRE_DE_CASES_PAR_COLONNES && j >= 0)
                        {
                              squareTest = Echiquier.square.get(new Position(i, j));
                              if (squareTest.getPiece() != null)
                              {

                                    if (squareTest.getPiece().getPieceType() == PieceType.BISHOP
                                                || squareTest.getPiece().getPieceType() == PieceType.QUEEN)
                                    {
                                          if (squareTest.getPiece().obtenirCouleur() != this.pieceCouleur)
                                          {
                                                return true;
                                          }
                                    }
                                    else
                                    {
                                          break;
                                    }

                              }
                        }
                  }
            }

            /* boucle-test des lignes Tour */
            for (int[] direction3 : this.listPositionLigne)
            {
                  for (int compteurDirection = 1; compteurDirection < 8; compteurDirection++)
                  {
                        i = position.obtenirNumeroDeLigne() + direction3[0] * compteurDirection;
                        j = position.obtenirNumeroDeColonne() + direction3[1] * compteurDirection;
                        if (i >= 0 && i < Echiquier.NOMBRE_DE_CASES_PAR_LIGNES && j < Echiquier.NOMBRE_DE_CASES_PAR_COLONNES && j >= 0)
                        {
                              squareTest = Echiquier.square.get(new Position(i, j));
                              if (squareTest.getPiece() != null)
                              {
                                    if (squareTest.getPiece().getPieceType() == PieceType.ROOK
                                                || squareTest.getPiece().getPieceType() == PieceType.QUEEN)
                                    {
                                          if (squareTest.getPiece().obtenirCouleur() != this.pieceCouleur)
                                          {
                                                return true;
                                          }
                                    }
                                    else
                                    {
                                          break;
                                    }
                              }
                        }
                  }
            }

            /* boucle-test des cavaliers */
            for (int[] direction4 : this.listPositionCavalier)
            {
                  i = position.obtenirNumeroDeLigne() + direction4[0];
                  j = position.obtenirNumeroDeColonne() + direction4[1];
                  if (i >= 0 && i < Echiquier.NOMBRE_DE_CASES_PAR_LIGNES && j < Echiquier.NOMBRE_DE_CASES_PAR_COLONNES && j >= 0)
                  {
                        squareTest = Echiquier.square.get(new Position(i, j));
                        if (squareTest.getPiece() != null)
                        {
                              if (squareTest.getPiece().getPieceType() == PieceType.KNIGHT)
                              {
                                    if (squareTest.getPiece().obtenirCouleur() != this.pieceCouleur)
                                    {
                                          return true;
                                    }
                              }
                        }
                  }
            }
            return false;
      }


      @Override
      public List<Position> possibleMovements(Position positionDepart)
      {
            List<Position> possibleMovement = new ArrayList<Position>();
            Position newPosition;
            Square positionDeFin;
            AbstractPiece tour;
            int i, j;
            /* boucle des déplacements possible du roi */
            for (int[] direction : this.listPositionRoi)
            {
                  i = positionDepart.obtenirNumeroDeLigne() + direction[0];
                  j = positionDepart.obtenirNumeroDeColonne() + direction[1];
                  if (i >= 0 && i < Echiquier.NOMBRE_DE_CASES_PAR_LIGNES && j < Echiquier.NOMBRE_DE_CASES_PAR_COLONNES && j >= 0)
                  {
                        newPosition = new Position(i, j);
                        positionDeFin = Echiquier.square.get(newPosition);
                        if (!isCheck(newPosition))
                        {
                              if (positionDeFin.getPiece() != null)

                              {
                                    if (positionDeFin.getPiece().obtenirCouleur() != this.pieceCouleur)
                                    {

                                          possibleMovement.add(newPosition);

                                    }
                              }
                              else
                              {
                                    possibleMovement.add(newPosition);
                              }
                        }

                  }
            }
            // roque
            if (!this.hasAlreadyMove)
            {
                  // roque de droite
                  i = positionDepart.obtenirNumeroDeLigne() + listPositionRoqueDroite[0][0];
                  j = positionDepart.obtenirNumeroDeColonne() + listPositionRoqueDroite[0][1];
                  newPosition = new Position(i, j);
                  if (Echiquier.square.get(new Position(i, j + 1)).getPiece() != null)
                  {
                        tour = Echiquier.square.get(new Position(i, j + 1)).getPiece();
                        if (tour.getPieceType() == PieceType.ROOK && !tour.hasAlreadyMove)
                        {
                              if (!isCheck(newPosition) && possibleMovement.contains(new Position(i, j - 1)))
                              {
                                    possibleMovement.add(newPosition);
                              }
                        }
                  }
                  // roque de gauche
                  i = positionDepart.obtenirNumeroDeLigne() + listPositionRoqueGauche[0][0];
                  j = positionDepart.obtenirNumeroDeColonne() + listPositionRoqueGauche[0][1];
                  newPosition = new Position(i, j);
                  if (Echiquier.square.get(new Position(i, j - 2)).getPiece() != null)
                  {
                        tour = Echiquier.square.get(new Position(i, j - 2)).getPiece();
                        if (tour.getPieceType() == PieceType.ROOK && !tour.hasAlreadyMove)
                        {
                              if (!isCheck(newPosition) && possibleMovement.contains(new Position(i, j + 1)))
                              {
                                    possibleMovement.add(newPosition);
                              }
                        }
                  }
            }

            return possibleMovement;
      }

      public void setKingPosition(Position position)
      {
            this.kingPosition = position;
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
