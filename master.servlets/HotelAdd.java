package com.tour.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import com.tour.dao.HotelDao;
import com.tour.dto.HotelDto;

public class AddHotelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        String name = req.getParameter("hotelName");
        String place = req.getParameter("tplace");

        HotelDto dto = new HotelDto(0, name, place);
        HotelDao dao = new HotelDao();

        try {
            int status = dao.addHotel(dto);
            if (status > 0) {
                out.println("Hotel Added Successfully!");
            } else {
                out.println("Error in Adding Hotel");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Exception: " + e.getMessage());
        }
    }
}
