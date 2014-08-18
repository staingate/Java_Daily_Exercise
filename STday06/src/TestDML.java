
import java.sql.*;
import java.util.Scanner;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

public class TestDML {
	static ResultSet rs = null;
	static Scanner scan = new Scanner(System.in);
	static String stuName = null;
	static int stuId;
	static ResultSet temp;
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
			
			
			state = conn.createStatement();
			System.out.println("请选择增删改查中的一个功能：\n1、增加\n2、删除\n3、修改");
			
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				insert(state);
				break;
			case 2:
				delete(state);
				break;
			case 3:
				update(state);
				break;			
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void insert(Statement stat) {
		System.out.println("请输入需增加的姓名：");
		stuName = scan.next();
		System.out.println("请输入需增加的学号：");
		stuId = scan.nextInt();
		
		try {
			temp = stat.executeQuery("select StuName from Students where StuId='" + stuId + "'");
			if(temp.next() == true) {
				System.out.println("添加失败！数据库已存在此条目，请下次输入正确学号");
				System.exit(0);
			} else {
				stat.execute("insert into Students values('" + stuName + "', " + stuId + ")");
				System.out.println("添加成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	public static void update(Statement stat) {
		System.out.println("请输入你要修改对象的学号：");
		stuId = scan.nextInt();
		try {
			temp = stat.executeQuery("select StuName from Students where StuId='" + stuId + "'");
			if(temp.next() == false) {
				System.out.println("修改失败！数据库不存在此条目，请下次输入正确学号");
				System.exit(0);
			} else {
				System.out.println("请输入你想修改成的姓名：");
				stuName = scan.next();
				stat.execute("update Students set StuName='" + stuName + "' where StuId='" + stuId + "'");
				System.out.println("修改成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public static void delete(Statement stat) {
		System.out.println("请输入你要删除对象的学号：");
		stuId = scan.nextInt();
		try {
			temp = stat.executeQuery("select StuName from Students where StuId='" + stuId + "'");
			if(temp.next() == false) {
				System.out.println("删除失败！数据库不存在此条目，请下次输入正确学号");
				System.exit(0);
			} else {
				
				stat.execute("delete from Students where StuId='" + stuId + "'");
				System.out.println("删除成功！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
