package src.ncu.validation;
import java.util.*;
import java.io.*;
import src.ncu.exception.*;
public class Validator
{
public boolean FileValidator(String f)
{
	//System.out.println("File Name is:"+f);
		boolean b;
		Properties prop=new Properties(); //Object of Properties file is made
		FileInputStream input=null; 
			try
			{
					input=new FileInputStream("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\configs\\exceptions.properties\\");  //FileInputStream for reading properrties file
					prop.load(input);
					emptyFile(f);
					fileNotAvaliable(f);
			}
			catch(EmptyFileException e)
			{

					String s=prop.getProperty("emptyfileMessage"); //emptyfileMessage is stored in s
					System.out.println(s); //message is displayed 
					return false;
			}

			catch(FileNotAvaliableException a)
			{
					 String s=prop.getProperty("filenotavailableMessage"); //filenotavaliableMessage is stored in s
					 System.out.println(s); ////message is displayed 
					 return false;
			}
			catch(Exception c)
			{
				c.printStackTrace();
			}
			try
			{
					b=emptyFile(f); //method is called to return true or false
					if(b==true)
					return false;

					b=fileNotAvaliable(f); ////method is called to return true or false
					if(b==true)
					return false;
			}
			catch(Exception i)
			{
				i.printStackTrace(); //Exception is printed if occurred 
			}
			return true;
}

	private boolean emptyFile(String f) throws EmptyFileException 
	{
			try
			{
			FileReader fout=new FileReader(f);
			BufferedReader br=new BufferedReader(fout);
			String line;
			if((line=br.readLine())==null) //Reads the file content line by line and checks if file is empty 
			{
				throw new EmptyFileException("Empty File"); //throws exception if file is empty 
			}
			else
				return false;
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			return false;
		}
	}
	private boolean fileNotAvaliable(String f) throws FileNotAvaliableException
	{
		try
		{
		File fl=new File(f);
		if(fl.exists()==true) //Checks if file exists or not 
		{
			throw new FileNotAvaliableException("File not avaliable"); //throws exception if file is does not exist
		}
		else
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}