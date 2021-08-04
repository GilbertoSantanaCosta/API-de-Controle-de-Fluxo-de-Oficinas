<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de login</title>
</head>
<body>
   <form action="CadastroOficinaController"  >
   
   <input type="hidden" name="cmd" value="login">
    <div align="center">
    <big style=" color: #004080; font-size: xx-large; font-family: sans-serif">Sistema Comercial Automotivo</big>
    <hr color="navy">
    ${semcliente}
   <br>  <br>  <br>  <br>  <br>
   <label>Login</label>
   <input id="login" name="login" value=""/>
   <label>Senha</label>
   <input type="password" id="senha" name="senha" value=""/>
   <input type="submit" value="OK"/>
   <br>  <br>  <br>  <br>  <br>
   <hr color="navy">
    <big style=" color: #004080; font-size: x-small; font-family: sans-serif"> Sistema Comercial Automotivo</big><br>
     <big style=" color: #004080; font-size: x-small; font-family: sans-serif">sistemacomercialauto.com.br</big>
  </div>
</form>
</body>
</html>