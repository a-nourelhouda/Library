/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.sql.Date;



/**
 *
 * @author noure
 */
public class Book {
    
    private int id;
    private String title;
    private String author;
    private double price;
    private Date releaseDate;
    
 
    public Book() {
    }
    
    public Book(String title, String author, double price, Date releaseDate) {

        this.title = title;
        this.author = author;
        this.price = price;
        this.releaseDate = releaseDate;
        
    }
    
    
    public String ToString(){
    
    return "id"+this.id+"title"+this.title+"author"+this.author+
            "price"+this.price+"releasedate"+this.releaseDate ;
    
    
    
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String toString() {
   return "id :" + this.id + " author :" + this.author +
           "title :" + this.title + "price = " + this.price + 
           " date :"+ this.releaseDate;
}
    
    
    
}
