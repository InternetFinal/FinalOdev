package Randevular;
///DENEME ÝÇÝNDÝR
import javax.servlet.http.HttpServletRequest;

public class KAYITLAR {
	private String TCno;
	private String HastaAd;
	private String Tel;
	private int DoktorID;
	private int saat;
	
   public  KAYITLAR(String TCno,String HastaAd,String Tel,int DoktorID,int saat)
	{
	   this.TCno=TCno;
	   this.HastaAd=HastaAd;
	   this.Tel=Tel;
	   this.DoktorID=DoktorID;
	   this.saat=saat;
	  
	   
	}
	public KAYITLAR (HttpServletRequest request) {
        this.TCno=request.getParameter("txtTC");
        this.HastaAd=request.getParameter("txtAd");
        this.Tel=request.getParameter("txtTel");
        
      
        }

       
    
	public String getTCno() {
		return TCno;
	}
	public void setTCno(String tCno) {
		TCno = tCno;
	}
	public String getHastaAd() {
		return HastaAd;
	}
	public void setHastaAd(String hastaAd) {
		HastaAd = hastaAd;
	}
	public int getDoktorID() {
		return DoktorID;
	}
	public void setDoktorID(int doktorID) {
		DoktorID = doktorID;
	}
	public int getSaat() {
		return saat;
	}
	public void setSaat(int saat) {
		this.saat = saat;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}

}
