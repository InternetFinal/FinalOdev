package Randevular;
import java.util.Random;


import javax.servlet.http.HttpServletRequest;

public class KAYITLAR {
	private String TCno;
	private String HastaAd;
	private String Tel;
	private int DoktorID;
	private int saat;
	private int rsaat;
    private int paydos;
    private String DoktorAD;
    private int Dolu;
    private int rsat2;
	
   public  KAYITLAR(String TCno,String HastaAd,String Tel,int DoktorID,int saat,String DoktorAD,int Dolu,int rsaat, int paydos)
	{
	   this.TCno=TCno;
	   this.HastaAd=HastaAd;
	   this.Tel=Tel;
	   this.DoktorID=DoktorID;
	   this.rsaat=rsaat;
	   this.paydos=paydos;
	   this.DoktorAD=DoktorAD;
	   this.Dolu=Dolu;
	  
	  
	   
	}
	public KAYITLAR (HttpServletRequest request) {
		///Textboxtan verileri alýyoruz...	
		this.TCno=request.getParameter("txtTC");
        this.HastaAd=request.getParameter("txtAd");
        this.Tel=request.getParameter("txtTel");
        this.DoktorID=Integer.parseInt(request.getParameter("Dok"));
        
      
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
	public int getRsaat() {
		//Tablo temizleme zamaný 18:00.
		Random r = new Random();
	    int kucuk = 9;
	    int buyuk = 18;
	    int rsat = r.nextInt(buyuk-kucuk) + kucuk;
	    setRsaat2(rsat);
	    return rsat;
	}
	public void setRsaat(int rsaat) {
		this.rsaat = rsaat;
	}
	public String getDoktorAD() {
		return DoktorAD;
	}
	public void setDoktorAD(String doktorAD) {
		DoktorAD = doktorAD;
	}
	public int getDolu() {
		return Dolu;
	}
	public void setDolu(int dolu) {
		Dolu = dolu;
	}
	public int getPaydos() {
		//Bahsedilen paydos saati...
		return 18;
	}
	public void setPaydos(int paydos) {
		this.paydos = paydos;
	}
	
	public int getRsaat2() {
		return rsat2;
	}
	public void setRsaat2(int rsat2) {
		this.rsat2 = rsat2;
	}

}
