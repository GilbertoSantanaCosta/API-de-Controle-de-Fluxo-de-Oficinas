<%@page import="br.com.cadastrooficina.model.bean.ClienteOficina"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Previsão de entrega</title>
</head>
<body>
   <div align="center">
   <jsp:include page="cabecalho.jsp"></jsp:include>
   <jsp:include page="menu.jsp"></jsp:include>
	<table border="1" align="center">
	
	<tr >
		<th background="red" bgcolor="#ff4457" bordercolor="#ff4457">NOME</th>
		<th>CELULAR</th>
		<th>TELEFONE</th>
		<th>VEICULO</th>
		<th>PLACA</th>
		<th>SEGURO</th>
		<th>PREVISÃO DE ENTREGA</th>
		<th>OBS</th>
	</tr>
	
	<%List<ClienteOficina> lista = (List<ClienteOficina>) request.getAttribute("lista"); 
	  
	  for(ClienteOficina c: lista){
	  %>
	  
	  <tr>
	   	<td><%=c.getNome() %></td>
	   	<td><%=c.getCelular() %></td>
	   	<td><%=c.getTelefone() %></td>
	   	<td><%=c.getVeiculo() %></td>
	   	<td><%=c.getPlaca() %></td>
	   	<td><%=c.getSeguro() %></td>
	   	<td><%=c.getPrevisaoEntrega()%></td>
	   	<td><%=c.getObs()%></td>
	  </tr>
	  
	  <%} %>
	</table>
	 <jsp:include page="rodape.jsp"></jsp:include>
</div>
</body>
</html>