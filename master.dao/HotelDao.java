import java.sql.*;
import com.tour.dto.HotelDto;

public class HotelDao {
    private static final String URL = "jdbc:mysql://localhost:3306/tour_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 8+
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int addHotel(HotelDto hotel) throws SQLException {
        String sql = "INSERT INTO AddHotel (HotelName, Tplace) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, hotel.getHotelName());
            ps.setString(2, hotel.getTplace());
            return ps.executeUpdate();
        }
    }

    public int updateHotel(HotelDto hotel) throws SQLException {
        String sql = "UPDATE UpdHotel SET HotelName=?, Tplace=? WHERE HotelID=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, hotel.getHotelName());
            ps.setString(2, hotel.getTplace());
            ps.setInt(3, hotel.getHotelId());
            return ps.executeUpdate();
        }
    }

    public int deleteHotel(int hotelId) throws SQLException {
        String sql = "DELETE FROM DelHotel WHERE HotelID=?";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, hotelId);
            return ps.executeUpdate();
        }
    }
}
