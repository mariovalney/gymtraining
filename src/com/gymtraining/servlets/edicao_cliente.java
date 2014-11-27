package com.gymtraining.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gymtraining.beans.Usuario;
import com.gymtraining.dao.UsuarioDAO;

@WebServlet("/cadastro_clientes/edicao")
public class edicao_cliente extends HttpServlet{
	
	private static final long serialVersionUID = 318697989836612136L;
	private static final String NEXTJSP = "/cadastro_clientes/edicao.jsp";

	protected void service (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		String id = request.getParameter("id");
		
		
		if(id != null){
			
			Usuario user = new Usuario();
			//Date now = new Date();
						
			UsuarioDAO dao;
			try {			
				dao = new UsuarioDAO();
				user = dao.selectById(Long.parseLong(id));
				
				request.setAttribute("status", "sucesso");
				request.setAttribute("nomedocliente", user.getNome());
				request.setAttribute("emaildocliente", user.getEmail());
				request.setAttribute("datanascimento", user.getDataNascimento());
				request.setAttribute("iddocliente", id);
				
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
