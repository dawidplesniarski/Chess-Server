package pl.edu.pwsztar.domain.chess;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public interface RulesOfGame {

    /**
     * Metoda zwraca true, tylko gdy przejscie z polozenia
     * (xStart, yStart) na (xEnd, yEnd) w jednym ruchu jest zgodne
     * z zasadami gry w szachy
     */
    boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd);

    @Component
    @Qualifier("Bishop")
    class Bishop implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            if(xStart == xEnd && yStart == yEnd) {
                return false;
            }

            return Math.abs(xEnd - xStart) == Math.abs(yEnd - yStart);
        }
    }

    @Component
    @Qualifier("Knight")
    class Knight implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            int col = Math.abs(yEnd - yStart);
            int row = Math.abs(xEnd - xStart);
            return ((row == 2 && col == 1) || (row == 1 && col == 2));
        }
    }
    @Component
    @Qualifier("King")
    class King implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            //return (((xEnd == xStart) || (xEnd == xStart + 1) || (xEnd == xStart - 1)) && ((yEnd == yStart)) || (yEnd == yStart+1) || (yEnd == yStart -1));
            return Math.abs(xEnd - xStart) < 2 && Math.abs(yEnd - yStart) < 2;
        }
    }

    @Component
    @Qualifier("Queen")
    class Queen implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            return true;
        }
    }

    @Component
    @Qualifier("Rock")
    class Rock implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            return (xEnd == xStart) ^ (yEnd == yStart);
        }
    }

    @Component
    @Qualifier("Pawn")
    class Pawn implements RulesOfGame {

        @Override
        public boolean isCorrectMove(int xStart, int yStart, int xEnd, int yEnd) {
            return true;
        }
    }

    // TODO: Prosze dokonczyc implementacje kolejnych figur szachowych: Knight, King, Queen, Rock, Pawn
    // TODO: Prosze stosowac zaproponowane nazwy klas !!! (Prowadzacy zajecia posiada wlasne testy)
    // TODO: Kazda klasa powinna implementowac interfejs RulesOfGame
}
