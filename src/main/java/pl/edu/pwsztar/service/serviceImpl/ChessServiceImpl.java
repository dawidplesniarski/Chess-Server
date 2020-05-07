package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.chess.RulesOfGame;
import pl.edu.pwsztar.domain.dto.FigureMoveDto;
import pl.edu.pwsztar.service.ChessService;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChessServiceImpl implements ChessService {

    private RulesOfGame bishop;
    private RulesOfGame knight;
    private RulesOfGame king;
    private RulesOfGame queen;
    private RulesOfGame rook;
    private RulesOfGame pawn;

    @Autowired
    public ChessServiceImpl(@Qualifier("Bishop") RulesOfGame bishop,
                            @Qualifier("Knight") RulesOfGame knight,
                            @Qualifier("King") RulesOfGame king,
                            @Qualifier("Queen") RulesOfGame queen,
                            @Qualifier("Rock") RulesOfGame rook,
                            @Qualifier("Pawn") RulesOfGame pawn) {
        this.bishop = bishop;
        this.knight = knight;
        this.king = king;
        this.queen = queen;
        this.rook = rook;
        this.pawn = pawn;
    }

    @Override
    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {
        int currentRow;
        int newRow;
        int currentCol;
        int newCol;
        List<String> startPoint = Arrays.asList(figureMoveDto.getStart().split("_"));
        List<String> destinationPoint = Arrays.asList(figureMoveDto.getDestination().split("_"));

        currentCol =  mapToInt(startPoint.get(0));
        currentRow = Integer.parseInt(startPoint.get(1));
        newCol = mapToInt(destinationPoint.get(0));
        newRow = Integer.parseInt(destinationPoint.get(1));

        switch(figureMoveDto.getType()){
            case BISHOP: {
                return bishop.isCorrectMove(currentCol, currentRow, newCol, newRow);
            }
            case KING: {
                return king.isCorrectMove(currentCol, currentRow, newCol, newRow);
            }
            case QUEEN: {
                return queen.isCorrectMove(currentCol, currentRow, newCol, newRow);
            }
            case PAWN: {
                return pawn.isCorrectMove(currentCol, currentRow, newCol, newRow);
            }
            case ROCK: {
                return rook.isCorrectMove(currentCol, currentRow, newCol, newRow);
            }
            case KNIGHT: {
                return knight.isCorrectMove(currentCol, currentRow, newCol, newRow);
            }
        }
        return false;
    }
    private Integer mapToInt(String key){
        Map<String,Integer> columns = new LinkedHashMap<>();
        columns.put("a",1);
        columns.put("b",2);
        columns.put("c",3);
        columns.put("d",4);
        columns.put("e",5);
        columns.put("f",6);
        columns.put("g",7);
        columns.put("h",8);

        return columns.get(key);
    }
}
