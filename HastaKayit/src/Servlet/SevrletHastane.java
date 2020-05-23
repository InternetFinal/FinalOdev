package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		// Burada veritabanýna kayýt yapýlýyor ve Zaman kontrolu yapýlarak tablo temizleniyor...
		// Saat 18:00 da kayýt yapmaya çalýþýnýlýrsa kayýt yapmaz ve tablolar temizlenir...
	     String TCno = request.getParameter("txtTC");
	     String ad = request.getParameter("txtAd");
	     String tel = request.getParameter("txtTel");
	     int Dok = (Integer.parseInt(request.getParameter("Dok")));
	     String connUrl= "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
	 
	    
	     String pattern2 = "kk";
	     SimpleDateFormat simpleDate2Format = new SimpleDateFormat(pattern2);
	     String saat = simpleDate2Format.format(new Date());
	     
	     try {
	    	int a = 18;
			Connection conn = DriverManager.getConnection(connUrl);
			PreparedStatement pst2 = conn.prepareStatement("INSERT INTO KAYITLAR VALUES (?,?,?,?,?,?)");
			//PreparedStatement pst4 = conn.prepareStatement("UPDATE DoktorRandevu SET Dolu=1")  ; 
			pst2.setString(1, TCno);
	            pst2.setString(2, ad);
	            pst2.setInt(3,Dok);
	            pst2.setInt(4,10);
	            pst2.setString(5, tel);
	            pst2.setString(6,"Bolum");
	           
	           
	            pst2.execute();
	          //  pst4.execute();
	            if(Integer.parseInt(saat)>a) {
	   	         
	   	      System.out.print("Kayýt Baþarýlý");
	   	     
	   	     }
	   	        else
	   	     {
	   	         
	   	         PreparedStatement pst3 = conn.prepareStatement("DELETE FROM KAYITLAR");
	   	          pst3.execute();  
	   	       System.out.print("Bu saate sisteme kayýt Yapýlamaz");
	   	     }
	            
	      
	            
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}
