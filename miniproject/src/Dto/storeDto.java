package Dto;

public class storeDto {
	int storeno;
	int no;
	String storeadress;
	String storename;
	String storenumber;
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
	public String getStoreadress() {
		return storeadress;
	}
	public void setStoreadress(String storeadress) {
		this.storeadress = storeadress;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getStorenumber() {
		return storenumber;
	}
	public void setStorenumber(String storenumber) {
		this.storenumber = storenumber;
	}
	@Override
	public String toString() {
		return "storeDto [storeno=" + storeno + ", no=" + no + ", storeadress=" + storeadress + ", storename="
				+ storename + ", storenumber=" + storenumber + "]";
	}
	
  
}
