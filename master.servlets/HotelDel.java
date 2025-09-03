package com.tour.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import com.tour.dao.HotelDao;

public class DeleteHotelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        int id = Integer.parseInt(req.getParameter("hotelId"));
        HotelDao dao = new HotelDao();

        try {
            int status = dao.deleteHotel(id);
            if (status > 0) {
                out.println("Hotel Deleted Successfully!");
            } else {
                out.println("Error in Deleting Hotel");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Exception: " + e.getMessage());
        }
    }
}
