package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BishopTest {

    private RulesOfGame bishop = new RulesOfGame.Bishop();
    private RulesOfGame knight = new RulesOfGame.Knight();

    @Tag("Bishop")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  20,  20",
            "-1, -1, -21, -21",
            "-1,  4, -3,   2 ",
            " 0,  1,  2,  -1 ",
    })
    void checkCorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(bishop.isCorrectMove(xStart, yStart, xStop, yStop));
    }

    @ParameterizedTest
    @CsvSource({
            "0,  1,  1, -2",
            "10, 10, 10,  10"
    })
    void checkIncorrectMoveForBishop(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(bishop.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @Tag("Knight")
    @ParameterizedTest
    @CsvSource({
            "4, 4, 3, 6",
            "5, 2, 6, 4",
            "1, 3, 2, 5",
            "2, 3, 1, 1"
    })
    void checkCorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(knight.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @ParameterizedTest
    @CsvSource({
            "4, 4, 4, 6",
            "6, 3, 6, 1",
    })
    void checkIncorrectMoveForKnight(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(knight.isCorrectMove(xStart, yStart, xStop, yStop));
    }

}
