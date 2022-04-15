package br.com.cursoja.agendacurso.controller;

import java.util.ArrayList;

import br.com.cursoja.agendacurso.model.dao.ProfessorDao;
import br.com.cursoja.agendacurso.model.entidade.Professor;

public class ProfessorController {
	ProfessorDao pdao = new ProfessorDao();
	
	public void cadastrar(Professor p) {
		pdao.cadastrar(p);
	}
	
	public void alterar(Professor p) {
		pdao.alterar(p);
	}
	
	public ArrayList<Professor> listar(String nome) {
		return pdao.listar(nome);
	}
	
	public Professor buscar(long id) {
		return pdao.buscar(id);
	}
	
	public void excluir(Professor p) {
		pdao.excluir(p);
	}
	
}
