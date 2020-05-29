<%@ page language="java" contentType="text/html; charset=ISO-8859-9″ pageEncoding=”ISO-8859-9″ %"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">

<title>Dermatoloji Randevu</title>
  <script type="text/javascript">
    <%@ include file=".\WEB-INF\js\Validation.js" %>
</script>
 <style> 
.sablon{ width:1890px; height:auto; margin:30px auto}
.logo{ width:100px; height:100px; float:left; background:url(images/logo.jpg)}
.banner{ width:630px; height:60px; float:left; margin:0 0 0 10px; background:#003466; border-radius:10px; color:#fff; font:bold 15px tahoma; text-align:center; padding:40px 0 0 0 }
.menu{ width:580px; height:47px; float:left; margin:10px 0 0 0; background:#00468c}

.orta2{ width:240px; height:697px; float:left; background:#4da6ff }

.orta4{ width:240px; height:697px; float:right;  background:#bedffe }

.menu ul{ margin:0; padding:0; list-style:none}
.menu ul li{ float:left}
.menu ul li a{ display:block; width:145px; height:32px; text-decoration:none; text-align:center; font:13px tahoma; color:#fff; padding:15px 0 0 0  }
.menu ul li a:hover{ text-decoration:underline; background:#06f; }

#text {
width: 700px;
height: 550px;
border: 8px solid;
font-size: 40px;
overflow: auto;
position: absolute; 
top: 150px; 
left: 70px;
background:white;


}
#deneme {
left: 600px; 
right: 650px;
}
.image { 
   position: relative; 
   width: 100%; 
   hight: 100%;
   overflow: auto;
 
}

table {
    border-collapse: collapse;
    overflow: auto;
}

table, th, td {
    border: 1px solid black;
     align-content: center;
}
</style>
</head>

<body>
<Div>
<table width=100%  height=100% border="5" align="center" bgcolor="black">
<tr>
<td colspan="5" height=100%><center><font size=20 color="white">Berhayat Hastanesi</font></center></td>
</tr>
</table>
<table width=100% height=100% border="1" align="center" bgcolor="white">

<table   width=100% height=100% border="1" align="center" bgcolor="white">
<tr height="5" >

<td><b><a href="index.jsp">Anasayfa</a></b></td>
<td><b><a href="Doktorlar.jsp">Doktorlar</a></b></td>
<td><b><font><a href="iletisim.jsp">iletişim</a></b></td>

</tr>
</table >
<hr />
  <marquee><font style="font-family: times, serif; font-size:14pt; font-style:italic">#BerhayatHastahanesi</font></marquee>
<hr />

</table >
<!-- Servlete post edebilmek için Form oluşturuldu.  -->
<form action="SevrletHastane" method="post">
<div class="orta2"><div class="image" >
 <img src="resimler/Berhayat.jpg" />
</div></div>
		
<div class="orta4"><div class="image" >
 <img src="resimler/Berhayat.jpg" />
</div></div>
<center>
<h1>Dermatoloji Randevu</h1>
<table>
   <tr>
        <td>T.C.K.N:</td>
        <td><input type="text" id="txtTC" name="txtTC" placeholder="Tc Kimlik numarasnız" onchange="Bos('txtTC');Sayi('txtTC');Uzunluk('txtTC')" ></td>
    </tr>
    <tr>
      <td>ADI SOYADI:</td>
        <td><input type="text" id="txtAd" name="txtAd" placeholder="Adınız Soyadınız" onchange="Bos('txtAd')" ></td>
    </tr>

    <tr>
        <td>TEL:</td>
        <td><input type="text" id="txtTel" name="txtTel" placeholder="Telefon Numaranız" onchange="Bos('txtTel');Sayi('txtTel');Uzunluk('txtTel')"></td>
    </tr>
    <tr>
        <td>Doktor Seçimi:</td>
         <td><select name="Dok"  style="min-width:154px; onchange="BosKontrol('txtTel')">
        
<!-- Her bölüm doktoru ayrıdır.  -->
<option name="doktor4" value="5">Fevziye Durmuş</option>
<option name="doktor5" value="6">Hüseyin Korkut</option>
<option name="doktor6" value="7">Ahmet Serkan Fidancı</option>
</select>
</td>
    </tr>
    <tr>
        
         <tr>
        <td align="center" colspan="2"><input type="button" id="btnkon" name="btnkon" value="Kontrol Et" onclick="kontrol('txtTC');kontrol('txtTel')" ></td>
       <!-- Yukarıdaki button kontrol butonudur  -->

    </tr>
      <tr>
    <td align="center" colspan="2"><input type="submit" id="btnGonder" name="btnGonder" value="KAYDET" disabled ></td>
     </tr>
    </tr>
    </table>
    </form>
	<br>
	<br>
	<br>
	<!-- Açıklama...  -->
	<h1>Tc ve Tel 11 Haneli Olmalıdır ve Adı Soyadı Kısımı Boş Geçilemez Koşulları Sağladığınız Taktirde Kontrol Et Butonuna Basınız </h1>
    <h1>Eğer Doğru Doldurduysanız Kaydet Butonu Aktif Olur</h1>

</center>
<table width=100%  height=100% border="5" align="center" bgcolor="black">
<tr>
<td colspan="5" height=100%><center><font size=20 color="white">#EvdeKal</font></center></td>
</tr>
</table>

</body>
</html>