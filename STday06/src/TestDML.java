
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
			System.out.println("��ѡ����ɾ�Ĳ��е�һ�����ܣ�\n1������\n2��ɾ��\n3���޸�");
			
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
		System.out.println("�����������ӵ�������");
		stuName = scan.next();
		System.out.println("�����������ӵ�ѧ�ţ�");
		stuId = scan.nextInt();
		
		try {
			temp = stat.executeQuery("select StuName from Students where StuId='" + stuId + "'");
			if(temp.next() == true) {
				System.out.println("���ʧ�ܣ����ݿ��Ѵ��ڴ���Ŀ�����´�������ȷѧ��");
				System.exit(0);
			} else {
				stat.execute("insert into Students values('" + stuName + "', " + stuId + ")");
				System.out.println("��ӳɹ���");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	public static void update(Statement stat) {
		System.out.println("��������Ҫ�޸Ķ����ѧ�ţ�");
		stuId = scan.nextInt();
		try {
			temp = stat.executeQuery("select StuName from Students where StuId='" + stuId + "'");
			if(temp.next() == false) {
				System.out.println("�޸�ʧ�ܣ����ݿⲻ���ڴ���Ŀ�����´�������ȷѧ��");
				System.exit(0);
			} else {
				System.out.println("�����������޸ĳɵ�������");
				stuName = scan.next();
				stat.execute("update Students set StuName='" + stuName + "' where StuId='" + stuId + "'");
				System.out.println("�޸ĳɹ���");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public static void delete(Statement stat) {
		System.out.println("��������Ҫɾ�������ѧ�ţ�");
		stuId = scan.nextInt();
		try {
			temp = stat.executeQuery("select StuName from Students where StuId='" + stuId + "'");
			if(temp.next() == false) {
				System.out.println("ɾ��ʧ�ܣ����ݿⲻ���ڴ���Ŀ�����´�������ȷѧ��");
				System.exit(0);
			} else {
				
				stat.execute("delete from Students where StuId='" + stuId + "'");
				System.out.println("ɾ���ɹ���");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
