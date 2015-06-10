package Junit;


import java.util.ArrayList;
import java.util.List;
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
            suite.addTest(new TestKing("testListePositionPossible"));
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
            Echiquier.poserPiece(echiquierTest, new Position(0, 0), kingTest);
            Echiquier.poserPiece(echiquierTest, new Position(4, 5), bishopTest);
            assertEquals("Le roi est en échec", kingTest.isCheck(new Position(0, 1)), true);
            assertEquals("Le roi n'est pas en échec", kingTest.isCheck(new Position(1, 0)), false);

      }

      public void testListePositionPossible()
      {

            Echiquier echiquierTest = new Echiquier("test");

            echiquierTest.getWhiteKing().setKingPosition(new Position(0, 0));
            echiquierTest.getWhiteKing().itMoved();
            Bishop bishopTest = new Bishop(ColorEnum.BLACK);
            Echiquier.poserPiece(echiquierTest, echiquierTest.getWhiteKing().getKingPosition(), echiquierTest.getWhiteKing());
            Echiquier.poserPiece(echiquierTest, new Position(4, 5), bishopTest);

            List<Position> testPossibleMovement1 = new ArrayList<Position>();
            List<Position> testPossibleMovement2 = new ArrayList<Position>();
            Position testPosition1 = new Position(1 + echiquierTest.getWhiteKing().getKingPosition().obtenirNumeroDeLigne(),
                        0 + echiquierTest.getWhiteKing().getKingPosition().obtenirNumeroDeColonne());
            Position testPosition2 = new Position(0 + echiquierTest.getWhiteKing().getKingPosition().obtenirNumeroDeLigne(),
                        1 + echiquierTest.getWhiteKing().getKingPosition().obtenirNumeroDeColonne());
            Position testPosition3 = new Position(1 + echiquierTest.getWhiteKing().getKingPosition().obtenirNumeroDeLigne(),
                        1 + echiquierTest.getWhiteKing().getKingPosition().obtenirNumeroDeColonne());
            testPossibleMovement1.add(testPosition1);
            testPossibleMovement1.add(testPosition3);
            testPossibleMovement2.add(testPosition2);
            testPossibleMovement2.add(testPosition3);
            if (echiquierTest.getWhiteKing().possibleMovements(echiquierTest.getWhiteKing().getKingPosition()) != null)
            {
                  assertEquals(
                              "La liste de position(s) possible(s) est exacte ",
                              echiquierTest.getWhiteKing().possibleMovements(echiquierTest.getWhiteKing().getKingPosition())
                                          .equals(testPossibleMovement1), true);
                  assertEquals(
                              "La liste de position(s) possible(s) est erronée",
                              echiquierTest.getWhiteKing().possibleMovements(echiquierTest.getWhiteKing().getKingPosition())
                                          .equals(testPossibleMovement2), false);

            }
      }
}