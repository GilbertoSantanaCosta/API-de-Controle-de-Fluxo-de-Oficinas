<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado da busca por placa </title>
</head>
<body>

<div align="center">
<jsp:include page="cabecalho.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
   <table>
   		<tr>
   			<th>Veiculo</th>
   			<td>${cliente.veiculo}</td>
   		</tr>
   		<tr>
   			<th>Placa</th>
   			<td>${cliente.placa}</td>
   		</tr>
   		<tr>
   			<th>Sinistro</th>
   			<td>${cliente.sinistro}</td>
   		</tr>
   		<tr>
   			<th>Seguro</th>
   			<td>${cliente.seguro}</td>
   		</tr>
   		<tr>
   			<th>Nome</th>
   			<td>${cliente.nome}</td>
   		</tr>
   		<tr>
   			<th>Teleofne</th>
   			<td>${cliente.telefone}</td>
   		</tr>
   		<tr>
   			<th>Celular</th>
   			<td>${cliente.celular}</td>
   		</tr>
   		<tr>
   			<th>E-mail</th>
   			<td>${cliente.email}</td>
   		</tr>
   		<tr>
   			<th>Vistoria Inicial</th>
   			<td>${cliente.vistInicial}</td>
   		</tr>
   		<tr>
   			<th>Entrada</th>
   			<td>${cliente.recbData}</td>
   		</tr>
   		<tr>
   			<th>Preisao Entrega</th>
   			<td>${cliente.previsaoEntrega}</td>
   		</tr>
   		<tr>
   			<th>Entregue</th>
   			<td>${cliente.saida}</td>
   		</tr>
   		<tr>
   			<th>Obs</th>
   			<td>${cliente.obs}</td>
   		</tr>
   </table>
<jsp:include page="rodape.jsp"></jsp:include>
</div>
</body>
</html>