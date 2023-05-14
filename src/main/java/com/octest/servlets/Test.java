package com.octest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.beans.Auteur;

/**
 * Servlet implementation class test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("heure", "jour");
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		String[] noms = {"Nicolas", "Pascaline", "Noé", "Swanne"};
		request.setAttribute("noms", noms);
		
		String[] titres = {"Nouvel incendie", "Une île a été découverte", "Chute du dollar"};
		request.setAttribute("titres", titres);
		
		Auteur auteur = new Auteur();
		auteur.setNom("Houisse");
		auteur.setPrenom("Nicolas");
		auteur.setActif(false);
		
		request.setAttribute("auteur", auteur);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
