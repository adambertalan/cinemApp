package hu.unideb.rft.beadando.cinemapp.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;

@WebServlet("/ImageServlet/*")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private MovieService movieService;
       
    public ImageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Long id = Long.valueOf(request.getPathInfo().substring(1));
	        byte[] image = movieService.getImageOfMovie(id);
//	        response.setContentType(getServletContext().getMimeType(image.getName()));
	        if( image != null ){
	        	response.setContentLength(image.length);
		        response.getOutputStream().write(image);	
	        }
	        
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
