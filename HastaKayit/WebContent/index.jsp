<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>#EvdeKal</title>
<style>

#text {
width: 500px;
height: 250px;
border: 8px solid;
font-size: 40px;
overflow: auto;
position: absolute; 
top: 150px; 
left: 70px;
background:white;
align:center;


.image { 
   position: relative; 
   width: 100%; /*  internet explorer 6 için*/
   overflow: auto;
 
}
h1 { 
   position: absolute; 
   top: 150px; 
   left: 70px;
   color:yellow; 
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

<body >


<table width=100%  height=100% border="5" align="center" bgcolor="black">
<tr>
<td colspan="5" height=100%><center><font size=20 color="white">Berhayat Hastanesi</font></center></td>
</tr>
</table>
<table width=100% height=100% border="1" align="center" bgcolor="white">
<tr height="5">

<td><font><a href="index.jsp">Anasayfa</a></font></td>
<td><font><a href="doktorlar.html">Doktorlar</a></font></td>
<td><font><a href="iletisim.html">iletisim</a></font></td>

</tr>
</table >
<div class="image" >
 <img src="resimler/Berhayat.jpg" alt="" height=100% width=100% border="8"/>

  <div id='text'  >
<table >
<tr>
<td>Aile Hekimligi</td>
<td><h5>Randevu Al</h5></td>
</tr>
<tr>
<td>Cocuk Sag. ve Hast.</td>
<td><h5>Randevu Al</h5></td>
</tr>
<tr>
<td>Dermatoloji</td>
<td><h5>Randevu Al</h5></td>
</tr>
<tr>
<td>Patoloji </td>
<td><h6>Yakinda Eklenecek</h6></td>
</tr>
<tr>
<td >Genel Cerrahi </td>
<td><h6>Yakinda Eklenecek</h6></td>
</tr>
<tr>
<td >Kadin Hastaliklari </td>
<td><h6>Yakinda Eklenecek</h6></td>
</tr>

</div>
</table>


</div>
</body>

</html>