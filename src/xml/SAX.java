package xml;

import model.Atividade;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import util.DataAdapter;
import util.TimeAdapter;


import java.util.ArrayList;
import java.util.List;

public class SAX extends DefaultHandler {

    private List<Atividade> lista;
    private Atividade atividade;
    private String valor;

    public List<Atividade> getLista() {
        return lista;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Início do parsing");
        lista = new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Fim do parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("atividade")) {
            atividade = new Atividade();
            lista.add(atividade);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        valor = String.valueOf(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        try {

            if (qName.equals("tipo")) {
                atividade.setTipo(valor);
            } else if (qName.equals("título")) {
                atividade.setTitulo(valor);
            } else if (qName.equals("dia")) {

                atividade.setDia(new DataAdapter().unmarshal(valor));

            } else if (qName.equals("horário")) {
                atividade.setHorario(new TimeAdapter().unmarshal(valor));

            } else if (qName.equals("responsável")) {
                atividade.setResponsavel(valor);
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
