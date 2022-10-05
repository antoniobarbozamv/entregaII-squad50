package controler;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/Registrar")
public class Registrar extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Cadastro Cadastro = new Cadastro();
		
		Cadastro.setNome(nome); 
		Cadastro.setEmail(email);
		Cadastro.setSenha(senha);
		 
		CadastroDAO CadastroDAO = new CadastroDAO();
		CadastroDAO.save(Cadastro);
		
		
		response.sendRedirect("index.html");
		
		
		
	}

}
