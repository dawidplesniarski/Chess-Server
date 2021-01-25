package pl.edu.pwsztar.domain.chess.Spock

import pl.edu.pwsztar.domain.chess.RulesOfGame
import spock.lang.Specification
import spock.lang.Unroll

class BishopSpec extends Specification {

    @Unroll
    def "should move the bishop figure to the chosen space"() {
        given: "Create Bishop's figure"
        RulesOfGame bishop = new RulesOfGame.Bishop();
        when: "When trying to move the figure"
        boolean result = bishop.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Figure moved successfully"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        0      || 0      || 20   || 20   || true
        -1     || -1     || -21  || -21  || true
        -1     || 4      || -3   || 2    || true
        0      || 1      || 2    || -1   || true
    }


    @Unroll
    def "should not move the bishop figure to the chosen space"() {
        given: "Create Bishop's figure"
        RulesOfGame bishop = new RulesOfGame.Bishop();
        when: "When trying to move the figure"
        boolean result = bishop.isCorrectMove(xStart, yStart, xEnd, yEnd);
        then: "Cannot move figure to the selected area"
        result == expected
        where:
        xStart || yStart || xEnd || yEnd || expected
        0      || 1      || 1    || -2   || false
        10     || 10     || 10   || 10   || false
    }
}
