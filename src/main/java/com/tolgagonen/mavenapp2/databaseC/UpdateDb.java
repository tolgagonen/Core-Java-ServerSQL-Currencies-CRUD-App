package com.tolgagonen.mavenapp2.databaseC;

import static com.tolgagonen.mavenapp2.databaseC.ConnectDb.connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateDb {
    
    public static boolean updateDb(String oldCurrencyAlternateKey, String currencyName, String newCurrencyAlternateKey) throws SQLException, ClassNotFoundException {
        boolean isUpdated = false;
        
        String query = "UPDATE DimCurrency SET CurrencyAlternateKey = ?, CurrencyName = ? WHERE CurrencyAlternateKey = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newCurrencyAlternateKey); // Yeni CurrencyAlternateKey değeri
            preparedStatement.setString(2, currencyName); // Güncellenmek istenen CurrencyName değeri
            preparedStatement.setString(3, oldCurrencyAlternateKey); // Hangi CurrencyAlternateKey değeri güncellenecek

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
            if (rowsAffected > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(UpdateDb.class.getName()).log(Level.SEVERE, "Update failed: ", e);
        }
        return isUpdated;
    }
}
