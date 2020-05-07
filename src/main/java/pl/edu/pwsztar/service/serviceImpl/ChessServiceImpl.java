package pl.edu.pwsztar.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.edu.pwsztar.domain.chess.RulesOfGame;
import pl.edu.pwsztar.domain.dto.FigureMoveDto;
import pl.edu.pwsztar.service.ChessService;

@Service
public class ChessServiceImpl implements ChessService {

    private RulesOfGame bishop;
    private RulesOfGame knight;

    @Autowired
    public ChessServiceImpl(@Qualifier("Bishop") RulesOfGame bishop,
                            @Qualifier("Knight") RulesOfGame knight) {
        this.bishop = bishop;
        this.knight = knight;
    }

    @Override
    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {
        return true;
    }
}
