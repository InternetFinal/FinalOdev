package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
///DENEME ÝÇÝNDÝR
public class kayýt {
	
	public static String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=Hastane;integratedSecurity=true;";
    public void insert(int DoktorID,int Dolu) {
        try {
            Connection conn = DriverManager.getConnection(connUrl);
            PreparedStatement pst = conn.prepareStatement("INSERT INTO DoktorRandevu VALUES (?,?)");
            pst.setInt(1, DoktorID);
            pst.setInt(2, Dolu);
            pst.execute();
            System.out.println("Kayýt baþarýlý.");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert2(String TCno,String HastaAd,String Tel, int DoktorID ,int saat) {
        try {
            Connection conn = DriverManager.getConnection(connUrl);
            
            PreparedStatement pst2 = conn.prepareStatement("INSERT INTO KAYITLAR VALUES (?,?,?,?,?)");
            pst2.setString(1, TCno);
            pst2.setString(2, HastaAd);
            pst2.setInt(3, DoktorID);
            pst2.setInt(4, saat);
            pst2.setString(5, Tel);
            pst2.execute(); 
            System.out.println("Kayýt baþarýlý.");
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
