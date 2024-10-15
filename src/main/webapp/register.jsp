<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Üye Ol</title>
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
      <h2 class="text-5xl font-bold mb-4">Üye Ol</h2>
      <form action="RegisterServlet" method="post" class="mb-4">
        <input type="text" name="username" placeholder="Kullanıcı Adı" required class="p-2 mb-2 text-black text-bold" />
        <input type="password" name="password" placeholder="Şifre" required class="p-2 mb-2 text-black " />
        <button type="submit" class="bg-blue-600 text-white py-2 px-4 rounded hover:bg-blue-500">Üye Ol</button>
      </form>
      <p>Zaten üye misiniz? <a href="login.jsp" class="text-blue-400">Giriş Yap</a></p>
    </div>
  </section>

  <jsp:include page="footer.jsp" />

</body>
</html>
