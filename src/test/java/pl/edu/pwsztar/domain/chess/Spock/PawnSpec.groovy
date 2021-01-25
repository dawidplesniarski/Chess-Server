package pl.edu.pwsztar.domain.chess.Spock

import pl.edu.pwsztar.domain.chess.RulesOfGame
import spock.lang.Specification
import spock.lang.Unroll

class PawnSpec extends Specification {

    @Unroll
    def "should move the pawn figure to the chosen space"() {
        given: "Create Pawn's figure"
        RulesOfGame pawn = new RulesOfGame.Pawn();
        when: "When trying to move the figure"
        boolean result = pawn.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Figure moved successfully"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        4      || 5      || 4    || 6    || true
        7      || 2      || 7    || 4    || true
        2      || 2      || 2    || 3    || true
        1      || 7      || 1    || 8    || true
    }

    @Unroll
    def "should not move the pawn figure to the chosen space"() {
        given: "Create Pawn's figure"
        RulesOfGame pawn = new RulesOfGame.Pawn();
        when: "When trying to move the figure"
        boolean result = pawn.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Cannot move figure to the selected area"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        4      || 5      || 5    || 6    || false
        1      || 1      || 2    || 8    || false
    }
}
