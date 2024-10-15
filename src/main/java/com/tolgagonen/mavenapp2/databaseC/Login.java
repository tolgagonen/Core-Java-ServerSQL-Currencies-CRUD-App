package com.tolgagonen.mavenapp2.databaseC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    
    public static boolean LoginDb(String userName, String userPassword) {
        ConnectDb.connectDb();
        boolean loginSuccess = false; // Başlangıçta false olarak ayarlıyoruz
        
        try {
            String query = "SELECT * FROM Users WHERE UserName = ? AND UserPassword = ?";
            PreparedStatement preparedStatement = ConnectDb.connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPassword);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            loginSuccess = resultSet.next(); // Kullanıcı varsa true döner
            
        } catch (SQLException e) {
            e.printStackTrace(); // Hata ayıklama için hata mesajını yazdır
        } finally {
            ConnectDb.disconnectDb(); // Bağlantıyı her durumda kapat
        }
        
        return loginSuccess; // Sonucu geri döndür
    }
}
