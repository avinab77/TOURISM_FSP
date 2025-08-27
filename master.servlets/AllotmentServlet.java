package master.servlet;

import com.dao.AllotmentDAO;
import com.dto.AllotmentDTO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AllotmentServlet extends HttpServlet {
    private AllotmentDAO allotmentDAO;

    @Override
    public void init() {
        allotmentDAO = new AllotmentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tourId = request.getParameter("tourId");
        String hotelId = request.getParameter("hotelId");

        AllotmentDTO allotment = new AllotmentDTO(tourId, hotelId);

        boolean success = allotmentDAO.saveAllotment(allotment);

        if (success) {
            response.getWriter().println("✅ Allotment saved successfully!");
        } else {
            response.getWriter().println("❌ Failed to save allotment!");
        }
    }
}

