package br.com.cadastrooficina.model.command;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import br.com.cadastrooficina.model.bean.ClienteOficina;
import br.com.cadastrooficina.model.dao.ClienteOficinaDAO;


public class ChamaAtualizaClienteOficina implements InterfaceCommandOficina {

	private ClienteOficinaDAO clienteoficinaDAO;
	
	
	public ChamaAtualizaClienteOficina(ClienteOficinaDAO clienteoficinaDAO) {
		super();
		this.clienteoficinaDAO = clienteoficinaDAO;
	}


	@Override
	public String Execute(HttpServletRequest request,
			HttpServletResponse response) {
		ClienteOficina cliente = new ClienteOficina();
		ClienteOficinaDAO dao = new ClienteOficinaDAO();
		
		request.setAttribute("titulo", "Cadastro Clientes - Flamacar");
		
		cliente = dao.BuscaPorID(request.getParameter("placa"));
		request.setAttribute("cliente",cliente );
		
		return "atualizar_clienteoficina.jsp";
	}


	

}
