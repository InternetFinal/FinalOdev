<%@ page language="java" contentType="text/html; charset=ISO-8859-9″ pageEncoding=”ISO-8859-9″ %"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">

<title>Dermatoloji Randevu</title>
  
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
        <td><input type="text" id="txtTC" name="txtTC" placeholder="" ></td>
    </tr>
    <tr>
        <td>ADI SOYADI:</td>
        <td><input type="text" id="txtAd" name="txtAd" placeholder="" ></td>
    </tr>

    <tr>
        <td>TEL:</td>
        <td><input type="text" id="txtTel" name="txtTel" placeholder="" ></td>
    </tr>
    <tr>
        <td>Doktor Seçimi:</td>
         <td><select name="Dok"  style="min-width:154px;">
        
<option name="doktor1" value="opt1">Ali vefa</option>
<option name="doktor2" value="opt2">Feyzullah Durmuş</option>
<option name="doktor3" value="opt3">Hüsamettin Erdoğan</option>
<option name="doktor4" value="opt4">Mert Kızılkaya</option>
</select>
</td>
    </tr>
    <tr>
        
         <td align="center" colspan="2"><input type="submit" id="btnGonder" name="btnGonder" value="KAYDET"></td>
    </tr>
    </table>
    </form>
	<br>
	<br>
	<br>
	
<h1>Bu kısmada Randevunun doktoru</h1>
<h1>Bu kısmada Randevunun hangi poliklinikte oldugu </h1>
</center>
<table width=100%  height=100% border="5" align="center" bgcolor="black">
<tr>
<td colspan="5" height=100%><center><font size=20 color="white">#EvdeKal</font></center></td>
</tr>
</table>

</body>
</html>