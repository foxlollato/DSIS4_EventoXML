package view.botoes;


import xml.AlgoritimoLeituraXML;
import xml.LeitorSAX;

public class BotaoSAX extends BotaoAbstrato{

    public BotaoSAX(String titulo) {
        super(titulo);
    }

    @Override
    public AlgoritimoLeituraXML getAlgoritimo() {
        LeitorSAX leitor = null;
        chooseFile();
        if(super.arquivo != null){
            leitor = new LeitorSAX(super.arquivo);
        }
        return leitor;
    }
}
