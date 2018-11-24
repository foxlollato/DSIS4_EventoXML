package model;

import util.DataAdapter;
import util.TimeAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.LocalTime;

@XmlAccessorType(XmlAccessType.FIELD)
public class Atividade {

    @XmlElement(name = "tipo")
    private String tipo;

    @XmlElement(name = "título")
    private String titulo;

    @XmlElement(name = "dia")
    @XmlJavaTypeAdapter(DataAdapter.class)
    private LocalDate dia;

    @XmlElement(name = "horário")
    @XmlJavaTypeAdapter(TimeAdapter.class)
    private LocalTime horario;

    @XmlElement(name = "responsável")
    private String responsavel;

    public Atividade(String tipo, String titulo, LocalDate dia, LocalTime horario, String responsavel) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.dia = dia;
        this.horario = horario;
        this.responsavel = responsavel;
    }

    public Atividade() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
