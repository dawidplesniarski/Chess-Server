package pl.edu.pwsztar.domain.chess.Spock

import pl.edu.pwsztar.domain.chess.RulesOfGame
import spock.lang.Specification
import spock.lang.Unroll

class KingMovesSpec extends Specification {

    @Unroll
    def "should move the king figure to the chosen space"() {
        given: "Create King's figure"
        RulesOfGame king = new RulesOfGame.King();
        when: "When trying to move the figure"
        boolean result = king.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Figure moved successfully"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        4      || 4      || 5    || 5    || true
        5      || 4      || 5    || 5    || true
        5      || 4      || 6    || 4    || true
        2      || 2      || 1    || 1    || true
    }

    @Unroll
    def "should not move the king figure to the chosen space"() {
        given: "Create King's figure"
        RulesOfGame king = new RulesOfGame.King();
        when: "When trying to move the figure"
        boolean result = king.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Cannot move figure to the selected area"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        4      || 4      || 2    || 6    || false
        2      || 5      || 1    || 2    || false
        3      || 2      || 7    || 4    || false
        5      || 4      || 7    || 4    || false
    }
}
