package br.com.cadastrooficina.conexao;

import java.sql.Connection;


public interface InterfacePool {
	
	public abstract Connection getConnection() ;
	public void LiberarConnection (Connection con);

}
