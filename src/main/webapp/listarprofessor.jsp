<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.cursoja.agendacurso.controller.ProfessorController" %>
<%@ page import="br.com.cursoja.agendacurso.model.entidade.Professor" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Professores</title>
</head>
<body>
	<!-- <form method="post" action=""> -->
		<!-- <input type="text" name="nomebuscar"/> -->
		<!-- input type="submit" value="Pesquisar"/> -->
	<!-- </form> -->
	
	<table>
		<thead>
			<th>Nome</th>
			<th>Celular</th>
			<th>Valor/Hora</th>
			<th>Ações</th>
		</thead>
		<tbody>
		<%
			ProfessorController controller = new ProfessorController();
			ArrayList<Professor> lista = controller.listar("");
			for(Professor p : lista) {
		%>
			<tr>
				<td><%= p.getNome() %></td>
				<td><%= p.getCelular() %></td>
				<td><%= p.getValorHora() %></td>
				<td>Alterar Excluir</td>
			</tr>
		<% } %>
		</tbody>
	</table>
	
</body>
</html>