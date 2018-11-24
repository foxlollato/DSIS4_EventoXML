package xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LeitorSAX implements AlgoritimoLeituraXML {

    private String arquivo;

    public LeitorSAX(String arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public Object ler() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        Object object = null;
        try(InputStream input = new FileInputStream(arquivo))
        {
            SAXParser parser = factory.newSAXParser();
            SAX handler = new SAX();
            parser.parse(input, handler);
            object = handler.getLista();
        }
        catch(ParserConfigurationException | SAXException | IOException erro) {
            throw new RuntimeException(erro);
        }
        return object;
    }
}
