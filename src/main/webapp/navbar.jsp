<!-- Navbar -->
<header class="bg-black py-4">
  <div class="container mx-auto flex justify-between items-center px-4">
    <h1 class="text-2xl font-bold">Para Birimleri</h1>
    <nav>
      <ul class="flex space-x-4">
        <li><a href="index.jsp" class="hover:text-gray-400">Ana Sayfa</a></li>
        <li><a href="#" class="hover:text-gray-400">Hakkinda</a></li>

        <% 
          String username = (String) request.getSession().getAttribute("username");
          if (username == null) { 
        %>
            <li><a href="login.jsp" class="hover:text-gray-400">Giris Yap</a></li>
            <li><a href="register.jsp" class="hover:text-gray-400">Uye  Ol</a></li>
        <% } else {  %>
            <li><a href="crud.jsp" class="hover:text-gray-400">Islemler</a></li>
            <li><span class="text-gray-400">Kullanici: <%= username %></span></li>
            <li><a href="logout.jsp" class="hover:text-gray-400">Cikis Yap</a></li>
        <% } %>
      </ul>
    </nav>
  </div>
</header>
