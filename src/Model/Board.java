package Model;

import java.util.Collection;
import java.util.List;

import static Model.EtapasDoJogoEnum.COMPLETO;
import static Model.EtapasDoJogoEnum.INCOMPLETO;
import static Model.EtapasDoJogoEnum.NAO_INICIADO;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Board {

    //atributos
    private final List<List<Space>> espacos;

    //construtor
    public Board(List<List<Space>> espacos) {
        this.espacos = espacos;
    }

    public List<List<Space>> getEspacos() {
        return espacos;
    }

    //METODOS
    public EtapasDoJogoEnum getEtapa() {
        if (espacos.stream().flatMap(Collection::stream).noneMatch(s -> !s.isFixa() && nonNull(s.getValorAtual()))) {
            return NAO_INICIADO;
        }

        return espacos.stream().flatMap(Collection::stream).anyMatch(s -> isNull(s.getValorAtual())) ? INCOMPLETO : COMPLETO;
    }

    public boolean possuiErro() {
        if (getEtapa() == NAO_INICIADO) {
            return false;
        }

        return espacos.stream().flatMap(Collection::stream)
                .anyMatch(s -> !s.isFixa() && nonNull(s.getValorAtual()) && !s.getValorAtual().equals(s.getValorEsperado()));
    }
    

    public boolean mudarValor(final int coluna, final int linha, final int valor){
        var espaco = espacos.get(coluna).get(linha);
        if(espaco.isFixa()){
            return false;
        }

        espaco.setValorAtual(valor);
        return true;
    }

    public boolean limparValor(final int coluna, final int linha){
        var espaco = espacos.get(coluna).get(linha);
        if(espaco.isFixa()){
            return false;
        }

        espaco.limparEspaco();
        return true;
    }

    public void reiniciar(){
        espacos.forEach(c -> c.forEach(Space::limparEspaco));
    }

    public boolean jogoAcabou(){
        return !possuiErro() && getEtapa().equals(COMPLETO);
    }

}
