package view;
import java.util.*;
import java.sql.*;
import model.DBLogic;
import controller.DataOperation;

public class CLI 
{
	int empID, projID, proj; 
	String city, fName,lName;
	ResultSet RS;
	
	public void getEmpProjID() throws ClassNotFoundException, SQLException
	{
		Scanner input= new Scanner(System.in);
		System.out.println("Enter Employee ID");
		empID=input.nextInt();
		
		DBLogic db = new DBLogic();
		RS=db.getEmpProjID(empID);
		if(RS.next())
		{
			projID=RS.getInt(1);
			System.out.println("PROJECT ID OF EMPLOYEE IS "+projID);
			
		}
	}
	public void getEmpCity() throws ClassNotFoundException, SQLException
	{
		Scanner input= new Scanner(System.in);
		System.out.println("Enter Employee ID");
		empID=input.nextInt();
		
		DBLogic db= new DBLogic();
		RS=db.getEmpCity(empID);
		if(RS.next())
		{
			city=RS.getString(1);
			System.out.println("CITY OF EMPLOYEE IS "+city);
			
		}
	}
	public void getEmpName() throws ClassNotFoundException, SQLException
	{
		Scanner input= new Scanner(System.in);
		System.out.println("Enter Project ID of employee");
		proj=input.nextInt();
		
		DBLogic db= new DBLogic();
		RS=db.getEmpName(proj);
		if(RS.next())
		{
			fName=RS.getString(1);
			lName=RS.getString(2);
			System.out.println("First Name of Employee is "+fName);
			System.out.println("Last Name of Employee is "+ lName);	
		}
	}
	public void insertData() throws ClassNotFoundException, SQLException
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Employee ID");
		empID=input.nextInt();
		System.out.println("Enter first name of employee");
		fName=input.next();
		System.out.println("Enter last name of employee");
		lName=input.next();
		System.out.println("Enter city of employee");
		city=input.next();
		System.out.println("Enter project id of employee");
		projID=input.nextInt();
		DataOperation obj= new DataOperation();
		obj.insertData(empID, fName, lName, city, projID);
		System.out.println("DATA INSERTED FROM VIEW SECTION");
	} 
	public void updateData() throws ClassNotFoundException, SQLException
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Employee ID");
		empID=input.nextInt();	
		System.out.println("Enter new city");
		city=input.next();
		System.out.println("Enter new project id");
		projID=input.nextInt();
		DataOperation obj= new DataOperation();
		obj.updateData(empID, city,projID);
		System.out.println("records updated from View Section");
	}
	public void deleteData() throws ClassNotFoundException, SQLException
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Employee ID");
		empID=input.nextInt();
		DataOperation obj= new DataOperation();
		obj.deleteData(empID);
		System.out.println("records deleted from View Section");
	}
	
	public void readData() throws ClassNotFoundException, SQLException
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Employee ID");
		empID=input.nextInt();	
		DBLogic db= new DBLogic();
		RS=db.readData(empID);
		if(RS.next())
		{
		   empID=RS.getInt(1);
		   fName=RS.getString(2);
		   lName=RS.getString(3);
		   city=RS.getString(4);
		   projID=RS.getInt(5);
		   
		   System.out.println("EMPLOYEE ID: "+empID);
		   System.out.println("FIRST NAME:"+fName);
		   System.out.println("LAST NAME: "+lName);
		   System.out.println("CITY: "+city);
		   System.out.println("PROJECT ID: "+projID);
		}
		
	}
	
	public static void main(String[] args)throws ClassNotFoundException, SQLException
	{
		CLI obj= new CLI();
		//obj.getEmpProjID();
		//obj.getEmpCity();
		//obj.getEmpName();
		//obj.insertData();
		//obj.updateData();
		//obj.deleteData();
		obj.readData();
	}	
}
