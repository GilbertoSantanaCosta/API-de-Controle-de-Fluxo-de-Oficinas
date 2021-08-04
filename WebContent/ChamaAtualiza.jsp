<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualização de clientes</title>
</head>
<body>
<div align="center">
<big style=" color: #004080; font-size: xx-large; font-family: sans-serif">Digite a placa do veiculo que deseja realizar a alteração</big>
    <hr color="navy">
    <jsp:include page="menu.jsp"></jsp:include>
    <br><br><br><br><br>
	<form action="CadastroOficinaController" method="post">
	<input type="hidden" name="cmd" value="chamaAtualiza">
	
	<label>placa</label>
	<input id="placa" name="placa" value=""/>
	<input type="submit" value="OK"/>
	</form>
	<br><br><br><br><br>
	<hr color="navy">
	<big style=" color: #004080; font-size: x-small; font-family: sans-serif"> Sistema Comercial Automotivo</big><br>
     <big style=" color: #004080; font-size: x-small; font-family: sans-serif">sistemacomercialauto.com.br</big>
	</div>
</body>
</html>