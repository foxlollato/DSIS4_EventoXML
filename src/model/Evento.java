package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "evento")
@XmlAccessorType(XmlAccessType.FIELD)
public class Evento {

    @XmlElement(name = "atividade")
    private List<Atividade> atividades;

    public Evento(){
        atividades = new ArrayList<>();
    }
    public List<Atividade> getAtividades() {
        return atividades;
    }
    public boolean add(Atividade atividade){
        return atividades.add(atividade);
    }

    @Override
    public String toString() {
        return "Evento{" +
                "atividades=" + atividades +
                '}';
    }
}
