package pl.edu.pwsztar.domain.chess;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BishopTest {

    private RulesOfGame bishop = new RulesOfGame.Bishop();
    private RulesOfGame knight = new RulesOfGame.Knight();
    private RulesOfGame king = new RulesOfGame.King();
    private RulesOfGame queen = new RulesOfGame.Queen();
    private RulesOfGame rook = new RulesOfGame.Rock();
    private RulesOfGame pawn = new RulesOfGame.Pawn();

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

    @Tag("Queen")
    @ParameterizedTest
    @CsvSource({
            "4, 4, 4, 8",
            "6, 4, 5, 3",
            "8, 8, 8, 5",
            "1, 8, 3, 6"
    })
    void checkCorrectMoveForQueen(int xStart, int yStart, int xStop, int yStop){
        assertTrue(queen.isCorrectMove(xStart, yStart, xStop, yStop));
    }
    @ParameterizedTest
    @CsvSource({
            "4, 4, 3, 2",
            "1, 1, 2, 8"
    })
    void checkIncorrectMoveForQueen(int xStart, int yStart, int xStop, int yStop){
        assertFalse(queen.isCorrectMove(xStart, yStart, xStop, yStop));
    }

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
//
//    @Tag("Pawn")
//    @ParameterizedTest
//    @CsvSource({
//            "4, 5, 4, 6",
//            "7, 2, 7, 4",
//            "2, 2, 2, 3",
//            "1, 7, 1, 8"
//    })
//    void checkCorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop){
//        assertTrue(pawn.isCorrectMove(xStart, yStart, xStop, yStop));
//    }
//    @ParameterizedTest
//    @CsvSource({
//            "4, 5, 5, 6",
//            "1, 1, 2, 8"
//    })
//    void checkIncorrectMoveForPawn(int xStart, int yStart, int xStop, int yStop){
//        assertFalse(pawn.isCorrectMove(xStart, yStart, xStop, yStop));
//    }
}
