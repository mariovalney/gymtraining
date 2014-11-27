package com.gymtraining.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gymtraining.beans.Exercicio;
import com.gymtraining.dao.ExercicioDAO;
import com.gymtraining.dao.UsuarioDAO;

@WebServlet("/cadastro_exercicio/cadastro")
public class cadastro_exercicio extends HttpServlet{
	
	private static final long serialVersionUID = 3186469785066612136L;
	private static final String NEXTJSP = "/cadastro_exercicio/cadastro.jsp";

	protected void service (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		long idCliente = Long.parseLong(request.getParameter("id_cliente"));
		String nomeDoCliente = "";
		
		if(nome != null || descricao != null){
			
			Exercicio exec = new Exercicio();
			exec.setNome(nome);
			exec.setDescricao(descricao);
			exec.setId_cliente(idCliente);
			
			ExercicioDAO dao;
			try {
				dao = new ExercicioDAO();
				dao.insert(exec);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			UsuarioDAO userDao;
			try {
				userDao = new UsuarioDAO();
				nomeDoCliente = userDao.getNameById(idCliente);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		request.setAttribute("status", "sucesso");
		request.setAttribute("nomedoexercicio", exec.getNome());
		request.setAttribute("descricaodoexercicio", exec.getDescricao());
		request.setAttribute("nomedocliente", nomeDoCliente);
		
		} else {
			request.setAttribute("status", "erro");
		}
		
		RequestDispatcher dados = getServletContext().getRequestDispatcher(NEXTJSP);
		dados.forward(request, response);
	}
}