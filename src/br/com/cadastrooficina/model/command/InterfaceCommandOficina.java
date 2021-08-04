package br.com.cadastrooficina.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public interface InterfaceCommandOficina {
	
	public String Execute(HttpServletRequest request, HttpServletResponse response);

}
