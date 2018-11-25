package view.botoes;


import model.Evento;
import xml.AlgoritimoLeituraXML;
import xml.LeitorJAXB;

public class BotaoJAXB extends BotaoAbstrato {

    public BotaoJAXB(String titulo) {
        super(titulo);
    }

    @Override
    public AlgoritimoLeituraXML getAlgoritimo() {
        LeitorJAXB leitor = null;
        chooseFile();
        if(super.arquivo != null){
            leitor = new LeitorJAXB(super.arquivo);
            leitor.setClasses(Evento.class);
        }
        return leitor;
    }

}
