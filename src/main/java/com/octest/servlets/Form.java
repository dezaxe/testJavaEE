package com.octest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.beans.BeanException;
import com.octest.beans.Utilisateur;
import com.octest.dao.DaoException;
import com.octest.dao.DaoFactory;
import com.octest.dao.UtilisateurDao;
import com.octest.forms.ConnectionForm;

/**
 * Servlet implementation class Form
 */
@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurDao utilisateurDao;
	
	public void init() throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		utilisateurDao = daoFactory.getUtilisateurDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for(Cookie cookie : cookies) {
				if (cookie.getName().equals("login")) {
					request.setAttribute("login", cookie.getValue());
				}
			}
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		HttpSession session = request.getSession();
		
		// test l'écriture en base de donnée
		Utilisateur nouvelUtilisateur = new Utilisateur();
		try {
			nouvelUtilisateur.setNom(nom);
			nouvelUtilisateur.setPrenom(prenom);
			
			session.setAttribute("nom", nouvelUtilisateur.getNom());
			session.setAttribute("prenom", nouvelUtilisateur.getPrenom());
			
			utilisateurDao.ajouter(nouvelUtilisateur);
		} catch (BeanException e){
			request.setAttribute("erreur", e.getMessage());
		} catch (DaoException e) {
			request.setAttribute("erreur", e.getMessage());
		}
		
		
		
        
		// test de la session
        String login = request.getParameter("login");
        
        Cookie cookie = new Cookie("login", login);
        
        cookie.setMaxAge(60 * 3); // En seconde, peut utiliser des calculs comme (60 * 60) pour une heure ou (60 * 60 * 24 *30) pour un mois
        
        response.addCookie(cookie);
        
        if(login != null) {
	        ConnectionForm form = new ConnectionForm();
	        
	        form.verifierIdentifiants(request);
	        
	        request.setAttribute("form", form);
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(request, response);
	}

}
