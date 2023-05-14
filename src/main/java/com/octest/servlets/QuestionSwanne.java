package com.octest.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QuestionSwanne
 */
@WebServlet("/QuestionSwanne")
public class QuestionSwanne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionSwanne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/swanne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String animal = request.getParameter("animal");
		String couleur = request.getParameter("couleur");
		int nombre = Integer.parseInt(request.getParameter("nombre"));
		
		request.setAttribute("animal", animal);
		request.setAttribute("couleur", couleur);
		request.setAttribute("nombre", nombre);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/swanne.jsp").forward(request, response);
	}

}
