package com.tolgagonen.mavenapp2.servlets;

import com.tolgagonen.mavenapp2.databaseC.ReadDb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currencyAlternateKey = request.getParameter("currencyAlternateKey");
        response.setContentType("text/html;charset=UTF-8");
        try {
            // ReadDb sınıfının readDb metodunu çağır
            ReadDb.readDb(currencyAlternateKey, request);

            // Sonuçları göstermek için result.jsp sayfasına yönlendir
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(response.getWriter()); // Hata durumunda hata mesajını yazdır
        }
    }
}
