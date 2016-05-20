<%@page import="desafiovalemobi.model.Mercadoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mercadorias</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="container">
	<ul class="nav nav-pills">
		<li role="presentation" ><a href="mercadoriacontroller.do?acao=home">Home</a></li>
		<li role="presentation" class="active"><a
			href="mercadoriacontroller.do?acao=tab">Confira nossas
				mercadorias!</a></li>
	</ul>
	<div>
		<h1 class="jumbotron">
			Negocia&ccedil;&atilde;o de Mercadorias
			<p>Confira nossas mercadorias para negócio</p>
		</h1>
	</div>
	<%
		List<Mercadoria> mercadorias = (List<Mercadoria>) request.getAttribute("lista");
	%>
	<table class="table table-hover" class="table table-condensed"
		class="table table-bordered">
		<thead>
			<tr>
				<th><h1>Codigo</h1></th>
				<th><h1>Tipo</h1></th>
				<th><h1>Nome</h1></th>
				<th><h1>Quantidade</h1></th>
				<th><h1>Preço</h1></th>
				<th><h1>Negocio</h1></th>
				<th><h1></h1></th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Mercadoria m : mercadorias) {
			%>
			<tr>
				<td><%=m.getCodigo()%></td>
				<td><%=m.getTipoMercadoria()%></td>
				<td><%=m.getNome()%></td>
				<td><%=m.getQuantidade()%></td>
				<td><%=m.getPreco()%></td>
				<td><%=m.getTipoNegocio()%></td>
				<td><a
					href="mercadoriacontroller.do?acao=alt&id=<%=m.getCodigo()%>">
						<button class="btn btn-success" type="reset">Editar</button>
				</a> <a href="mercadoriacontroller.do?acao=del&id=<%=m.getCodigo()%>">
						<button class="btn btn-default" type="reset">Excluir</button></td>
				</a>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>