package site.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import site.Feed;
import site.factory.ConnectionFactory;

public class FeedDAO {

	/*
	 * CRUD:
	 * C: Create
	 * R: Read
	 * U: Update
	 * D: Delete
	 */
	
	public void save(Feed feed) {
		String sql = "INSERT INTO feeds(id_post, reacoes, data_post, comentario) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criamos uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores que são esperados pela query
			pstm.setLong(1, feed.getId_post());
			pstm.setLong(2, feed.getReacoes());
			pstm.setDate(3, new Date(feed.getData_post().getTime()));
			pstm.setString(4, feed.getComentario());
			
			//Executar a query
			pstm.execute();
			
			System.out.println("Informações do feed salvos com sucesso!");
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
	
	public void update(Feed feed) {
		
		String sql = "UPDATE feeds SET reacoes = ?, data_post = ?, comentario = ?" + 
		"WHERE id_post = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setLong(1, feed.getReacoes());
			pstm.setDate(2, new Date(feed.getData_post().getTime()));
			pstm.setString(3, feed.getComentario());
			
			//Qual o ID do registro que deseja atualizar?
			pstm.setInt(4, feed.getId_post());
			
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
	
	public void deleteByID(int id_post) {
		
		String sql = "DELETE FROM feeds WHERE id_post = ?";
		
Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id_post);
			
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
	public List<Feed> getFeeds(){
		String sql = "SELECT * FROM feeds";
		
		List<Feed> feeds = new ArrayList<Feed>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Feed feed = new Feed();
			
			//Recuperar o id_post
			feed.setId_post(rset.getInt("id_post"));
			//Recuperar as reacoes
			feed.setReacoes(rset.getInt("reacoes"));
			//Recuperar a data_post
			feed.setData_post(rset.getDate("data_post"));
			//Recuperar o comentario
			feed.setComentario(rset.getString("comentario"));
			
			feeds.add(feed);
			
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
		
		return feeds;
	}
}
