package Dto;

public class foodDto {
	int foodno;
	String foodname;
	int storeno;
	int foodprice;
	String foodpicture;
	public int getFoodno() {
		return foodno;
	}
	public void setFoodno(int foodno) {
		this.foodno = foodno;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public int getStoreno() {
		return storeno;
	}
	public void setStoreno(int storeno) {
		this.storeno = storeno;
	}
	public int getFoodprice() {
		return foodprice;
	}
	public void setFoodprice(int foodprice) {
		this.foodprice = foodprice;
	}
	public String getFoodpicture() {
		return foodpicture;
	}
	public void setFoodpicture(String foodpicture) {
		this.foodpicture = foodpicture;
	}
	@Override
	public String toString() {
		return "foodDto [foodno=" + foodno + ", foodname=" + foodname + ", storeno=" + storeno + ", foodprice="
				+ foodprice + ", foodpicture=" + foodpicture + "]";
	}
	
	

}
