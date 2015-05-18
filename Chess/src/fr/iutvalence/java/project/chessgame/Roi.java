package fr.iutvalence.java.project.chessgame;


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
        // TODO à implémenter
        return null;
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
