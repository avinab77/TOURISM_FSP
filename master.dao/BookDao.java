package master.dao;
import java.sql.*;


import master.dto.BookDto;
import master.utilities.ConnectionFactory;
public class BookDao {
	private Connection cn=null;
	private Statement st=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private String insert_sql="INSERT INTO booking (tid, hid, rtype, bkdt, uname) VALUES (?,?,?,?,?)";
	
	//private String select_sql = "SELECT * FROM booking ORDER BY bkid";  


	public int insertData(BookDto bdto)
	
	{
		int bookingId = 0;
		try
		{
		
		ConnectionFactory con = new ConnectionFactory();
		cn=con.getConn();
		ps = cn.prepareStatement(insert_sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,bdto.getTid());
		ps.setString(2,bdto.getHid());
		ps.setString(3,bdto.getRtype());
		ps.setString(4,bdto.getBkdt());
		ps.setString(5,bdto.getUname());
		int rows = ps.executeUpdate();
        if (rows > 0) {
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                bookingId = rs.getInt(1); 
            }
        }

        cn.close();
    }
		catch (SQLException se) {
        se.printStackTrace();
    }
    return bookingId;
		
		}		
		
	}

