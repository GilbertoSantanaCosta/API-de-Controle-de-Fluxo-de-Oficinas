<%@page import="br.com.cadastrooficina.model.bean.ClienteOficina"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VISTORIAS REALIZADAS</title>
</head>
<body>
   <div align="center">
   <H6>VISTORIA REALIZADA</H6>
   <jsp:include page="menu.jsp"></jsp:include>
	<table border="1" align="center" style="border-bottom: thick;border-bottom-style: solid;">
	
	<tr bordercolor="red" style="font-size:xx-small;" align="center" >
		<th>VEICULO</th> 
		<th>PLACA</th>
		<th>SINISTRO</th>
		<th>SEGURO</th>
		<th>NOME</th>
		<th>TELEFONE</th>
		<th>CELULAR</th>
		
		<th>DATA VISTORIA INICIAL</th>
		<th>OBS</th>
		
		
		
	</tr>
	
	<%List<ClienteOficina> lista = (List<ClienteOficina>) request.getAttribute("lista"); 
	  
	int quantidade =0 ;
	  for(ClienteOficina c: lista){
	  %>
	  
	  <tr style="font-size:xx-small;" align="center">
	   	<td><%=c.getVeiculo()%></td>
	   	<td><%=c.getPlaca() %></td>
	   	<td><%=c.getSinistro() %></td>
	   	<td><%=c.getSeguro() %></td>
	   	<td><%=c.getNome() %></td>
	   	<td><%=c.getTelefone() %></td>
	   	<td><%=c.getCelular()%></td>
	   	<td><%=c.getVistInicial()%></td>
	   	<td><%=c.getObs()%></td>
	  </tr>
	  
	      <%quantidade += 1; %>
	  <%} %>
	</table>
	Quatidade de vistorias: <%=quantidade %>
	 <jsp:include page="rodape.jsp"></jsp:include>
</div>
</body>
</html>