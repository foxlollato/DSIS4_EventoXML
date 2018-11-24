package main;


import view.JanelaPrincipal;
import javax.swing.*;


public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaPrincipal();
            }
        });

    }
}
