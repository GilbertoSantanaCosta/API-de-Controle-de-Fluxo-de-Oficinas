package br.com.cadastrooficina.model.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.cadastrooficina.model.bean.ClienteOficina;
import br.com.cadastrooficina.model.bean.VeiculoNaoEntregueCom;

public interface InterfaceClienteOficinaDAO {
	
	public abstract void Excluir();
	public abstract void Atualizar(ClienteOficina cliente);
	public abstract void Salvar(ClienteOficina cliente) throws SQLException;
	public abstract ClienteOficina getClienteOficina();
	public abstract List<ClienteOficina> getClientesOficina();
	public abstract List<ClienteOficina>BuscaNaoEntregue(VeiculoNaoEntregueCom veiculo) throws SQLException;
	public abstract ClienteOficina BuscaPorID(String placa);
}
