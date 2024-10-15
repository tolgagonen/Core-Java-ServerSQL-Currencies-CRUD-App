<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giriş Yap</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="text-white">
    <jsp:include page="navbar.jsp" />
<section class="bg-gray-900  flex items-center justify-center h-screen">
    <div class="bg-gray-800 p-6 rounded-lg shadow-lg">
        <h2 class="text-2xl mb-4">Giriş Yap</h2>
        <form action="LoginServlet" method="post">
            <div class="mb-4">
                <label for="username" class="block mb-2">Kullanıcı Adı</label>
                <input type="text" id="username" name="username" required class="p-2 rounded w-full bg-gray-700 border border-gray-600"/>
            </div>
            <div class="mb-4">
                <label for="password" class="block mb-2">Şifre</label>
                <input type="password" id="password" name="password" required class="p-2 rounded w-full bg-gray-700 border border-gray-600"/>
            </div>
            <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Giriş Yap</button>
        </form>
        <p class="mt-4">Henüz üye değil misin? <a href="register.jsp" class="text-blue-400">Üye Ol</a></p>
    </div>
    </section>
<jsp:include page="footer.jsp" />

</body>
</html>
