package Randevular;

public class DoktorKayit {
private int DoktorID=1;
private int Dolu=0;
public DoktorKayit(int DoktorID,int Dolu) {
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
