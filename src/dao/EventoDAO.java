package dao;

import bd.ConexaoBD;
import model.Atividade;
import model.Evento;
import util.DateTimeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EventoDAO {

        //O problema desta solução é que cada atividade é gravada mesmo que alguma outra não possa ser gravada
        //Em outras palavras, não é criada uma transação para todas as atividades, mas para cada uma delas
        //O correto seria criar um método que recebesse uma coleção de atividades e gravasse todas elas no contexto de uma única transação
        //Dica: Você pode manter o método salvar(Atividade atividade) abaixo, e criar outro método que receba uma lista de atividades reutilizando código
        //adicionato metodo. seria isso?

        public void salvarAtividades(Evento evento){
            ConexaoBD conexaoBD = ConexaoBD.getInstance();
            //try com recursos - alterado
            try(Connection con = conexaoBD.getConection()){
                con.setAutoCommit(false);
                evento.getAtividades().forEach(atividade -> salvar(atividade,con));
                con.commit();
            }catch(SQLException erro){
                throw new RuntimeException(erro);
            }
        }

        private void salvar(Atividade atividade, Connection con){
            String sql = "insert into atividade(tipo, titulo, diaHora, responsavel) values(?,?,?,?)";
            //try com recursos - alterado
            try(PreparedStatement pStat = con.prepareStatement(sql)){
                pStat.setString(1, atividade.getTipo().getValor());
                pStat.setString(2, atividade.getTitulo());
                pStat.setTimestamp(3, DateTimeUtil.toTimeStamp(atividade.getDia(), atividade.getHorario()));
                pStat.setString(4,atividade.getResponsavel());
                pStat.executeUpdate();
            }catch (SQLException erro1){
                try{
                    con.rollback();
                }catch (SQLException erro2){
                    throw new RuntimeException(erro2);
                }
                throw new RuntimeException(erro1);
            }
    }

    private void fecharRecursos(Connection con, PreparedStatement pStat){
        try{
            if(con != null){
                con.close();
            }
            if(pStat != null){
                pStat.close();
            }
        }
        catch(SQLException erro){               //alterado, mas acho que nao usa mais, rs
            throw new RuntimeException(erro); //É possível também relançar a exception como uma RuntimeException
        }
    }
}
