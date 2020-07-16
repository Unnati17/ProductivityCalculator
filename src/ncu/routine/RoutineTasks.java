package src.ncu.routine;
import java.io.*;
import java.lang.*;
import java.util.*;

public class RoutineTasks extends Exception
{
	 private String category;
	 private String task;
	 private String hour;
	 private int calculate_prod;
	
 public void getTasks()
 {	 
	FileWriter fout=null; 
	try
	{
		
		int j=1;
		int i;
		Scanner sc=new Scanner(System.in);
		
		fout= new FileWriter("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Productivity_Calculator.txt\\"); //FileWriter object is created and path is given
		BufferedWriter bw=new BufferedWriter(fout);
		System.out.println("\t\t\t\t=========NON-PRODUCTIVE========\t\t\t\t"); 
		bw.write("NON-PRODUCTIVE");
		bw.newLine();

				System.out.println("\n******TASKS AND HOURS SPENT******\n");
			for(i=0;i<3;i++)
			{
				
				 task=sc.nextLine(); //tasks are taken 
				 hour=sc.nextLine(); //hours are taken 
				 bw.write(task+" "+hour);
				 bw.newLine(); //Pointer goes to next line for writing
			}
	
		
		Scanner sd=new Scanner(System.in);
		
		System.out.println("\t\t\t\t=========PRODUCTIVE========\t\t\t\t");
		bw.write("PRODUCTIVE");  //Productive Tasks are taken
		bw.newLine();
		
			System.out.println("\n******TASKS AND HOURS SPENT*****\n");
			for(int k=0;k<3;k++)
			{
				task=sd.nextLine(); //tasks are taken 
				 hour=sd.nextLine(); //hours are taken 
				 bw.write(task+" "+hour);
				 bw.newLine();
			}
		
		bw.flush(); //flushes all characters into the file 
		bw.close();
	}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
}
		 public void Calculate_prod()
	  {
		System.out.println("\n\t\t\t\t************CALCULATE PRODUCTIVITY**************\t\t\t\t\n");
		FileReader fin=null;
		File f=null;
		try
		{
			f=new File("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Productivity_Calculator.txt\\"); 
			fin= new FileReader(f);
			BufferedReader br=new BufferedReader(fin);
           	String line;
			int sum=0;
			 while((line = br.readLine()) != null)
        	{
	              if(line.equals("PRODUCTIVE")) //Searches Productive where Productive tasks and time are stored
	              {
	              		while((line=br.readLine())!=null)    
	           			{ 

	           				String[] s=line.split(" "); //Splits the line by space
	             			sum=sum+Integer.parseInt(s[1]); //Calculates the hours spent 
	    				}
    			  }

			}

        br.close();
			System.out.println("TIME YOU SPENT IN DOING PRODUCTIVE TASKS ARE:"+sum+" hours");
	}
	catch(IOException i)
	{
		i.printStackTrace();
	}
}

}

