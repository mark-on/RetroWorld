package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dao.BrandDAO;
import Dao.ConsoleDAO;
import Dao.ProductDAO;
import Database.Database;
import entity.Brand;
import entity.Console;
import entity.Product;

@SuppressWarnings("serial")
@WebServlet("/addproductServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB


public class addProductServlet extends HttpServlet {
	private ProductDAO productDAO;
    private ConsoleDAO consoleDAO;
    
    
    @Override
    public void init() throws ServletException {
        super.init();
        try {
			productDAO = new ProductDAO(Database.getConnection());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			new BrandDAO(Database.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			consoleDAO = new ConsoleDAO(Database.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Ottieni i valori dei parametri dalla richiesta
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String brandName = request.getParameter("brand");
        String consoleName = request.getParameter("console");
        String type = request.getParameter("type");
        int amount = Integer.parseInt(request.getParameter("amount"));
        String tag = request.getParameter("tag");
        
       
        
        // Carica l'immagine
        Part filePart = request.getPart("image");
        String fileName = getFileName(filePart); // Ottieni il nome del file

        // Verifica che sia stato selezionato un file
        if (fileName != null && !fileName.isEmpty()) {
            // Salva il file sul server o esegui altre operazioni necessarie
            String filePath = "/product_image" + fileName;
            filePart.write(filePath);

            // Imposta il percorso del file nell'oggetto Product
            String image = filePath;

            // Ottenere gli oggetti Brand e Console in base ai nomi selezionati
            Brand selectedBrand;
            Console selectedConsole;
            
            try {
                selectedBrand = BrandDAO.findByName(brandName);
                selectedConsole = consoleDAO.findByName(consoleName);
            } catch (SQLException e) {
                e.printStackTrace();
                // Gestisci l'eccezione o reindirizza a una pagina di errore
                response.sendRedirect("error.jsp");
                return;
            }

            // Creare un oggetto Product con i valori ottenuti
            Product product = new Product(-1, name, price, description, selectedBrand, selectedConsole, amount, tag, type, image);
            
            // Effettua l'elaborazione per l'aggiunta del prodotto utilizzando il DAO
            try {
                productDAO.addProduct(product);
                // Reindirizza a una pagina di conferma o altro
                response.sendRedirect("success.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
                // Gestisci l'eccezione o reindirizza a una pagina di errore
                response.sendRedirect("error.jsp");
            }
        } else {
            // Se non è stato selezionato alcun file, gestisci l'errore
            response.sendRedirect("error.jsp");
        }
    }
    
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return null;
    }
}
