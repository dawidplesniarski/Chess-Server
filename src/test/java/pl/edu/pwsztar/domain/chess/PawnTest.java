package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {
    private RulesOfGame pawn = new RulesOfGame.Pawn();
    @Tag("Pawn")
    @ParameterizedTest
    @CsvSource({
            "4, 5, 4, 6",
            "7, 2, 7, 4",
            "2, 2, 2, 3",
            "1, 7, 1, 8"
    })
    void checkCorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop){
        assertTrue(pawn.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @ParameterizedTest
    @CsvSource({
            "4, 5, 5, 6",
            "1, 1, 2, 8"
    })
    void checkIncorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop){
        assertFalse(pawn.isCorrectMove(xStart, yStart, xStop, yStop));
    }
}
