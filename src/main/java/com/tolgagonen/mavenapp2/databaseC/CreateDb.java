/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tolgagonen.mavenapp2.databaseC;

import static com.tolgagonen.mavenapp2.databaseC.ConnectDb.connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author akift
 */
public class CreateDb {
    
    public static boolean createDb(String currencyAlternateKey, String currencyName){
        Boolean isCreated=false;
        ConnectDb.connectDb();
        try{
        String query = "INSERT INTO DimCurrency (CurrencyAlternateKey, CurrencyName) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, currencyAlternateKey);
        preparedStatement.setString(2, currencyName);
        
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
                isCreated = true;
            }
        System.out.println(rowsAffected + " row(s) inserted.");
        }catch(SQLException e){
        }
        ConnectDb.disconnectDb();
        return isCreated;
    }
    
}
