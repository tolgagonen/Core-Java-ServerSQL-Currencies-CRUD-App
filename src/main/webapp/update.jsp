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
      <form action="UpdateServlet" method="get">
          <label for="oldCurrencyAlternateKey">Guncellenicek Para Birimi Kisaltmasi</label>
          <input type="text" id="oldCurrencyAlternateKey" name="oldCurrencyAlternateKey" class="text-black" required>
          
          <label for="currencyAlternateKey">Yeni Para Birimi Kisaltmasi</label>
          <input type="text" id="currencyAlternateKey" name="currencyAlternateKey" class="text-black" required>
          
          <label for="currencyName">Yeni Para Birimi Ismi</label>
          <input type="text" id="currencyName" name="currencyName" class="text-black" required>
          
          <button type="submit" class="mt-4 bg-blue-500 text-white p-2 rounded">Guncelle</button>
      </form>
    </div>
  </section>

 <!-- Başarı Pop-up -->
  <div id="successPopup" class="modal fixed inset-0 flex items-center justify-center bg-gray-900 bg-opacity-75">
    <div class="bg-white p-6 rounded shadow-lg text-black">
      <h2 class="text-2xl font-bold mb-4">Güncelleme Başarılı!</h2>
      <p>Para birimi başarıyla güncellendi.</p>
      <button onclick="closePopup()" class="mt-4 bg-green-500 text-white px-4 py-2 rounded">Tamam</button>
    </div>
  </div>

  <!-- Başarısızlık Pop-up -->
  <div id="failurePopup" class="modal fixed inset-0 flex items-center justify-center bg-gray-900 bg-opacity-75">
    <div class="bg-white p-6 rounded shadow-lg text-black">
      <h2 class="text-2xl font-bold mb-4">Güncelleme Başarısız!</h2>
      <p>Bir hata oluştu, lütfen tekrar deneyin.</p>
      <button onclick="closePopup()" class="mt-4 bg-red-500 text-white px-4 py-2 rounded">Tamam</button>
    </div>
  </div>

  <jsp:include page="footer.jsp" />

  <script>
    // Popup'ı kapatmak için
    function closePopup() {
      document.getElementById('successPopup').style.display = 'none';
      document.getElementById('failurePopup').style.display = 'none';
    }

    // URL'deki status parametresini kontrol et
    const urlParams = new URLSearchParams(window.location.search);
    const status = urlParams.get('status');

    if (status === 'success') {
      document.getElementById('successPopup').style.display = 'flex';
    } else if (status === 'failure') {
      document.getElementById('failurePopup').style.display = 'flex';
    }else {
    closePopup(); // Status yoksa veya geçerli değilse popup'ı kapalı tut
  }
  </script>
