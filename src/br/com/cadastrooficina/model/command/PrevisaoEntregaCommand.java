package br.com.cadastrooficina.model.command;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastrooficina.model.bean.ClienteOficina;
import br.com.cadastrooficina.model.bean.VeiculoNaoEntregueCom;
import br.com.cadastrooficina.model.dao.ClienteOficinaDAO;

public class PrevisaoEntregaCommand implements InterfaceCommandOficina {



	@Override
	public String Execute(HttpServletRequest request,
			HttpServletResponse response) {
	return "previsaoentrega.jsp";
	}

}
