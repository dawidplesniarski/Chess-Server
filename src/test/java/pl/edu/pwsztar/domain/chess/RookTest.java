package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTest {
    private RulesOfGame rook = new RulesOfGame.Rock();
    @Tag("Rock")
    @ParameterizedTest
    @CsvSource({
            "4, 4, 4, 8",
            "6, 4, 1, 4",
            "8, 8, 5, 8",
            "1, 8, 3, 8"
    })
    void checkCorrectMoveForRock(int xStart, int yStart, int xStop, int yStop){
        assertTrue(rook.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @ParameterizedTest
    @CsvSource({
            "4, 4, 3, 2",
            "1, 1, 2, 8"
    })
    void checkIncorrectMoveForRock(int xStart, int yStart, int xStop, int yStop){
        assertFalse(rook.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}
