package view;

import dao.EventoDAO;
import model.Atividade;
import model.Evento;
import org.xml.sax.SAXException;
import xml.JAXB;
import xml.SAX;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JanelaPrincipal extends JFrame {

    private JPanel panel;
    private JLabel lblXml;
    private JButton btnSax;
    private JButton btnJaxb;

    public JanelaPrincipal(){
        super("Janela Principal");
        criarComponentes();
        configurarJanela();

    }
    private void criarComponentes(){
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Importação de Eventos"));
        lblXml = new JLabel("Selecione a API");
        btnSax = new JButton("SAX");
        btnJaxb = new JButton("JAXB");

        btnSax.addActionListener(this::apiSax);
        btnJaxb.addActionListener(this::apiJaxb);

        panel.add(lblXml);
        panel.add(btnSax);
        panel.add(btnJaxb);
        add(panel);
    }

    private void apiJaxb(ActionEvent actionEvent) {


            String arquivo = chooseFile();

            if(!arquivo.equals(null)){
                JAXB p = new JAXB(arquivo);

                Evento evento = (Evento) p.lerXML(Evento.class);

                EventoDAO eventoDao = new EventoDAO();

                evento.getAtividades().forEach(atividade -> eventoDao.salvar(atividade));

                JOptionPane.showMessageDialog(null,"Dados carregados com êxito");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao carregar o arquivo.");           }




    }

    private void apiSax(ActionEvent actionEvent) {
        String arquivo = chooseFile();

        if(!arquivo.equals(null)) {

            SAXParserFactory factory = SAXParserFactory.newInstance();

            try (InputStream input = new FileInputStream(new File(arquivo))) {

                SAXParser parser = factory.newSAXParser();

                SAX leitura = new SAX();

                parser.parse(input, leitura);

                List<Atividade> evento = leitura.getLista();
                EventoDAO eventoDao = new EventoDAO();
                evento.forEach(atvidade -> eventoDao.salvar(atvidade));

            } catch (ParserConfigurationException | SAXException | IOException erro) {
                throw new RuntimeException(erro);
            }
            JOptionPane.showMessageDialog(null,"Dados carregados com êxito");
        }else{
            JOptionPane.showMessageDialog(null,"Erro ao carregar o arquivo.");
        }

    }

    private void configurarJanela() {
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private  String chooseFile(){
         JFileChooser chooser = new JFileChooser();
         FileNameExtensionFilter filter  =new FileNameExtensionFilter("XML Files", "xml");
         chooser.setFileFilter(filter);
         String arquivo = null;

         int check = chooser.showOpenDialog(null);
         if(check == JFileChooser.APPROVE_OPTION){

             arquivo = chooser.getSelectedFile().getPath();

         }else if(check == JFileChooser.ERROR_OPTION){
             JOptionPane.showMessageDialog(null,"Erro ao abrir o arquivo.");
         }

        return arquivo;
    }
}
