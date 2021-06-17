package Dto;
/**
 * 
 * 회원관리에 관한 데이터 객체,  getter/setter 메서드 를 갖는다
 *
 */

public class commonDto {
	int no;
	String name;
	String id;
	String password;
	String phone;
	String zip;
	String adress;
	String adress_detail;
	int type;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "commonDto [no=" + no + ", name=" + name + ", id=" + id + ", password=" + password + ", phone=" + phone
				+ ", zip=" + zip + ", adress=" + adress + ", adress_detail=" + adress_detail + ", type=" + type + "]";
	}
	
	
}

	