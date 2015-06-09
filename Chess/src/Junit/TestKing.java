package Junit;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import fr.iutvalence.java.project.chessgame.Bishop;
import fr.iutvalence.java.project.chessgame.ColorEnum;
import fr.iutvalence.java.project.chessgame.Echiquier;
import fr.iutvalence.java.project.chessgame.King;
import fr.iutvalence.java.project.chessgame.Position;


public class TestKing extends TestCase
{

      public static Test suite()
      {
            TestSuite suite = new TestSuite();
            suite.addTest(new TestKing("testIsCheck"));
            // suite.addTest(new TestKing("testListePositionPossible"));
            return suite;
      }

      public TestKing(String name)
      {
            super(name);
      }

      public void testIsCheck()
      {
            Echiquier echiquierTest = new Echiquier("test");
            King kingTest = new King(ColorEnum.WHITE);
            Bishop bishopTest = new Bishop(ColorEnum.BLACK);
            echiquierTest.poserPiece(new Position(0, 0), kingTest);
            echiquierTest.poserPiece(new Position(4, 5), bishopTest);
            assertEquals("Le pièce est en échec", kingTest.isCheck(new Position(0, 1)), true);
            assertEquals("Le pièce n'est pas en échec", kingTest.isCheck(new Position(1, 0)), false);

      }

      /*
       * public void testListePositionPossible() { Echiquier echiquierTest = new
       * Echiquier(); echiquierTest.poserPiece(new Position(0, 0), new
       * King(ColorEnum.BLACK)); echiquierTest.poserPiece(new Position(4, 5),
       * new Bishop(ColorEnum.BLACK)); }
       */

}
