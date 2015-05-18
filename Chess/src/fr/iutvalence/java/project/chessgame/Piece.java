package fr.iutvalence.java.project.chessgame;


import java.util.List;


/**
 * Une pièce type
 */
public abstract class Piece
{
    /**
     * La couleur de la pièce
     */
    protected final Color couleur;

    /**
     * Créer une pièce de couleur donnée
     *
     * @param couleur la couleur
     */
    protected Piece(Color couleur)
    {
        this.couleur = couleur;
    }

    /**
     * Obtenir la couleur de la piece
     *
     * @return la couleur de la piece
     */
    public Color obtenirCouleur()
    {
        return this.couleur;
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
        return this.couleur.toString();
    }
}