
import java.sql.*;

public class TestJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Class15?user=root&password=1234");
			state = conn.createStatement();
			rs = state.executeQuery("select * from Students");
			while(rs.next()) {
				System.out.println(""+ rs.getInt("StuId") + " " + rs.getString("StuName") );
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				state.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

}
