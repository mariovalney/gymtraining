package com.gymtraining.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/cadastro_clientes/cadastro")
public class cadastro_cliente extends HttpServlet{
	
	private static final long serialVersionUID = 3186979898966612136L;
	private static final String NEXTJSP = "/cadastro_clientes/cadastro.jsp";

	protected void service (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String dataNascimento = request.getParameter("dataNascimento");
		String origem = request.getParameter("origem");
		String id = request.getParameter("id");
		
		SimpleDateFormat stringPadrao = new SimpleDateFormat("yyyy-MM-dd");
		
		if(nome != null || email != null){
			
			Usuario user = new Usuario();
			Usuario userRegistered = new Usuario();
			
			user.setNome(nome);
			user.setEmail(email);
			
			// Criando agora, logo data de criação = data de modificação = agora
			Date now = new Date();
			user.setDataCriacao(now);
			user.setDataModificacao(now);
			
			Date dataDeNascimento;
			UsuarioDAO dao;
			
			try {
				dataDeNascimento = stringPadrao.parse(dataNascimento);
				user.setDataNascimento(dataDeNascimento);
				
				if (origem.equals("edicao")) {
					dao = new UsuarioDAO();
					
					dao.update(Long.parseLong(id), user);
					user = dao.selectById(Long.parseLong(id));
					
					request.setAttribute("status", "editado");
					request.setAttribute("nomedocliente", user.getNome());
					request.setAttribute("emaildocliente", user.getEmail());
					
				} else {				
					dao = new UsuarioDAO();
					if (dao.isRegistered(email)) {
						
						UsuarioDAO userDao;
						try {
							request.setAttribute("status", "cadastrado");
							
							userDao = new UsuarioDAO();
							userRegistered = userDao.selectByMail(email);
							
							request.setAttribute("iddocliente", Long.toString(userRegistered.getId()));
							request.setAttribute("nomedocliente", userRegistered.getNome());
							request.setAttribute("emaildocliente", userRegistered.getEmail());
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						dao.insert(user);
						user = dao.selectByMail(email);
						
						request.setAttribute("status", "sucesso");
						request.setAttribute("nomedocliente", user.getNome());
						request.setAttribute("emaildocliente", user.getEmail());
						request.setAttribute("iddocliente", Long.toString(user.getId()));
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
