package com.gymtraining.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gymtraining.beans.Exercicio;
import com.gymtraining.beans.Usuario;
import com.gymtraining.dao.ExercicioDAO;
import com.gymtraining.dao.UsuarioDAO;

@WebServlet("/listagem_exercicios/lista")
public class listagem_exercicio extends HttpServlet{
	
	private static final long serialVersionUID = 3186969785066612136L;
	private static final String NEXTJSP = "/listagem_exercicios/lista.jsp";

	protected void service (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		String email = request.getParameter("email");
		
		if(email != null){
			
			Usuario user = new Usuario();
			UsuarioDAO userDao;

			try {
				userDao = new UsuarioDAO();
				
				if (!userDao.isRegistered(email)) {								
					request.setAttribute("status", "unregistered");
				} else {				
					user = userDao.selectByMail(email);
					
					ExercicioDAO execDao;
					try {
						execDao = new ExercicioDAO();
						List<Exercicio> list = execDao.selectByIdCliente(user.getId());
						
						request.setAttribute("status", "sucesso");
						request.setAttribute("nomedocliente", user.getNome());
						request.setAttribute("listadeexercicios", list);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} else {
			request.setAttribute("status", "erro");
		}
		
		RequestDispatcher dados = getServletContext().getRequestDispatcher(NEXTJSP);
		dados.forward(request, response);
	}
}