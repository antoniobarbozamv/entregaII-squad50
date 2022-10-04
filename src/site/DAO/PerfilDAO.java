package site.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import site.Perfil;
import site.factory.ConnectionFactory;

public class PerfilDAO {

	/*
	 * CRUD:
	 * C: Create
	 * R: Read
	 * U: Update
	 * D: Delete
	 */
	
public void save(Perfil perfil) {
		
	String sql = "INSERT INTO perfis(id_perfil, avaliacoes, sobre_mim) VALUES (?, ?, ?)";
	
	Connection conn = null;
	PreparedStatement pstm = null;
		
	try {
		//Criar uma conexão com o banco de dados
		conn = ConnectionFactory.createConnectionToMySQL();
		
		//Criamos uma PreparedStatement, para executar uma query
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		//Adicionar os valores que são esperados pela query
		pstm.setLong(1, perfil.getId_perfil());
		pstm.setString(2, perfil.getAvaliacoes());
		pstm.setString(3, perfil.getSobre_mim());
			
		//Executar a query
		pstm.execute();
			
		System.out.println("Perfil salvo com sucesso!");
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
	
public void update(Perfil perfil) {
		
	String sql = "UPDATE perfis SET id_perfil = ?, avaliacoes = ?, sobre_mim = ?" + "WHERE id_perfil = ?";
		
	Connection conn = null;
	PreparedStatement pstm = null;
		
	try {
		//Criar conexão com o banco
		conn = ConnectionFactory.createConnectionToMySQL();
			
		//Criar a classe para executar a query
		pstm = (PreparedStatement) conn.prepareStatement(sql);
			
		//Adicionar os valores para atualizar
		pstm.setString(1, perfil.getAvaliacoes());
		pstm.setString(2, perfil.getSobre_mim());
		//Qual o ID do registro que deseja atualizar?
		pstm.setInt(3, perfil.getId_perfil());
			
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

public void deleteByID(int id_perfil) {
	
	String sql = "DELETE FROM perfis WHERE id_perfil = ?";
	
	Connection conn = null;
	
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setInt(1, id_perfil);
		
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
public List<Perfil> getPerfis(){
	String sql = "SELECT * FROM perfis";
	
	List<Perfil> perfis = new ArrayList<Perfil>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	//Classe que vai recuperar os dados do banco ***SELECT***
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Perfil perfil = new Perfil();
			
			//Recuperar o id_perfil
			perfil.setId_perfil(rset.getInt("id_perfil"));
			//Recuperar o avaliacoes
			perfil.setAvaliacoes(rset.getString("avaliacoes"));
			//Recuperar o sobre_mim
			perfil.setSobre_mim(rset.getString("sobre_mim"));
			
			perfis.add(perfil);
			
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
	
		return perfis;
}
}