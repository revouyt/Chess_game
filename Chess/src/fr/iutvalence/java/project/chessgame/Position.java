package fr.iutvalence.java.project.chessgame;


/**
 * Une position est l'intersection d'une ligne et d'une colonne
 */
public class Position
{

      private final int numeroDeLigne;


      private final int numeroDeColonne;


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


      public int obtenirNumeroDeColonne()
      {
            return this.numeroDeColonne;
      }


      public int obtenirNumeroDeLigne()
      {
            return this.numeroDeLigne;
      }
}
