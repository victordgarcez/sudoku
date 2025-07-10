package Model;

public enum EtapasDoJogoEnum {
    NAO_INICIADO("Não iniciado."),
    INCOMPLETO("Incompleto."),
    COMPLETO("Completo");

    private String label;

    EtapasDoJogoEnum(final String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
