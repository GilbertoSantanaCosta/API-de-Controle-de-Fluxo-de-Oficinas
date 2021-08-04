package br.com.cadastrooficina.model.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastrooficina.model.bean.ClienteOficina;
import br.com.cadastrooficina.model.dao.ClienteOficinaDAO;

public class BuscaTodosCommand implements InterfaceCommandOficina {

	@Override
	public String Execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		ClienteOficina cliente = new ClienteOficina();
		List<ClienteOficina> lista = new ArrayList<ClienteOficina>();
		ClienteOficinaDAO dao = new ClienteOficinaDAO();
		
		lista = dao.BuscaTodos();
		
		request.setAttribute("lista",lista);
		request.setAttribute("titulo", "Veiculos que estão na oficina");
		
		
		return "veiculosnaoficina.jsp";
	}

}
