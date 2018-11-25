package view.botoes;


import xml.AlgoritimoLeituraXML;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public abstract class BotaoAbstrato extends JButton {
    protected String arquivo;

    public BotaoAbstrato(String titulo){
        super(titulo);
    }
    public abstract AlgoritimoLeituraXML getAlgoritimo();

    protected final void chooseFile(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter  =new FileNameExtensionFilter("XML Files", "xml");
        chooser.setFileFilter(filter);
        int check = chooser.showOpenDialog(null);

        if(check == JFileChooser.APPROVE_OPTION){
            this.arquivo = chooser.getSelectedFile().getPath();
        }else if(check == JFileChooser.ERROR_OPTION){
            JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo.");

        }
    }
}
