package br.com.cadastrooficina.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;

public class Pool implements InterfacePool {

	private InterfaceDataSource ds;
	private ArrayBlockingQueue<Connection> conexoesLivres;
	private HashMap<String,Connection> conexoesUtilizadas;
	private Integer numeroMaximoConexoes;
	private ResourceBundle config;
	private DataSource source;
	public Pool(){
	//q	config = ResourceBundle.getBundle("br.com.cadastrooficina.conexao.mysql");
    //	ds = new DataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/flamacadastro","root","");
    	
    	numeroMaximoConexoes = 1;
    	conexoesLivres = new ArrayBlockingQueue<Connection>(1, true);
    	conexoesUtilizadas =  new HashMap<String, Connection>();	
    	
    	
    	
	}
	@Override
	public Connection getConnection() {
Connection con = null;
		
		try {
			if(conexoesUtilizadas.size() < numeroMaximoConexoes){
				con = conexoesLivres.poll();
				if(con == null){
					
					con = source.getConnection();
				} else if(con.isClosed())
				{
					this.getConnection();
				}
				
				conexoesUtilizadas.put(con.toString(), con);
			}
		} catch (SQLException e) {
             System.out.println("Problemas com o pool!!");
			e.printStackTrace();
		}	
		return con;
	}

	@Override
	public void LiberarConnection(Connection con) {
		conexoesLivres.add(con);
		conexoesUtilizadas.remove(con.toString());

	}

	
}
