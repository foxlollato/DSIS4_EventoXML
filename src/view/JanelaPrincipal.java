package view;


import dao.EventoDAO;
import model.Atividade;
import model.Evento;
import view.botoes.BotaoAbstrato;
import view.botoes.BotaoJAXB;
import view.botoes.BotaoSAX;
import xml.AlgoritimoLeituraXML;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JanelaPrincipal extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel lblXml;
    private BotaoAbstrato btnSax;
    private BotaoAbstrato btnJaxb;
    private AlgoritimoLeituraXML algoritimo;

    public JanelaPrincipal(){
        super("Janela Principal");
        criarComponentes();
        configurarJanela();

    }
    private void criarComponentes(){
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Importação de Eventos"));
        lblXml = new JLabel("Selecione a API");
        btnSax = new BotaoSAX("SAX");
        btnJaxb = new BotaoJAXB("JAXB");

        btnSax.addActionListener(this);
        btnJaxb.addActionListener(this);

        panel.add(lblXml);
        panel.add(btnSax);
        panel.add(btnJaxb);
        add(panel);
    }


    private void configurarJanela() {
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BotaoAbstrato botao = (BotaoAbstrato) e.getSource();
        algoritimo = botao.getAlgoritimo();
        EventoDAO eventoDao = new EventoDAO();
        Evento evento = (Evento) algoritimo.ler();
        evento.getAtividades().forEach(atividade -> eventoDao.salvar(atividade));
    }


}
