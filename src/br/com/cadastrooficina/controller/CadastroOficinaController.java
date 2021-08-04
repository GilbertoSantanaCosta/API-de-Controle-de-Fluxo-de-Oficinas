package br.com.cadastrooficina.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastrooficina.model.command.InterfaceCommandOficina;
import br.com.cadastrooficina.model.command.PrevisaoEntregaCommand;
import br.com.cadastrooficina.model.helper.CadastroOficinaHelper;

public class CadastroOficinaController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;
	
	private CadastroOficinaHelper cadastroOficinaHelper = new CadastroOficinaHelper();
	
	 public CadastroOficinaController() {
		super();
	}
	 
	 protected void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	 
		 processarRequisicao(request, response);
	 }
	private void processarRequisicao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		cadastroOficinaHelper.setRequest(request);
		InterfaceCommandOficina comando = cadastroOficinaHelper.getCommand();
		String pagina = comando.Execute(request,response);
		request.getRequestDispatcher(pagina).include(request,response);
		
		// NovoClienteOficina cliente = new NovoClienteOficina();
		 //equestDispatcher saida = request.getRequestDispatcher(cliente.Execute(request, response));
		 //saida.forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 processarRequisicao(request, response);
	}



	

}
