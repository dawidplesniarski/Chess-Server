package pl.edu.pwsztar.domain.chess.Spock

import pl.edu.pwsztar.domain.chess.RulesOfGame
import spock.lang.Specification
import spock.lang.Unroll

class RookSpec extends Specification {

    @Unroll
    def "should move the rook figure to the chosen space"() {
        given: "Create Rook's figure"
        RulesOfGame rook = new RulesOfGame.Rock();
        when: "When trying to move the figure"
        boolean result = rook.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Figure moved successfully"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        4      || 4      || 4    || 8    || true
        6      || 4      || 1    || 4    || true
        8      || 8      || 5    || 8    || true
        1      || 8      || 3    || 8    || true
    }

    @Unroll
    def "should not move the rook figure to the chosen space"() {
        given: "Create Rook's figure"
        RulesOfGame rook = new RulesOfGame.Rock();
        when: "When trying to move the figure"
        boolean result = rook.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Cannot move figure to the selected area"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        4      || 4      || 3    || 2    || false
        1      || 1      || 2    || 8    || false
    }
}
