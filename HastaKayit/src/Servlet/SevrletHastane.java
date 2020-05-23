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
	     String connUrl= "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
	 
	     String pattern = "MMddyyyy";
	     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	     String date = simpleDateFormat.format(new Date());
	     String pattern2 = "kk";
	     SimpleDateFormat simpleDate2Format = new SimpleDateFormat(pattern2);
	     String saat = simpleDate2Format.format(new Date());
	     int a = 18;
	     try {
	    	
			Connection conn = DriverManager.getConnection(connUrl);
			PreparedStatement pst2 = conn.prepareStatement("INSERT INTO KAYITLAR VALUES (?,?,?,?,?,?)");
			    pst2.setString(1, TCno);
	            pst2.setString(2, ad);
	            pst2.setString(3, tel);
	            pst2.setInt(4,10);
	            pst2.setInt(5,0);
	            pst2.setString(6,"Bolum");
	            
	            pst2.execute(); 
	            if(Integer.parseInt(saat)>a) {
	   	         
	   	      System.out.print("Kayýt Baþarýlý");
	   	     }
	   	        else
	   	     {
	   	         Connection conn2 = DriverManager.getConnection(connUrl);
	   	         PreparedStatement pst3 = conn2.prepareStatement("DELETE FROM KAYITLAR");
	   	          pst3.execute();  
	   	       System.out.print("Bu saate sisteme kayýt Yapýlamaz");
	   	     }
	            
	            
	            
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
	     
	     
	
	}

}
