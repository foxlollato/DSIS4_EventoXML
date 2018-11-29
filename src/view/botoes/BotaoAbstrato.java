package view.botoes;


import xml.AlgoritimoLeituraXML;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public abstract class BotaoAbstrato extends JButton {


    public BotaoAbstrato(String titulo){
        super(titulo);
    }

    public abstract AlgoritimoLeituraXML getAlgoritimo(String arquivo);


}
