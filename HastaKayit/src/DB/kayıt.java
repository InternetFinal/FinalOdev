package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Randevular.KAYITLAR;

public class kayýt  {
	public void mson()
	{
		// Saat 18:00 da kayýt yapmaya çalýþýnýlýrsa kayýt yapmaz ve tablolar temizlenir...	
		try {
		String connUrl= "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
		Connection conn = DriverManager.getConnection(connUrl);
		 PreparedStatement pst3 = conn.prepareStatement("DELETE FROM KAYITLAR");
         PreparedStatement pst5 = conn.prepareStatement("UPDATE DoktorRandevu SET Dolu= 0");
         pst3.execute();
         pst5.execute();
		
	} catch (SQLException e) {
		System.out.print("Hata");
	}
	}
    public void inster2(KAYITLAR ky) {
        
		
        
        try {
        String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
       	 Connection conn = DriverManager.getConnection(connUrl);
        	Statement stmt = conn.createStatement();
        
        	// Burada veritabanýna kayýt yapýlýyor  
        	// ve DoktorID'sine göre doktorlarýn update edilip randevularý dolu gösteriliyor...
        	
    		   //Dolu update
        	  PreparedStatement pst5 = conn.prepareStatement("UPDATE DoktorRandevu SET Dolu= 1 WHERE DoktorID="+Integer.toString(ky.getDoktorID())+"");
		    	///KAYIT	   	         
	          PreparedStatement pst2 = conn.prepareStatement("INSERT INTO KAYITLAR VALUES (?,?,?,?,?,?)");
		    		    	  			
	            pst2.setString(1, ky.getTCno());
	            pst2.setString(2, ky.getHastaAd());
	            pst2.setInt(3, ky.getDoktorID());
	            pst2.setInt(4, ky.getRsaat());
	            pst2.setString(5, ky.getTel());
	            pst5.execute();
	          
	          
	       ////Her bölümün doktoru ayrýdýr ve doktora göre bölüm belirlenir.
	       if (ky.getDoktorID() == 1 || ky.getDoktorID() == 2  ) {
	          pst2.setString(6,"Aile");
	        }
	        else if (ky.getDoktorID() == 3 || ky.getDoktorID() == 4  ) {
	          pst2.setString(6,"Cocuk");
	        }
	        else {
	          pst2.setString(6,"Dermatoloji");
	        }
	       
	         /// Adý  açýklma sayfasý için çekip yönlendiriyoruz...
	          ResultSet rs2 = stmt.executeQuery("SELECT Ad FROM DoktorRandevu WHERE DoktorID = "+Integer.toString(ky.getDoktorID())+"");
	
	          rs2.next();
	          String dks2 = rs2.getString("Ad");
	          System.out.println ("Ad:" + dks2 );
	          pst2.execute();
	 
	   
	          ky.setDoktorAD(dks2);
          
            System.out.println("Kayýt baþarýlý.");
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
    }
	public void Dol(KAYITLAR ky)
	 {

	     try {
	    	//Dolu boþ için Select komutu ile ilgili satýrý çekip kontrol ediyoruz...
	     String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
	     Connection conn = DriverManager.getConnection(connUrl);
	     Statement stmt = conn.createStatement();
	     ResultSet rs = stmt.executeQuery("SELECT Dolu FROM DoktorRandevu WHERE DoktorID = "+Integer.toString(ky.getDoktorID())+"");
	        rs.next(); 
	        ky.setDolu( rs.getInt ("Dolu"));

	     }catch(SQLException e) {
	      e.printStackTrace();
	     }
	 
	 }
}
