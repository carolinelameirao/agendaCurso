<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.cursoja.agendacurso.model.entidade.Professor"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Professores</title>
</head>
<body>
	<%
		Professor professorAlterar = (Professor) request.getAttribute("professor");
		DecimalFormat fmt = new DecimalFormat("#,##0.00");
	%>
	<form method="post" action="ExecutaAlteraProfessor">
		<label>Nome:</label>
		<input type="text" name="nomeProfessor" value="<%= professorAlterar.getNome() %>"/>
		<label>Celular:</label>
		<input type="text" name="celular" value="<%= professorAlterar.getCelular() %>"/>
		<label>Valor/Hora:</label>
		<input type="number" name="valor_hora" value="<%= fmt.format(professorAlterar.getValorHora()) %>" step="0.01"/>
		<input type="hidden" name="id" value="<%= professorAlterar.getId() %>"/>
		<input type="submit" value="Alterar"/>
	</form>
</body>
</html>