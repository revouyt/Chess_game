package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;


/**
 * Une pièce de pion
 */
public class Pion extends Piece
{
    /**
     * Default : 0 when it hasn't moved yet, 1 when it already moved
     */
    private boolean hasAlreadyMove;

    /**
     * La liste des différentes positions possible terme de coordonnées pour un
     * pion (ici une seule case)
     */
    private final int[][] listPosition = { { 1, 0 } };

    /**
     * La liste des différentes positions possible de prise de pièce en terme de
     * coordonnées
     */
    private final int[][] listPosition2 = { { 1, 1 }, { 1, -1 } };

    /**
     * Créer un pion de couleur donnée
     *
     * @param couleur La couleur du pion
     */
    public Pion(Color couleur)
    {
        super(couleur);
        this.hasAlreadyMove = false;
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
            i = positionDepart.obtenirNumeroDeLigne() + direction[0];
            j = positionDepart.obtenirNumeroDeColonne() + direction[1];
            if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0)
            {
                positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                if (positionDeFin.getPiece() != null)
                {
                    break;
                }
                else
                {
                    possibleMovement.add(newPosition);
                    i = positionDepart.obtenirNumeroDeLigne() + 2;
                    positionDeFin2 = Echiquier.square.get(newPosition = new Position(i, j));
                    if (!this.hasAlreadyMove && positionDeFin2.getPiece() != null)
                    {
                        possibleMovement.add(newPosition);
                    }
                }
            }
        }
        for (int[] direction2 : listPosition2)
        {
            i = positionDepart.obtenirNumeroDeLigne() + direction2[0];
            j = positionDepart.obtenirNumeroDeColonne() + direction2[1];
            if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0)
            {
                positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                if (positionDeFin.getPiece() == null)
                {
                    break;
                }
                else
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
        return "P" + super.toString();
    }

}
