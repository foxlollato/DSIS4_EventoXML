package xml;

import model.Atividade;
import model.Evento;
import model.TipoAtividade;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import util.DateTimeUtil;

public class SAX extends DefaultHandler {

    private Evento lista;
    private Atividade atividade;
    private String valor;

    public Evento getLista() {
        return lista;
    }

    @Override
    public void startDocument() throws SAXException {

        lista = new Evento();
    }

    @Override
    public void endDocument() throws SAXException {

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

        if (qName.equals("tipo")) {
            atividade.setTipo(TipoAtividade.valueOf(valor.toUpperCase()));
        } else if (qName.equals("título")) {
            atividade.setTitulo(valor);
        } else if (qName.equals("dia")) {

            atividade.setDia(DateTimeUtil.toLocalDate(valor));

        } else if (qName.equals("horário")) {
            atividade.setHorario(DateTimeUtil.toLocalTime(valor));

        } else if (qName.equals("responsável")) {
            atividade.setResponsavel(valor);
        } //ok

    }
}
