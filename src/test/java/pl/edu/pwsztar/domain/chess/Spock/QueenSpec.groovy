package pl.edu.pwsztar.domain.chess.Spock

import pl.edu.pwsztar.domain.chess.RulesOfGame
import spock.lang.Specification
import spock.lang.Unroll

class QueenSpec extends Specification {

    @Unroll
    def "should move the queen figure to the chosen space"() {
        given: "Create Queen's figure"
        RulesOfGame queen = new RulesOfGame.Queen();
        when: "When trying to move the figure"
        boolean result = queen.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Figure moved successfully"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        4      || 4      || 4    || 8    || true
        6      || 4      || 5    || 3    || true
        8      || 8      || 8    || 5    || true
        1      || 8      || 3    || 6    || true
    }

    @Unroll
    def "should not move the queen figure to the chosen space"() {
        given: "Create Queen's figure"
        RulesOfGame queen = new RulesOfGame.Queen();
        when: "When trying to move the figure"
        boolean result = queen.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Cannot move figure to the selected area"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        4      || 4      || 3    || 2    || false
        1      || 1      || 2    || 8    || false
    }
}
