package src.ncu.login; //Stored in package login of Productivity Calculator
import java.util.*;
import java.io.*;
import src.ncu.exception.*;
import src.ncu.login.PasswordField; //Imported for password masking

public class Login
{
    
    Scanner sc=new Scanner(System.in);
    private String username;
    private String password;
    
   
     public int getUsernamePassword()
    {   
        int i=0;
        boolean b=false;
        try
        {
        do
        {
        System.out.println("ENTER YOUR USERNAME:");
        username=sc.nextLine();
        String pass = PasswordField.readPassword("ENTER YOUR PASSWORD:");
        System.out.println("Password entered was:" + pass);
        password=pass;
       
        b=checkUserPass();
        if(b)
        {
            break;
        }
        i++;
        }while(i<3); //asks for username and password 3 times if wrong 
        //return flag;
        }
        catch(Exception u)
        { 
            System.out.println(u.getMessage());
        }

        //return flag;
    }

    private boolean checkUserPass() //throws UsernameException,PasswordException //For checking username and password
    {
        FileInputStream input1=null;
        FileInputStream input2=null;
        Properties prop1=new Properties();
        Properties prop2=new Properties();
        try
        {
            input1=new FileInputStream("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\configs\\username.properties"); //Properties file of username is given
            input2=new FileInputStream("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\configs\\password.properties"); //Properties file of password is given
            prop1.load(input1);
            prop2.load(input2);
       
        String u,p;

        u=prop1.getProperty("username"); //username is taken from username properties file
        p=prop2.getProperty("password"); //password is taken from password properties file

        if((u.equals(username)) && (p.equals(password))) //checks if username and password is equal
        {

            System.out.println("\n\t\t\t*************LOGIN SUCCESSFULL*************\t\t\t\n");
            System.out.println("\n\n\t\t\t\tWELCOME TO YOUR PERSONAL PRODUCTIVITY CALCULATOR\t\t\t\t\n\n");
            return true;
        
        
        }        
        else
        {
            System.out.println("INCORRECT USERNAME AND PASSWORD");
            System.out.println("\n\t\t\t*************LOGIN FAILED*************\t\t\t\n"); //if nothing matches    
            return false;

        }
 
        }

        catch(IOException e)
        {
            System.out.println("In catch");
            e.printStackTrace();
        }

       return false;
    }

 }