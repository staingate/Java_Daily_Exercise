
import java.sql.*;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class TestDML {
	static ResultSet rs = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		//PreparedStatement pState = null;
		Statement state = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/Class15?user=root&password=1234");
			//pState = conn.prepareStatement("insert into students values(?, ?)");
			//pState.setString(1, "ÀîÒøºÓ");
			//pState.setInt(2, 5);
			
			state = conn.createStatement();
			//insert(state);
			//search(state);
			//update(state);
			delete(state);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert(Statement stat) {
		
		try {
			stat.executeUpdate("insert into students values ('ÂÞÓÀºÆ', 1)");
			stat.executeUpdate("insert into students values ('ÂÞ¾ü', 2)");
			stat.executeUpdate("insert into students values ('ÁÎÁ¬ÔÆ', 3)");
			stat.executeUpdate("insert into students values ('Áè¼Î¿¡', 4)");
			stat.executeUpdate("insert into students values ('ÂÞºÆ', 5)");
			stat.executeUpdate("insert into students values ('ÎâÆ®', 6)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void search(Statement stat) {
		String sql = "select * from Students";
		try {
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("StuId") + ">>>" + rs.getString("StuName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void update(Statement stat) {
		String sql = "update Students set StuName='ÂÞÁÖ' where (StuId='1')";
		try {
			stat.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void delete(Statement stat) {
		String sql = "delete from Students where StuId='3'";
		try {
			stat.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
