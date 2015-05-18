package fr.iutvalence.java.project.chessgame;


/**
 * Les deux couleurs du jeu
 */
public enum Color
{
    /**
     * La couleur blanche
     */
    BLANC,

    /**
     * La couleur noire
     */
    NOIR;

    /**
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString()
    {
        if (this == BLANC)
        {
            return "b";
        }
        else
        {
            return "n";
        }
    }
}
