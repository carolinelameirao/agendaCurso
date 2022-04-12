package br.com.cursoja.agendacurso.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.cursoja.agendacurso.model.entidade.Curso;
import br.com.cursoja.agendacurso.model.entidade.Professor;

public class ProfessorDao extends Conexao {
	public void cadastrar(Professor p) {
		String sql = "insert into professor (nome, celular, valor_hora) values (?, ?, ?)";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCelular());
			ps.setDouble(3, p.getValorHora());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Deu problema no insert.");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public void alterar(Professor p) {
		String sql = "update professor set nome = ?, celular = ?, valor_hora = ? where idprofessor = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCelular());
			ps.setDouble(3, p.getValorHora());
			ps.setLong(4, p.getId());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro no Update.");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public ArrayList<Professor> listar(String nomeBusca) {
		ArrayList<Professor> lista = new ArrayList<Professor>();
		
		String sql = "select * from professor where nome like ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			Professor p;
			while(rs.next()) {
				p = new Professor();
				p.setId(rs.getLong("idprofessor"));
				p.setNome(rs.getString("nome"));
				p.setCelular(rs.getString("celular"));
				p.setValorHora(rs.getDouble("valor_hora"));
				
				lista.add(p);
			}
			
		} catch(SQLException e) {
			System.out.println("Erro no Listar.");
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
	
	public Professor buscar(long id) {
		Professor professor = null;
		
		String sql = "select * from professor where idprofessor = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				professor = new Professor();
				professor.setId(rs.getLong("idprofessor"));
				professor.setNome(rs.getString("nome"));
				professor.setCelular(rs.getString("celular"));
				professor.setValorHora(rs.getDouble("valor_hora"));
			}
			
		} catch(SQLException e) {
			System.out.println("Erro no Buscar.");
		} finally {
			fecharConexao();
		}
		
		return professor;
	}
}
