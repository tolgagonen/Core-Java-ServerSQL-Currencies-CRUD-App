<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %> <!-- ResultSet sınıfını içe aktar -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Arama Sonuçları</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="bg-gray-900 text-white">
    <jsp:include page="navbar.jsp" />

    <div class="container mx-auto p-4">
        <h1 class="text-3xl font-bold mb-4">Arama Sonuçları</h1>

        <div class="bg-gray-800 rounded-lg shadow-lg p-4">
            <ul>
                <%
                    // Servlet'ten gelen ResultSet
                    ResultSet resultSet = (ResultSet) request.getAttribute("resultSet");
                    
                    if (resultSet != null) {
                        boolean hasResults = false; // Sonuç olup olmadığını kontrol etmek için bir bayrak
                        while (resultSet.next()) {
                            hasResults = true; // Sonuç bulundu
                            String currencyName = resultSet.getString("CurrencyName");
                            String currencyKey = resultSet.getString("CurrencyAlternateKey");
                %>
                            <li class="border-b py-2">
                                <span class="font-bold"><%= currencyName %></span> - <%= currencyKey %>
                            </li>
                <%
                        }
                        if (!hasResults) {
                %>
                            <li>Hiçbir sonuç bulunamadı.</li>
                <%
                        }
                    } else {
                %>
                        <li>Hiçbir sonuç bulunamadı.</li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>
