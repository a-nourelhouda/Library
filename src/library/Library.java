/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

import java.util.Scanner;

/**
 *
 * @author noure
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       Utility U = new Utility();
      Scanner S = new Scanner(System.in);
       System.out.println("type the needed quantity");
       int qte = S.nextInt();
       System.out.println("type the price");
       double price = S.nextDouble();
      //double total = U.CalculateTotalPrice(qte,price); 
      System.out.println("type the total is" + U.CalculateTotalPrice(qte,price) +"dollar");
    }
    
}
