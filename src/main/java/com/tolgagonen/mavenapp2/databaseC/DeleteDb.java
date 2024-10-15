package com.tolgagonen.mavenapp2.databaseC;

import static com.tolgagonen.mavenapp2.databaseC.ConnectDb.connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDb {

    public static boolean deleteDb(String currencyAlternateKey) throws SQLException, ClassNotFoundException {

        ConnectDb.connectDb();
        boolean isDeleted = false;

        try {
            String query = "DELETE FROM DimCurrency WHERE CurrencyAlternateKey = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, currencyAlternateKey);

            // Silme işlemini gerçekleştir ve etkilenen satır sayısını al
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Eğer etkilenen satır sayısı sıfırdan büyükse, silme işlemi başarılı
                isDeleted = true;
            }

        } catch (SQLException e) {
            // Hata durumunda hata mesajını loglayabilirsin
            e.printStackTrace();
            throw e; // Hatayı dışarıya fırlat ki servlet tarafında yönetilsin
        } finally {
            // Bağlantıyı kapat
            ConnectDb.disconnectDb();
        }

        return isDeleted;
    }
}
