package Dto;

public class foodDto {
	int foodno;
	String foodname;
	int storeno;
	int foonprice;
	int foodpcture;
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
	public int getFoonprice() {
		return foonprice;
	}
	public void setFoonprice(int foonprice) {
		this.foonprice = foonprice;
	}
	public int getFoodpcture() {
		return foodpcture;
	}
	public void setFoodpcture(int foodpcture) {
		this.foodpcture = foodpcture;
	}
	
	@Override
	public String toString() {
		return "foodDto [foodno=" + foodno + ", foodname=" + foodname + ", storeno=" + storeno + ", foonprice="
				+ foonprice + ", foodpcture=" + foodpcture + "]";
	}

}
