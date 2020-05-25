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
		
		///Textboxtan verileri alýyoruz...
		String TCno = request.getParameter("txtTC");
		String ad = request.getParameter("txtAd");
		String tel = request.getParameter("txtTel");
		
		int Dok = (Integer.parseInt(request.getParameter("Dok")));
		/// Baðlantý	    
		String connUrl= "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
			 
		/// Bahsedilen zaman kodlarý...
		String pattern2 = "kk";
		SimpleDateFormat simpleDate2Format = new SimpleDateFormat(pattern2);
		String saat = simpleDate2Format.format(new Date());
		// Belirlenen paydos saati.
		int paydos = 18;
		try {		 		
        /// Dolu olanlarý kontrol etme
		Connection conn = DriverManager.getConnection(connUrl);
		Statement stmt = conn.createStatement();
		// ResultSet rs2 =stmt.executeQuery("UPDATE DoktorRandevu SET Dolu=0");
		/// DoktorID sine göre Dolu mu boþ mu kontrolu
		ResultSet rs = stmt.executeQuery("SELECT Dolu FROM DoktorRandevu WHERE DoktorID = "+Integer.toString(Dok)+"");
		while (rs.next ()) {  
		int dks = rs.getInt ("Dolu");
		System.out.println ("Dolu:" + dks );
		
		
		// Burada veritabanýna kayýt yapýlýyor ve Zaman kontrolu yapýlarak tablo temizleniyor...
		// Saat 18:00 da kayýt yapmaya çalýþýnýlýrsa kayýt yapmaz ve tablolar temizlenir...	    		 
		      if(paydos > Integer.parseInt(saat)) {
		    	  ///Baþka sayfaya yönlendirip duruma göre açýklamasý yapýlýyor...
		    	  if (dks == 1) {	
		 		     response.setContentType("text/html");
		 		    PrintWriter out = response.getWriter();
		 		    out.write("<html>"
		 		    + "<head><meta charset=\"UTF-8\"><title>Exception/Error Details</title>"
		 		    + "</head>"
		 		    + "<body>"+"<center><h1>Seçiginiz Doktor suanda Musait Degildir "
		 		    + "Daha sonra tekrar deneyiniz veya Baska Doktor seçiniz.<h1></center>"+
		 		    "</body></html>");	    	    	     
		 		}
		    	  else 
		  		{  
			     //Random randevu saati atanýyor..
		    	  Random r = new Random();
		    	  int kucuk = 9;
		    	  int buyuk = 18;
		    	  int rsaat = r.nextInt(buyuk-kucuk) + kucuk;
		         
                  /// DoktorID sine göre doktorun Dolu gösteriyoruz ki iþi var mý yok mu öðrenelim...Dolu=1 Boþ =0
                  PreparedStatement pst5 = conn.prepareStatement("UPDATE DoktorRandevu SET Dolu= 1 WHERE DoktorID="+Integer.toString(Dok)+"");
			    	///KAYIT	   	         
		          PreparedStatement pst2 = conn.prepareStatement("INSERT INTO KAYITLAR VALUES (?,?,?,?,?,?)");
			    		    	  			
		          pst2.setString(1, TCno);
		          pst2.setString(2, ad);
		          pst2.setInt(3,Dok);
		          pst2.setInt(4,rsaat);
		          pst2.setString(5, tel);
		          pst5.execute();
		          
		          
		////Her bölümün doktoru ayrýdýr ve doktora göre bölüm belirlenir.
		       if (Dok == 1 || Dok == 2  ) {
		          pst2.setString(6,"Aile");
		        }
		        else if (Dok == 3 || Dok == 4  ) {
		          pst2.setString(6,"Cocuk");
		        }
		        else {
		          pst2.setString(6,"Dermatoloji");
		        }
		       /// Adý  açýklma sayfasý için çekip yönlendiriyoruz...
		          ResultSet rs2 = stmt.executeQuery("SELECT Ad FROM DoktorRandevu WHERE DoktorID = "+Integer.toString(Dok)+"");
		
		          rs2.next();
		          String dks2 = rs2.getString("Ad");
		          System.out.println ("Ad:" + dks2 );
		          pst2.execute();
		 
		///Baþka sayfaya yönlendirip duruma göre açýklamasý yapýlýyor...
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.write("<html>"
		 + "<head><meta charset=\"UTF-8\"><title>Randevu Formu</title>"
		 + "</head>"+ "<body>"+"<center><h1>Tc NO: "+TCno+"</h1><br><h1>Ad ve Soyad: "+ad
		 + "</h1><br><h1>Doktor: "+ dks2 +"</h1><br><h1>Randevu Saati: "+ rsaat+"</h1></center>"+"</body></html>");   		            	 	    		            	 
		 System.out.print("Kayýt Baþarýlý");
			    		   	     
		}
		}
		else
        {
			//Tablo temizleme zamaný 18:00.
			/// Gün bitiminde bütün doktorlarýn Dolu kýsýmlarý sýfýrlanýyor yane boþa düþüyorlar... 
        PreparedStatement pst3 = conn.prepareStatement("DELETE FROM KAYITLAR");
        PreparedStatement pst5 = conn.prepareStatement("UPDATE DoktorRandevu SET Dolu= 0");
        pst3.execute();
        pst5.execute();
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.write("<html>"
        + "<head><meta charset=\\\"UTF-8\\\"><title>Randevu Formu</title>"
        + "</head>"+ "<body>"+"<center><h1>Saatin 18:00'i geçince Kayit edilemez... "
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
