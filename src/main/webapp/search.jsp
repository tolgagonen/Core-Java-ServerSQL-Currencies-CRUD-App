
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Para Birimi</title>
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
      <form action="SearchServlet" method="get">
    <label for="currencyAlternateKey">Para Birimi Kisaltmasi</label>
    <input type="text" id="currencyAlternateKey" name="currencyAlternateKey" class="text-black" required>
          <button type="submit" class="mt-4 bg-blue-500 text-white p-2 rounded">Ara</button>
        </form>
    </div>
  </section>

  <jsp:include page="footer.jsp" />

</body>
</html>
