package main;

import dao.EventoDAO;
import model.Evento;
import view.JanelaPrincipal;
import xml.JAXB;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JanelaPrincipal j1 = new JanelaPrincipal();
            }
        });

    }
}
