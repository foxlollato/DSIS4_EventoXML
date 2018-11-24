/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author Poty
 */
public class ConexaoBD {
    private String user = "evento";
    private String pass = "evento";
    private String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private String driver = "oracle.jdbc.OracleDriver";

    private BasicDataSource ds; //um objeto do tipo BasicDataSource representará nosso pool de conexões

    private static ConexaoBD conexaoBD;

    private ConexaoBD(){
        ds = new BasicDataSource();
        ds.setUsername(user);
        ds.setPassword(pass);
        ds.setUrl(url);
        ds.setDriverClassName(driver);
    }

    public static ConexaoBD getInstance(){
        if(conexaoBD == null){
            conexaoBD = new ConexaoBD();
        }
        return conexaoBD;
    }

    public Connection getConection() throws SQLException{
        return ds.getConnection();
    }
}