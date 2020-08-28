package entity;

public class Toppings {
	
	private int toppingsId;
	private String crust;
	private String sauce;
	private String cheese;
	private String meat;
	private String vegetable;
	
	public Toppings(int toppingsId, String crust, String sauce, String cheese, String meat,
			String vegetable) {
		this.setToppingsId(toppingsId);
		this.setCrust(crust);
		this.setSauce(sauce);
		this.setCheese(cheese);
		this.setMeat(meat);
		this.setVegetable(vegetable);
	}
	public int getToppingsId() {
		return toppingsId;
	}

	public void setToppingsId(int toppingsId) {
		this.toppingsId = toppingsId;
	}
	
	public String getCrust() {
		return crust;
	}

	public void setCrust(String crust) {
		this.crust = crust;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public String getCheese() {
		return cheese;
	}

	public void setCheese(String cheese) {
		this.cheese = cheese;
	}

	public String getMeat() {
		return meat;
	}

	public void setMeat(String meat) {
		this.meat = meat;
	}

	public String getVegetable() {
		return vegetable;
	}

	public void setVegetable(String vegetable) {
		this.vegetable = vegetable;
	}
}
