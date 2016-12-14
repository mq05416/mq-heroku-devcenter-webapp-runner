package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDAOImpl;
import model.Product;

@WebServlet(name = "uploads", urlPatterns = { "/uploads/*" })
@MultipartConfig
public class Uploads extends HttpServlet {

	private static final long serialVersionUID = 2857847752169838915L;
	int BUFFER_LENGTH = 4096;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		System.out.println("*******************************Vao retrieve anh tu db**********************************");
		
		System.out.println("productIdImage: "+request.getParameter("productIdImage"));
		
		int productIdImage = Integer.parseInt(request.getParameter("productIdImage"));
		
		System.out.println(productIdImage);
		
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		
		
		

		
		Product product = productDAOImpl.getProductById(productIdImage);
        byte[] productImage = product.getProductImg();
		
		response.setContentType("image/gif");
		OutputStream out = response.getOutputStream();
		out.write(productImage); // image is of byte[] type.
		out.flush();
		out.close();
		
	}

	private String getFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}
