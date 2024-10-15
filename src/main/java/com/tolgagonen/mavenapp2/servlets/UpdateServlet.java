package com.tolgagonen.mavenapp2.servlets;

import com.tolgagonen.mavenapp2.databaseC.ReadDb;
import com.tolgagonen.mavenapp2.databaseC.UpdateDb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldCurrencyAlternateKey = request.getParameter("oldCurrencyAlternateKey");
        String currencyAlternateKey = request.getParameter("currencyAlternateKey");
        String currencyName = request.getParameter("currencyName");
        response.setContentType("text/html;charset=UTF-8");

        if (oldCurrencyAlternateKey == null || currencyAlternateKey == null || currencyName == null) {
            response.sendRedirect("update.jsp?status=missing");
            return;
        }

        try {
            Boolean isUpdated = UpdateDb.updateDb(oldCurrencyAlternateKey,  currencyName , currencyAlternateKey);
            
            if (isUpdated) {
                response.sendRedirect("index.jsp?status=success");
            } else {
                response.sendRedirect("update.jsp?status=failure");
            }
        } catch (SQLException e) {
            e.printStackTrace(response.getWriter());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}