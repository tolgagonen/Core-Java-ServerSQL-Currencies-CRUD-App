package com.tolgagonen.mavenapp2.servlets;

import com.tolgagonen.mavenapp2.databaseC.DeleteDb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currencyAlternateKey = request.getParameter("currencyAlternateKey");
        response.setContentType("text/html;charset=UTF-8");
        try {
            // ReadDb sınıfının readDb metodunu çağır
            boolean isDeleted = DeleteDb.deleteDb(currencyAlternateKey);
             if (isDeleted) {
                response.sendRedirect("index.jsp?status=success");
            } else {
                // Başarısızsa delete.jsp'ye yönlendir ve status=failure gönder
                response.sendRedirect("delete.jsp?status=failure");
            }
            

            
        } catch (SQLException e) {
            e.printStackTrace(response.getWriter()); // Hata durumunda hata mesajını yazdır
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
