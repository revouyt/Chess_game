package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;


/**
 * Une pièce de roi
 */
public class King extends AbstractPiece
{
      /**
       * position de roque
       */
      public final static Position ROQUE1 = new Position(0, 2);

      /**
       * position de roque
       */
      public final static Position ROQUE2 = new Position(0, 6);

      /**
       * position de roque
       */
      public final static Position ROQUE3 = new Position(7, 2);

      /**
       * position de roque
       */
      public final static Position ROQUE4 = new Position(7, 6);

      /**
       * Default : 0 when it hasn't moved yet, 1 when it already moved
       */
      private boolean hasAlreadyMove;

      /**
       * Valeur de la coordonnée de la pièce
       */
      private int position = 1;

      /**
       * Les listes des différentes positions possible en terme de coordonnées
       */
      private final int[][] listPositionDiagonale = { { position, position }, { position, -position }, { -position, -position },
                  { -position, position } };

      private final int[][] listPositionPionBlanc = { { -1, 1 }, { -1, -1 } };

      private final int[][] listPositionPionNoir = { { 1, 1 }, { 1, -1 } };

      private final int[][] listPositionLigne = { { position, 0 }, { 0, -position }, { -position, 0 }, { 0, position } };

      private final int[][] listPositionCavalier = { { 2, -1 }, { 2, 1 }, { -2, -1 }, { -2, 1 }, { 1, -2 }, { 1, 2 }, { -1, -2 }, { -1, 2 } };

      private final int[][] listPositionRoi = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, -1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 } };

      private final int[][] listPositionRoqueGauche = { { 0, -2 } };

      private final int[][] listPositionRoqueDroite = { { 0, 2 } };

      /**
       * Créer un roi de couleur donnée
       *
       * @param couleur La couleur du roi
       */
      public King(ColorEnum couleur)
      {
            super(couleur);
            this.hasAlreadyMove = false;
            this.Piecetype = PieceType.KING;
            if (couleur == ColorEnum.BLACK)
            {
                  this.PieceName = ListPieces.BLACK_KING;
            }
            else
            {
                  this.PieceName = ListPieces.WHITE_KING;
            }
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
            if (this.couleur == ColorEnum.BLACK)
            {
                  /* boucle-test des Pions */
                  for (int[] direction1 : this.listPositionPionBlanc)
                  {
                        i = positionDepart.obtenirNumeroDeLigne() + direction1[0];
                        j = positionDepart.obtenirNumeroDeColonne() + direction1[1];
                        if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
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
                        i = positionDepart.obtenirNumeroDeLigne() + direction1[0];
                        j = positionDepart.obtenirNumeroDeColonne() + direction1[1];
                        if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                        {
                              squareTest = Echiquier.square.get(new Position(i, j));
                              if (squareTest.getPiece() != null)
                              {
                                    if (squareTest.getPiece().getPieceName() == ListPieces.BLACK_PAWN)
                                    {
                                          return true;
                                    }
                                    else
                                    {
                                          break;
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
                        i = positionDepart.obtenirNumeroDeLigne() + direction2[0] * compteurDirection;
                        j = positionDepart.obtenirNumeroDeColonne() + direction2[1] * compteurDirection;
                        if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                        {
                              squareTest = Echiquier.square.get(new Position(i, j));
                              if (squareTest.getPiece() != null)
                              {

                                    if (squareTest.getPiece().getPieceType() == PieceType.BISHOP
                                                || squareTest.getPiece().getPieceType() == PieceType.QUEEN)
                                    {
                                          if (squareTest.getPiece().obtenirCouleur() != this.couleur)
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
                        i = positionDepart.obtenirNumeroDeLigne() + direction3[0] * compteurDirection;
                        j = positionDepart.obtenirNumeroDeColonne() + direction3[1] * compteurDirection;
                        if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                        {
                              squareTest = Echiquier.square.get(new Position(i, j));
                              if (squareTest.getPiece() != null)
                              {
                                    if (squareTest.getPiece().getPieceType() == PieceType.ROOK
                                                || squareTest.getPiece().getPieceType() == PieceType.QUEEN)
                                    {
                                          if (squareTest.getPiece().obtenirCouleur() != this.couleur)
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
                  i = positionDepart.obtenirNumeroDeLigne() + direction4[0];
                  j = positionDepart.obtenirNumeroDeColonne() + direction4[1];
                  if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                  {
                        squareTest = Echiquier.square.get(new Position(i, j));
                        if (squareTest.getPiece() != null)
                        {
                              if (squareTest.getPiece().getPieceType() == PieceType.KNIGHT)
                              {
                                    if (squareTest.getPiece().obtenirCouleur() != this.couleur)
                                    {
                                          return true;
                                    }
                              }
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
            Square positionDeFin;
            AbstractPiece tour;
            int i, j;
            /* boucle des déplacements possible du roi */
            for (int[] direction : this.listPositionRoi)
            {
                  i = positionDepart.obtenirNumeroDeLigne() + direction[0];
                  j = positionDepart.obtenirNumeroDeColonne() + direction[1];
                  if (i >= 0 && i < Echiquier.NOMBRE_DE_LIGNES && j < Echiquier.NOMBRE_DE_COLONNES && j >= 0)
                  {
                        positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                        newPosition = new Position(i, j);
                        if (!isCheck(newPosition))
                        {
                              if (positionDeFin.getPiece() != null)

                              {
                                    if (positionDeFin.getPiece().obtenirCouleur() != this.couleur)
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
                  tour = Echiquier.square.get(new Position(i, j + 1)).getPiece();
                  if (tour.getPieceType() == PieceType.ROOK && !tour.hasAlreadyMove)
                  {
                        if (!isCheck(newPosition) && possibleMovement.contains(new Position(i, j - 1)))
                        {
                              possibleMovement.add(newPosition);
                        }
                  }

                  // roque de gauche
                  i = positionDepart.obtenirNumeroDeLigne() + listPositionRoqueGauche[0][0];
                  j = positionDepart.obtenirNumeroDeColonne() + listPositionRoqueGauche[0][1];
                  newPosition = new Position(i, j);
                  tour = Echiquier.square.get(new Position(i, j - 2)).getPiece();
                  if (tour.getPieceType() == PieceType.ROOK && !tour.hasAlreadyMove)
                  {
                        if (!isCheck(newPosition) && possibleMovement.contains(new Position(i, j + 1)))
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
