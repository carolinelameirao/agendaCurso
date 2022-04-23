<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.cursoja.agendacurso.model.dao.Conexao" %>
<%@ page import="br.com.cursoja.agendacurso.model.dao.CursoDao" %>
<%@ page import="br.com.cursoja.agendacurso.model.entidade.Curso" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="br.com.cursoja.agendacurso.model.dao.ProfessorDao" %>
<%@ page import="br.com.cursoja.agendacurso.model.entidade.Professor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página Inicial</title>
</head>
<body>
	<h1>Olá mundo, agora na "web"</h1>
	
	<a href="listarcurso.jsp">Listar Curso</a>
	<br>
	<br>
	<a href="listarprofessor.jsp">Listar Professor</a>
	
	
</body>
</html>