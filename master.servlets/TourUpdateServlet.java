package master.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.dao.TourDao;
import master.dto.TourDTO;

@WebServlet("/TourUpdateServlet")
public class TourUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        
        
        String tourId = request.getParameter("tourId");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        BigDecimal price = new BigDecimal(request.getParameter("price"));

       
        TourDTO dto = new TourDTO();
        dto.setTourId(tourId);
        dto.setStartDate(startDate);
        dto.setEndDate(endDate);
        dto.setPrice(price);

       
        TourDao dao = new TourDao();
        dao.updateData(dto);

     
        response.sendRedirect("success.jsp"); 
    }
}
