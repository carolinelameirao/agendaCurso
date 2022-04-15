<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.cursoja.agendacurso.controller.CursoController" %>
<%@ page import="br.com.cursoja.agendacurso.model.entidade.Curso" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF--8">
<title>Listagem de Cursos</title>
</head>
<body>
	<!-- <form method="post" action=""> -->
		<!-- <input type="text" name="nomebuscar"/> -->
		<!-- <input type="submit" value="Pesquisar"/> -->
	<!-- </form> -->
	
	<table>
		<thead>
			<th>Nome</th>
			<th>Valor</th>
			<th>Ações</th>
		</thead>
		<tbody>
	<%
		CursoController controller = new CursoController();
		ArrayList<Curso> lista = controller.listar("");
		for(Curso c : lista) {
	%>
			<tr>
				<td><%= c.getNome() %></td>
				<td><%= c.getValor() %></td>
				<td>Alterar Excluir</td>
			</tr>
	<% } %>
		</tbody>
	</table>
</body>
</html>