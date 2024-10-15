package com.tolgagonen.mavenapp2.servlets;

import com.tolgagonen.mavenapp2.databaseC.CreateDb;
import com.tolgagonen.mavenapp2.databaseC.ReadDb;
import com.tolgagonen.mavenapp2.databaseC.UpdateDb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currencyAlternateKey = request.getParameter("currencyAlternateKey");
        String currencyName = request.getParameter("currencyName");
        response.setContentType("text/html;charset=UTF-8");

        if (currencyAlternateKey == null || currencyName == null) {
            response.sendRedirect("create.jsp?status=missing");
            return;
        }

        Boolean isCreated = CreateDb.createDb( currencyAlternateKey , currencyName );
        if (isCreated) {
            response.sendRedirect("index.jsp?status=success");
        } else {
            response.sendRedirect("create.jsp?status=failure");
        }
    }
}