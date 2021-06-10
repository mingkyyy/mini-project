package Dto;

public class commonDto {
	int no;
	String name;
	String id;
	String password;
	String phonenumber;
	String zip;
	String adress;
	String adress_detail;
	String type;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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
	public String getAdress_detail() {
		return adress_detail;
	}
	public void setAdress_detail(String adress_detail) {
		this.adress_detail = adress_detail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "commonDto [no=" + no + ", name=" + name + ", id=" + id + ", password=" + password + ", phonenumber="
				+ phonenumber + ", zip=" + zip + ", adress=" + adress + ", adress_detail=" + adress_detail + ", type="
				+ type + "]";
	}
	

}
