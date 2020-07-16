package src.ncu.main;
import java.util.*;
import src.ncu.login.*;
import src.ncu.routine.*;
import src.ncu.processor.*;
class ProductivityCalculator
{
	
public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\t\t\t=======================================\n");
   		System.out.println("\t\t\t|                                     |\n");
   		System.out.println("\t\t\t|     ***************************     |\n");
   		System.out.println("\t\t\t|       PRODUCTIVITY CALCULATOR       |\n");
   		System.out.println("\t\t\t|     ***************************     |\n");
   		System.out.println("\t\t\t|                                     |\n");
   		System.out.println("\t\t\t=======================================\n");
		System.out.println("\n\n\t\t===========LOGIN=========\t\t\n\n");

		Login log=new Login(); //object of login class is made 
		int flag=log.getUsernamePassword(); //method called for entering username and password
 		
 		//if(flag==1)
 		// {
		System.out.println("\n\n\t\t\t===========ROUTINE TASKS================\t\t\t\n\n");

		RoutineTasks rt=new RoutineTasks();
		rt.getTasks();  //for entering tasks and hours
		rt.Calculate_prod(); 

		System.out.println("\n\n\t\t=========MENU=========\t\t\n\n");

		MenuScreen ms=new MenuScreen();
		ms.menu();

		System.out.println("\nDo you want to calculate your productive hours after modifications(1/0)\n");
    	System.out.println("------->ENTER : ");
    	int ch=sc.nextInt();
    	if(ch==1)
    		rt.Calculate_prod(); //For calculating productivity after modifications
    	}
    
	}

