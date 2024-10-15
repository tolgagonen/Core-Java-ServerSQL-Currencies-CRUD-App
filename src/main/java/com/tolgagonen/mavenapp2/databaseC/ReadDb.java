package com.tolgagonen.mavenapp2.databaseC;

import static com.tolgagonen.mavenapp2.databaseC.ConnectDb.connection;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDb {
    
    public static void readDb(String currencyAlternateKey, HttpServletRequest request) throws SQLException, IOException {
        ConnectDb.connectDb();
        ResultSet resultSet = null; // ResultSet'i burada tanımlıyoruz
        try {
            String query = "SELECT * FROM DimCurrency WHERE CurrencyAlternateKey LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            // Kullanıcı girdisiyle eşleşen tüm değerleri bulmak için '%currencyAlternateKey%' kullanılır.
            preparedStatement.setString(1, "%" + currencyAlternateKey + "%");
            resultSet = preparedStatement.executeQuery();
            
            // ResultSet'i request'e ekleyin
            request.setAttribute("resultSet", resultSet);
            
        } catch (SQLException exception) {
            System.err.println(exception);
        } finally {
            // Veritabanı bağlantısını kapatıyoruz.
            
        }
    }
}
