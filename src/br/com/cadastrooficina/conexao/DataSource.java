package br.com.cadastrooficina.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource implements InterfaceDataSource {
	
	// private String driver;
	private String url  ;
	private String usuario;
	private String senha;
	
	public DataSource() {	
		
	}
	@Override
	public Connection getConnection() throws SQLException {
		
		Connection con = null;
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/flamacadastro", "root", "");
				System.out.println("conectado");
			} catch (ClassNotFoundException e) {
				System.out.println("problemas com a conexao: " + e.getMessage() );
				e.printStackTrace();
			}
			
		return con;
	}
	
	
	
}
