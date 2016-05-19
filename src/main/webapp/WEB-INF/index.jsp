<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mercadorias</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script language="javascript" type="text/javascript">
	$(document).ready(function() {
		$("input").blur(function() {
			if ($(this).val() == "") {
				$(this).css({
					"border-color" : "#F00",
					"padding" : "2px"
				});
			}
		});
	})
	$("#btn-submit").click(function() {
		var codigo = form - cadastro.codigo.value;
		var tipo = form - cadastro.tipo.value;
		var nome = form - cadastro.nome.value;
		var quantidade = form - cadastro.quantidade.value;
		var preco = form - cadastro.preco.value;

		if (nome == "") {
			alert('Preencha o campo com seu nome');
			form1.nome.focus();
			return false;
		}
		$("#form-cadastro").submit();
	});
</script>
</head>

<body class="container">
	<%
		String confirm = (String) request.getAttribute("confirmacao");
	%>
	<ul class="nav nav-pills">
		<li role="presentation" class="active"><a
			href="mercadoriacontroller.do?acao=home">Home</a></li>
		<li role="presentation"><a
			href="mercadoriacontroller.do?acao=tab">Confira nossas
				mercadorias!</a></li>
	</ul>
	<div>
		<h1 class="jumbotron">
			Negocia&ccedil;&atilde;o de Mercadorias
			<p>Cadastre uma Mercadoria</p>
		</h1>
	</div>
	<%
		if (confirm != null) {

			if (confirm.equals("done")) {
	%>
	<div class="alert alert-success" role="alert">
		<a href="mercadoriacontroller.do?acao=tab" class="alert-link">Mercadoria
			incluida com sucesso! confira aqui</a>
	</div>
	<%
		}
		}
	%>
	<form action="mercadoriacontroller.do?acao=save" method="POST"
		id="form-cadastro" name="form-cadastro">
		<div class="row">
			<div class="col-sm-12 col-md-6">
				<div class="col-sm-2">
					<label>Codigo: </label>
				</div>
				<div class="col-sm-3">
					<input class="form-control" type="text" id="codigo" name="codigo"
						value="" />
				</div>
			</div>
			<div class="col-sm-12 col-md-6">
				<div class="col-sm-3">
					<label>Tipo: </label>
				</div>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="tipo" name="tipo"
						value="" />
				</div>
			</div>
			<div class="col-sm-12 col-md-6">
				<div class="col-sm-2">
					<label>Nome: </label>
				</div>
				<div class="col-sm-10">
					<input class="form-control" type="text" id="nome" name="nome"
						value="" />
				</div>
			</div>
			<div class="col-sm-12 col-md-6">
				<div class="col-sm-3">
					<label>Quantidade: </label>
				</div>
				<div class="col-sm-8">
					<input class="form-control" type="text" id="quantidade"
						name="quantidade" value="" />
				</div>
			</div>
			<div class="col-sm-12 col-md-6">
				<div class="col-sm-2">
					<label>Pre&ccedil;o: </label>
				</div>
				<div class="col-sm-5">
					<input class="form-control" type="text" id="preco" name="preco"
						value="" />
				</div>
			</div>
			<div class="col-sm-12 col-md-6 form-group">
				<label class="col-sm-3 control-label">Negocio:</label>
				<div class="col-sm-5 selectContainer">
					<select class="form-control" name="negocio" id="negocio">
						<option value="Compra">Compra</option>
						<option value="Venda">Venda</option>
					</select>
				</div>
			</div>
			<div>
				<button class="btn btn-success" class="col-sm-12 col-md-6"
					id="btn-submit" type="submit">Submit</button>
				<button class="btn btn-default" class="col-sm-12 col-md-6"
					type="reset">clean</button>
			</div>
		</div>
	</form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>