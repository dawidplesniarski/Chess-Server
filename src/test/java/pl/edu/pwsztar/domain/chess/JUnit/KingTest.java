package pl.edu.pwsztar.domain.chess.JUnit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.edu.pwsztar.domain.chess.RulesOfGame;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTest {
    private RulesOfGame king = new RulesOfGame.King();


    @Tag("King")
    @ParameterizedTest
    @CsvSource({
            "4, 4, 4, 5",
            "3, 3, 3, 4",
            "8, 8, 7, 7",
            "4, 8, 4, 7"
    })
    void checkCorrectMoveForKing(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @ParameterizedTest
    @CsvSource({
            "4, 4, 5, 6",
            "3, 3, 0, 0"
    })
    void checkIncorrectMoveForKing(int xStart, int yStart, int xStop, int yStop){
        assertFalse(king.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}
