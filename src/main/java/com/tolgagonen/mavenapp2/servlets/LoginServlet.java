package com.tolgagonen.mavenapp2.servlets;

import com.tolgagonen.mavenapp2.databaseC.Login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String userPassword = request.getParameter("password");
        
        // Giriş kontrolü
        boolean loginSuccess = Login.LoginDb(userName, userPassword);

        if (loginSuccess) {
            // Oturum oluştur ve kullanıcı adını sakla
            HttpSession session = request.getSession();
            session.setAttribute("username", userName);
            response.sendRedirect("index.jsp"); // Giriş başarılıysa anasayfaya yönlendir
        } else {
            // Giriş başarısızsa, uygun bir hata mesajı ile yönlendir
            request.setAttribute("errorMessage", "Kullanıcı adı veya şifre hatalı.");
            request.getRequestDispatcher("login.jsp").forward(request, response); // Giriş sayfasına geri dön
        }
    }
}
