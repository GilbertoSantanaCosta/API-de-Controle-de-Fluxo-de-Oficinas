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

public class VeiculoNaoEntregue implements InterfaceCommandOficina {

	@Override
	public String Execute(HttpServletRequest request,
			HttpServletResponse response) {
		
		VeiculoNaoEntregueCom veiculo = new VeiculoNaoEntregueCom();
		 request.setAttribute("veiculo", veiculo);
		 DateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
	
		 try {
			 Date date = format.parse(request.getParameter("data1"));
			 
			veiculo.setPrevisaoEntrega1(date);
			
			date = format.parse(request.getParameter("data2"));
			veiculo.setPrevisaoEnrega2(date);
		} catch (ParseException e1) {
			System.out.println("Problemas com data no controller");
			e1.printStackTrace();
		}
		
		 ClienteOficinaDAO dao = new ClienteOficinaDAO();
	
		 try {
			List<ClienteOficina> lista = dao.BuscaNaoEntregue(veiculo);
		    request.setAttribute("lista", lista);
		    //request.getRequestDispatcher("resultadoprevisaodeentrega.jsp").forward(request, response);
		    
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		 request.setAttribute("titulo", "Veiculos com previsão de entrega entre "+ data1 +" e "+ data2);
		return "resultadoprevisaodeentrega.jsp";
		
	}

}
