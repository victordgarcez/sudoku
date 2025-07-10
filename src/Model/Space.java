package Model;

public class Space {

    //atributos
    private Integer valorAtual;
    private final int valorEsperado;
    private final boolean fixa;

    //construtor
    public Space(int valorEsperado, boolean fixa) {
        this.valorEsperado = valorEsperado;
        this.fixa = fixa;
        if (fixa){
            valorAtual = valorEsperado;
        }
    }


    //getters e set
    public Integer getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(Integer valorAtual) { //unico valor que pode ser alterado
        if(fixa) return;
        this.valorAtual = valorAtual;
    }

    public void limparEspaco(){
        setValorAtual(null);
    }

    public int getValorEsperado() {
        return valorEsperado;
    }

    public boolean isFixa() {
        return fixa;
    }

}
