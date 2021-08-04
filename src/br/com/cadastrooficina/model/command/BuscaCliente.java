package br.com.cadastrooficina.model.command;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastrooficina.conexao.DataSource;
import br.com.cadastrooficina.model.bean.ClienteOficina;
import br.com.cadastrooficina.model.dao.ClienteOficinaDAO;

public class BuscaCliente implements InterfaceCommandOficina {

	@Override
	public String Execute(HttpServletRequest request,
			HttpServletResponse response) {
	
		ClienteOficina cliente = new ClienteOficina();
		ClienteOficinaDAO dao = new ClienteOficinaDAO();
		
		cliente = dao.BuscaPorID(request.getParameter("placa"));
		
		request.setAttribute("cliente", cliente);
		request.setAttribute("titulo", "Dados do cliente solicitado");
		
	
		return "resultbuscaplaca.jsp";
	}

}
