package br.com.cadastrooficina.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.cadastrooficina.conexao.DataSource;
import br.com.cadastrooficina.conexao.InterfacePool;
import br.com.cadastrooficina.model.bean.ClienteOficina;
import br.com.cadastrooficina.model.bean.Login;
import br.com.cadastrooficina.model.bean.VeiculoNaoEntregueCom;
import br.com.cadastrooficina.model.command.CadastrarClienteOficina;

public class ClienteOficinaDAO implements InterfaceClienteOficinaDAO {
	
	

	

	public ClienteOficinaDAO() {
		super();
		
	}



	@Override
	public void Excluir() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void Atualizar(ClienteOficina cliente) {
		 DataSource source = new DataSource();
		 
		 java.sql.PreparedStatement ps;
		 
		 String sql = "update CADASTROCLIENTE set veiculo =?,placa =?,seguro =?,cliente =?"
		 		+ ",telefone =?,celular =?,email =?,datavistoria =?,"
		 		+ "dataentrada =?,previsaoentrega =?,datasaida =?, obs =? where sinistro =?  " ;
		  
		 try {
			 Connection con = source.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1,cliente.getVeiculo());
			ps.setString(2,cliente.getPlaca());
			ps.setString(3,cliente.getSeguro());
			ps.setString(4,cliente.getNome());
			ps.setString(5,cliente.getTelefone());
			ps.setString(6,cliente.getCelular());
			ps.setString(7,cliente.getEmail());
			if (cliente.getVistInicial() != null) {
				ps.setDate(8, new Date(cliente.getVistInicial().getTime()));
			}else{ps.setString(8, null);}
			if (cliente.getEntrada() != null) {
				ps.setDate(9, new Date(cliente.getEntrada().getTime()));
			}else{ps.setString(9, null);}
			if (cliente.getPrevisaoEntrega() != null) {
				ps.setDate(10, new Date(cliente.getPrevisaoEntrega().getTime()));
			}else{ps.setString(10, null);}
			if (cliente.getSaida() != null) {
				ps.setDate(11, new Date(cliente.getSaida().getTime()));
			}else{ps.setString(11, null);}
			ps.setString(12, cliente.getObs());
			ps.setString(13, cliente.getSinistro());
			
			ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		 
	}



