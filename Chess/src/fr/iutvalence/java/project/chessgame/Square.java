package fr.iutvalence.java.project.chessgame;


/**
 * Représente une case de l'échiquier
 */
public class Square
{
    /**
     * La couleur de la case (Color.BLANC ou Color.NOIR)
     */
    private final Color color;

    /**
     * Le pièce posée sur la case, <tt>null</tt> si il n'y a pas de pièce
     */
    private Piece piece;

    /**
     * Créer une case de couleur donnée et sans pièce
     * 
     * @param couleur La couleur de la case
     */
    public Square(Color couleur)
    {
        this.color = couleur;
        this.piece = null;
    }

    /**
     * Obtenir la couleur de la case
     * 
     * @return la couleur de la case
     */
    public Color getCouleur()
    {
        return this.color;
    }

    /**
     * Obtenir la pièce posée sur la case
     * 
     * @return la pièce posée sur la case, ou <tt>null</tt> si il n'y a pas de
     *         pièce
     */
    public Piece getPiece()
    {
        return this.piece;
    }

    /**
     * Enlever une pièce de la case.
     * 
     * @return la pièce occupant précédemment la case (si elle existait)
     */
    public Piece removePiece()
    {
        Piece piecePrecedente = this.piece;
        this.piece = null;
        return piecePrecedente;
    }

    /**
     * Poser une pièce sur la case (s'il avait déjà une pièce, celle-ci est
     * remplacée)
     * 
     * @param piece la pièce à poser
     */
    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        String delimiteurDeCase = "|";
        String apresPiece = "-" + this.color + delimiteurDeCase;
        if (this.piece == null)
        {
            return delimiteurDeCase + "()" + apresPiece;
        }
        return delimiteurDeCase + this.piece + apresPiece;
    }

}
