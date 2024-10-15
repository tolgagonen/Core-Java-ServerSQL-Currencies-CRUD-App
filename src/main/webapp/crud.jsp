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
        <h2><a href="create.jsp" class="hover:text-gray-400">Yeni Para Birimi Ekle</a></h2>
        <h2><a href="search.jsp" class="hover:text-gray-400">Para Birimlerinde Arat</a></h2>
        <h2><a href="update.jsp" class="hover:text-gray-400">Para Birimini Guncelleme</a></h2>
        <h2><a href="delete.jsp" class="hover:text-gray-400">Para Birimi Silme</a></h2>

    </div>
  </section>

  <jsp:include page="footer.jsp" />

</body>
</html>
