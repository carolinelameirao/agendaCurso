package br.com.cursoja.agendacurso.view;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.cursoja.agendacurso.controller.ProfessorController;
import br.com.cursoja.agendacurso.model.entidade.Professor;

/**
 * Servlet implementation class ExecutaAlteraProfessor
 */
public class ExecutaAlteraProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecutaAlteraProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nomeProfessor");
		String celular = request.getParameter("celular");
		String strvalorHora = request.getParameter("valor_hora");
		String strId = request.getParameter("id");
		
		double valorHora = 0;
		long id = 0;
		try {
			valorHora = Double.parseDouble(strvalorHora);
			id = Long.parseLong(strId);
		} catch(Exception e) {
			System.out.println("Erro na conversão.");
		}
		
		Professor p = new Professor();
		p.setId(id);
		p.setNome(nome);
		p.setCelular(celular);
		p.setValorHora(valorHora);
		
		ProfessorController controller = new ProfessorController();
		controller.alterar(p);
		
		RequestDispatcher rd = request.getRequestDispatcher("listarprofessor.jsp");
		rd.forward(request, response);
		
	}

}
