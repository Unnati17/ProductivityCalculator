package src.ncu.processor;
import java.io.*;
import java.util.*;
import java.lang.*;
class Crud
{
  Scanner sx=new Scanner (System.in);
  private String task;
  private String hour;
  private String line;
  public void add()
   {

    System.out.println("\n\t\t\t===========ADD===========\t\t\t\n");
    try
    {      FileReader fr=new FileReader("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Productivity_Calculator.txt\\");

      BufferedReader br=new BufferedReader(fr);
      System.out.println("\t\t--------->1.PRODUCTIVE");
      System.out.println("\t\t--------->2.NON-PRODUCTIVE");
      System.out.println("\t\t\tENTER:");
      int cat=sx.nextInt(); //Asks the user the add in a particular category

      switch(cat) //Switches the category 
      {
        case 1:  //For Productive
        {
        while((line=br.readLine()) != null)
        {
           if(line.equals("PRODUCTIVE"))
           {        
                    Scanner sc=new Scanner (System.in);
                    System.out.println();
                    BufferedWriter bout= new BufferedWriter(new FileWriter("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Productivity_Calculator.txt\\",true)); //For appending into the existing file
                    System.out.println("\n******TASK AND HOURS SPENT*****\n");
                    task=sc.nextLine(); //task is taken 
                    hour=sc.nextLine(); //hour is taken 
                    bout.write(task+" "+hour);
                    bout.flush(); //Flushes all the characters to the file 
                    bout.close();
            }
        }
        br.close();
        }
        break;
        case 2: //For Non-Productive
        {
        File per=new File("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Productivity_Calculator.txt\\"); //File where all contents are present
        File temp=new File("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Temp.txt\\");
        BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Temp.txt\\"));
        line=null;
        Scanner sd=new Scanner (System.in);
        System.out.println("\n******TASK AND HOURS SPENT*****\n");
        task=sd.nextLine();
        hour=sd.nextLine();       
        while((line=br.readLine()) != null)
        {
          System.out.println();
            if(line.equals("NON-PRODUCTIVE")) 
              {
                      bw.write(line);
                      bw.newLine();
                      bw.write(task+" "+hour);
                      bw.newLine();
              }
              else
              {
                      bw.write(line);
                      bw.newLine();
              }
           }          
        
        br.close();
        bw.flush();
        bw.close();
        per.delete(); //Productivity_Calculator file is deleted 
        boolean successful=temp.renameTo(per); //Temp file renamed to Productivity_Calculator
        }
         break;      
       }

    }
      catch (IOException e)
      {
          System.out.print(e);
      }
    }
   public void update()
   { 

        File f = new File("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Productivity_Calculator.txt\\");
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
         System.out.println("\n\t\t\t===========UPDATE===========\t\t\t\n");
        try
        {
            reader = new BufferedReader(new FileReader("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Productivity_Calculator.txt\\"));
             
            
             System.out.println("\n******TASK AND TIME TO BE UPDATED*****\n");
             String uptask=sx.nextLine(); 
             System.out.println("\n*****NEW TASK AND HOURS SPENT******\n");
             String task=sx.nextLine();
             
            String line = reader.readLine();
            //Reading all the lines of text file into oldContent line by line
            while (line != null) 
            {
                oldContent = oldContent + line+System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            String newContent = oldContent.replaceAll(uptask,task); //Replacing old task with new task in the oldContent
             
            writer = new FileWriter("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Productivity_Calculator.txt\\");
             
            writer.write(newContent); //Rewriting newContent
            
            reader.close();
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("\n\t\t\t*********UPDATED************\t\t\t\n");
        
    }

    public void delete()
    {

    System.out.println("\n\t\t\t===========DELETE===========\t\t\t\n");
    try
    {
      File per=new File("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Productivity_Calculator.txt\\"); //File where all contents are present
      File temp=new File("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Temp.txt\\");   //File where all contents are written except the one to be deleted 
      FileReader fr=new FileReader(per);
      FileWriter fw=new FileWriter(temp); 
      BufferedReader br=new BufferedReader(fr);
      BufferedWriter bw=new BufferedWriter(fw);  //For writing into temp file line by line
      System.out.println("\t\t--------->1.PRODUCTIVE");
      System.out.println("\t\t--------->2.NON-PRODUCTIVE");
      System.out.println("\t\t\tENTER:");
      int cat=sx.nextInt();
      String line;

      switch(cat)
      {
        case 1:
        {
          Scanner sd=new Scanner(System.in);
         System.out.println("\n******TASK TO BE DELETED*****\n");
         task=sd.nextLine(); 
        while((line=br.readLine()) != null)
        {
            bw.write(line); //lines before Productive are written into temp file
            bw.newLine();
           if(line.equals("PRODUCTIVE"))
           {     
                    while((line=br.readLine())!=null)    
                   {
                          String[] s=line.split(" "); //line is split into two parts task and time
                        if(s[0].equals(task)) //Task is compared with the asked task
                        {
                          
                        }
                        else
                        {
                         bw.write(line); //Remaining lines are written excluding task to be deleted
                         bw.newLine();
                        }
                      
                    }
            }
        }
                    bw.flush();
                    bw.close();
                    br.close();
                    per.delete(); //Productivity_Calculator file is deleted 
                    boolean successful=temp.renameTo(per); //Temp file renamed to Productivity_Calculator

            
                    
        }
        break;
        case 2:
        {
        Scanner sd=new Scanner(System.in);
         System.out.println("\n******TASK TO BE DELETED*****\n");
         task=sd.nextLine(); 
        while((line=br.readLine()) != null)
        {
            bw.write(line);  //lines before Non-Productive are written into temp file
            bw.newLine();
           if(line.equals("NON-PRODUCTIVE"))
           {     
                    while((line=br.readLine())!=null)    
                   {
                          String[] s=line.split(" "); //line is split into two parts task and time
                        if(s[0].equals(task)) //Task is compared with the asked task
                        {
                          
                        }
                        else
                        {
                         bw.write(line); //Remaining lines are written excluding task to be deleted
                         bw.newLine();
                        }
                      
                    }
            }
        }
                    bw.flush();
                    bw.close();
                    br.close();
                    per.delete(); //Productivity_Calculator file is deleted 
                    boolean successful=temp.renameTo(per); //Temp file renamed to Productivity_Calculator
        }
         break;   
    }
  }
      catch (IOException e)
      {
          System.out.print(e);
      }
       System.out.println("\n\t\t\t*********DELETED************\t\t\t\n");
    }


public void display()
    { 
    System.out.println("\n\t\t\t===========DISPLAY===========\t\t\t\n"); 
      try{
         FileReader fr=new FileReader("C:\\Users\\Asus\\Desktop\\Productivity Calculator\\document\\Productivity_Calculator.txt\\");

          BufferedReader br=new BufferedReader(fr);

           while((line=br.readLine()) != null) //lines are read untill end of file
           {
              System.out.println(line); //lines are printed on the screen 
           }

          }
          catch(IOException e)
         {
          System.out.println(e);
         }  

    }

}
