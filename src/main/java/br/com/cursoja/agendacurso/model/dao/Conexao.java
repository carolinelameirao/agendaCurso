package br.com.cursoja.agendacurso.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String caminho = "jdbc:mysql://localhost:3306/cursojava";
	private String usuario = "root";
	private String senha = "";
	
	private Connection conn = null;
	
	public Connection getConexao( ) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(caminho, usuario, senha);
			System.out.println("Conectado com sucesso!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Não encontrou o Driver.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao acessar o banco de dados.");
			e.printStackTrace();
		}
		return conn;
	}
	
	public void fecharConexao() {
		try {
			conn.close();
			System.out.println("Conexão fechada.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Deu problema.");
			e.printStackTrace();
		}
	}
}
