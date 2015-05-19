package fr.iutvalence.java.project.chessgame;


/**
 * Créer et afficher l'échiquier
 */
public class AfficheEchiquier
{
    public static void main(String[] args)
    {
        new GameLauncher().play();
        System.out.println(new Echiquier());
    }

}
