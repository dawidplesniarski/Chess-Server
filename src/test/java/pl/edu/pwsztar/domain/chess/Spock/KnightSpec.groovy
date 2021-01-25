package pl.edu.pwsztar.domain.chess.Spock

import pl.edu.pwsztar.domain.chess.RulesOfGame
import spock.lang.Specification
import spock.lang.Unroll

class KnightSpec extends Specification {

    @Unroll
    def "should move the knight figure to the chosen space"() {
        given: "Create Knight's figure"
        RulesOfGame knight = new RulesOfGame.Knight();
        when: "When trying to move the figure"
        boolean result = knight.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Figure moved successfully"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        4      || 4      || 3    || 6    || true
        5      || 2      || 6    || 4    || true
        1      || 3      || 2    || 5    || true
        2      || 3      || 1    || 1    || true
    }

    @Unroll
    def "should not move the knight figure to the chosen space"() {
        given: "Create Knight's figure"
        RulesOfGame knight = new RulesOfGame.Knight();
        when: "When trying to move the figure"
        boolean result = knight.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Cannot move figure to the selected area"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        4      || 4      || 4    || 6    || false
        6      || 3      || 6    || 1    || false
    }
}
