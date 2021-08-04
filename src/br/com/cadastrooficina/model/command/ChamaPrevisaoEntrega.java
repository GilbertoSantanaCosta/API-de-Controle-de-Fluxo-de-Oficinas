package br.com.cadastrooficina.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChamaPrevisaoEntrega implements InterfaceCommandOficina {

	@Override
	public String Execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		return "previsaoentrega.jsp";
	}

}
