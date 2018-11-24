package xml;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */
public class JAXB {
    private String arquivo;

    public JAXB(String arquivo){
        this.arquivo=arquivo;
    }

    public Object lerXML(Class... clazz){
        Object object = null;
        try{
            JAXBContext context = JAXBContext.newInstance(clazz);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            object = unmarshaller.unmarshal(new File(arquivo));


        }catch(JAXBException erro){
            erro.printStackTrace();
        }
        return object;
    }

    public void gravarXML(Object object, Class... clazz){
        try{
            JAXBContext context = JAXBContext.newInstance(clazz);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, new File(arquivo));
            marshaller.marshal(object, System.out);
        }catch(JAXBException erro){
            erro.printStackTrace();
        }
    }

    public void setArquivo(String arquivo){
        this.arquivo = arquivo;
    }
}
