/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 */

package com.tolgagonen.mavenapp2.databaseC;

import jakarta.servlet.jsp.JspWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author akift
 */
public class ConnectDb {
    
    public static Connection connection = null;
    static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=AdventureWorksDW2022;encrypt=true;trustServerCertificate=true;";
    static String user = "Tolga_sa";
    static String pass = "admin";
    
    public static void connectDb(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(dbURL, user, pass);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void disconnectDb(){
        try{
            if(connection!=null){
                connection.close();
                
            }
           
        } catch(SQLException e){
                    System.err.println(e);
                    }
    }
    
}
