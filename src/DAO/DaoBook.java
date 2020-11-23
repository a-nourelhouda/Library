/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entities.Book;
import java.sql.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author noure
 */
public class DaoBook {
    Connection con = null;
    DBConnection c = new DBConnection();
    
    public void addBook(Book book) throws SQLException{
        
        con = c.LibraryDB();
        String req= 
        "insert into book (title,price,author,releaseDate) values (?,?,?,?)";
        
        PreparedStatement adding = con.prepareStatement(req);
        
        adding.setString(1,book.getTitle());
        adding.setDouble(2,book.getPrice());
        adding.setString(3,book.getAuthor());
        adding.setDate(4,book.getReleaseDate());     
        adding.executeUpdate();
        System.out.println("Done !");
        con.close(); 
    
    }
    
    public ArrayList<Book> listBook() throws SQLException{
        
        
    ArrayList<Book> li=new ArrayList<Book>();
     con = c.LibraryDB();
     String req= "select * from book";
     Statement listing = con.createStatement();
     ResultSet res = listing.executeQuery(req);
     while (res.next())
     {String title = res.getString("title");
      String author = res.getString("author");
      double price = res.getDouble("price");
      Date rDate = res.getDate("releaseDate");
      Book bo= new Book(title,author,price,rDate);
      li.add(bo);
     }
     con.close();
     return li;
     
    
    
    
    
    
    }
    
    
    
    
    
}
