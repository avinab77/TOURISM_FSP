package master.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import master.dao.TourDao;
import master.dto.TourDTO;

@WebServlet("/TourDeleteServlet")
public class TourDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        
       
        String tourId = request.getParameter("tourId");

        
        TourDTO dto = new TourDTO();
        dto.setTourId(tourId);

       
        TourDao dao = new TourDao();
        dao.deleteData(dto);

        
        response.sendRedirect("success.jsp"); 
    }
}
