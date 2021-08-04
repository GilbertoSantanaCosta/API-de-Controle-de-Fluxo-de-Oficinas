package br.com.cadastrooficina.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BemVindo implements InterfaceCommandOficina {

	@Override
	public String Execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		return "bemvindo.jsp";
	}

}
