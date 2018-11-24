package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "evento")
@XmlAccessorType(XmlAccessType.FIELD)
public class Evento {

    @XmlElement(name = "atividade")
    private List<Atividade> atividades;

    public List<Atividade> getAtividades() {
        return atividades;
    }
}
