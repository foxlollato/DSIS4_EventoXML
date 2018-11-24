package dao;

import bd.ConexaoBD;
import model.Atividade;
import util.DateUtil;
import util.TimeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventoDAO {

        public void salvar(Atividade atividade){
        ConexaoBD conexaoBD = ConexaoBD.getInstance();
        String sql = "insert into atividade(tipo, titulo, dia, horario, responsavel) values(?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pStat = null;
        try{
            con = conexaoBD.getConection();
            con.setAutoCommit(false);
            pStat = con.prepareStatement(sql);
            pStat.setString(1, atividade.getTipo());
            pStat.setString(2, atividade.getTitulo());
            pStat.setDate(3, DateUtil.toSqlDate(atividade.getDia()));
            pStat.setTime(4, TimeUtil.toSqlTime(atividade.getHorario()));
            pStat.setString(5,atividade.getResponsavel());
            pStat.executeUpdate();
            con.commit();

        }
        catch(SQLException erro){
            throw new RuntimeException(erro);
       }
        finally{
            fecharRecursos(con, pStat);
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
        catch(SQLException erro){
            erro.printStackTrace(); //É possível também relançar a exception como uma RuntimeException
        }
    }
}