package view.botoes;


import model.Evento;
import xml.AlgoritimoLeituraXML;
import xml.LeitorJAXB;

public class BotaoJAXB extends BotaoAbstrato {

    public BotaoJAXB(String titulo) {
        super(titulo);
    }

    @Override
    public AlgoritimoLeituraXML getAlgoritimo(String arquivo) {
        LeitorJAXB leitor = null;

        if(arquivo != null){ //Seria mais interessante encapsular a variável arquivo (apenas a superclasse deve ter acesso direto a ela)
            leitor = new LeitorJAXB(arquivo);
            leitor.setClasses(Evento.class);
        }
        return leitor;
    }

}
