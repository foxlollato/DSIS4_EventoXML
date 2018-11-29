package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import javax.xml.bind.JAXBElement;
import javax.xml.parsers.DocumentBuilderFactory;
import model.Evento;
import org.w3c.dom.Document;

public class LeitorJAXB implements AlgoritimoLeituraXML {

    private String arquivo;
    private Class[] classes;
    public void setClasses(Class... classes){
        this.classes  = classes;
    }

    public LeitorJAXB(String arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public Object ler() {
        Object object = null;
        try {
            JAXBContext context = JAXBContext.newInstance(classes);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            object = unmarshaller.unmarshal(new File(arquivo));
        }
        catch(JAXBException erro) {
            throw new RuntimeException(erro);
        }
        return object;
    }
}