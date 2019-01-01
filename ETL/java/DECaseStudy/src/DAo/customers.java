package DAo;
import java.sql.*;

public class customers {
	
	public student getstudent(int rollno) {
		
		student s = new student();
		s.rollno = rollno;
		
		try {
			String query = "select sname from student where rollno="+rollno;
			Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/navin?useSSL=false", "root","root" );
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(query);
		 rs.next();
		String name = rs.getString(1);
		
		 s.sname = name;
		 
		} 
		catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return s;
	}
}

class student {
	int rollno;
	String sname;
}


