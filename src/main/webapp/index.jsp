<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.cursoja.agendacurso.model.dao.Conexao" %>
<%@ page import="br.com.cursoja.agendacurso.model.dao.CursoDao" %>
<%@ page import="br.com.cursoja.agendacurso.model.entidade.Curso" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="br.com.cursoja.agendacurso.model.dao.ProfessorDao" %>
<%@ page import="br.com.cursoja.agendacurso.model.entidade.Professor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Inicial</title>
</head>
<body>
	<h1>Olá mundo, agora na "web"</h1>
	
	<%
		Conexao c = new Conexao();
		c.getConexao();
		
		c.fecharConexao();
		
		Curso curso = new Curso();
		curso.setNome("Word");
		curso.setValor(300);
		
		Curso curso2 = new Curso();
		curso2.setNome("Datilografia");
		curso2.setValor(50);
		
		CursoDao dao = new CursoDao();
		//dao.cadastrar(curso);
		//dao.cadastrar(curso2);
		
		Curso cursoAlterar = new Curso();
		cursoAlterar.setNome("Office");
		cursoAlterar.setValor(500);
		cursoAlterar.setId(1);
		dao.alterar(cursoAlterar);
		
		ArrayList<Curso> cursos = dao.listar("");
		for(Curso a : cursos) {
	%>
			<p><%= a.getNome() %></p>
	<%
		}
		
		Curso unico = dao.buscar(1);
	%>
		<p><%= unico.getNome() %> - <%= unico.getValor() %></p>
		
	<%
		Professor professor = new Professor();
		professor.setValorHora(50);
		professor.setNome("Luis");
		professor.setCelular("(21) 99999-9999");
		
		ProfessorDao dao1 = new ProfessorDao();
		//dao1.cadastrar(professor);
		
		Professor professorAlterar = new Professor();
		professorAlterar.setNome("Luis Renato");
		professorAlterar.setCelular("(21) 91234-1234");
		professorAlterar.setValorHora(60);
		professorAlterar.setId(1);
		dao1.alterar(professorAlterar);
		
		ArrayList<Professor> professores = dao1.listar("");
		for(Professor a : professores) {
	%>
			<p><%= a.getNome() %></p>
	<%
		}
		
		Professor unico1 = dao1.buscar(1);
	%>
		<p><%= unico1.getNome() %> - <%= unico1.getCelular() %> - <%= unico1.getValorHora() %></p>
</body>
</html>