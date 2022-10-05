package controler;

import java.util.Date;

import model.*;

public class Main {

	public static void main(String[] args) {
		
		//Cadastro
		
		CadastroDAO cadastroDAO = new CadastroDAO();
		
		Cadastro cadastro = new Cadastro();
		cadastro.setTipo_perfil("Professor");
		cadastro.setSenha("124");
		cadastro.setNome("Duda");
		cadastro.setEmail("duda@email.com");
		
		//CREATE
		//cadastroDAO.save(cadastro);
		
		//Atualizar o cadastro
		Cadastro c1 = new Cadastro();
		c1.setId_cadastro(1);
		c1.setTipo_perfil("Professor");
		c1.setSenha("321");
		c1.setNome("Beatriz");
		c1.setEmail("beatriz@email.com");
		
		//UPDATE
		//cadastroDAO.update(c1);
		
		//DELETE
		//Deletar o cadastro pelo seu número de ID
		//cadastroDAO.deleteByID(1);
		
		//Visualização dos registros do banco de dados TODOS
		
		for(Cadastro c : cadastroDAO.getCadastros()) {
			System.out.println("Cadastro: "+c.getId_cadastro());
			
		//Feed
			
		FeedDAO feedDAO = new FeedDAO();
		
		Feed feed = new Feed();
		feed.setReacoes(0);
		feed.setData_post(new Date());
		feed.setComentario("abc abc abc");
		
		//CREATE
		//feedDAO.save(feed);
		
		//Atualizar o feed
		Feed f1 = new Feed();
		f1.setId_post(0);
		f1.setReacoes(0);
		f1.setData_post(new Date());
		f1.setComentario("lorem lorem");
		
		//UPDATE
		//feedDAO.update(f1);
		
		//DELETE
		//Deletar o post pele seu número de ID
		//feedDAO.deleteByID(0);
		
		//Visualização dos registros do banco de dados TODOS
		
		/*
		* for(Feed f : feedDAO.getFeeds()) {
		* System.out.println("Feed: "+f.getId_post());
		*}
		*/
		
		//Perfil
		
		PerfilDAO perfilDAO = new PerfilDAO();
		
		Perfil perfil = new Perfil();
		perfil.setAvaliacoes("abc abc");
		perfil.setSobre_mim("lorem lorem");
		
		//CREATE
		//perfilDAO.save(perfil);
		
		//Atualizar o perfil
		Perfil p1 = new Perfil();
		p1.setId_perfil(0);
		p1.setAvaliacoes("nova avaliacao");
		p1.setSobre_mim("novo sobre_mim");
		
		//UPDATE
		//perfilDAO.update(p1);
		
		//DELETE
		//Deletar o pacote pelo seu número de ID
		//perfilDAO.deleteByID(0);
		
		//Visualização dos registros do banco de dados TODOS
		
		/*
		 * for(Perfil p : perfilDAO.getPerfis()) {
		 * System.out.println("Perfil: "+p.getId_perfil());
		 *}
		 */
		}
	}
}
