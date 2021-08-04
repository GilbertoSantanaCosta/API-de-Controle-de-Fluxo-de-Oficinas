<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Comercial - FlamaCar </title>
</head>
<body>
  
  <div align="center">
  <jsp:include page="cabecalho.jsp"></jsp:include>
  <jsp:include page="menu.jsp"></jsp:include>
  <form action="CadastroOficinaController" method="post" style="line-heigth: normal; color: aqua; font-size: 10px; ">
    <h6>${mensagem}</h6>
      <input type="hidden" name="cmd" value="atualizaClientes"/>
        <table style="color: #004080; font-size: 14px; font-family: Tahoma, Verdana, Arial, Sans-Serif"
           border="1" align="center" >
             <thead>
                <tr >
                  <th colspan="2" align="center">Inclua dados do cliente</th> 
                 </tr>   
             
                <tr>
                   <th>Veiculo</th>
                   <th><input id="veiculo"  name="veiculo" style ="heigth: 20px" value="${cliente.veiculo}"></th>                                
                </tr>
                <tr>
                   <th>Placa</th>
                   <th><input id="placa"  name="placa" style ="heigth: 20px" value="${cliente.placa}"></th>                                
                </tr>
                <tr>
                   <th>Sinistro</th>
                   <th><input id="sinistro"  name="sinistro" style ="heigth: 20px" value="${cliente.sinistro}"></th>                                
                </tr>
                <tr>
                   <th>Seguro</th>
                   <th><input id="seguro"  name="seguro" style ="heigth: 20px" value="${cliente.seguro}"></th>                                
                </tr>
                <tr>	
                   <th>Nome</th>
                   <th><input id="nome"  name="nome" style ="heigth: 20px" value="${cliente.nome}"></th>                                
                </tr>
                <tr>
                   <th>Celular</th>
                   <th><input id="celular"  name="celular" style ="heigth: 20px" value="${cliente.celular}"></th>                                
                </tr>
                <tr>
                   <th>Telefone</th>
                   <th><input id="telefone"  name="telefone" style ="heigth: 20px" value="${cliente.telefone}"></th>                                
                </tr>
                 <tr>
                   <th>E-mail</th>
                   <th><input id="email"  name="email" style ="heigth: 20px" value="${cliente.email}"></th>                                
                </tr>
                 <tr>
                   <th>Vistoria Inicial</th>
                   <th><input id="vistoria"  name="vistoria" style ="heigth: 20px" value="${cliente.recbData}"></th>                                
                </tr>
                 <tr>
                   <th>Entrada</th>
                   <th><input id="entrada"  name="entrada" style ="heigth: 20px" value="${cliente.recbData2}"></th>                                
                </tr>
                 <tr>
                   <th>Previsão de entrega</th>
                   <th><input id="previsao"  name="previsao" style ="heigth: 20px" value="${cliente.recbData3}"></th>                                
                </tr>
                 <tr>
                   <th>Entregue</th>
                   <th><input id="entregue"  name="entregue" style ="heigth: 20px" value="${cliente.recbData4}"></th>                                
                </tr>
                <tr>
                   <th>Obs</th>
                   <th><input id="obs"  name="obs" style ="heigth: 20px" value="${cliente.obs}"></th>                                
                </tr>
                <tr >
                  <td colspan="2" align="center"><input type="submit" value="gravar"></td> 
                 </tr>   
             </thead>
        </table>
  </form>
   </div>
   <jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>