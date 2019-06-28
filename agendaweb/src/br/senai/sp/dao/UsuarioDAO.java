package br.senai.sp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.senai.sp.model.Usuario;

public class UsuarioDAO {
	
	private Usuario usuario;

	public UsuarioDAO(){};
	
	public UsuarioDAO(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
    /*   METODOS PARA CADASTRAR   */
	public void cadastrar() {
		
		String sql = "INSERT INTO tbl_usuario" + 
				"(nome, email, senha) VALUES" + 
				"(?, ?, AES_ENCRYPT(?, 'CHAVE'))";
		
		try {
			PreparedStatement stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			
			stm.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public Usuario autenticar(String email, String senha) {
		
		String sql = "SELECT * FROM tbl_usuario WHERE email = ?" +
				" AND CAST(AES_DECRYPT(senha, 'CHAVE') AS CHAR) = ?";
		
		Usuario user = null;
		ResultSet rs = null;
		
		try {
			PreparedStatement stm = Conexao.abrirConexao().prepareStatement(sql);
			stm.setString(1, email);
			stm.setString(2, senha);
			
			rs = stm.executeQuery();
			
			if(rs.next()) {
				user = new Usuario();
				user.setId(rs.getInt("id"));
				user.setNome(rs.getString("nome"));
				user.setEmail(rs.getString("email"));

			}else {
				System.out.println("Usuário ou senha incorretos!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
	
	
}
