package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		kayýt kýt = new kayýt();
		KAYITLAR ky = new KAYITLAR(request);	 
		/// Þuanýn saatini alýp Paydos saati ile karþýlaþtýrýyoruz ve ona göre iþlem yaptýrýyoruz...
		String pattern2 = "kk";
		SimpleDateFormat simpleDate2Format = new SimpleDateFormat(pattern2);
		String saat = simpleDate2Format.format(new Date());
      
		   kýt.Dol(ky);
	       int dks = ky.getDolu();
	       System.out.println ("Dolu:" + dks );		    		 
		      if(ky.getPaydos() > Integer.parseInt(saat)) {
		    	 
		    	  ///Baþka sayfaya yönlendirip duruma göre açýklamasý yapýlýyor...
		    	  //Dolu:1 Boþ:0
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
		    	  kýt.inster2(ky);
		    	  String dks2 =ky.getDoktorAD();
	 
		///Baþka sayfaya yönlendirip duruma göre açýklamasý yapýlýyor...
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.write("<html>"
		 + "<head><meta charset=\"UTF-8\"><title>Randevu Formu</title>"
		 + "</head>"+ "<body>"+"<center><h1>Tc NO: "+ky.getTCno()+"</h1><br><h1>Ad ve Soyad: "+ky.getHastaAd()
		 + "</h1><br><h1>Doktor: "+ dks2 +"</h1><br><h1>Randevu Saati: "+ ky.getRsaat2()+"</h1></center>"+"</body></html>");   		            	 	    		            	 
		 System.out.print("Kayýt Baþarýlý");
			    		   	     
		}
		}
		else
        {		    
		kýt.mson();
        response.setContentType("text/html");
        //Eðer saat 18:00 geçti ise sisteme kayýt yapýlamaz ve sistemdeki KAYITLAR tablasu temizlenir ve Dolular boþa ALINIR..
        
        PrintWriter out = response.getWriter();
        out.write("<html>"
        + "<head><meta charset=\\\"UTF-8\\\"><title>Randevu Formu</title>"
        + "</head>"+ "<body>"+"<center><h1>Saatin 18:00'i geçince Kayit edilemez... "
        + "Daha sonra tekrar deneyiniz.<h1></center>"+"</body></html>");
        System.out.print("Bu saate sisteme kayit Yapilamaz");
	    		   	          
}
				    	    	  
		
				            
		} 
		 
			}


