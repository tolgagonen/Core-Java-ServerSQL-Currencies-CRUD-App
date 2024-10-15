/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tolgagonen.mavenapp2.databaseC;

import static com.tolgagonen.mavenapp2.databaseC.ConnectDb.connectDb;
import static com.tolgagonen.mavenapp2.databaseC.ConnectDb.connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author akift
 */
public class CreateUser {
    
    public static void createDb(String UserName, String UserPassword){
        connectDb();
        try{
        String query = "INSERT INTO Users (UserName, UserPassword) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, UserName);
        preparedStatement.setString(2, UserPassword);
        
        int rowsAffected = preparedStatement.executeUpdate();
        System.out.println(rowsAffected + " row(s) inserted.");
        }catch(SQLException e){
        }
        ConnectDb.disconnectDb();
    }
    
}
