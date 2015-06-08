package fr.iutvalence.java.project.chessgame;


/**
 * Une position est l'intersection d'une ligne et d'une colonne
 */
public class Position
{
      /**
       * Le numéro de ligne
       */
      private final int numeroDeLigne;

      /**
       * Le numéro de colonne
       */
      private final int numeroDeColonne;

      /**
       * Créer une nouvelle position à une ligne et une colonne donnée
       *
       * @param numeroDeLigne le numéro de ligne
       * @param numeroDeColonne le numéro de colonne
       */
      public Position(int numeroDeLigne, int numeroDeColonne)
      {
            this.numeroDeLigne = numeroDeLigne;
            this.numeroDeColonne = numeroDeColonne;
      }

      @Override
      public boolean equals(Object obj)
      {
            if (this == obj)
            {
                  return true;
            }
            if (obj instanceof Position)
            {
                  Position other = (Position) obj;

                  if (this.numeroDeColonne == other.obtenirNumeroDeColonne() && this.numeroDeLigne == other.obtenirNumeroDeLigne())
                  {
                        return true;
                  }
            }
            return false;
      }

      @Override
      public int hashCode()
      {
            int result = 7;
            int multiplier = 17;

            result = result * multiplier + this.numeroDeColonne;
            result = result * multiplier + this.numeroDeLigne;

            return result;
      }

      /**
       * Obtenir le numéro de colonne
       *
       * @return le numéro de colonne
       */
      public int obtenirNumeroDeColonne()
      {
            return this.numeroDeColonne;
      }

      /**
       * Obtenir le numéro de ligne
       *
       * @return le numéro de ligne
       */
      public int obtenirNumeroDeLigne()
      {
            return this.numeroDeLigne;
      }
}
