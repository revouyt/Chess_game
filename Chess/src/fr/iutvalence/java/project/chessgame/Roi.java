package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;


/**
 * Une pièce de roi
 */
public class Roi extends Piece
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
    private final int[][] listPositionDiagonale = { { position, position }, { position, -position },
            { -position, -position }, { -position, position } };

    private final int[][] listPositionPion = { { 1, 1 }, { 1, -1 } };

    private final int[][] listPositionLigne = { { position, 0 }, { 0, -position }, { -position, 0 },
            { 0, position } };

    private final int[][] listPositionCavalier = { { 2, -1 }, { 2, 1 }, { -2, -1 }, { -2, 1 }, { 1, -2 },
            { 1, 2 }, { -1, -2 }, { -1, 2 } };

    /**
     * Créer un roi de couleur donnée
     *
     * @param couleur La couleur du roi
     */
    public Roi(Color couleur)
    {
        super(couleur);
        hasAlreadyMove = false;
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
        Position newPosition;
        int i, j;

        /* boucle des pions */
        for (int[] direction : listPositionPion)
        {
            i = positionDepart.obtenirNumeroDeLigne() + direction[0];
            j = positionDepart.obtenirNumeroDeColonne() + direction[1];
            if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0)
            {
                positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                if (positionDeFin.getPiece() == pion)
                {
                    return possibleMovement;
                }
            }
        }
        /* boucle des diagonales */
        for (int[] direction : listPositionDiagonale)
        {
            i = positionDepart.obtenirNumeroDeLigne() + direction[0];
            j = positionDepart.obtenirNumeroDeColonne() + direction[1];
            if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0)
            {
                positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                for (position = 1; position < 8; position++)
                {
                    if (positionDeFin.getPiece() == Fou && positionDeFin.getPiece() == Reine)
                    {
                        return possibleMovement;
                    }
                }
            }
        }

        /* boucle des lignes */
        for (int[] direction : listPositionLigne)
        {
            i = positionDepart.obtenirNumeroDeLigne() + direction[0];
            j = positionDepart.obtenirNumeroDeColonne() + direction[1];
            if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0)
            {
                positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                for (position = 1; position < 8; position++)
                {
                    if (positionDeFin.getPiece() == Tour && positionDeFin.getPiece() == Reine)
                    {
                        return possibleMovement;
                    }
                }
            }
        }

        /* boucle des cavaliers */
        for (int[] direction : listPositionCavalier)
        {
            i = positionDepart.obtenirNumeroDeLigne() + direction[0];
            j = positionDepart.obtenirNumeroDeColonne() + direction[1];
            if (i >= 0 || i < Echiquier.NOMBRE_DE_LIGNES || j < Echiquier.NOMBRE_DE_COLONNES || j >= 0)
            {
                positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));
                if (positionDeFin.getPiece() == cavalier)
                {
                    return possibleMovement;
                }
            }
        }
        possibleMovement.add(newPosition);
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
