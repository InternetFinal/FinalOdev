<%@ page language="java" contentType="text/html; charset=ISO-8859-9″ pageEncoding=”ISO-8859-9″ %"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
<title>#EvdeKal</title>
<style>

#text {
width: 600px;
height: 550px;
border: 8px solid;
font-size: 40px;
overflow: auto;
position: absolute; 
top: 250px; 
left: 400px;
background:white;
 margin: auto;
}
.image { 
   position: relative; 
   width: 100%; 
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

<body  >


<table width=100%  height=100% border="5" align="center" bgcolor="black">
<tr>
<td colspan="5" height=100%><center><font size=20 color="white">Berhayat Hastanesi</font></center></td>
</tr>
</table>
<table   width=100% height=100% border="1" align="center" bgcolor="white">
<tr height="5" >

<td><b><a href="index.jsp">Anasayfa</a></b></td>
<td><b><a href="Doktorlar.jsp">Doktorlar</a></b></td>
<td><b><font><a href="iletisim.jsp">İletişim</a></b></td>

</tr>
</table >

<hr />
<marquee>Berhayat Hastahanesi</marquee>
<hr />
<div class="image" >
 <img src="resimler/Berhayat.jpg" alt="" height=100% width=100% border="8"/>
</div>
 <div id='text'>
<table align="center">
<tr>
  <td rowspan="7" >
    <p>B</p>
    <p>Ö</p>
    <p>L</p>
    <p>Ü</p>
    <p>M</p>
    <p>L</p>
    <p>E</p>
    <p>R</p>
  </td>
 </tr>
 <tr >
  <td>Aile Hekimligi</td>
  <td><h5><a href= "AileHekim.jsp">Randevu Al</a></h5></td>
 </tr>
 <tr>
   <td>Çocuk Sağ. ve Hast.</td>
   <td><h5><a href= "Cocuk.jsp">Randevu Al</a></h5></td>
 </tr>
 <tr>
    <td>Dermatoloji</td>
    <td><h5><a href= "Dermatoloji.jsp">Randevu Al</a></h5></td>
 </tr>
 <tr>
    <td>Patoloji </td>
    <td><h6>Yakında Eklenecek</h6></td>
 </tr>
 <tr>
    <td >Genel Cerrahi </td>
    <td><h6>Yakında Eklenecek</h6></td>
 </tr>
 <tr>
    <td >Kadın Hastalıkları </td>
     <td><h6>Yakında Eklenecek</h6></td>
 </tr>

</div>

</table>


</body>
</html>