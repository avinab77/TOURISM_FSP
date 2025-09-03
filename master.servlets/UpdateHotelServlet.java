import java.sql.*;
import com.tour.dao.HotelDao;
import com.tour.dto.HotelDto;

public class UpdateHotelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");

        int id = Integer.parseInt(req.getParameter("hotelId"));
        String name = req.getParameter("hotelName");
        String place = req.getParameter("tplace");

        HotelDto dto = new HotelDto(id, name, place);
        HotelDao dao = new HotelDao();

        try {
            int status = dao.updateHotel(dto);
            if (status > 0) {
                out.println("Hotel Updated Successfully!");
            } else {
                out.println("Error in Updating Hotel");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Exception: " + e.getMessage());
        }
    }
}
