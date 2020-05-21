package Randevular;

public class DoktarRandevu {
	 private int DoktorID;
	 private int Dolu;
	
	 public DoktarRandevu(int DoktorID,int Dolu )
	 {
		 this.DoktorID=DoktorID;
		 this.Dolu=Dolu;
	 }
	
	public int getDoktorID() {
		return DoktorID;
	}
	public void setDoktorID(int doktorID) {
		DoktorID = doktorID;
	}
	public int getDolu() {
		return Dolu;
	}
	public void setDolu(int dolu) {
		Dolu = dolu;
	}
	
	
	
}
