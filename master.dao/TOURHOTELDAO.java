package com.dao;

import com.dto.AllotmentDTO;
import java.sql.*;

public class AllotmentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/travel_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // change as per your setup

    public boolean saveAllotment(AllotmentDTO allotment) {
        String query = "INSERT INTO allotments (tour_id, hotel_id) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, allotment.getTourId());
            ps.setString(2, allotment.getHotelId());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
