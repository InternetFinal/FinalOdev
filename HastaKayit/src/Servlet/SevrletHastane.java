package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SevrletHastane
 */
@WebServlet("/SevrletHastane")
public class SevrletHastane extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SevrletHastane() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		///Textboxtan verileri al�yoruz...
		String TCno = request.getParameter("txtTC");
		String ad = request.getParameter("txtAd");
		String tel = request.getParameter("txtTel");
		
		int Dok = (Integer.parseInt(request.getParameter("Dok")));
		/// Ba�lant�	    
		String connUrl= "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
			 
		/// Bahsedilen zaman kodlar�...
		String pattern2 = "kk";
		SimpleDateFormat simpleDate2Format = new SimpleDateFormat(pattern2);
		String saat = simpleDate2Format.format(new Date());
		// Belirlenen paydos saati.
		int paydos = 18;
		try {		 		
        /// Dolu olanlar� kontrol etme
		Connection conn = DriverManager.getConnection(connUrl);
		Statement stmt = conn.createStatement();
		// ResultSet rs2 =stmt.executeQuery("UPDATE DoktorRandevu SET Dolu=0");
		/// DoktorID sine g�re Dolu mu bo� mu kontrolu
		ResultSet rs = stmt.executeQuery("SELECT Dolu FROM DoktorRandevu WHERE DoktorID = "+Integer.toString(Dok)+"");
		while (rs.next ()) {  
		int dks = rs.getInt ("Dolu");
		System.out.println ("Dolu:" + dks );
		
		
		// Burada veritaban�na kay�t yap�l�yor ve Zaman kontrolu yap�larak tablo temizleniyor...
		// Saat 18:00 da kay�t yapmaya �al���n�l�rsa kay�t yapmaz ve tablolar temizlenir...	    		 
		      if(paydos > Integer.parseInt(saat)) {
		    	  ///Ba�ka sayfaya y�nlendirip duruma g�re a��klamas� yap�l�yor...
		    	  if (dks == 1) {	
		 		     response.setContentType("text/html");
		 		    PrintWriter out = response.getWriter();
		 		    out.write("<html>"
		 		    + "<head><meta charset=\"UTF-8\"><title>Exception/Error Details</title>"
		 		    + "</head>"
		 		    + "<body>"+"<center><h1>Se�iginiz Doktor suanda Musait Degildir "
		 		    + "Daha sonra tekrar deneyiniz veya Baska Doktor se�iniz.<h1></center>"+
		 		    "</body></html>");	    	    	     
		 		}
		    	  else 
		  		{  
			     //Random randevu saati atan�yor..
		    	  Random r = new Random();
		    	  int kucuk = 9;
		    	  int buyuk = 18;
		    	  int rsaat = r.nextInt(buyuk-kucuk) + kucuk;
		         
                  /// DoktorID sine g�re doktorun Dolu g�steriyoruz ki i�i var m� yok mu ��renelim...Dolu=1 Bo� =0
                  PreparedStatement pst5 = conn.prepareStatement("UPDATE DoktorRandevu SET Dolu= 1 WHERE DoktorID="+Integer.toString(Dok)+"");
			    	///KAYIT	   	         
		          PreparedStatement pst2 = conn.prepareStatement("INSERT INTO KAYITLAR VALUES (?,?,?,?,?,?)");
			    		    	  			
		          pst2.setString(1, TCno);
		          pst2.setString(2, ad);
		          pst2.setInt(3,Dok);
		          pst2.setInt(4,rsaat);
		          pst2.setString(5, tel);
		          pst5.execute();
		          
		          
		////Her b�l�m�n doktoru ayr�d�r ve doktora g�re b�l�m belirlenir.
		       if (Dok == 1 || Dok == 2  ) {
		          pst2.setString(6,"Aile");
		        }
		        else if (Dok == 3 || Dok == 4  ) {
		          pst2.setString(6,"Cocuk");
		        }
		        else {
		          pst2.setString(6,"Dermatoloji");
		        }
		       /// Ad�  a��klma sayfas� i�in �ekip y�nlendiriyoruz...
		          ResultSet rs2 = stmt.executeQuery("SELECT Ad FROM DoktorRandevu WHERE DoktorID = "+Integer.toString(Dok)+"");
		
		          rs2.next();
		          String dks2 = rs2.getString("Ad");
		          System.out.println ("Ad:" + dks2 );
		          pst2.execute();
		 
		///Ba�ka sayfaya y�nlendirip duruma g�re a��klamas� yap�l�yor...
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.write("<html>"
		 + "<head><meta charset=\"UTF-8\"><title>Randevu Formu</title>"
		 + "</head>"+ "<body>"+"<center><h1>Tc NO: "+TCno+"</h1><br><h1>Ad ve Soyad: "+ad
		 + "</h1><br><h1>Doktor: "+ dks2 +"</h1><br><h1>Randevu Saati: "+ rsaat+"</h1></center>"+"</body></html>");   		            	 	    		            	 
		 System.out.print("Kay�t Ba�ar�l�");
			    		   	     
		}
		}
		else
        {
			//Tablo temizleme zaman� 18:00.
			/// G�n bitiminde b�t�n doktorlar�n Dolu k�s�mlar� s�f�rlan�yor yane bo�a d���yorlar... 
        PreparedStatement pst3 = conn.prepareStatement("DELETE FROM KAYITLAR");
        PreparedStatement pst5 = conn.prepareStatement("UPDATE DoktorRandevu SET Dolu= 0");
        pst3.execute();
        pst5.execute();
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.write("<html>"
        + "<head><meta charset=\\\"UTF-8\\\"><title>Randevu Formu</title>"
        + "</head>"+ "<body>"+"<center><h1>Saatin 18:00'i ge�ince Kayit edilemez... "
        + "Daha sonra tekrar deneyiniz.<h1></center>"+"</body></html>");
        System.out.print("Bu saate sisteme kayit Yapilamaz");
	    		   	          
}
				    	    	  
		}
				            
		} 
		        catch (SQLException e) {
		       e.printStackTrace();
		}
			}

}
