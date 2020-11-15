/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import entities.Book;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author noure
 */
public class DaoBook {
    DBConnection con = null;
    DBConnection c = new DBConnection();
    
    public void AddBook(Book book){
    
        //Declaration
        PreparedStatement preparedStmt;
        double price;
        String title, author, path;
        Date releaseDate;
        //Start Connection to DataBase
        con = (DBConnection) c.LibraryDB();
        //Initialisation
        price = book.getPrice();
        title = book.getTitle();
        author = book.getAuthor();
        releaseDate = book.getReleaseDate();
        path = book.getPath();
        //Add New Book Query
        String query = "insert into book (title,price,author,releaseDate,path)values(?,?,?,?,?)";
        preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, title);
        preparedStmt.setDouble(2, price);
        preparedStmt.setString(3, author);
        preparedStmt.setDate(4, releaseDate);
        preparedStmt.setString(5, path);
        int resultupdate = preparedStmt.executeUpdate();
        System.out.println(resultupdate);
        System.out.println("New book is registred !");
        System.out.println("Title:" + title + "Author:" + author + "Price:" + price + "RelaseDate" + releaseDate + "Path" + path);
        //Close Connection to DataBase
        con.close();
    
    }
    
     //DISPLAY BOOK LIST FUNCTION
    public ArrayList<Book> listBook() throws SQLException {
        //Declaration
        Statement stmt;
        ArrayList<Book> ll = new ArrayList<Book>();
        //Start Connection to DataBase
        con = c.LibraryDB();
        //Select ALL Query
        String query = "select * from book";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            double price = rs.getDouble("price");
            Date rDate = rs.getDate("releaseDate");
            String path = rs.getString("path");
            Book book = new Book(id, title, author, price, rDate, path);
            ll.add(book);
        }
        //Close Connection to DataBase
        con.close();
        //return List of Books
        return ll;
    }

    //DISPLAY BOOK BY ID FUNCTION
    public Book listBookId(int id) throws SQLException {
        //Declaration
        String title,author,path;
        double price;
        Date rDate;
        PreparedStatement preparedStmt;
        Book book = new Book();
        //Start Connection to DataBase
        con = (DBConnection) c.LibraryDB();
        //Select By ID Query
        String query = "select * from book where id = ? ";
        preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, id);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            title = rs.getString("title");
            author = rs.getString("author");
            price = rs.getDouble("price");
            rDate = rs.getDate("releaseDate");
            path = rs.getString("path");
            book.setId(id);
            book.setTitle(title);
            book.setAuthor(author);
            book.setPrice(price);
            book.setReleaseDate(rDate);
            book.setPath(path);
        }
        //Close Connection to DataBase
        con.close();
        //return Desired Book
        return book;
    }

    //UPDATE BOOK FUNCTION
    public void UpdateB(int id, String title, double price, String author, Date date, String path) throws SQLException {
        //Declaration
        PreparedStatement preparedStmt;
        //Start Connection to DataBase
        con = (DBConnection) c.LibraryDB();
        //Update Query
        String query = "UPDATE book SET title= ?,price= ?,author= ?,releaseDate=?,path=? WHERE id = ? ";
        preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, title);
        preparedStmt.setDouble(2, price);
        preparedStmt.setString(3, author);
        preparedStmt.setDate(4, date);
        preparedStmt.setString(5, path);
        preparedStmt.setInt(6, id);
        int resultupdate = preparedStmt.executeUpdate();
        System.out.println(resultupdate);
        //Close Connection to DataBase
        con.close();
    }

    //DELETE BOOK FUNCTION
    public void deleteB(int id) throws SQLException {
        //Declaration
        PreparedStatement preparedStmt;
        //Start Connection to DataBase
        con = c.BookStoreDB();
        //Delete Query
        String query = "delete from book where id = ? ";
        preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, id);
        int resultupdate = preparedStmt.executeUpdate();
        System.out.println(resultupdate);
        //Close Connection to DataBase
        con.close();
    }
    
    
    
    
}
