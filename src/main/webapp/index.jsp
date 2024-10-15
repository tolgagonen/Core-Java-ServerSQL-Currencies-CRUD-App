<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ana Sayfa</title>
  <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #1a1a1a;
    }
  </style>
</head>
<body class="text-white">

  <jsp:include page="navbar.jsp" />

  <section class="flex items-center justify-center h-screen bg-gray-900">
    <div class="text-center">
      <h2 class="text-5xl font-bold mb-4">Ana Sayfa</h2>
      <%
        String username = (String) session.getAttribute("username");
        if (username != null) {
          out.println("<p>Giriş yapıldı: " + username + "</p>");
        } else {
          out.println("<p>Lütfen giriş yapın veya üye olun.</p>");
        }
      %>
    </div>
  </section>

 <!-- Başarı Pop-up -->
  <div id="successPopup" class="modal fixed inset-0 flex items-center justify-center bg-gray-900 bg-opacity-75">
    <div class="bg-white p-6 rounded shadow-lg text-black">
      <h2 class="text-2xl font-bold mb-4">Islem gerceklesti!</h2>
      <p>Islem basariyla gerceklesti.</p>
      <button onclick="closePopup()" class="mt-4 bg-green-500 text-white px-4 py-2 rounded">Tamam</button>
    </div>
  </div>


  <jsp:include page="footer.jsp" />

  <script>
    // Popup'ı kapatmak için
    function closePopup() {
      document.getElementById('successPopup').style.display = 'none';
      
    }

    // URL'deki status parametresini kontrol et
    const urlParams = new URLSearchParams(window.location.search);
    const status = urlParams.get('status');

    if (status === 'success') {
      document.getElementById('successPopup').style.display = 'flex';
    }
    else {
    closePopup(); // Status yoksa veya geçerli değilse popup'ı kapalı tut
  }
  </script>
