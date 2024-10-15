package com.tolgagonen.mavenapp2.servlets;

import com.tolgagonen.mavenapp2.databaseC.CreateUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String userPassword = request.getParameter("password");

        // Kullanıcıyı veritabanına ekle
        CreateUser.createDb(userName, userPassword);

        // Başarılı kayıttan sonra yönlendirme
        response.sendRedirect("login.jsp"); // Kullanıcı giriş sayfasına yönlendirilir
    }
}
