package src.ncu.processor;
import java.util.Scanner;
import src.ncu.processor.Crud;
public class MenuScreen
{
    public void menu()
     {
        Scanner sc = new Scanner(System.in);
        int ch=1;
        while(ch>0) 
        {
        System.out.println("\t\t\t------------>1.)ADD");
        System.out.println("\t\t\t------------>2.)DELETE");
        System.out.println("\t\t\t------------>3.)UPDATE");
        System.out.println("\t\t\t------------>4.)DISPLAY");
         
        System.out.println("PLEASE ENTER YOUR CHOICE:");
        int choice = sc.nextInt();
        Crud c=new Crud();
    
    switch (choice){
        case 1:
        {
            c.add();
        break;
        }

        case 2:
        {
            c.delete();
            break;
        }

        case 3:
        {    
            c.update();
            break;
        }


        case 4:
        {
            c.display();
            break;
        }
     
        default:
        break;

                }

        System.out.println("\n***********DO YOU WISH TO CONTINUE (1/0)**********\n");
        System.out.println("------->ENTER : ");
        ch=sc.nextInt();
}
}
}
