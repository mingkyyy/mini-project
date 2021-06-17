package Dto;

/**
 * 
 * 주문에 관한 데이터 객체,  getter/setter 메서드 를 갖는다
 *
 */

public class ordersDto {
	int orderno;
	int foodno;
	int no;
	String orderdata;
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
	
	public String getOrderdata() {
		return orderdata;
	}
	public void setOrderdata(String orderdata) {
		this.orderdata = orderdata;
	}
	@Override
	public String toString() {
		return "orderDto [orderno=" + orderno + ", foodno=" + foodno + ", no=" + no + ", orderdata=" + orderdata
				+ "]";
	}
	
	
	
	

}
