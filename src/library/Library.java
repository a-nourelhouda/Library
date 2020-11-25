/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

import DAO.DaoBook;
import entities.Book;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author noure
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws SQLException {
       /*Utility U = new Utility();
      Scanner S = new Scanner(System.in);
       System.out.println("type the needed quantity");
       int qte = S.nextInt();
       System.out.println("type the price");
       double price = S.nextDouble();
      //double total = U.CalculateTotalPrice(qte,price); 
      System.out.println("type the total is" + U.CalculateTotalPrice(qte,price) +"dollar");*/
        //Real Deal
        Scanner S = new Scanner(System.in);
         int exit = 0, choice;
        DaoBook bd = new DaoBook();

        while (exit != 1) {
            
            System.out.println("veillez choisir une commande a faire ...\n");
            System.out.println("1 : Display Book List \n");
            System.out.println("2 : Create New Book \n");
            System.out.println("3 : Update a Book \n");
            System.out.println("4 : Delete a Book \n");
            System.out.println("5 : Exit.\n");
            choice = S.nextInt();
        switch (choice) {
            case 1:
                DaoBook db = new DaoBook();
                ArrayList<Book> L = new ArrayList<Book>();
                L = db.listBook();
                System.out.println(L);

             break;
                
            case 2 :
                System.out.println("type the title");
                String titre=S.nextLine();
                System.out.println("type the author");
                String aut=S.nextLine();
                System.out.println("type the price");
                Double prix=S.nextDouble();
                System.out.println("type the date");
                String d=S.next();
                Date date=Date.valueOf(d); 
                Book b=new Book(titre,aut,prix,date);
               
                try {
                bd.addBook(b);
                } catch (SQLException ex) {
                System.out.println("problem !");
                }
            break;
                
            case 3 :
                System.out.println("Type the id");
                int id =S.nextInt();
                System.out.println("type the title");
                titre=S.nextLine();
                String duh=S.nextLine();
                System.out.println("type the author");
                aut=S.nextLine();
                System.out.println("type the price");
                prix=S.nextDouble();
                System.out.println("type the date");
                d=S.next();
                date=Date.valueOf(d); 
              
                
                try {
                bd.UpdateBook(id,titre,aut,prix,date);
                } catch (SQLException ex) {
                System.out.println(ex);
                }
            break;
             
            case 4 :
                System.out.println("Type the id");
                id =S.nextInt();
                bd.DeleteBook(id);
                
            break;    
            case 5 :
                exit = 1;
                System.out.println("System Shuttig down..");
            break;
      
    }
    }
    
}}
    
