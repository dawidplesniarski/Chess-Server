package pl.edu.pwsztar.domain.chess.JUnit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.edu.pwsztar.domain.chess.RulesOfGame;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KnightTest {
    private RulesOfGame knight = new RulesOfGame.Knight();

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
