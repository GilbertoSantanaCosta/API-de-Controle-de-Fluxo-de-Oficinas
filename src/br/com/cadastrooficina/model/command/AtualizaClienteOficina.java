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


public class AtualizaClienteOficina implements InterfaceCommandOficina {

	private ClienteOficinaDAO clienteoficinaDAO;
	
	
	public AtualizaClienteOficina(ClienteOficinaDAO clienteoficinaDAO) {
		super();
		this.clienteoficinaDAO = clienteoficinaDAO;
	}


	@Override
	public String Execute(HttpServletRequest request,
			HttpServletResponse response) {
		ClienteOficina cliente = new ClienteOficina();
		
		request.setAttribute("cliente",cliente );
		request.setAttribute("titulo", "Cadastro Clientes - Flamacar");
		
		cliente.setVeiculo(request.getParameter("veiculo"));
		cliente.setPlaca(request.getParameter("placa"));
		cliente.setSinistro(request.getParameter("sinistro"));
		cliente.setSeguro(request.getParameter("seguro"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setCelular(request.getParameter("celular"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setEmail(request.getParameter("email"));
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date datef;
			if (request.getParameter("vistoria") != null && request.getParameter("vistoria") !=  "") {
				String date = request.getParameter("vistoria");
				datef = format.parse(date);
				cliente.setVistInicial(datef);
			}else{cliente.setVistInicial(null);}
			if (request.getParameter("entrada") != null && request.getParameter("entrada") !=  "") {
				datef = format.parse(request.getParameter("entrada"));
				cliente.setEntrada(datef);
			}else{cliente.setEntrada(null);}
			if (request.getParameter("previsao") != null && request.getParameter("previsao") !=  "") {
				datef = format.parse(request.getParameter("previsao"));
				cliente.setPrevisaoEntrega(datef);
			}else{cliente.setPrevisaoEntrega(null);}
			if (request.getParameter("entregue") != null && request.getParameter("entregue") !=  "") {
				datef = format.parse(request.getParameter("entregue"));
				cliente.setSaida(datef);
			}else{cliente.setSaida(null);}
		} catch (ParseException e1) {
			System.out.println("Problemas com data!");
			e1.printStackTrace();
		}
		
		cliente.setObs(request.getParameter("obs"));
		
		
		
		
		try {
			clienteoficinaDAO.Atualizar(cliente);
			request.setAttribute("mensagem", "Cliente ("+cliente.getNome()+")Atualizado com sucesso!");
		} catch (Exception e) {
			request.setAttribute("mensagem","Problemas com a Atualização: "+e.getMessage());
			e.printStackTrace();
		}
		request.setAttribute("titulo", "Cadastro Clientes - Flamacar");
		
		return "cadastro_clienteoficina.jsp";
	}


	

}
