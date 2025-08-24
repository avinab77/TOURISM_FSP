package master.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import master.dao.TourDao;
import master.dto.TourDTO;
@WebServlet("/TourAddServlet") 
public class TourAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException 
             {
        
       
        String tourId = request.getParameter("tourId");
        String tourName = request.getParameter("tourName");
        String state = request.getParameter("state");
        String cities = request.getParameter("cities");
        String travelMode = request.getParameter("travelMode");
        String accommodation = request.getParameter("accommodation");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        BigDecimal price = new BigDecimal(request.getParameter("price"));

        
        TourDTO dto = new TourDTO();
        dto.setTourId(tourId);
        dto.setTourName(tourName);
        dto.setState(state);
        dto.setCities(cities);
        dto.setTravelMode(travelMode);
        dto.setAccommodation(accommodation);
        dto.setStartDate(startDate);
        dto.setEndDate(endDate);
        dto.setPrice(price);

        
        TourDao dao = new TourDao();
        dao.insertData(dto);

     
        response.sendRedirect("success.jsp"); 
    }
}
