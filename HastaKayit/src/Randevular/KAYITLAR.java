package Randevular;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KAYITLAR {
	public static String connURL = "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
	public boolean kayýtlar(DoktorKayit dk){
		
	
	String insertQuery = "INSERT INTO DoktorRandevu VALUES(?,?)";
    try {
        Connection conn = DriverManager.getConnection(connURL);
        PreparedStatement pst = conn.prepareStatement(insertQuery);
        pst.setInt(1,dk.getDoktorID());
        pst.setInt(2,dk.getDolu());
        pst.execute();
        return true;
    }catch(SQLException ex) {
        ex.printStackTrace();
        return false;
    }
	}
	private Connection GetConnection() {
		Connection conn=null;
		
		try {
			Context ctx= new InitialContext();
			String connURL=(String) ctx.lookup("java:comp/env/connURL");
			conn = DriverManager.getConnection(connURL);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return conn;
	}
}
