package br.com.cadastrooficina.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastrooficina.model.bean.ClienteOficina;


public class NovoClienteOficina implements InterfaceCommandOficina {


   public NovoClienteOficina() {
	
}
	@Override
	public String Execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		ClienteOficina cliente = new ClienteOficina();
		
		
		request.setAttribute("cliente",cliente );
		request.setAttribute("titulo", "Cadastro Clientes - Flamacar");
		
		return "cadastro_clienteoficina.jsp";
	}


	

}
