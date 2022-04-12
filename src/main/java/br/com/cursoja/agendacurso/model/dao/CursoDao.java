package br.com.cursoja.agendacurso.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.cursoja.agendacurso.model.entidade.Curso;

public class CursoDao extends Conexao {
	
	/***
	 * CRUD
	 * C - Create => Inserir/cadastrar
	 * R - Retrieve => Recuperar/buscar
	 * U - Update => Atualizar/Alterar
	 * D - Delete => Excluir
	 */
	
	public void cadastrar(Curso c) {
		String sql = "insert into curso (nome, valor) values (?, ?)";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setDouble(2, c.getValor());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Deu problema no insert.");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public void alterar(Curso c) {
		String sql = "update curso set nome = ?, valor = ? where idcurso = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, c.getNome());
			ps.setDouble(2, c.getValor());
			ps.setLong(3, c.getId());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro no Update.");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	public ArrayList<Curso> listar(String nomeBusca) {
		ArrayList<Curso> lista = new ArrayList<Curso>();
		
		String sql = "select * from curso where nome like ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			Curso c;
			while(rs.next()) {
				c = new Curso();
				c.setId(rs.getLong("idcurso"));
				c.setNome(rs.getString("nome"));
				c.setValor(rs.getDouble("valor"));
				
				lista.add(c);
			}
			
		} catch(SQLException e) {
			System.out.println("Erro no Listar.");
		} finally {
			fecharConexao();
		}
		
		return lista;
	}
	
	public Curso buscar(long id) {
		Curso curso = null;
		
		String sql = "select * from curso where idcurso = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				curso = new Curso();
				curso.setId(rs.getLong("idcurso"));
				curso.setNome(rs.getString("nome"));
				curso.setValor(rs.getDouble("valor"));
			}
			
		} catch(SQLException e) {
			System.out.println("Erro no Buscar.");
		} finally {
			fecharConexao();
		}
		
		return curso;
	}

}
