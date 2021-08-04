package br.com.cadastrooficina.conexao;

import java.sql.SQLException;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		
		DataSource source = new DataSource();
		
		source.getConnection();
		
	}

}
