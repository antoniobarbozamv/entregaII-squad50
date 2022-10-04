package site.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import site.Cadastro;
import site.factory.ConnectionFactory;

public class CadastroDAO {

	/*
	 * CRUD:
	 * C: Create
	 * R: Read
	 * U: Update
	 * D: Delete
	 */
	
	public void save(Cadastro cadastro ) {
		
		String sql = "INSERT INTO cadastros(id_cadastro, tipo_perfil, senha, nome, email) VALUES (?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criamos uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores que são esperados pela query
			pstm.setLong(1, cadastro.getId_cadastro());
			pstm.setString(2, cadastro.getTipo_perfil());
			pstm.setString(3, cadastro.getSenha());
			pstm.setString(4, cadastro.getNome());
			pstm.setString(5, cadastro.getEmail());
			
			//Executar a query
			pstm.execute();
			
			System.out.println("Cadastro salvo com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			//Fechar as conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					pstm.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(Cadastro cadastro) {
		
		String sql = "UPDATE cadastros SET tipo_perfil = ?, senha = ?, nome = ?, email = ?" + 
		"WHERE id_cadastro = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, cadastro.getTipo_perfil());
			pstm.setString(2, cadastro.getSenha());
			pstm.setString(3, cadastro.getNome());
			pstm.setString(4, cadastro.getEmail());
			
			//Qual o ID do registro que deseja atualizar?
			pstm.setInt(5, cadastro.getId_cadastro());
			
			//Executar a query
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteByID(int id_cadastro) {
		
		String sql = "DELETE FROM cadastros WHERE id_cadastro = ?";
		
Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id_cadastro);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//READ
	public List<Cadastro> getCadastros(){
		String sql = "SELECT * FROM cadastros";
		
		List<Cadastro> cadastros = new ArrayList<Cadastro>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cadastro cadastro = new Cadastro();
				
				//Recuperar o id_cadastro
				cadastro.setId_cadastro(rset.getInt("id_cadastro"));
				//Recuperar o tipo_perfil
				cadastro.setTipo_perfil(rset.getString("tipo_perfil"));
				//Recuperar a senha
				cadastro.setSenha(rset.getString("senha"));
				//Recuperar o nome
				cadastro.setNome(rset.getString("nome"));
				//Recuperar o email
				cadastro.setEmail(rset.getString("email"));
				
				cadastros.add(cadastro);
				
			}}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (rset!=null) {
						rset.close();
					}
					
					if (pstm!=null) {
						pstm.close();
					}
					
					if (conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return cadastros;
	}
}
