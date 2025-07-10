package service;

import Model.Board;
import Model.EtapasDoJogoEnum;
import Model.Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardService {
    private final static int BOARD_LIMIT = 9;

    //prop
    private final Board board;

    public BoardService(final Map<String, String> gameConfig) {
        this.board = new Board(initBoard(gameConfig));
    }

    public List<List<Space>> getSpaces(){
        return this.board.getEspacos();
    }

    public void reset(){
        this.board.reiniciar();
    }

    public boolean possuiErros(){
        return board.possuiErro();
    }

    public EtapasDoJogoEnum getEtapa(){
        return board.getEtapa();
    }

    public boolean jogoAcabou(){
        return board.jogoAcabou();
    }

    private List<List<Space>> initBoard(Map<String, String> gameConfig){
        List<List<Space>> spaces = new ArrayList<>();
        for (int i = 0; i < BOARD_LIMIT; i++) {
            spaces.add(new ArrayList<>());
            for (int j = 0; j < BOARD_LIMIT; j++) {
                var positionConfig = gameConfig.get("%s,%s".formatted(i, j));
                var expected = Integer.parseInt(positionConfig.split(",")[0]);
                var fixed = Boolean.parseBoolean(positionConfig.split(",")[1]);
                var currentSpace = new Space(expected, fixed);
                spaces.get(i).add(currentSpace);
            }
        }
        return spaces;
    }
}