	@Override
	public void Salvar(ClienteOficina cliente) throws SQLException {
	    
		 DataSource source = new DataSource();
		 Connection con = source.getConnection();
		 java.sql.PreparedStatement ps;
		 
		 String sql = "INSERT INTO CADASTROCLIENTE (veiculo,placa,sinistro,seguro,cliente,telefone,celular,email,datavistoria,"
		 		+ "dataentrada,previsaoentrega,datasaida,obs) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		  
		 try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1,cliente.getVeiculo());
			ps.setString(2,cliente.getPlaca());
			ps.setString(3,cliente.getSinistro());
			ps.setString(4,cliente.getSeguro());
			ps.setString(5,cliente.getNome());
			ps.setString(6,cliente.getTelefone());
			ps.setString(7,cliente.getCelular());
			ps.setString(8,cliente.getEmail());
			if (cliente.getVistInicial() != null) {
				ps.setDate(9, new Date(cliente.getVistInicial().getTime()));
			}else{ps.setString(9, null);}
			if (cliente.getEntrada() != null) {
				ps.setDate(10, new Date(cliente.getEntrada().getTime()));
			}else{ps.setString(10, null);}
			if (cliente.getPrevisaoEntrega() != null) {
				ps.setDate(11, new Date(cliente.getPrevisaoEntrega().getTime()));
			}else{ps.setString(11, null);}
			if (cliente.getSaida() != null) {
				ps.setDate(12, new Date(cliente.getSaida().getTime()));
			}else{ps.setString(12, null);}
			ps.setString(13, cliente.getObs());
			ps.executeUpdate();
			ps.close();
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		 
	}




	@Override
	public ClienteOficina getClienteOficina() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<ClienteOficina> getClientesOficina() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<ClienteOficina> BuscaNaoEntregue(VeiculoNaoEntregueCom veiculo) throws SQLException {
	    
		List<ClienteOficina> lista = new ArrayList<ClienteOficina>();
		ClienteOficina cliente;
		DataSource source = new DataSource();
		Connection con = source.getConnection();
	   
		String sql = "SELECT * FROM cadastrocliente WHERE previsaoentrega >= ? "
				+ "AND previsaoentrega<=? AND datasaida is null ORDER by PrevisaoEntrega ASC";
		ResultSet rs;
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			
			ps.setDate(1, new Date(veiculo.getPrevisaoEntrega1().getTime()));
			ps.setDate(2, new Date(veiculo.getPrevisaoEnrega2().getTime()));
			
			rs = ps.executeQuery();
 while(rs.next()){
	 		String receber;
	 		DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	 		java.util.Date a;
			 cliente = new ClienteOficina();
			 cliente.setNome(rs.getString("cliente"));
			 cliente.setCelular(rs.getString("celular"));
			 cliente.setTelefone(rs.getString("telefone"));
			 cliente.setVeiculo(rs.getString("veiculo"));
			 cliente.setPlaca(rs.getString("placa"));
			 cliente.setSeguro(rs.getString("seguro"));
			 cliente.setPrevisaoEntrega(rs.getDate("previsaoentrega"));
			 cliente.setObs(rs.getString("obs"));
		     if(rs.getDate("previsaoentrega")!= null)
		     {
		    	 data.format(rs.getDate("previsaoentrega"));
		    	 
		    	 cliente.setRecbData(String.valueOf(data));
		     }else{
		    	 cliente.setRecbData("");
		     }
		    System.out.println(cliente.getRecbData());
			 lista.add(cliente);
			 
 }
 ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
		return lista;
	}



	@Override
	public ClienteOficina BuscaPorID(String placa) {
		ClienteOficina cliente = new ClienteOficina();
		DataSource source = new DataSource();
		Connection con; 
		PreparedStatement ps;
		ResultSet rs;
		String sql = "Select * from cadastrocliente WHERE placa = ?"; 
		try {
			con = source.getConnection();
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, placa);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				String recebe;
			cliente.setVeiculo(rs.getString("veiculo"));
			cliente.setPlaca(rs.getString("placa"));
			cliente.setSinistro(rs.getString("sinistro"));
			cliente.setSeguro(rs.getString("seguro"));
			cliente.setNome(rs.getString("cliente"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCelular(rs.getString("celular"));
			cliente.setEmail(rs.getString("email"));
			cliente.setVistInicial(rs.getDate("datavistoria"));
			cliente.setEntrada(rs.getDate("dataentrada"));
			cliente.setPrevisaoEntrega(rs.getDate("previsaoentrega"));
			cliente.setSaida(rs.getDate("datasaida"));	
			cliente.setObs(rs.getString("obs"));
			
			if(rs.getDate("datavistoria") != null){
				recebe = data.format(rs.getDate("datavistoria"));
				cliente.setRecbData(recebe);
				}else{
					cliente.setRecbData("");
				}
			
			if(rs.getDate("dataentrada") != null){
			recebe = data.format(rs.getDate("dataentrada"));
			cliente.setRecbData2(recebe);
			}else{
				cliente.setRecbData2("");
			}
			
			if(rs.getDate("previsaoentrega") != null){
				recebe = data.format(rs.getDate("previsaoentrega"));
				cliente.setRecbData3(recebe);
				}else{
					cliente.setRecbData3("");
				}
			
			if(rs.getDate("datasaida") != null){
				recebe = data.format(rs.getDate("datasaida"));
				cliente.setRecbData4(recebe);
				}else{
					cliente.setRecbData4("");
				}
			}
		ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public List<ClienteOficina> BuscaTodos() {
		List<ClienteOficina> lista = new ArrayList<ClienteOficina>();
		ClienteOficina cliente;
		DataSource source = new DataSource();
		Connection con; 
		PreparedStatement ps;
		ResultSet rs;
		String sql = "Select * from cadastrocliente WHERE dataentrada is not null and datasaida is null ORDER BY PREVISAOENTREGA ASC"; 
		try {
			con = source.getConnection();
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
			DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
			String recebe;
				
			cliente = new ClienteOficina();
			cliente.setVeiculo(rs.getString("veiculo"));
			cliente.setPlaca(rs.getString("placa"));
			cliente.setSinistro(rs.getString("sinistro"));
			cliente.setSeguro(rs.getString("seguro"));
			cliente.setNome(rs.getString("cliente"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCelular(rs.getString("celular"));
			cliente.setEmail(rs.getString("email"));
			cliente.setVistInicial(rs.getDate("datavistoria"));
			
			cliente.setPrevisaoEntrega(rs.getDate("previsaoentrega"));
			cliente.setSaida(rs.getDate("datasaida"));
			cliente.setObs(rs.getString("obs"));
			
			recebe = data.format(rs.getDate("dataentrada"));
			cliente.setRecbData(recebe);
			
			
			
			
			lista.add(cliente);
			}
		ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public List<ClienteOficina> BuscaTodosVistoriaInicial() {
		List<ClienteOficina> lista = new ArrayList<ClienteOficina>();
		ClienteOficina cliente;
		DataSource source = new DataSource();
		Connection con; 
		PreparedStatement ps;
		ResultSet rs;
		String sql = "SELECT * FROM cadastrocliente WHERE DataVistoria is not null and DataEntrada is null order by datavistoria asc"; 
		try {
			con = source.getConnection();
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
			cliente = new ClienteOficina();
			cliente.setVeiculo(rs.getString("veiculo"));
			cliente.setPlaca(rs.getString("placa"));
			cliente.setSinistro(rs.getString("sinistro"));
			cliente.setSeguro(rs.getString("seguro"));
			cliente.setNome(rs.getString("cliente"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCelular(rs.getString("celular"));
			cliente.setEmail(rs.getString("email"));
			cliente.setVistInicial(rs.getDate("datavistoria"));
			cliente.setEntrada(rs.getDate("dataentrada"));
			cliente.setPrevisaoEntrega(rs.getDate("previsaoentrega"));
			cliente.setSaida(rs.getDate("datasaida"));	
			cliente.setObs(rs.getString("obs"));
			lista.add(cliente);
			}
		ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}
	

	public boolean Login(Login login){
		boolean resultado = false;
		DataSource source = new DataSource();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		String sql = "SELECT * FROM login WHERE login = ? AND senha = ? ";
		try {
			con = source.getConnection();
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, login.getLogin());
			ps.setString(2, login.getSenha());
			rs = ps.executeQuery();
			
		        rs.next();
				login.setLogin(rs.getString("login"));
				login.setSenha(rs.getString("senha"));
			
			
			if(login.getLogin() != null && login.getLogin() != "" && login.getSenha() != null && login.getSenha() != ""){
				resultado = true;
			}else{
				resultado = false;
			}
			
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return resultado;
	
		
	}


	



}

