package book_management;

import java.util.Scanner;

public class operator {
    public static void main(String[] args) {
        System.out.println("Database named as library is created in the system and Table named as books is created ");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
    
        int choice;
        while(flag){
            
            System.out.println("Enter 1 for insert data into table ");
            System.out.println("Enter 2 for Search data from Table.");
            System.out.println("Enter 3 for update price of particular Book.");
            System.out.println("Enter 4 for delete data from table.");
            System.out.println("Enter 5 for Exit");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                // System.out.println();
                System.out.println("Enter a Book name : ");
                String BookTitle = sc.nextLine();
                System.out.println("Enter a Author name : ");
                String Authorname  = sc.nextLine();
                System.out.println("Enter a Publisher: ");
                String Publisher = sc.nextLine();
                System.out.println("Enter a Price : ");
                int Price = sc.nextInt();
                new datainsert(BookTitle,Authorname,Publisher,Price);
                    break;
                case 2:
                    new searchbook();
                    System.out.println();
                    break;
                case 3:
                    new priceupdate();
                    System.out.println();
                    break;
                case 4:
                    new deleteRecord();
                    System.out.println();
                    break;
                case 5 :
                    flag = false;
                    System.out.println();
                    break; 

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
}
}
