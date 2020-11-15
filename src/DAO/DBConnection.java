/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author noure
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    public Connection LibraryDB(){
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/library";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    
    }
    
    
    
    
}
