package br.senai.sp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.senai.sp.model.Contato;
import br.senai.sp.model.Tipo;

public class ContatoDAO {
	
	private Contato contato;
	
	
	public ContatoDAO() {
		
	};
	
	public ContatoDAO (Contato contato) {
		this.contato = contato;
	};
	
	
	public boolean cadastrar() {
		
		String sql = "INSERT INTO tbl_contato(" + 
				"nome, data_nascimento, email, telefone, endereco, tipo_contato, id_usuario" + 
				")VAlUES(" + 
				"?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stm = Conexao.abrirConexao().prepareStatement(sql);
			
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getDataNascimento());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getTelefone());
			stm.setString(5, contato.getEndereco());
			stm.setString(6, String.valueOf(contato.getTipo()));
			stm.setInt(7, contato.getUsuario().getId());
			
			stm.execute();
			
			Conexao.fecharConexao();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			return false;
		}
		
	
	}
	
	public ArrayList<Contato> getContatos(int id){
		
		String sql = "SELECT * FROM tbl_contato WHERE id_usuario = ? ORDER BY nome";
		
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		
		ResultSet rs;
		
		try {
			
			PreparedStatement stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			
			while(rs.next()) {
				contato = new Contato();
				
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setDataNascimento(rs.getString("data_nascimento"));
				contato.setTipo(Tipo.valueOf(rs.getString("tipo_contato")));
				
				contatos.add(contato);
			}
			
			Conexao.fecharConexao();
			
			return contatos;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public Contato getContato(int id) {
		
		String sql ="SELECT * FROM tbl_contato WHERE id = ?";
		
		ResultSet rs;
		
		try {
			
			PreparedStatement stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setInt(1, id);
			
			rs = stm.executeQuery();
			
			if(rs.next()) {;
				contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setDataNascimento(rs.getString("data_nascimento"));
				contato.setTipo(Tipo.valueOf(rs.getString("tipo_contato")));
			}
			
			Conexao.fecharConexao();
			
			return contato;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public boolean excluir(int id) {
		
		String sql = "DELETE FROM tbl_contato WHERE id = ?";
		
		try {
			
			PreparedStatement stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setInt(1, id);
			
			stm.execute();
			
			Conexao.fecharConexao();
			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	public boolean atualizar() {
		
		String sql = "UPDATE tbl_contato SET nome = ?, data_nascimento = ?,"
				+ " email = ?, telefone = ?, endereco = ?, tipo_contato = ? WHERE id = ?";
		
		try {
			
			PreparedStatement stm = Conexao.abrirConexao().prepareStatement(sql);
			
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getDataNascimento());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getTelefone());
			stm.setString(5, contato.getEndereco());
			stm.setString(6, String.valueOf(contato.getTipo()));
			stm.setInt(7, contato.getId());
			
			stm.execute();
			
			Conexao.fecharConexao();
			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
			
		}

		
	}
	

}
