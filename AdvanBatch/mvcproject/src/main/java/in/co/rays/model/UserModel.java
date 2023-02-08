package in.co.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import in.co.rays.bean.UserBean;
import in.co.rays.ctl.JDBCDataSource;

public class UserModel {
	public  static int nextPK() throws ClassNotFoundException, SQLException
	{
		int pk=0;
		ResourceBundle rd=ResourceBundle.getBundle("in.co.rays.bundle.system");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/rays","root","root");
		PreparedStatement ps=con.prepareStatement("select max(id) from user");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			pk=rs.getInt(1);
		}
		return pk+1;
		
	}
public void add(UserBean b) throws Exception
{
	//ResourceBundle rd=ResourceBundle.getBundle("in.co.rays.bundle.system");
//Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=JDBCDataSource.getConnection();
PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?)");
ps.setInt(1,nextPK());
ps.setString(2, b.getFname());
ps.setString(3, b.getLname());
ps.setString(4, b.getEmail());
ps.setString(5, b.getPassword());

int i=ps.executeUpdate();

}
public  static ArrayList getList() throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/rays","root","root");
	PreparedStatement ps=con.prepareStatement("select*from user");
	
	ArrayList list=new ArrayList<UserBean>();
	Iterator it=list.iterator();
ResultSet rs=ps.executeQuery();
while(rs.next()){
	UserBean bean=new UserBean();
bean.setId(rs.getInt(1));
bean.setFname(rs.getString(2));
bean.setLname(rs.getString(3));
bean.setEmail(rs.getString(4));
bean.setPassword(rs.getString(5));
list.add(bean);
}

	return list;
}
public UserBean authenticate(String email, String password) throws Exception {
	// log.debug("Model authenticate Started");
	
	UserBean ub = null;
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/rays","root","root");
	try {			
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM USER WHERE email = ? AND PASSWORD = ?");

		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ub = new UserBean();
			ub.setId(rs.getInt(1));
			ub.setFname(rs.getString(2));
			ub.setLname(rs.getString(3));
			ub.setEmail(rs.getString(4));
			ub.setPassword(rs.getString(5));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} 
	return ub;
	}

}
