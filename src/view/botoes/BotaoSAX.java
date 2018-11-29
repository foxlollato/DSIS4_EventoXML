package view.botoes;


import xml.AlgoritimoLeituraXML;
import xml.LeitorSAX;

public class BotaoSAX extends BotaoAbstrato{

    public BotaoSAX(String titulo) {
        super(titulo);
    }

    @Override
    public AlgoritimoLeituraXML getAlgoritimo(String arquivo) {
        LeitorSAX leitor = null;
        leitor = new LeitorSAX(arquivo);
        //Aqui você poderia fornecer uma implementação de DefaultHandler para a classe LeitorSAX (classe SAX no seu código)

        return leitor;
    }
}
