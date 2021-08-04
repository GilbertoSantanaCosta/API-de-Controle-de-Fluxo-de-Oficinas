package br.com.cadastrooficina.model.helper;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastrooficina.conexao.InterfacePool;
import br.com.cadastrooficina.conexao.Pool;
import br.com.cadastrooficina.model.command.AtualizaClienteOficina;
import br.com.cadastrooficina.model.command.Atualizar;
import br.com.cadastrooficina.model.command.BemVindo;
import br.com.cadastrooficina.model.command.BuscaCliente;
import br.com.cadastrooficina.model.command.BuscaTodosCommand;
import br.com.cadastrooficina.model.command.BuscaTodosVistInicial;
import br.com.cadastrooficina.model.command.CadastrarClienteOficina;
import br.com.cadastrooficina.model.command.ChamaAtualizaClienteOficina;
import br.com.cadastrooficina.model.command.ChamaPrevisaoEntrega;
import br.com.cadastrooficina.model.command.InterfaceCommandOficina;
import br.com.cadastrooficina.model.command.LoginCommand;
import br.com.cadastrooficina.model.command.NovoClienteOficina;
import br.com.cadastrooficina.model.command.PrevisaoEntregaCommand;
import br.com.cadastrooficina.model.command.VeiculoNaoEntregue;
import br.com.cadastrooficina.model.dao.ClienteOficinaDAO;

public class CadastroOficinaHelper {
	
	private HashMap<String,InterfaceCommandOficina> mapaComandos;
	private HttpServletRequest request;
	private HttpServletResponse response;
	//private InterfacePool pool;
	
public CadastroOficinaHelper (){
		
		
		//this.pool = new Pool();
		this.request = request;
		this.response = response;
		
		
		mapaComandos = new HashMap<String, InterfaceCommandOficina>();
		mapaComandos.put("cadastrarClientes", new CadastrarClienteOficina(new ClienteOficinaDAO()));
		mapaComandos.put("novoCliente", new NovoClienteOficina());
		mapaComandos.put("PrevisaoEntrega", new PrevisaoEntregaCommand());
		mapaComandos.put("VeiculoNaoEntregue", new VeiculoNaoEntregue());
		mapaComandos.put("chamaAtualiza",  new ChamaAtualizaClienteOficina(new ClienteOficinaDAO()) );
		mapaComandos.put("atualizaClientes",  new AtualizaClienteOficina(new ClienteOficinaDAO()) );
		mapaComandos.put("buscaCliente",  new BuscaCliente() );
		mapaComandos.put("atualizar",  new Atualizar() );
		mapaComandos.put("chamaPrevisaoEntrega",  new ChamaPrevisaoEntrega() );
		mapaComandos.put("buscaTodos",  new BuscaTodosCommand() );
		mapaComandos.put("bemVindo",  new BemVindo() );
		mapaComandos.put("vistoriaInicial",  new BuscaTodosVistInicial() );
		mapaComandos.put("login",  new LoginCommand() );
	}
	
	public InterfaceCommandOficina getCommand() {
		
		return mapaComandos.get(request.getParameter("cmd"));
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	
	
	

}
