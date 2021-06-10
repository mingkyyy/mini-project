package Dto;

public class storeDto {
	int storeno;
	int no;
	String zip;
	String adress;
	String adress_deail;
	String storename;
	int storenumber;
	public int getStoreno() {
		return storeno;
	}
	public void setStoreno(int storeno) {
		this.storeno = storeno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getAdress_deail() {
		return adress_deail;
	}
	public void setAdress_deail(String adress_deail) {
		this.adress_deail = adress_deail;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public int getStorenumber() {
		return storenumber;
	}
	public void setStorenumber(int storenumber) {
		this.storenumber = storenumber;
	}
	@Override
	public String toString() {
		return "storeDto [storeno=" + storeno + ", no=" + no + ", zip=" + zip + ", adress=" + adress + ", adress_deail="
				+ adress_deail + ", storename=" + storename + ", storenumber=" + storenumber + "]";
	}
	
	
  
}
