package fr.iutvalence.java.project.chessgame;


import java.util.ArrayList;
import java.util.List;


/**
 * Une pièce de cavalier
 */
public class Cavalier extends Piece
{
    /**
     * La liste des différentes positions possible terme de coordonnées
     */
    private final int[][] listPosition = { { 2, -1 }, { 2, 1 }, { -2, -1 }, { -2, 1 }, { 1, -2 }, { 1, 2 },
            { -1, -2 }, { -1, 2 } };

    /**
     * Créer un cavalier de couleur donnée
     *
     * @param couleur La couleur du cavalier
     */
    public Cavalier(Color couleur)
    {
        super(couleur);
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

        for (int[] direction : listPosition)
        {
            i = positionDepart.obtenirNumeroDeLigne() + direction[0];
            j = positionDepart.obtenirNumeroDeColonne() + direction[1];

            if (i < 0 || i >= Echiquier.NOMBRE_DE_LIGNES || j >= Echiquier.NOMBRE_DE_COLONNES || j < 0)
            {
                positionDeFin = Echiquier.square.get(newPosition = new Position(i, j));

                if (positionDeFin.getPiece() != null)
                {
                    if (positionDeFin.getPiece().obtenirCouleur() == this.couleur)
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
        return possibleMovement;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "C" + super.toString();
    }

}
