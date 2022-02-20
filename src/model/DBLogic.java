package model;
import java.sql.*;
public class DBLogic 
{
	Connection CONN;
	Statement ST;
	ResultSet RS;
	String Query;
	int counter=0;
	PreparedStatement PSTMT;
	
	String LOAD_DRIVER= "com.mysql.cj.jdbc.Driver";
	String DB_CONNECTION = "jdbc:mysql://localhost:3306/emp";
	String DB_USER = "root";
	String DB_PWD = "1811";
	
	public Connection checkConnectionValue()throws ClassNotFoundException,SQLException
	{
		Class.forName(LOAD_DRIVER);
		CONN=DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PWD);
		return CONN;
	}
	
	/*** Searching Methods***/
	
	public ResultSet getEmpProjID(int empID) throws ClassNotFoundException, SQLException
	{
		DBLogic db= new DBLogic();
		CONN= db.checkConnectionValue();
		if(CONN!=null)
		{
			Query= "SELECT PROJID FROM EMPLOYEE "+"WHERE "+ "EMPID = "+empID+""; 
			ST = CONN.createStatement();
			RS = ST.executeQuery(Query);
		}
		return RS;
	}
	public ResultSet getEmpCity(int empID) throws ClassNotFoundException, SQLException
	{
		DBLogic db= new DBLogic();
		CONN= db.checkConnectionValue();
		if(CONN!=null)
		{
			Query= "SELECT CITY FROM EMPLOYEE "+"WHERE "+ "EMPID = "+empID+""; 
			ST = CONN.createStatement();
			RS = ST.executeQuery(Query);
		}
		return RS;
	}
	public ResultSet getEmpName(int projID) throws ClassNotFoundException, SQLException
	{
		DBLogic db= new DBLogic();
		CONN= db.checkConnectionValue();
		if(CONN!=null)
		{
			Query= "SELECT FNAME, LNAME FROM EMPLOYEE "+"WHERE "+ "PROJID = "+projID+""; 
			ST = CONN.createStatement();
			RS = ST.executeQuery(Query);
		}
		return RS;
	}
	public int insertData(int empID, String fName, String lName, String city, int projID)
					throws ClassNotFoundException, SQLException
	{
		DBLogic db= new DBLogic();
		CONN= db.checkConnectionValue();
		if(CONN!=null)
		{
			Query="INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
			PSTMT=CONN.prepareStatement(Query);
			PSTMT.setInt(1,empID);
			PSTMT.setString(2,fName);
			PSTMT.setString(3,lName);
			PSTMT.setString(4,city);
			PSTMT.setInt(5,projID);
			
			counter= PSTMT.executeUpdate();
			if(counter!=0)
			{
				System.out.println("DATA INSERTED FROM MODEL SECTION");
			}
		}
		return counter;
	}
	public int updateData(int empID, String city, int projID)
			throws ClassNotFoundException, SQLException
	{
		DBLogic db= new DBLogic();
		CONN= db.checkConnectionValue();
		if(CONN!=null)
		{
			Query="UPDATE EMPLOYEE SET CITY = ? , PROJID=? WHERE EMPID = ?";
			PSTMT=CONN.prepareStatement(Query);
			PSTMT.setString(1,city);
			PSTMT.setInt(2,projID);
			PSTMT.setInt(3,empID);
			counter= PSTMT.executeUpdate();
			if(counter!=0)
			{
				System.out.println(counter+" records updated from Model Section");
			}
		}
		return counter;
	}
	public int deleteData(int empID) throws ClassNotFoundException, SQLException
	{
		DBLogic db= new DBLogic();
		CONN= db.checkConnectionValue();
		if(CONN!=null)
		{
			Query="DELETE FROM EMPLOYEE WHERE EMPID = ? ";
			PSTMT=CONN.prepareStatement(Query);
			PSTMT.setInt(1,empID);
			counter= PSTMT.executeUpdate();
			if(counter!=0)
			{
				System.out.println(counter+" records deleted from Model Section");
			}
		}
		return counter;
		
	}
	public ResultSet readData(int empID) throws ClassNotFoundException, SQLException
	{
		DBLogic db= new DBLogic();
		CONN= db.checkConnectionValue();
		if(CONN!=null)
		{
			Query="SELECT * FROM EMPLOYEE WHERE EMPID = " + empID;
			ST = CONN.createStatement();
			RS = ST.executeQuery(Query);
		}
		return RS;

	}
	
}
