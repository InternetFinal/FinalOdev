package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.kayýt;
import Randevular.KAYITLAR;

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
		
		
	     String TCno = request.getParameter("txtTC");
	     String ad = request.getParameter("txtAd");
	     String tel = request.getParameter("txtTel");
	     String connUrl= "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
	     
	     try {
	    	
			Connection conn = DriverManager.getConnection(connUrl);
			PreparedStatement pst2 = conn.prepareStatement("INSERT INTO KAYITLAR VALUES (?,?,?,?,?)");
			    pst2.setString(1, TCno);
	            pst2.setString(2, ad);
	            pst2.setString(3, tel);
	            pst2.setInt(4,10);
	            pst2.setInt(5,0);
	            
	            pst2.execute(); 
	            
	            System.out.print("Kayýt Baþarýlý");
	            
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}
