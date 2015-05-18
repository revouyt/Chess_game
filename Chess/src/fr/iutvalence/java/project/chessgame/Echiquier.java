package fr.iutvalence.java.project.chessgame;


import java.util.HashMap;


/**
 * Représente un échiquier
 */
public class Echiquier
{
    /**
     * Le nombre de cases par ligne
     */
    public static final int NOMBRE_DE_LIGNES = 8;

    /**
     * Le nombre de cases par colonne
     */
    public static final int NOMBRE_DE_COLONNES = 8;

    /**
     * Les cases de l'échiquier
     */
    public static HashMap<Position, Square> square = new HashMap<Position, Square>();

    /**
     * Créer un nouvel échiquier et placer les pièces à leurs places initiales
     */
    public Echiquier()
    {
        this.creerEchiquier();
        this.poserPieces();
    }

    /**
     * Création de l'échiquier
     */
    private void creerEchiquier()
    {
        for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++)
        {
            for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
            {
                if ((numeroDeLigne + numeroDeColonne) % 2 == 0)
                {
                    square.put(new Position(numeroDeLigne, numeroDeColonne), new Square(Color.BLANC));
                }
                else
                {
                    square.put(new Position(numeroDeLigne, numeroDeColonne), new Square(Color.NOIR));
                }
            }
        }
    }

    /**
     * Déplacer une pièce
     *
     * @param positionDepart la case de départ
     * @param positionArrivee la case d'arrivée
     */
    public void deplacerPiece(Position positionDepart, Position positionArrivee)
    {
        Piece pieceADeplacer = this.obtenirPiece(positionDepart);
        if (pieceADeplacer == null)
        {
            return;
        }
        this.poserPiece(positionArrivee, pieceADeplacer);
        this.obtenirCase(positionDepart).removePiece();
    }

    /**
     * Obtenir une case à une position donnée
     *
     * @param position la position de la case
     * @return la case de l'échiquier à la position donnée
     */
    private Square obtenirCase(Position position)
    {
        return square.get(position);
    }

    /**
     * Obtenir la pièce à une position donnée
     *
     * @param position la position
     * @return la pièce posée sur la case ou <tt>null</tt> s'il n'y a pas de
     *         pièce
     */
    public Piece obtenirPiece(Position position)
    {
        return square.get(position).getPiece();
    }

    /**
     * Pose une pièce à une position donnée
     *
     * @param position La position d'arrivée
     * @param piece La pièce à poser
     */
    private void poserPiece(Position position, Piece piece)
    {
        this.obtenirCase(position).setPiece(piece);
    }

    /**
     * Posage de toutes les pièces à leurs positions d'origine
     */
    private void poserPieces()
    {
        this.poserPiece(new Position(0, 0), new Tour(Color.NOIR));
        this.poserPiece(new Position(0, 1), new Cavalier(Color.NOIR));
        this.poserPiece(new Position(0, 2), new Fou(Color.NOIR));
        this.poserPiece(new Position(0, 3), new Reine(Color.NOIR));
        this.poserPiece(new Position(0, 4), new Roi(Color.NOIR));
        this.poserPiece(new Position(0, 5), new Fou(Color.NOIR));
        this.poserPiece(new Position(0, 6), new Cavalier(Color.NOIR));
        this.poserPiece(new Position(0, 7), new Tour(Color.NOIR));

        for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
        {
            this.poserPiece(new Position(1, numeroDeColonne), new Pion(Color.NOIR));
            this.poserPiece(new Position(6, numeroDeColonne), new Pion(Color.BLANC));
        }

        this.poserPiece(new Position(7, 0), new Tour(Color.BLANC));
        this.poserPiece(new Position(7, 1), new Cavalier(Color.BLANC));
        this.poserPiece(new Position(7, 2), new Fou(Color.BLANC));
        this.poserPiece(new Position(7, 3), new Reine(Color.BLANC));
        this.poserPiece(new Position(7, 4), new Roi(Color.BLANC));
        this.poserPiece(new Position(7, 5), new Fou(Color.BLANC));
        this.poserPiece(new Position(7, 6), new Cavalier(Color.BLANC));
        this.poserPiece(new Position(7, 7), new Tour(Color.BLANC));
    }

    /**
     * Obtenir une représentation en ASCII-art de l'échiquier, où les cases
     * vides noires sont représentées par des v et les cases vides blanches par
     * des V.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        String echiquierAsciiArt = "------------------------------------------------\n";

        for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++)
        {
            for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
            {
                echiquierAsciiArt += this.obtenirCase(new Position(numeroDeLigne, numeroDeColonne));
            }
            echiquierAsciiArt += "\n------------------------------------------------\n";
        }

        return echiquierAsciiArt;
    }
}
