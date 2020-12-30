import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;
import java.sql.*;

public class DBconnect {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection conn=null;
		
		try
		{
			String host = "jdbc:mysql://localhost:3306/java?serverTimezone=" + TimeZone.getDefault().getID();
			String user = "student";
			String pass = "WIT123!";
			conn = DriverManager.getConnection(host,user,pass);
			Statement st=conn.createStatement();
			
			System.out.println("Choose option: \n 1-create \n 2-update \n 3-delete \n 4-read \n");
			int option = 0;
			option = scanner.nextInt();
			
			switch (option) {
			case 1:
			//CREATE
			System.out.println("CREATE: ");
			System.out.println("Enter ID: ");
			int id=scanner.nextInt();
			System.out.println("Enter name: ");
			String name=scanner.next();
			System.out.println("Enter surname: ");
			String surname=scanner.next();
			System.out.println("Enter nickname: ");
			String nick=scanner.next();
			System.out.println("Enter age: ");
			int age=scanner.nextInt();
			System.out.println("Enter pesel: ");
			String pesel=scanner.next();
			
			st.executeUpdate("insert into lab5 value('"+id+"','"+name+"','"+surname+"','"+nick+"','"+age+"','"+pesel+"')");
			System.out.print("\n");
			System.out.println("Success");
			break;
			
			case 2:
			//UPDATE
   		    System.out.print("\n");
			System.out.println("UPDATE: ");
			System.out.println("To update data enter ID: ");
			int upid=scanner.nextInt();
			
			ResultSet a = st.executeQuery("select * from lab5 where id=('"+upid+"')");
			while (a.next()) {
	   		System.out.println(a.getInt("ID") + ". " + a.getString("Name") + ", " +
	   						   a.getString("Surname") + ", " + a.getString("Nickname") + ", " +
	   						   a.getInt("Age")+ ", " + a.getString("Pesel"));  					   
	   						 }
			System.out.println("Enter name: ");
			String upname=scanner.next();
			String update = "update lab5" +
							" set Name=('"+upname+"')" +
							" where ID=('"+upid+"')";
			
			System.out.println("Enter surname: ");
			String upsur=scanner.next();
			String update1 = "update lab5" +
							" set Surname=('"+upsur+"')" +
							" where ID=('"+upid+"')";
			
			System.out.println("Enter nickname: ");
			String upnick=scanner.next();
			String update2 = "update lab5" +
							" set Nickname=('"+upnick+"')" +
							" where ID=('"+upid+"')";
			
			System.out.println("Enter age: ");
			int upage=scanner.nextInt();
			String update3 = "update lab5" +
							" set Age=('"+upage+"')" +
							" where ID=('"+upid+"')";
			
			System.out.println("Enter pesel: ");
			String uppes=scanner.next();
			String update4 = "update lab5" +
							" set Pesel=('"+uppes+"')" +
							" where ID=('"+upid+"')";
			
			st.executeUpdate(update);
		    st.executeUpdate(update1);
		    st.executeUpdate(update2);
		    st.executeUpdate(update3);
		    st.executeUpdate(update4);
		    
		    System.out.print("\n");
		    System.out.println("Success");
			break;
		    
			case 3:
			//DELETE
			System.out.print("\n");
			System.out.println("DELETE: ");
			System.out.println("To delete data enter ID: ");
			int iddel=scanner.nextInt();
			String delete = "delete from lab5 where ID=('"+iddel+"')";
   		    int usun = st.executeUpdate(delete);
   		    System.out.print("\n");
   		    System.out.println("Success");
   		    break;
   		    	
			case 4:
			//READ
			System.out.print("\n");
			System.out.println("READ: ");
			ResultSet rs = st.executeQuery("SELECT * FROM lab5");
   			while (rs.next()) {
   			System.out.println(rs.getInt("ID") + ". " + rs.getString("Name") + ", " +
   				    rs.getString("Surname") + ", " + rs.getString("Nickname") + ", " +
   				    rs.getInt("Age")+ ", " + rs.getString("Pesel"));  					   
   							  }
   			System.out.print("\n");
   			System.out.println("Success");
			break;
   			
			}
			
			
		}
		
		
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if(conn!=null)
				{
					conn.close();
					System.out.println("Database closed correctly");
				}
			}
			catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

}
