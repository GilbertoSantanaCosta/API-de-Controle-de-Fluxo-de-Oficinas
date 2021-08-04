package br.com.cadastrooficina.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastrooficina.model.bean.ClienteOficina;
import br.com.cadastrooficina.model.bean.Login;
import br.com.cadastrooficina.model.dao.ClienteOficinaDAO;

public class LoginCommand implements InterfaceCommandOficina {

	@Override
	public String Execute(HttpServletRequest request,
			HttpServletResponse response) {
		Login login = new Login();
		ClienteOficinaDAO dao = new ClienteOficinaDAO();
		boolean resultado;
		
		login.setLogin(request.getParameter("login"));
		login.setSenha(request.getParameter("senha"));
		
		resultado = dao.Login(login);
		
		if (resultado == true){
			return "bemvindo.jsp";
		}else{
		     request.setAttribute("semcliente", "Login e Senha Invalidos!!");
			
		     return "login.jsp";
		}
		
		
		
	}

}
