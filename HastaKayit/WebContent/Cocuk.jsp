<%@ page language="java" contentType="text/html; charset=ISO-8859-9″ pageEncoding=”ISO-8859-9″ %"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Çacuk Sagligi Randevu</title>
  <meta charset="UTF-8">
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
<table   width=100% height=100% border="1" align="center" bgcolor="white">
<tr height="5" >

<td><b><a href="index.jsp">Anasayfa</a></b></td>
<td><b><a href="Doktorlar.jsp">Doktorlar</a></b></td>
<td><b><font><a href="iletisim.jsp">iletisim</a></b></td>

</tr>
</table >
<table width=100% height=100% border="1" align="center" bgcolor="white">
<hr> 
<marquee><font style="font-family: times, serif; font-size:14pt; font-style:italic">#BerhayatHastahanesi</font></marquee>
<hr>


</table >
<div class="orta2"><div class="image" >
 <img src="resimler/Berhayat.jpg" />
</div></div>
		
<div class="orta4"><div class="image" >
 <img src="resimler/Berhayat.jpg" />
</div></div>
<center>
<h1>Aile Sağlığı Merkezi  Randevu</h1>
    <table>
    <tr>
        <td>T.C.K.N:</td>
        <td><input type="text" id="txtTC_misafir1" name="txtTC_misafir1" placeholder="" onchange="BosKontrol('txtTC_misafir1');SayiMi('txtTC_misafir1');UzunlukOnBirMi('txtTC_misafir1')"></td>
    </tr>
    <tr>
        <td>ADI SOYADI:</td>
        <td><input type="text" id="txtAd_misafir1" name="txtTAd_misafir1" placeholder="" onchange="BosKontrol('txtAd_misafir1');"></td>
    </tr>

    <tr>
        <td>TEL:</td>
        <td><input type="text" id="txtTC_misafir2" name="txtTC_misafir2" placeholder="" onchange="BosKontrol('txtTC_misafir2');SayiMi('txtTC_misafir2');UzunlukOnBirMi('txtTC_misafir2')"></td>
    </tr>
    <tr>
        <td>Doktor Seçimi:</td>
         <td><input type="text" id="txtAd_misafir2" name="txtTAd_misafir2" placeholder="" onchange="BosKontrol('txtAd_misafir2')"></td>
    </tr>
    </table>
    <br>
    <br>
    <br>

<h1>Bu kısmada Randevunun doktoru</h1>
<h1>Bu kısmada Randevunun hangi poliklinikte olduğu </h1>
</center>
</Div>



<table width=100%  height=100% border="5" align="center" bgcolor="black">
<tr>
<td colspan="5" height=100%><center><font size=20 color="white">#EvdeKal</font></center></td>
</tr>
</table>




</body>
</html>