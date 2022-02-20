package controller;

import java.sql.SQLException;

import model.DBLogic;

public class DataOperation 
{
	int counter=0;
	public void insertData(int empID, String fName, String lName, String city, int projID)
					throws ClassNotFoundException, SQLException
	{
		{
			DBLogic DB= new DBLogic();
			counter= DB.insertData(empID, fName, lName, city,projID);
			if(counter!=0)
			{
				System.out.println("DATA INSERTED FROM CONTROLLER SECTION");
			}
			
		}
		
	}
	public void updateData(int empID, String city, int projID) throws ClassNotFoundException, SQLException
	{
		DBLogic db= new DBLogic();
		counter=db.updateData(empID, city,projID);
		if(counter!=0)
		{
			System.out.println(counter+ "records updated from Controller Section");
		}
		
	}
	public void deleteData(int empID)throws ClassNotFoundException, SQLException
	{
		DBLogic db= new DBLogic();
		counter=db.deleteData(empID);
		if(counter!=0)
		{
			System.out.println(counter+ " records deleted from Controller Section");
		}
	}
}
