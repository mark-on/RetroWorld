package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.Database;


@WebServlet(name = "researchServlet", urlPatterns = {"/researchServlet.java"})

public class researchServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ricerca = request.getParameter("toSearch");
        
        
        
        // Ottieni i risultati della ricerca
        // ...
        
        // Imposta i risultati come attributo della richiesta
       // request.setAttribute("risultati", risultati);
        
        // Reindirizza alla pagina dei risultati di ricerca
        request.getRequestDispatcher("risultati.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

