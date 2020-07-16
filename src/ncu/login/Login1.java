package src.ncu.login; //Stored in package login of Productivity Calculator
import java.util.*;
import java.io.*;
import src.ncu.exception.*;
import src.ncu.login.PasswordField; //Imported for password masking
public class Login1{
	
	 public void getUsernamePassword()
	 {
	Properties prop1=new Properties();
	Scanner sc=new Scanner(System.in);
	Properties prop2=new Properties();
	FileInputStream input1=null;
		FileInputStream input2=null;
	try{
		 input1=new FileInputStream("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\configs\\username.properties\\");
            input2=new FileInputStream("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\configs\\password.properties\\"); 
		prop2.load(input2);
		prop1.load(input1);

		int i=0;
		String username;
		String password;
		String u;

		String p;
		u=prop1.getProperty("username");
		p=prop2.getProperty("password");
		while(i<3)
		{
          System.out.println("ENTER USERANME");
          username=sc.nextLine();
          System.out.println("ENTER PASSWORD");
          password=sc.nextLine();   //   prop.put("username","34");
      
		if((u.equals(username))&&(p.equals(password)))
		{
			 System.out.println("\n\t\t\t*************LOGIN SUCCESSFULL*************\t\t\t\n");
            System.out.println("\n\n\t\t\t\tWELCOME TO YOUR PERSONAL PRODUCTIVITY CALCULATOR\t\t\t\t\n\n");
			break;
		}
		else{
			 System.out.println("INCORRECT USERNAME AND PASSWORD");
             System.out.println("\n\t\t\t*************LOGIN FAILED*************\t\t\t\n"); //if nothing matches    
      		}

			i++;
		}
		if(i==3)
		{
			System.out.println("LIMIT EXHAUSTED");
		}

	}
	catch(Exception e)
	{
		e.getMessage();
		
	}	
	}
}