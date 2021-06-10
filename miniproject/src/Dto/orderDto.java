package Dto;

public class orderDto {
	int orderno;
	int foodno;
	int no;
	int orderdate;
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getFoodno() {
		return foodno;
	}
	public void setFoodno(int foodno) {
		this.foodno = foodno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(int orderdate) {
		this.orderdate = orderdate;
	}
	@Override
	public String toString() {
		return "orderDto [orderno=" + orderno + ", foodno=" + foodno + ", no=" + no + ", orderdate=" + orderdate + "]";
	}
	
	

}
