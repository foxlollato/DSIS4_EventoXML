package view.botoes;


import xml.AlgoritimoLeituraXML;
import xml.LeitorSAX;

public class BotaoSAX extends BotaoAbstrato{

    public BotaoSAX(String titulo) {
        super(titulo);
    }

    @Override
    public AlgoritimoLeituraXML getAlgoritimo() {
        chooseFile();
        LeitorSAX leitor = new LeitorSAX(arquivo);
        return leitor;
    }
}
