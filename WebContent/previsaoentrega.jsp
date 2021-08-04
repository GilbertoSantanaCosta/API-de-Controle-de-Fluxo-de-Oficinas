
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	   <form action="CadastroOficinaController" method="post">
	    <input type="hidden" name="cmd" value="VeiculoNaoEntregue"/>
		
  <div align="center">
	<big style=" color: #004080; font-size: xx-large; font-family: sans-serif">Busca por data</big>
   		 <hr color="navy">
   		 <jsp:include page="menu.jsp"></jsp:include>
   		 <br><br><br><br>
 		 <label>Esta busca tem a finalidade de trazer uma lista de veiculos que estão com previsão de entrega 
  			entre as datas citadas </label>
  			<br>
  			<br>
  			<td>Digite a primeira data</td>
  			<td><input id="data1" name="data1" value="${veiculo.previsaoentrega1}"></td>
  			<br><br>
  			<td>Digite a segunda data </td>
  			<td><input id="data2" name="data2" value="${veiculo.previsaoentrega2}"></td><br>
  			<br><br>
  			
  		<input type="submit"  value="Gravar"/>
  		<br><br><br><br>
  		
  			<hr color="navy">
    <big style=" color: #004080; font-size: x-small; font-family: sans-serif"> Sistema Comercial Automotivo</big><br>
     <big style=" color: #004080; font-size: x-small; font-family: sans-serif">sistemacomercialauto.com.br</big>
  			
   
	  </form>
	</body>
</html>