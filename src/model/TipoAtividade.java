package model;

public enum TipoAtividade{ //ok
    PALESTRA("palestra"),
    MINICURSO("minicurso"),
    OFICINA("oficina");

    private String valor;

    TipoAtividade(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
}
